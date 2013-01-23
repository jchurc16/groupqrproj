// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        BasketServlet.java  (15/01/13)
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
import com.cilogi.cart.IStoreDAO;
import com.cilogi.qr.servlets.BaseServlet;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


@Singleton
public class BasketServlet extends BaseServlet {
    static final Logger LOG = Logger.getLogger(StoreServlet.class.getName());

    private final Provider<IBasket> basketProvider;

    @Inject
    public BasketServlet(Provider<IBasket> basketProvider) {
        this.basketProvider = basketProvider;
    }

    // the get method just displays the store with the items available for purchase in the store
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IBasket basket = basketProvider.get();
        showView(response, "store/basket.ftl",
                "lines", basket.getLineItems(),
                "imageRoot", "/content/images/store/",
                "netCost", CartUtil.netCost(basket),
                "shippingCost", CartUtil.shippingCost(basket),
                "totalCost", CartUtil.cost(basket),
                "count", basket.getLineItems().size()
        );
    }

}

