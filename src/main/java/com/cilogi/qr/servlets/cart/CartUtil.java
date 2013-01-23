// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        CartUtil.java  (15/01/13)
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

package com.cilogi.qr.servlets.cart;

import com.cilogi.cart.IBasket;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.logging.Logger;

public class CartUtil {
    static final Logger LOG = Logger.getLogger(CartUtil.class.getName());

    private CartUtil() {

    }

    static String count(IBasket basket) {
        int nItems = basket.getLineItems().size();
        if (nItems == 0) {
            return "empty";
        } else if (nItems == 1) {
            return "1 item";
        } else {
            return nItems + " items";
        }
    }

    static String cost(IBasket basket) {
        String cost = f(basket.getNetCost().add(basket.getTax().add(basket.getShipping())));
        int nItems = basket.getLineItems().size();
        if (nItems == 0) {
            return "";
        } else {
            return cost;
        }
    }

    static String netCost(IBasket basket) {
        String cost = f(basket.getNetCost().add(basket.getTax()));
        int nItems = basket.getLineItems().size();
        if (nItems == 0) {
            return "";
        } else {
            return cost;
        }
    }

    static String shippingCost(IBasket basket) {
        String cost = f(basket.getShipping());
        int nItems = basket.getLineItems().size();
        if (nItems == 0) {
            return "";
        } else {
            return cost;
        }
    }

    static String lastPathElement(String uri) {
        String[] subs = uri.split("/");
        return subs[subs.length-1];
    }

    static String f(BigDecimal d) {
        NumberFormat fmt = NumberFormat.getInstance();
        fmt.setMaximumFractionDigits(2);
        fmt.setMinimumFractionDigits(2);
        return  fmt.format(d);
    }
}
