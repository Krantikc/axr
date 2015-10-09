axrControllers
.controller('HeadersController', 
    function($scope, $rootScope,  $stateParams, axLocale, $state, $localStorage, productAPIService) {
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

    
    productAPIService.getAllProducts().success(function(response){
    	$rootScope.productsList = response.productsList;
    });
    
    var style = {backgroundColor: 'yellow', color: 'black', headerFontSize: 22, headerFontFamily: 'RobotoSlab'};
    AXStyles.setHeaderStyle(style);
});
