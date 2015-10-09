/**
 *  Products Service
 */
axrServices.
factory('productAPIService', function($http){
	
	var productAPI = {};
	
	productAPI.getAllProducts = function() {
		return $http({
			method: 'GET',
			url: 'getAllProducts.do'
		});
	};
	
	productAPI.getProductByModel = function(productId) {
		return $http({
			method: 'GET',
			url: 'getProductById.do',
			params: {productId: productId},
		});
	};
	
	productAPI.getProduct = function(productId, colorId, graphicsId, graphicsColorId) {
		return $http({
			method: 'GET',
			url: 'getProduct.do',
			params: {productId: productId, colorId: colorId, graphicsId: graphicsId, graphicsColorId: graphicsColorId},
		});
	};
	
	productAPI.addProduct = function(product) {
		return $http({
			method: 'POST',
			url: 'addProduct.do',
			data: product,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	};
	
	productAPI.saveProduct = function(product) {
		return $http({
			method: 'POST',
			url: 'saveProduct.do',
			data: product,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	};
	
	productAPI.deleteProduct = function(productId) {
		return $http({
			method: 'POST',
			url: 'deleteProduct.do',
			data: {productId: productId},
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	};
	
	
	return productAPI;
});


/**
 *  Product Features Service
 */

axrServices.
factory('productFeaturesAPIService', function($http){
	
	var productFeaturesAPI = {};

	productFeaturesAPI.getProductFeatures = function(productId) {
		return $http({
			method: 'GET',
			url: 'getProductFeatures.do',
			params: {productId: productId},
		});
	}

	productFeaturesAPI.addProductFeature = function(productFeature) {
		return $http({
			method: 'POST',
			url: 'addProductFeature.do',
			data: productFeature,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	}
	
	productFeaturesAPI.saveProductFeature = function(productFeature) {
		return $http({
			method: 'POST',
			url: 'saveProductFeature.do',
			data: productFeature,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	}
	
	productFeaturesAPI.deleteProductFeature = function(productFeatureId) {
		return $http({
			method: 'POST',
			url: 'deleteProductFeature.do',
			data: {productFeatureId: productFeatureId},
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	}
	
	
	return productFeaturesAPI;
});


/**
 *  Product Colors Service
 */

axrServices.
factory('productColorsAPIService', function($http){
	
	var productColorsAPI = {};

	productColorsAPI.getProductColorsByModel = function(productId) {
		return $http({
			method: 'GET',
			url: 'getProductColorsById.do',
			params: {productId: productId},
		});
	}

	productColorsAPI.addProductColor = function(productColor) {
		return $http({
			method: 'POST',
			url: 'addProductColor.do',
			data: productColor,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	}
	
	productColorsAPI.saveProductColor = function(productColor) {
		return $http({
			method: 'POST',
			url: 'saveProductColor.do',
			data: productColor,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	}
	
	productColorsAPI.deleteProductColor = function(productColorId) {
		return $http({
			method: 'POST',
			url: 'deleteProductColor.do',
			data: {productColorId: productColorId},
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	}
	
	
	return productColorsAPI;
});


/**
 *  Product Graphics Service
 */

axrServices.
factory('productGraphicsAPIService', function($http){
	
	var productGraphicsAPI = {};

	productGraphicsAPI.getProductGraphicsByColor = function(productId, productColorId) {
		return $http({
			method: 'GET',
			url: 'getProductGraphicsByColor.do',
			params: {productId: productId, productColorId: productColorId},
		});
	}

	productGraphicsAPI.addProductGraphics = function(productGraphics) {
		return $http({
			method: 'POST',
			url: 'addProductGraphics.do',
			data: productGraphics,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	}
	
	productGraphicsAPI.saveProductGraphics = function(productGraphics) {
		return $http({
			method: 'POST',
			url: 'saveProductGraphics.do',
			data: productGraphics,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	}
	
	productGraphicsAPI.deleteProductGraphics = function(productGraphicsId) {
		return $http({
			method: 'POST',
			url: 'deleteProductGraphics.do',
			data: {productGraphicsId: productGraphicsId},
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	}
	
	
	return productGraphicsAPI;
});


/**
 *  Product Graphics Color Service
 */

axrServices.
factory('productGraphicsColorAPIService', function($http) {
	
	var productGraphicsColorAPI = {};

	productGraphicsColorAPI.getProductGraphicsColorsByGraphics = function(productId, productGraphicsId) {
		return $http({
			method: 'GET',
			url: 'getProductGraphicsColorsByGraphics.do',
			params: {productId: productId, productGraphicsId: productGraphicsId},
		});
	}

	productGraphicsColorAPI.addProductGraphicsColor = function(productGraphicsColor) {
		return $http({
			method: 'POST',
			url: 'addProductGraphicsColor.do',
			data: productGraphicsColor,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			}
		});
	}
	
	productGraphicsColorAPI.saveProductGraphicsColor = function(productGraphicsColor) {
		return $http({
			method: 'POST',
			url: 'saveProductGraphicsColor.do',
			data: productGraphicsColor,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	}
	
	productGraphicsColorAPI.deleteProductGraphicsColor = function(productGraphicsColorId) {
		return $http({
			method: 'POST',
			url: 'deleteProductGraphicsColor.do',
			data: {productGraphicsColorId: productGraphicsColorId},
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	}
	
	
	return productGraphicsColorAPI;
});


