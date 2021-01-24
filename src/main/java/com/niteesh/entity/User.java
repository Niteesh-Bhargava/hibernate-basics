package com.niteesh.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Serializable {
    protected String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal calcShippingCosts(Address fromLocation){
        return null;
    }
}
