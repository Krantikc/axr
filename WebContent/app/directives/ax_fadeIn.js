axrApp.directive('fadeIn', function() {
    return {
        restrict: 'A',
        link: function($scope, $element, attr) {
            $(".main-image").fadeOut(2).fadeIn(700);
        }
    }
    
});
