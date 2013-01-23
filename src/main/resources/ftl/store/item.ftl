<#assign title="Item Description">
<!DOCTYPE html>
<html>

<head>
    <#include "../inc/_head.ftl">
</head>

<body>

<div data-role="page">

    <div data-role="header">
        <a href="/index.html" data-icon="home" data-iconpos="notext">Home</a>
        <h4>${item.title}</h4>
    </div>

    <div data-role="content">
      <a class="cart-widget" href="/store/basket"><span class="cart-count">${count}</span><span class="cart-cost">${cost}</span></a>
        <div>
          <img  class="item-image" alt="${item.title}" src="${imageRoot}${item.image}" />
        </div>

        <div class="item-info">
            <div class="item-title">${item.title}</div>
            <div class="item-description">${item.description}</div>
            <div class="item-price">&pound;${item.unitPrice}</div>
            <form class="store-item-form" method="post">
              <p>
                <input class="item-id" type="hidden" name="item-id" value="${item.id}" />
                <label>Quantity:</label>
                <input class="item-quantity" name="quantity" size="2" type="number" value="1" />
              </p>
              <p>
                <input id="addItem" class="uq" type="submit" value="Add to Cart" />
              </p>
            </form>
            <div class="back-link">
              <a data-role="button" href="/store">Back to Store</a>
            </div>
        </div>
    </div>


</div><!-- /page -->

</body>
</html>
