// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        ISku.java  (14/01/13)
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

import java.math.BigDecimal;

public interface ISku {
    public String getId();
    public String getTitle();
    public String getDescription();
    public String getThumb();
    public String getImage();
    public BigDecimal getUnitPrice();
    public String getURL();
    public Category getCategory();
    public String getProperty(String name);
}
