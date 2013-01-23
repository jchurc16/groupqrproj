<#assign title="Sample Page">
<!DOCTYPE html>
<html ${manifest}>

<head>
    <#include "../../inc/_head.ftl">
</head>

<body>

<div data-role="page">

	<div data-role="header">
        <a href="/index.html" data-icon="home" data-iconpos="notext">Home</a>
		<h1>Sample Page</h1>
	</div><!-- /header -->

	<div data-role="content">
        <img src="../images/high-light06.jpg" width="100%">
        <p>This is a sample page. It contains a description of an image, and (eventually) links
           to the site and links which let you buy the image and/or calendar(s) containing it.</p>
	</div><!-- /content -->

    <#include "../../inc/_foot.ftl">

</div><!-- /page -->

</body>
</html>