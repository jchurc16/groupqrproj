// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        JsonSkuTest.java  (14/01/13)
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
import com.cilogi.util.IOUtil;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.logging.Logger;

import static junit.framework.Assert.assertEquals;

public class JsonSkuTest {
    static final Logger LOG = Logger.getLogger(JsonSkuTest.class.getName());

    private JSONObject obj;


    @Before
    public void setup() throws Exception {
        obj = (JSONObject)IOUtil.readJSON(getClass().getResource("sku.json"));
    }

    @Test
    public void testObject() {
        JsonSku sku = new JsonSku(obj);
        assertEquals("gardens", sku.getId());
        assertEquals("The Story of Glasgow Botanic Gardens", sku.getTitle());
        assertEquals("Compiled by former curator Eric Curtis, this is a visual and historical celebration, richly illustrated with colour photos throughout.\n\n2006 saw the inauguration of the renovated Kibble Place glasshouse and many other features to take the Gardens into a new century.\n\nGlasgow University first established a Physic Garden in 1706. Changing uses and demands in the plant world and in the wider society in the three hundred years since then have brought about many changes. But the core purpose \"the named collection of plants\" has remained.\n\nAt the point of the three hundredth anniversary of the Glasgow Botanic Gardens, the site is an oasis in the city much used for the enjoyment of the general public. Its botanical base is kept however in the plant collections throughout the eleven acre site.", sku.getDescription());
        assertEquals("store/images/gardens.jpg", sku.getThumb());
        assertEquals("store/images/gardens.jpg", sku.getImage());
        assertEquals(new BigDecimal("13.59"), sku.getUnitPrice());
        assertEquals("http://http://www.amazon.co.uk/Story-Glasgow-Botanic-Gardens/dp/1902831942", sku.getURL());
        assertEquals(new Category(""), sku.getCategory());
    }

}