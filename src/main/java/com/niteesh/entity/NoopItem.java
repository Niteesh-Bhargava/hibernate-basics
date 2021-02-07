package com.niteesh.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class NoopItem {

    @Id
    @GeneratedValue
    protected Long id;

    protected String name;

    protected Boolean validated;

    @Column(name = "IMPERIAL_WEIGHT")
    @ColumnTransformer(
            read = "IMPERIAL_WEIGHT/2.20462",
            write = "? * 2.20462"
    )
    protected double metricWeight;

    /*@Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Generated(GenerationTime.ALWAYS)*/
    @UpdateTimestamp
    protected Date lastModified;

    @CreationTimestamp
    protected Date createdDate;

    @Column(insertable = false)
    @Generated(GenerationTime.INSERT)
    @ColumnDefault("1.0")
    protected BigDecimal initialPrice;

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
        this.name = name;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public double getMetricWeight() {
        return metricWeight;
    }

    public void setMetricWeight(double metricWeight) {
        this.metricWeight = metricWeight;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }
}
