axrControllers
.controller('BlocksController', 
    function($scope, $rootScope, axLocale, $state, blocksAPIService) {
	
	var isLogin = $rootScope.loginCheck();

    if (!isLogin) {
    	 $state.go('login');
    }
		// Localizations

	$scope.getBlocks = function() {
		blocksAPIService.getBlocks().success(function(response) {
			if (response.success) {
				$scope.blocks = response.blocks;
			}
		});
	};
	
	$scope.getBlocks();
	
	$scope.updateBlock = function(block) {
		blocksAPIService.updateBlock(block).success(function(response) {
			if (response.success) {
				$scope.getBlocks();
			}
		});
	};
	
});