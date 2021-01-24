package com.niteesh.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Item {

    @Id
    @GeneratedValue
    private String id;

    @OneToMany
    protected Set<Bid> bids;

    public Item() {
        bids = new HashSet<Bid>();
    }

    @NotNull
    @Size(
            min = 2, max = 255,
            message = "Name is required, maximum 255 characters"
    )
    protected String name;

    @Future
    protected Date auctionDate;

    public Set<Bid> getBids() {
        return Collections.unmodifiableSet(bids);
    }

    private void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public void addBid(Bid bid) {
        if (bid == null) {
            throw new IllegalArgumentException("Can't add null bid");
        }

        if (bid.getItem() != null) {
            throw new IllegalStateException("Bid is already assigned to an item");
        }
        bids.add(bid);
        bid.setItem(this);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAuctionDate() {
        return auctionDate;
    }

    public void setAuctionDate(Date auctionDate) {
        this.auctionDate = auctionDate;
    }
}
