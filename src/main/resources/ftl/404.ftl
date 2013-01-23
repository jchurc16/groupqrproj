<#assign title="Page Not Found">
<!DOCTYPE html>
<html ${manifest}>

<head>
    <#include "inc/_head.ftl">
</head>

<body>

<div data-role="page">

	<div data-role="header">
		<h1>${title}</h1>
	</div><!-- /header -->

	<div data-role="content">
        <p>Sorry, we can't find the page you're looking for.</p>
	</div><!-- /content -->

	<div data-role="footer">
<h4>Footer content</h4>
	</div><!-- /footer -->

</div><!-- /page -->

</body>
</html>