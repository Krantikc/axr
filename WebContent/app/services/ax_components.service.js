axrServices.
factory('componentsAPIService', function($http) {
	
	var componentsAPI = {};
	
	componentsAPI.getComponents = function() {
		return $http({
			method: 'GET',
			url: 'getComponents.do'
		});
	};
	

	componentsAPI.updateComponent = function(component) {
		return $http({
			method: 'POST',
			url: 'updateComponent.do',
			data: component,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	};
	
	
	return componentsAPI;
});
