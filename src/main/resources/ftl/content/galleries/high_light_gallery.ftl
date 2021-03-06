<#assign title="Sample Page">
<!DOCTYPE html>
<html ${manifest}>

<head>
    <#include "../../inc/_head.ftl">
</head>

<body>

<div data-role="page" class="gallery-page" id="high_light_gallery">

	<div data-role="header">
        <a href="/index.html" data-ajax="false">Home</a>
		<h1>High Light</h1>
	</div><!-- /header -->


    <div data-role="content">
   		<ul class="gallery">
   			<li><a href="high_light_images/images/high-light01.jpg" rel="external"><img src="high_light_images/thumbs/thumb_256_high-light01.jpg" alt="Ben Starav" /></a></li>
   			<li><a href="high_light_images/images/high-light02.jpg" rel="external"><img src="high_light_images/thumbs/thumb_256_high-light02.jpg" alt="Suilven and Cul Mor" /></a></li>
   			<li><a href="high_light_images/images/high-light03.jpg" rel="external"><img src="high_light_images/thumbs/thumb_256_high-light03.jpg" alt="Blaven and Clas Gas" /></a></li>
   			<li><a href="high_light_images/images/high-light04.jpg" rel="external"><img src="high_light_images/thumbs/thumb_256_high-light04.jpg" alt="Three Sisters" /></a></li>
   			<li><a href="high_light_images/images/high-light05.jpg" rel="external"><img src="high_light_images/thumbs/thumb_256_high-light05.jpg" alt="Inaccessible Pinnacle" /></a></li>
   			<li><a href="high_light_images/images/high-light06.jpg" rel="external"><img src="high_light_images/thumbs/thumb_256_high-light06.jpg" alt="Five Sisters" /></a></li>
   			<li><a href="high_light_images/images/high-light07.jpg" rel="external"><img src="high_light_images/thumbs/thumb_256_high-light07.jpg" alt="Moonrise, Rannoch Moor" /></a></li>
   			<li><a href="high_light_images/images/high-light08.jpg" rel="external"><img src="high_light_images/thumbs/thumb_256_high-light08.jpg" alt="Old Man of Storr" /></a></li>
   			<li><a href="high_light_images/images/high-light09.jpg" rel="external"><img src="high_light_images/thumbs/thumb_256_high-light09.jpg" alt="Stob Ghabar" /></a></li>
   		</ul>
   	</div>

    <#include "../../inc/_foot.ftl">


</div><!-- /page -->

</body>
</html>