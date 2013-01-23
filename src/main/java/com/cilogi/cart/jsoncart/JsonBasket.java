// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        JsonBasket.java  (14/01/13)
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

import com.cilogi.cart.IBasket;
import com.cilogi.cart.ILineItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


public class JsonBasket implements IBasket, Serializable {
    static final Logger LOG = Logger.getLogger(JsonBasket.class.getName());

    private static final long serialVersionUID = -403250971215463030L;

    private final List<ILineItem> items;

    public JsonBasket() {
        items = Lists.newArrayList();
    }

    @Override
    public List<ILineItem> getLineItems() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public void addLineItem(ILineItem item) {
        Preconditions.checkNotNull(item);
        items.add(item);
    }

    @Override
    public void removeLineItem(ILineItem item) {
        Preconditions.checkNotNull(item);
        items.remove(item);
    }

    @Override
    public BigDecimal getNetCost() {
        BigDecimal sum = new BigDecimal(0);
        for (ILineItem item : items) {
            sum = sum.add(new BigDecimal(item.getQuantity()).multiply(item.getSku().getUnitPrice()));
        }
        return sum;
    }

    @Override
    public BigDecimal getTax() {
        return getNetCost().multiply(new BigDecimal("0.20"));
    }

    @Override
    public BigDecimal getShipping() {
        return (items.size() == 0) ? new BigDecimal(0) : new BigDecimal("2.80");
    }

}
