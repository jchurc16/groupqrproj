// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        IOUtil.java  (12/01/13)
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


package com.cilogi.util;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Logger;


public class IOUtil {
    static final Logger LOG = Logger.getLogger(IOUtil.class.getName());

    private IOUtil() {}

    /**
     * We always code everything as UTF-8 (thanks Ken).
     * @param url  The URL to read (assumed to contain a String
     * @return  the contents of the URL as a string
     * @throws IOException  if anything goes wrong
     */
    public static String readString(URL url) throws IOException {
        InputStream is = url.openStream();
        try {
            InputStreamReader reader = new InputStreamReader(is, Charsets.UTF_8);
            return CharStreams.toString(reader);
        } finally {
            is.close();
        }
    }

    public static Object readJSON(URL url) throws IOException {
        InputStream is = url.openStream();
        try {
            InputStreamReader reader = new InputStreamReader(is, Charsets.UTF_8);
            return JSONValue.parse(reader);
        } finally {
            is.close();
        }
    }
}
