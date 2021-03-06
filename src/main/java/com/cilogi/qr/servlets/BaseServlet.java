// Copyright (c) 2011 Cilogi All Rights Reserved.
//
// File:        BaseServlet.java  (31-Oct-2011)
// Author:      Cilogi

//
// Copyright in the whole and every part of this source file belongs to
// Cilogi (the Author) and may not be used,
// sold, licenced, transferred, copied or reproduced in whole or in
// part in any manner or form or in or on any media to any person
// other than in accordance with the terms of The Author's agreement
// or otherwise without the prior written consent of The Author.  All
// information contained in this source file is confidential information
// belonging to The Author and as such may not be disclosed other
// than in accordance with the terms of The Author's agreement, or
// otherwise, without the prior written consent of The Author.  As
// confidential information this source file must be kept fully and
// effectively secure at all times.
//


package com.cilogi.qr.servlets;


import com.cilogi.util.MimeTypes;
import com.cilogi.util.doc.CreateDoc;
import com.google.common.base.Preconditions;
import org.json.simple.JSONObject;

import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;


public class BaseServlet extends HttpServlet implements MimeTypes {
    static final Logger LOG = Logger.getLogger(BaseServlet.class.getName());

    protected final String MESSAGE = "message";
    protected final String CODE = "code";

    protected final int HTTP_STATUS_OK = 200;
    protected final int HTTP_STATUS_NOT_FOUND = 404;
    protected final int HTTP_STATUS_FORBIDDEN = 403;
    protected final int HTTP_STATUS_INTERNAL_SERVER_ERROR = 500;

    private CreateDoc create;


    protected BaseServlet() {}

    @Inject
    protected void setCreate(CreateDoc create) {
        this.create = create;
    }

    protected void issue(String mimeType, int returnCode, String output, HttpServletResponse response) throws IOException {
        response.setContentType(mimeType);
        response.setStatus(returnCode);
        response.getWriter().println(output);
    }

    protected void issueJson(HttpServletResponse response, int status, String... args) throws IOException {
        Preconditions.checkArgument(args.length % 2 == 0, "There must be an even number of strings");

        JSONObject obj = new JSONObject();
        for (int i = 0; i < args.length; i += 2) {
            obj.put(args[i], args[i+1]);
        }
        issueJson(response, status, obj);
    }

    protected void issueJson(HttpServletResponse response, int status, JSONObject obj) throws IOException {
        issue(MIME_APPLICATION_JSON, status, obj.toString(), response);
    }

    protected void showView(HttpServletResponse response, String templateName, Object... args) throws IOException {
        showView(response, templateName, CreateDoc.map(args));
    }

    protected void showView(HttpServletResponse response, String templateName, Map<String,Object> args) throws IOException {
         String html =  create.createDocumentString(templateName, args);
         issue(MIME_TEXT_HTML, HTTP_STATUS_OK, html, response);
     }

    protected String view(String templateName, Object... args) {
        return create.createDocumentString(templateName, CreateDoc.map(args));
    }

    protected int intParameter(String name, HttpServletRequest request, int deflt) {
        String s = request.getParameter(name);
        return (s == null) ? deflt : Integer.parseInt(s);
    }

    protected boolean booleanParameter(String name, HttpServletRequest request, boolean deflt) {
        String s = request.getParameter(name);
        return (s == null) ? deflt : Boolean.parseBoolean(s);
    }
}
