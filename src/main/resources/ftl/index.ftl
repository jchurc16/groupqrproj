<#assign title="Welcome to the QR Mobile Demo!">
<!DOCTYPE html>
<html ${manifest}>

<head>
    <#include "inc/_head.ftl">
</head>


<body>

<div data-role="page" id="body">
<div id="container">
	<div data-role="header" id="header">
		<center><h1>QR Mobile Demo</h1></center>
	</div><!-- /header -->

	<center><div data-role="content" id="maincontent">
        <p>This is the main page of the site, which will link to the photo descriptions, and the shop.</p>
		<img src="high-light06.jpg" alt="Main Image" width="100%" max-width="400px">

        
	</div></center><!-- /content -->

<#include "inc/_foot.ftl">
</div><!-- /page -->
</div>

</body>
</html>