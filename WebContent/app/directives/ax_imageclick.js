axrApp.directive('imageonclick', function() {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            element.bind('click', function() {
            	$('.main-image').trigger('zoom.destroy');
                if(attrs.imageonclick!=='') {
                    scope.$apply(attrs.imageonclick);
                } else {
                    $('.main-image').fadeOut(0).fadeIn(700);
                    $('.main-image').zoom();
                }
            });
        }
    }
});
