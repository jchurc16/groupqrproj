<#assign title="QR code and short URL">
<!DOCTYPE html>
<html>

<head>
    <#include "inc/_head.ftl">
</head>

<body>

<div data-role="page">

	<div data-role="header">
        <a href="/index.html" data-icon="home" data-iconpos="notext">Home</a>
		<h4>QR Code and Short URL</h4>
	</div><!-- /header -->

	<div data-role="content">
        <p>Below are the QR code and short URL for <code>${url}</code></p>

        <p><img src="${qrCode}" alt="QR for ${url}" width=256></p>
        <p><a href="${shortURL}">${shortURL}</a></p>
	</div><!-- /content -->

    <#include "inc/_foot.ftl">

</div><!-- /page -->

</body>
</html>