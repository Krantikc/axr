window.ax_utils = {
    
    zoom: function(imageClass) {

        $('.easyzoom').easyZoom();

        // Get an instance API
        var api1 = $easyzoom.filter('.' + imageClass).data('easyZoom');
    }
    

};