// Copyright (c) 2013 Cilogi. All Rights Reserved.
//
// File:        IBasket.java  (14/01/13)
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
import java.util.List;

public interface IBasket {
    public List<ILineItem> getLineItems();
    public void addLineItem(ILineItem item);
    public void removeLineItem(ILineItem item);

    public BigDecimal getNetCost();
    public BigDecimal getTax();
    public BigDecimal getShipping();
}
