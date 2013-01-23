// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        JsonLineItem.java  (14/01/13)
// Author:      Cilogi
//
// Copyright in the whole and every part of this source file belongs to
// Cilogi (the Author) and may not be used, sold, licenced, 
// transferred, copied or reproduced in whole or in part in 
// any manner or form or in or on any media to any person other than 
// in accordance with the terms of The Author's agreement
// or otherwise without the prior written consent of The Author.  All
// information contained in this source file is confidential information
// belonging to The Author and as such may not be disclosed other
// than in accordance with the terms of The Author's agreement, or
// otherwise, without the prior written consent of The Author.  As
// confidential information this source file must be kept fully and
// effectively secure at all times.
//


package com.cilogi.cart.jsoncart;

import com.cilogi.cart.ILineItem;
import com.cilogi.cart.ISku;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Logger;


public class JsonLineItem implements ILineItem, Serializable {
    static final Logger LOG = Logger.getLogger(JsonLineItem.class.getName());

    private static final long serialVersionUID = -403250971215462020L;

    private final ISku sku;
    private final int quantity;

    public JsonLineItem(ISku sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    @Override
    public String getUid() {
        return Integer.toString(hashCode());
    }

    @Override
    public ISku getSku() {
        return sku;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(quantity).multiply(getSku().getUnitPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sku, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof JsonLineItem) {
            JsonLineItem item = (JsonLineItem)o;
            return Objects.equal(this, item) && this.getQuantity() == item.getQuantity();
        } else {
            return false;
        }
    }

}
