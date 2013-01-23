// Copyright (c) 2012 Cilogi. All Rights Reserved.
//
// File:        FreemarkerServlet.java  (07-Oct-2012)
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


import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.common.collect.Maps;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateModel;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;


@Singleton
public class FreemarkerServlet extends freemarker.ext.servlet.FreemarkerServlet {
    static final Logger LOG = Logger.getLogger(FreemarkerServlet.class.getName());

    private final String manifest;

    @Inject
    public FreemarkerServlet(@Named("manifest") String manifest) {
        super();
        this.manifest = manifest;
    }

    @Override
    protected boolean preTemplateProcess(javax.servlet.http.HttpServletRequest request,
                                         javax.servlet.http.HttpServletResponse response,
                                         Template template,
                                         TemplateModel data)
            throws javax.servlet.ServletException,
            java.io.IOException {
        ((SimpleHash) data).put("manifest", manifest);
        return true;

    }

}
