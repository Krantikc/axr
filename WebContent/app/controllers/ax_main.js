axrControllers
.controller('MainController', function($scope, $rootScope, $location, $state, $http, $localStorage, authAPIService) {

    $rootScope.loginCheck = function() {
        if ($localStorage.currentUser != null) {
            return true;
        } else {
            return false;
        }
    };

    $rootScope.logout = function() {
        authAPIService.logoutUser().success(function(response) {
            delete $localStorage.currentUser;
            $state.go("login");
        });
    };
});