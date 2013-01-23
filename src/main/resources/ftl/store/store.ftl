<#assign title="Colin's store">
<!DOCTYPE html>
<html>

<head>
    <#include "../inc/_head.ftl">
</head>

<body>

<div data-role="page">

    <div data-role="header">
        <a href="/index.html" data-icon="home" data-iconpos="notext">Home</a>
        <h4>Shop</h4>
    </div>

    <div data-role="content">
      <a class="cart-widget" href="/store/basket"><span class="cart-count">${count} </span><span class="cart-cost">${cost}</span></a>
      <ul data-role="listview">
        <#list items as item>
            <li class="item">
                <a class="item-entry" href="store/item/${item.id}">
                  <img alt="${item.title}" src="${imageRoot}${item.thumb}" />
                  <h3 class="item-title">${item.title}</h3>
                  <p class="item-description">${item.description}</p>
                  <p class="item-price">${item.unitPrice}</p>
                </a>
            </li>
        </#list>
        </ul>
     </div>


</div><!-- /page -->

</body>
</html>
