package com.niteesh.entity;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Immutable
@Subselect(value = "select i.id as item_id, i.name as name, count(b.id) as number_of_bids from " +
        "Item i left join Bid b on i.id = b.item.id" +
        " group by i.id, i.name")
@Synchronize({"Item", "Bid"})
public class ItemBidSummery {
    @Id
    protected long itemId;

    protected String name;

    protected long numberOfBids;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfBids() {
        return numberOfBids;
    }

    public void setNumberOfBids(long numberOfBids) {
        this.numberOfBids = numberOfBids;
    }
}
