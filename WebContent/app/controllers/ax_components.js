axrControllers
.controller('ComponentsController', 
    function($scope, $rootScope,  $stateParams, axLocale, $state, componentsAPIService) {
	
	var isLogin = $rootScope.loginCheck();

    if (!isLogin) {
    	 $state.go('login');
    }
        
    // Localizations    
    $scope.home = axLocale.translate('home');
    $scope.about = axLocale.translate('about');
    $scope.products = axLocale.translate('products');
    $scope.warranty = axLocale.translate('warranty');
    $scope.dealers = axLocale.translate('dealers');
    $scope.contactUs = axLocale.translate('contactUs');
    

	$scope.getComponents = function() {
		componentsAPIService.getComponents().success(function(response) {
			if (response.success) {
				$scope.components = response.components;
			}
		});
	};
	
	$scope.getComponents();
	
	$scope.updateComponent = function(component) {
		componentsAPIService.updateComponent(component).success(function(response) {
			if (response.success) {
				$scope.getComponents();
			}
		});
	};
});
