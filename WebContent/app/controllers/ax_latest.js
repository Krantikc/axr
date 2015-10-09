axrControllers
.controller('LatestController', 
    function($scope, $rootScope, $state, axLocale, productAPIService, productColorsAPIService, productGraphicsAPIService, productGraphicsColorAPIService, homeAPIService) {
		var isLogin = $rootScope.loginCheck();
	
	    if (!isLogin) {
	    	 $state.go('login');
	    }
		// Localizations
		$scope.aboutTitle = axLocale.translate('about');
		$scope.aboutUsP1 = axLocale.translate('aboutUsP1');
		$scope.aboutUsP2 = axLocale.translate('aboutUsP2');
		
		$scope.getLatestDesigns = function() {
			homeAPIService.getLatestDesigns().success(function(response) {
				if (response.success) {
					$scope.latestDesigns = response.latestDesigns;
				}
			});
		};
		
		$scope.loadProducts = function() {
			productAPIService.getAllProducts().success(function(response) {
				$scope.productsList = response.productsList;
			});
		};
		
		$scope.getLatestDesigns();
		$scope.loadProducts();
		
		$scope.loadColors = function(productId) {
			productColorsAPIService.getProductColorsByModel(productId).success(function(response) {
				$scope.productColors = response.productColors;
			});
		};
		
		$scope.loadGraphics = function(productId, colorId) {
			productGraphicsAPIService.getProductGraphicsByColor(productId, colorId).success(function(response) {
				$scope.productGraphics = response.productGraphics;
			});
		};
		
		$scope.loadGraphicsColors = function(productId, graphicsId) {
			productGraphicsColorAPIService.getProductGraphicsColorsByGraphics(productId, graphicsId).success(function(response) {
				$scope.productGraphicsColors = response.productGraphicsColors;
			});
		};

		$scope.addLatestDesign = function(isFormValid) {
			if (isFormValid) {
				homeAPIService.addLatestDesign($scope.latestDesign).success(function(response) {
					if (response.success) {
						$scope.latestDesignForm.$setPristine();
						$scope.getLatestDesigns();
					}
				});
			} else {
				alert('Please choose all the fields');
			}
		};
		
		$scope.deleteLatestDesign = function(latestDesignId) {
			var isConfirm = confirm('Are you sure to delete the latest design ?');
			if (isConfirm) {
				homeAPIService.deleteLatestDesign(latestDesignId).success(function(response) {
					if (response.success) {
						$scope.getLatestDesigns();
					}
				});
			}
		};
	
});