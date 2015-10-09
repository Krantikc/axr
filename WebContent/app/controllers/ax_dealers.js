axrControllers
.controller('DealersController', 
    function($scope, $rootScope, axLocale, dealersAPIService) {
		// Localizations
		$scope.dealersTitle = axLocale.translate('dealers');
        
		/*$.get('data/dealers.json').success(function(response){
			$scope.dealersList = response;
		});*/
		
		$scope.loadDealers = function() {
			dealersAPIService.getDealers().success(function(response) {
				if (response.success) {
					$scope.dealersList = response.dealers;
				}
			});
		};
		
		$scope.loadDealers();
		
		$scope.createDealer = function(isValid) {
			if (isValid) {
				dealersAPIService.createDealer($scope.dealer).success(function(response) {
					if(response.success) {
						
						$scope.dealer = {};
						$scope.dealersForm.$setPristine();
						$scope.loadDealers();
					}
				});
			}
			
		};
		
		$scope.updateDealer = function(dealer) {
			dealersAPIService.updateDealer(dealer).success(function(response) {
				if(response.success) {
					$scope.loadDealers();
				}
			});
			
		};
		
		$scope.deleteDealer = function(dealerId) {
	    	var isConfirm = confirm('Are you sure to delete the Product Graphics?');
	    	if (isConfirm) {
	    		dealersAPIService.deleteDealer(dealerId).success(function(response) {
	    			if(response.success) {
	    				$scope.result = 'Dealer deleted successfully';
	    				$scope.loadDealers();
	    			}
	    		});
	    	}
		};
		
		
});