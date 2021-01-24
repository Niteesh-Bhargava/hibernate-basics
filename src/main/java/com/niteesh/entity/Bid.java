package com.niteesh.entity;

import javax.persistence.*;

@Entity
public class Bid {
    @Id
    @GeneratedValue
    private String id;

    @ManyToOne
    protected Item item;

    public Bid() {
    }

    public Bid(Item item) {
        this.item = item;
        item.getBids().add(this);
    }

    public Item getItem() {
        return item;
    }

    void setItem(Item item) {
        this.item = item;
    }
}
