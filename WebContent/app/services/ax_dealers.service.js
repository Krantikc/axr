axrServices.
factory('dealersAPIService', function($http){
	
	var dealersAPI = {};
	
	dealersAPI.getDealers = function() {
		return $http({
			method: 'GET',
			url: 'getDealers.do'
		});
	};
	
	dealersAPI.createDealer = function(dealer) {
		return $http({
			method: 'POST',
			url: 'createDealer.do',
			data: dealer,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	};
	
	dealersAPI.updateDealer = function(dealer) {
		return $http({
			method: 'POST',
			url: 'updateDealer.do',
			data: dealer,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	};
	
	dealersAPI.deleteDealer = function(dealerId) {
		return $http({
			method: 'POST',
			url: 'deleteDealer.do',
			data: {dealerId: dealerId},
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	};
	
	return dealersAPI;
});

