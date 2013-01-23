// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        Category.java  (14/01/13)
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


package com.cilogi.cart;

import com.google.appengine.api.search.checkers.Preconditions;

import java.io.Serializable;
import java.util.logging.Logger;


public class Category implements Serializable {
    static final Logger LOG = Logger.getLogger(Category.class.getName());

    private final String name;

    public Category(String name) {
        Preconditions.checkNotNull(name, "Category name can't be null");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Category) {
            Category c = (Category)o;
            return c.getName().equals(getName());
        }  else {
            return false;
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
