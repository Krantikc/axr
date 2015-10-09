axrApp.directive('redirect', function() {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
        	element.ready(function() {
                if(attrs.redirect!=='') {
                	location.href='/#/'+attrs.redirect;
                } else {
                	location.href='/#/home';
                }
            });
        }
    }
    
});
