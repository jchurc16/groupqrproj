<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
<title>${title}</title>

<link rel="stylesheet" href="/css/jquery-mobile/jquery.mobile-1.2.0.min.css" />
<link rel="stylesheet" href="/css/photoswipe/jquery-mobile.css" />
<link rel="stylesheet" href="/css/photoswipe/photoswipe.css" />
<link rel="stylesheet" href="/css/store/store.css" />
<link rel="stylesheet" href="/css/font-awesome/jqm-icon-pack-2.1.2-fa.css"/>
<link rel="stylesheet" href="/css/Styles/main.css"/>

<script src="/js/jquery/jquery-1.8.2.min.js"></script>
<script src="/js/jquery-mobile/jquery.mobile-1.2.0.min.js"></script>

<script src="/js/photoswipe/lib/klass.min.js"></script>
<script src="/js/photoswipe/code.photoswipe.jquery-3.0.5.1.js"></script>

<script src="/js/local.js"></script>
<script>
$("#QR").live("click", function (e) {
    alert('Works!');
var pathname = window.location.href;
var dest = pathname + '/qr';
window.location.href = dest;
});

</script>
