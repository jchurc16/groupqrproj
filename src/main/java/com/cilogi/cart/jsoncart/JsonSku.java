// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        JsonSku.java  (14/01/13)
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
import org.json.simple.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Logger;


public class JsonSku implements ISku, Serializable {
    static final Logger LOG = Logger.getLogger(JsonSku.class.getName());

    private static final long serialVersionUID = -403250971215461010L;

    private final JSONObject obj;

    public JsonSku(JSONObject obj) {
        this.obj = obj;
    }

    public String getId() {
        return getProperty("id");
    }
    public String getTitle() {
        return getProperty("title");
    }
    public String getDescription() {
        return getProperty("description");
    }
    public String getThumb() {
        return getProperty("thumb");
    }
    public String getImage() {
        return getProperty("image");
    }
    public BigDecimal getUnitPrice() {
        return new BigDecimal(getProperty("unitPrice"));
    }
    public String getURL() {
        return getProperty("url");
    }
    public Category getCategory() {
        return new Category(getProperty("category"));
    }

    public String getProperty(String name) {
        Object value = obj.get(name);
        return (value == null) ? "" : value.toString();
    }

}
