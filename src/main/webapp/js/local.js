(function(window, $, PhotoSwipe){

    $(document).bind('pageinit', function(){

        $('div.gallery-page')
            .live('pageshow', function(e){

                var currentPage = $(e.target),
                    options = {};

                var photoswipeInstance = PhotoSwipe.getInstance(currentPage.attr('id'));

                if (typeof photoSwipeInstance == "undefined" || photoSwipeInstance == null) {
                    photoSwipeInstance = $("ul.gallery a", e.target).photoSwipe(options,  currentPage.attr('id'));
                }

                return true;

            })

            .live('pagehide', function(e){

                var currentPage = $(e.target),
                    photoSwipeInstance = PhotoSwipe.getInstance(currentPage.attr('id'));

                if (typeof photoSwipeInstance != "undefined" && photoSwipeInstance != null) {
                    PhotoSwipe.detatch(photoSwipeInstance);
                }

                return true;

            });

    });

}(window, window.jQuery, window.Code.PhotoSwipe));
