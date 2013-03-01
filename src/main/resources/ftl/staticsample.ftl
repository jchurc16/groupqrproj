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
        <p>This is a page built to test our ability to add pages to the site.</p>
		
<a href="index.html" data-role="button">To the home page!</a>
        
	</div></center><!-- /content -->

<#include "inc/_foot.ftl">
</div><!-- /page -->
</div>

</body>
</html>