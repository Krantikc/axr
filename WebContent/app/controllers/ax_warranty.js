axrControllers
.controller('WarrantyController', 
    function($scope, $rootScope, axLocale) {
		// Localizations
    	$scope.warrantyTitle = axLocale.translate('warranty');
    	$scope.warrantyName = axLocale.translate('warrantyName');
    	$scope.warrantyAge = axLocale.translate('warrantyAge');
    	$scope.warrantyLocation = axLocale.translate('warrantyLocation');
    	$scope.warrantyProfession = axLocale.translate('warrantyProfession');
    	$scope.warrantyProductNo = axLocale.translate('warrantyProductNo');
    	$scope.warrantyEmail = axLocale.translate('warrantyEmail');
    	$scope.warrantyContact = axLocale.translate('warrantyContact');
});