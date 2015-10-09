axrApp.directive('imageonload', function() {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            element.bind('load', function() {
                if(attrs.imageonload!=='') {
                    scope.$apply(attrs.imageonload);
                } else {
                    element.parent().fadeOut(0).fadeIn(700);
                    element.parent().zoom();
                }
            });
        }
    }
});
