axrControllers
.controller('ProductsController', 
    function($scope, $rootScope,  $stateParams, $http, $state, axLocale, productAPIService) {
	
	var isLogin = $rootScope.loginCheck();

    if (!isLogin) {
    	 $state.go('login');
    }
     // Localizations
    $scope.colorsTitle = axLocale.translate('colors');
    $scope.featuresTitle = axLocale.translate('features');
    $scope.graphicsTitle = axLocale.translate('graphics');
    $scope.graphicsColorsTitle = axLocale.translate('graphicsColors');
    
    productAPIService.getAllProducts().success(function(response){
    	$scope.productsList = response.productsList;
    }); 
    /* $http.get('data/products.json').success(function(response){
          $scope.productList = response;
      }); 
*/
    $scope.addNewProduct = function(isFormValid) {
		console.log(isFormValid+"-"+$scope.product.name+' '+$scope.product.description);
		productAPIService.addProduct($scope.product).success(function(response){
			if(response.success) {
				$scope.result = 'Product added successfully';
	    		$scope.product = {};
	    		$scope.productsForm.$setPristine();
	    		productAPIService.getAllProducts().success(function(response){
	    	    	$scope.productsList = response.productsList;
	    	    });
			}
		});
		
	};
    
    $scope.saveProduct = function(product) {
		productAPIService.saveProduct(product).success(function(response) {
			if(response.success) {
				$scope.result = 'Product updated successfully';
			}
		});
		
	};
    
    $scope.deleteProduct = function(productId) {
    	var isConfirm = confirm('Are you sure to delete the Product?');
    	if (isConfirm) {
    		productAPIService.deleteProduct(productId).success(function(response) {
    			if(response.success) {
    				$scope.result = 'Product deleted successfully';
    	    		productAPIService.getAllProducts().success(function(response){
    	    	    	$scope.productsList = response.productsList;
    	    	    });
    			}
    		});
    	}
	};
});



axrControllers
.controller('ProductsFeaturesController', 
    function($scope, $rootScope,  $stateParams, $http, $state, axLocale, productFeaturesAPIService) {
	
	var isLogin = $rootScope.loginCheck();

    if (!isLogin) {
    	 $state.go('login');
    }
    
    // Localizations
    $scope.colorsTitle = axLocale.translate('colors');
    $scope.featuresTitle = axLocale.translate('features');
    $scope.graphicsTitle = axLocale.translate('graphics');
    $scope.graphicsColorsTitle = axLocale.translate('graphicsColors');

    $scope.modelId = $stateParams.modelId;
    
    $scope.loadProductFeatures = function() {
    	 productFeaturesAPIService.getProductFeatures($scope.modelId).success(function(response) {
    	    	$scope.productFeatures = response.productFeatures;
    	    	$scope.product = response.product;
    	    	
    	    }); 
    };
   
    $scope.loadProductFeatures();

    $scope.deleteProductFeature = function(productFeatureId) {
    	var isConfirm = confirm('Are you sure to delete the Product Feature?');
    	if (isConfirm) {
    		productFeaturesAPIService.deleteProductFeature(productFeatureId).success(function(response) {
    			if(response.success) {
    				$scope.result = 'Product Feature deleted successfully';
    				$scope.loadProductFeatures();
    			}
    		});
    	}
	};
});
    

axrControllers
.controller('ProductsColorController', 
    function($scope, $rootScope,  $stateParams, $http, $state, axLocale, productColorsAPIService) {
	
	var isLogin = $rootScope.loginCheck();

    if (!isLogin) {
    	 $state.go('login');
    }
    
    // Localizations
    $scope.colorsTitle = axLocale.translate('colors');
    $scope.featuresTitle = axLocale.translate('features');
    $scope.graphicsTitle = axLocale.translate('graphics');
    $scope.graphicsColorsTitle = axLocale.translate('graphicsColors');

    $scope.modelId = $stateParams.modelId;
    
    $scope.loadProductColors = function() {
    	 productColorsAPIService.getProductColorsByModel($scope.modelId).success(function(response) {
    	    	$scope.productColors = response.productColors;
    	    	$scope.product = response.product;
    	    	
    	    	$.each($scope.productColors, function(index, productColor) {
    	    		if(productColor.defaultColor) {
    	    	    	$scope.defaultColorId = productColor.productColorId;
    	    		}
    	    	});

    	    }); 
    };
   
    $scope.loadProductColors();
    
    $scope.addNewProductColor = function(isFormValid) {
		console.log(isFormValid+"-"+$scope.product.name+' '+$scope.product.description);
		$scope.productColor.productId = $scope.product.productId;
		productColorsAPIService.addProductColor($scope.productColor).success(function(response){
			if(response.success) {
				$scope.result = 'Product Color added successfully';
	    		$scope.productColor = {};
	    		$scope.productColorForm.$setPristine();
	    		$scope.loadProductColors();
			}
		});
		
	};
    
    
    $scope.saveProductColor = function(productColor, defaultProductColorId) {
    	productColor.defaultProductColorId = defaultProductColorId;
    	productColorsAPIService.saveProductColor(productColor).success(function(response) {
			if(response.success) {
				$scope.result = 'Product updated successfully';
			}
		});
		
	};
    
    $scope.deleteProductColor = function(productColorId) {
    	var isConfirm = confirm('Are you sure to delete the Product Color?');
    	if (isConfirm) {
    		productColorsAPIService.deleteProductColor(productColorId).success(function(response) {
    			if(response.success) {
    				$scope.result = 'Product Color deleted successfully';
    				$scope.loadProductColors();
    			}
    		});
    	}
	};
    
    /* 
   $http.get('data/products.json').success(function(response){
          for(var i=0; i<response.length; i++) {
              var product = response[i];
              if(product.productId == $scope.modelId) {
                  $scope.product = product;
                  $rootScope.selectedAngle = 'n';
                  $rootScope.selectedColor = $scope.product.defaultColor;
                  $rootScope.selectedGraphics = $scope.product.defaultGraphics;
                  $rootScope.selectedGraphicsColor = $scope.product.defaultGraphicsColor;
              }
          }
          
      }); */
});

axrControllers
.controller('ProductsGraphicsController', 
    function($scope, $rootScope,  $stateParams, $http, $state, axLocale, productGraphicsAPIService) {
	
	var isLogin = $rootScope.loginCheck();

    if (!isLogin) {
    	 $state.go('login');
    }
    
	 // Localizations
    $scope.colorsTitle = axLocale.translate('colors');
    $scope.featuresTitle = axLocale.translate('features');
    $scope.graphicsTitle = axLocale.translate('graphics');
    $scope.graphicsColorsTitle = axLocale.translate('graphicsColors');

    $scope.modelId = $stateParams.modelId;
    $scope.colorId = $stateParams.colorId;
    $scope.colorName = $stateParams.colorName;
    
    $scope.loadProductGraphics = function() {
    	productGraphicsAPIService.getProductGraphicsByColor($scope.modelId, $scope.colorId).success(function(response) {
        	$scope.productGraphics = response.productGraphics;
        	$scope.product = response.product;
        	
        	$.each($scope.productGraphics, function(index, productGraphics) {
        		if(productGraphics.defaultGraphics) {
        	    	$scope.defaultGraphicsId = productGraphics.productGraphicsId;
        		}
        	});

        }); 
    };
    
    $scope.loadProductGraphics();
    
    
    $scope.addNewProductGraphics = function(isFormValid) {
		console.log(isFormValid+"-"+$scope.product.name+' '+$scope.product.description);
		$scope.productGraphics.productId = $scope.modelId;
		$scope.productGraphics.productColorId = $scope.colorId;
		productGraphicsAPIService.addProductGraphics($scope.productGraphics).success(function(response){
			if(response.success) {
				$scope.result = 'Product Graphics added successfully';
	    		$scope.productGraphics = {};
	    		$scope.productGraphicsForm.$setPristine();
	    		$scope.loadProductGraphics();
			}
		});
		
	};
    
    
    $scope.saveProductGraphics = function(productGraphics, defaultProductGraphicsId) {
    	productGraphics.defaultProductGraphicsId = defaultProductGraphicsId;
		productGraphics.productId = $scope.modelId;
		productGraphics.productColorId = $scope.colorId;
    	productGraphicsAPIService.saveProductGraphics(productGraphics).success(function(response) {
			if(response.success) {
				$scope.result = 'Product updated successfully';
			}
		});
		
	};
    
    $scope.deleteProductGraphics = function(productGraphicsId) {
    	var isConfirm = confirm('Are you sure to delete the Product Graphics?');
    	if (isConfirm) {
    		productGraphicsAPIService.deleteProductGraphics(productGraphicsId).success(function(response) {
    			if(response.success) {
    				$scope.result = 'Product Graphics deleted successfully';
    				$scope.loadProductGraphics();
    			}
    		});
    	}
	};
});

axrControllers
.controller('ProductsGraphicsColorController', 
    function($scope, $rootScope,  $stateParams, $http, $state, axLocale, productGraphicsColorAPIService, Upload) {
	var isLogin = $rootScope.loginCheck();

    if (!isLogin) {
    	 $state.go('login');
    } 
	// Localizations
    $scope.colorsTitle = axLocale.translate('colors');
    $scope.featuresTitle = axLocale.translate('features');
    $scope.graphicsTitle = axLocale.translate('graphics');
    $scope.graphicsColorsTitle = axLocale.translate('graphicsColors');

    $scope.modelId = $stateParams.modelId;
    $scope.colorId = $stateParams.colorId;
    $scope.graphicsId = $stateParams.graphicsId;
    $scope.colorName = $stateParams.colorName;
    $scope.graphicsName = $stateParams.graphicsName;
    
    $scope.loadProductGraphicsColors = function() {
    	productGraphicsColorAPIService.getProductGraphicsColorsByGraphics($scope.modelId, $scope.graphicsId).success(function(response) {
        	$scope.productGraphicsColors = response.productGraphicsColors;
        	$scope.product = response.product;
        	
        	$.each($scope.productGraphicsColors, function(index, productGraphicsColor) {
        		if(productGraphicsColor.defaultGraphicsColor) {
        	    	$scope.defaultGraphicsColorId = productGraphicsColor.productGraphicsColorId;
        		}
        	});

        }); 
    };
    
    $scope.loadProductGraphicsColors();
    
    $scope.productGraphicsColor = {};
    $scope.uploadFileAsStream = function(fileFieldName) {
    	$scope[fileFieldName+'Uploaded'] = false;
    	var file = document.getElementById(fileFieldName).files[0];
    	var fileReader = new FileReader();
    	fileReader.onloadend = function(e) {
    		$scope.productGraphicsColor[fileFieldName] = e.target.result;
    		$scope[fileFieldName+'Uploaded'] = true;
    		$scope.$digest();
    	};
    	fileReader.readAsBinaryString(file);
    };
    
    $scope.upload = function(file) {
    	    var formData=new FormData();
    	    formData.append("file",file);


    	    console.log(formData);
    	    
    	    jQuery.ajax({
    	        url: 'uploadProductGraphicsColorImage.do',
    	        data: formData,
    	        cache: false,
    	        contentType: 'multipart/form-data',
    	        processData: false,
    	        type: 'POST',
    	        success: function(data){
    	            alert(data);
    	        }
    	    });

    };
    $scope.addNewProductGraphicsColor = function(isFormValid) {
		console.log(isFormValid+"-"+$scope.product.name+' '+$scope.product.description);
		$scope.productGraphicsColor.productId = $scope.modelId;
		$scope.productGraphicsColor.productGraphicsId = $scope.graphicsId;
		
		productGraphicsColorAPIService.addProductGraphicsColor($scope.productGraphicsColor, $scope.frontAngle).success(function(response) {
			if(response.success) {
				$scope.result = 'Product GraphicsColor added successfully';
	    		$scope.productGraphicsColor = {};
	    		$scope.productGraphicsColorForm.$setPristine();
	    		$scope.loadProductGraphicsColors();
	    		var file = document.getElementById('frontAngle').files[0];
	  /*  		Upload.upload({
	    	        url: 'uploadProductGraphicsColorImage.do',
	    	        file: file,
	    	        contentType: false,
	    	        method: 'POST',
	    	        
	    	        progress: function(e){}
	    	      }).then(function(data, status, headers, config) {
	    	        // file is uploaded successfully
	    	        console.log(data);
	    	      });*/
	    		
	    		$scope.upload(file);
			}
		});
		
	};

    
    $scope.saveProductGraphicsColor = function(productGraphicsColor, defaultProductGraphicsColorId) {
    	productGraphicsColor.defaultProductGraphicsColorId = defaultProductGraphicsColorId;
		productGraphicsColor.productId = $scope.modelId;
		productGraphicsColor.productGraphicsId = $scope.graphicsId;
    	productGraphicsColorAPIService.saveProductGraphicsColor(productGraphicsColor).success(function(response) {
			if(response.success) {
				$scope.result = 'Product updated successfully';
			}
		});
		
	};
    
    $scope.deleteProductGraphicsColor = function(productGraphicsColorId) {
    	var isConfirm = confirm('Are you sure to delete the Product Graphics Color?');
    	if (isConfirm) {
    		productGraphicsColorAPIService.deleteProductGraphicsColor(productGraphicsColorId).success(function(response) {
    			if(response.success) {
    				$scope.result = 'Product Graphics Color deleted successfully';
    				$scope.loadProductGraphicsColors();
    			}
    		});
    	}
	};
});