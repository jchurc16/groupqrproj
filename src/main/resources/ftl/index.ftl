<#assign title="Welcome to the QR Mobile Demo!">
<!DOCTYPE html>
<html ${manifest}>

<head>
    <#include "inc/_head.ftl">
</head>

<body>

<div data-role="page">

	<div data-role="header">
		<h1>QR Mobile Demo</h1>
	</div><!-- /header -->

	<div data-role="content">
        <p>This is the main page of the site, which will link to the photo descriptions, and the shop.</p>

        <p>At the moment there is <a href="content/pages/sample.html" data-ajax="false">a page</a>
          and <a href="content/galleries/high_light_gallery.html">an image gallery</a> and the
          rudiments of <a href="store">a shop</a></p>
	</div><!-- /content -->

    <#include "inc/_foot.ftl">

</div><!-- /page -->

</body>
</html>