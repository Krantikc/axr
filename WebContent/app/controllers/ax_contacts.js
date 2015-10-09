axrControllers
.controller('ContactsController', 
    function($scope, $rootScope, axLocale, contactsAPIService) {
    // Localizations
    	$scope.contactUsTitle = axLocale.translate('contactUs');
    	
    	$scope.submitForm = function(isFormValid) {
    		console.log(isFormValid);
    		contactsAPIService.sendEnquiry($scope.enquiry).success(function(response){
    			if(response.success) {
    				$scope.result = 'Thank you! We have recieved your enquiry';
    	    		$scope.enquiry = {};
    	    		$scope.contactsForm.$setPristine();
    			}
    		});
    		
    	};
});