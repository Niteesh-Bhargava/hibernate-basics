package com.niteesh.entity;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
