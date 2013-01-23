// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        UserCheckFilter.java  (12/01/13)
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


package com.cilogi.qr.filters;

import com.cilogi.util.IOUtil;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.common.collect.Lists;
import org.json.simple.JSONValue;

import javax.inject.Singleton;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

@Singleton
public class UserCheckFilter implements Filter {
    static final Logger LOG = Logger.getLogger(UserCheckFilter.class.getName());

    private List<String> permittedEmails;

    private static final String LOGOUT_URL = "/logout";

    public void init(FilterConfig fConfig) throws ServletException {
        permittedEmails = permittedEmails();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String uri = ((HttpServletRequest)request).getRequestURI();
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        String userName = (user == null) ? "null" : user.getEmail();
        LOG.info("User is " + userName + " uri is " + uri);
        if (user != null && !LOGOUT_URL.equals(uri) && !permittedEmails.contains(user.getEmail())) {
            LOG.info("logging out " +userName);
            String logoutURL = userService.createLogoutURL("/404.html");
            RequestDispatcher rd = request.getRequestDispatcher(logoutURL);
            rd.forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

    @SuppressWarnings("unchecked")
    static List<String> permittedEmails() {
        try {
            URL url = UserCheckFilter.class.getResource("/permittedEmails.json");
            return (List<String>)JSONValue.parse(IOUtil.readString(url));
        } catch (IOException e) {
            return Lists.newArrayList();
        }
    }
}
