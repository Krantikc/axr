axrApp = angular.module('AXRHelmets', ['ui.router', 'AXRControllers', 'AXRServices']);

axrApp.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/home');

    $stateProvider
	    .state('login', {
	        url: '/login',
	        templateUrl: 'partials/login.html',
	        controller: 'AuthenticationController'
	    })
	    .state('blocks', {
	        url: '/blocks',
	        templateUrl: 'partials/blocks.html',
	        controller: 'BlocksController'
	    })
        .state('components', {
            url: '/components',
            templateUrl: 'partials/components.html',
            controller: 'ComponentsController'
        })
        .state('home', {
            url: '/home',
            templateUrl: 'partials/home.html',
            controller: 'HomeController'
        })
        .state('products', {
            url: '/products',
            templateUrl: 'partials/products.html',
            controller: 'ProductsController'
        })
        .state('products_features', {
            url: '/products/features/:modelId',
            templateUrl: 'partials/products.features.html',
            controller: 'ProductsFeaturesController'
        })
        .state('products_color', {
            url: '/products/color/:modelId',
            templateUrl: 'partials/products.color.html',
            controller: 'ProductsColorController'
        })
        .state('products_graphics', {
            url: '/products/graphics/:modelId/:colorId/:colorName',
            templateUrl: 'partials/products.graphics.html',
            controller: 'ProductsGraphicsController'
        })
        .state('products_graphics_color', {
            url: '/products/graphicscolor/:modelId/:colorId/:graphicsId/:colorName/:graphicsName',
            templateUrl: 'partials/products.graphicscolor.html',
            controller: 'ProductsGraphicsColorController'
        })
        .state('latest', {
            url: '/latest',
            templateUrl: 'partials/latest_designs.html',
            controller: 'LatestController'
        })
        .state('about', {
            url: '/about',
            templateUrl: 'partials/about.html',
            controller: 'AboutController'
        })
        .state('warranty', {
            url: '/warranty',
            templateUrl: 'partials/warranty.html',
            controller: 'WarrantyController'
        })
        .state('dealers', {
            url: '/dealers',
            templateUrl: 'partials/dealers.html',
            controller: 'DealersController'
        })
        .state('contacts', {
            url: '/contacts',
            templateUrl: 'partials/contacts.html',
            controller: 'ContactsController'
        }); 
});

axrControllers = angular.module('AXRControllers', ['ngFileUpload', 'ngStorage']);
axrServices = angular.module('AXRServices', []);