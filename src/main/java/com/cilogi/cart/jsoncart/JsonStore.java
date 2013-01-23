// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        JsonStore.java  (14/01/13)
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

import com.cilogi.cart.Category;
import com.cilogi.cart.ISku;
import com.cilogi.cart.IStoreDAO;
import com.cilogi.util.IOUtil;
import com.google.common.collect.Lists;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


public class JsonStore implements IStoreDAO {
    static final Logger LOG = Logger.getLogger(JsonStore.class.getName());

    private final List<ISku> skus;

    public JsonStore(String url) throws IOException {
        this(new URL(url));
    }

    public JsonStore(URL url) throws IOException {
        skus = Lists.newArrayList();
        JSONArray array = (JSONArray) IOUtil.readJSON(url);
        if (array == null) {
            throw new NullPointerException("Empty store (or error) for URL " + url);
        } else {
            for (Object o : array) {
                skus.add(new JsonSku((JSONObject)o));
            }
        }
    }

    @Override
    public ISku getSku(String id) {
        for (ISku sku : skus) {
            if (sku.getId().equals(id)) {
                return sku;
            }
        }
        return null;
    }


    @Override
    public List<ISku> getSkus() {
        return Collections.unmodifiableList(skus);
    }

    @Override
    public List<ISku> getSkus(Category category) {
        List<ISku> out = Lists.newArrayList();
        for (ISku sku : skus) {
            if (sku.getCategory().equals(category)) {
                out.add(sku);
            }
        }
        return out;
    }
}
