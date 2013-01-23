// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        QRServlet.java  (15/01/13)
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


package com.cilogi.qr.servlets;

import com.cilogi.util.services.GenShortURLGoogle;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Singleton
public class QRServlet extends BaseServlet {
    static final Logger LOG = Logger.getLogger(QRServlet.class.getName());

    private final String host;

    @Inject
    public QRServlet(@Named("host") String host) {
        this.host = host;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String target = host + uri.substring(3);
        GenShortURLGoogle shorten = new GenShortURLGoogle();

        String shortURL = shorten.shortURL(target);
        String qrCode = shorten.qrURL(shortURL, 256);

        showView(response, "/qr.ftl",
                "url", target,
                "qrCode", qrCode,
                "shortURL", shortURL
        );
    }

}
