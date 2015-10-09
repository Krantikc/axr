axrServices.
factory('homeAPIService', function($http) {
	
	var homeAPI = {};
	
	homeAPI.getSlides = function() {
		return $http({
			method: 'GET',
			url: 'getSlides.do'
		});
	};
	
	
	homeAPI.deleteSlide = function(slideId) {
		return $http({
			method: 'POST',
			url: 'deleteSlide.do',
			data: {slideId: slideId},
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	};
	
	homeAPI.addLatestDesign = function(latestDesign) {
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
	
	homeAPI.getLatestDesigns = function() {
		return $http({
			method: 'GET',
			url: 'getLatestDesigns.do'
		});
	};
	
	homeAPI.deleteLatestDesign = function(latestDesignId) {
		return $http({
			method: 'POST',
			url: 'deleteLatestDesign.do',
			data: {latestDesignId: latestDesignId},
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	};
	
	
	return homeAPI;
});
