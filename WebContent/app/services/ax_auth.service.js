axrServices.
factory('authAPIService', function($http) {
	
	var authAPI = {};
	
	authAPI.logoutUser = function() {
		return $http({
			method: 'GET',
			url: 'logoutUser.do'
		});
	};
	
	
	authAPI.authenticateUser = function(loginCredentials) {
		return $http({
			method: 'POST',
			url: 'authenticateUser.do',
			data: loginCredentials,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	};
	
	authAPI.addLatestDesign = function(latestDesign) {
		return $http({
			method: 'POST',
			url: 'addLatestDesign.do',
			data: latestDesign,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	};
	
	
	return authAPI;
});
