// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        GenShortURLGoogleTest.java  (15/01/13)
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


package com.cilogi.util.services;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

public class GenShortURLGoogleTest {
    static final Logger LOG = Logger.getLogger(GenShortURLGoogleTest.class.getName());

    //this is just here for reference, to show how you can set up local test versions of app engine service
    private final LocalServiceTestHelper helper =
        new LocalServiceTestHelper(new LocalUserServiceTestConfig())
            .setEnvIsLoggedIn(true)
            .setEnvAuthDomain("localhost")
            .setEnvEmail("test@localhost");

    public GenShortURLGoogleTest() {
    }

    @Before
    public void setUp() {
        helper.setUp();
    }

    @Test
    public void testGenShortURL() {
        GenShortURLGoogle shorten = new GenShortURLGoogle();
        //String shortURL = shorten.shortURL("http://qr2mobile.appspot.com/content/pages/sample.ftl");
        //LOG.info("short url is " + shortURL);
        //String qrURL = shorten.qrURL(shortURL, 256);
        //LOG.info("qr url is " + qrURL);

    }
}