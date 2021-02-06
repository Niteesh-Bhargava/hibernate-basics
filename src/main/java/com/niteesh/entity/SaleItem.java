package com.niteesh.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class SaleItem {

    @Id
    @GeneratedValue
    protected Long id;

    @NotNull
    @Column(nullable = false)
    @Access(AccessType.PROPERTY)
    protected String name;

    @NotNull
    @Basic(optional = false)
    @Column(nullable = false, name = "START_PRICE")
    protected BigDecimal initialPrice;

    @Transient
    protected BigDecimal totalPrice;

    public SaleItem() {
    }

    public SaleItem(String name, BigDecimal initialPrice, BigDecimal totalPrice) {
        this.name = name;
        this.initialPrice = initialPrice;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = "On sale : "+name;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
