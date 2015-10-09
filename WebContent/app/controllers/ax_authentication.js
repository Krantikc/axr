axrControllers
.controller('AuthenticationController', function($scope, $rootScope, $state, $http, $localStorage, authAPIService) {

	var isLoggedIn = $rootScope.loginCheck();

	if(isLoggedIn) {
		$state.go('home');
	}
	$rootScope.login = function(isValid) {	
		if (isValid) {
			authAPIService.authenticateUser($scope.loginCredentials).success(function(response) {
				if(!response.success) {
					$scope.error = response.error;
					$state.go('login');
				} else {
					$scope.error = '';
					$localStorage.currentUser = angular.toJson(response.currentUser);
					$state.go('home');
				}			
			});
		
		} else {
			alert('Please fill fields with valid inputs');
		}
	};
	
});