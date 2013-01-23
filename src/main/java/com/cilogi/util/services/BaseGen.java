// Copyright (c) 2012 Tim Niblett. All Rights Reserved.
//
// File:        BaseGen.java  (30/09/12)
// Author:      Cilogi
//
// Copyright in the whole and every part of this source file belongs to
// Tim Niblett (the Author) and may not be used, sold, licenced, 
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

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.json.simple.JSONObject;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


abstract class BaseGen {
    static final Logger LOG = Logger.getLogger(BaseGen.class.getName());

    protected final LoadingCache<String,JSONObject> cache;
    protected final String baseURL;
    protected final String token;
    protected final String user;

    BaseGen(String baseURL, String token, String user) {
        CacheLoader<String,JSONObject> loader = new CacheLoader<String,JSONObject>() {
            public JSONObject load(String key) throws Exception {
                return getShortenedURLAsJson(key);
            }
        };
        this.cache = CacheBuilder.newBuilder()
                .maximumSize(1000L)
                .expireAfterWrite(12, TimeUnit.HOURS)
                .build(loader);
        this.baseURL = baseURL;
        this.token = token;
        this.user = user;
    }

    abstract JSONObject getShortenedURLAsJson(String inputURL) throws IOException;
    
    static URI queryURI(String baseURIString, String token, String user, String longURL) throws URISyntaxException {
        URI baseURI = new URI(baseURIString);
        String scheme = baseURI.getScheme();
        String host = baseURI.getHost();
        int port = baseURI.getPort();
        String path = baseURI.getPath();
        String tokenPart = (token == null) ? "" : "apiKey=" +token;
        String userPart = (user == null) ? "" :  "&login=" + user;
        URI outputURI = new URI(
                scheme, // scheme
                null, // userInfo
                host, // host
                port, // port
                path, //path
                tokenPart + userPart + "&longUrl=" + longURL, // query
                null // fragment
        );
        return outputURI;
    }    

}
