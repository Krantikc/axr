axrControllers
.controller('ComponentsController', 
    function($scope, $rootScope,  $stateParams, axLocale, $state, componentsAPIService) {

    var isLogin = $rootScope.loginCheck();

    if (!isLogin) {
         $state.go('login');
    }
    
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
