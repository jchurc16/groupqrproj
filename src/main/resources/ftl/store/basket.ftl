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
        <h4>Your Basket</h4>
    </div>
    <div data-role="content">
        <div>
            <ul class="main-cart" data-role="listview" data-inset="true" data-split-icon="delete">
                <#list lines as line>
                    <li>
                        <a href="/store/item/${line.sku.id}">
                            <img src="${imageRoot}${line.sku.thumb}" alt="thumbnail image"/>
                            <h3>${line.sku.title}</h3>
                            <p><#if line.quantity &gt; 1>
                                ${line.quantity} x &pound;${line.sku.unitPrice} = </#if>&pound;${line.cost}</p>
                        </a>
                        <a href="#" data-id="${line.uid}" class="cart-remove">Remove item</a>
                    </li>
                </#list>
            </ul>
        </div>

        <div class="cart-summary">
            <#if count &gt; 0 >
                <div style="clear:both"></div>
                <p><span class="cart-head">Subtotal:</span><span class="cart-item">${netCost}</span></p>
                <p><span class="cart-head">Shipping:</span><span class="cart-item">${shippingCost}</span></p>
                <p><span class="cart-head">Total:</span><span class="cart-item">&pound;${totalCost}</span></p>
            </#if>
        </div>

        <div style="margin-top: 4em">
            <a id="pay" data-role="button" href="#">Pay with PayPal</a>
            <a data-role="button" href="/store">Go to Store</a>
        </div>
    </div>


<script>
    $("#pay").click(function() {
        alert("No implemented yet");
    });
</script>
</div><!-- /page -->

</body>
</html>
