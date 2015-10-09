axrServices.
factory('blocksAPIService', function($http) {
	
	var blocksAPI = {};
	
	blocksAPI.getBlocks = function() {
		return $http({
			method: 'GET',
			url: 'getBlocks.do'
		});
	};
	

	blocksAPI.updateBlock = function(block) {
		return $http({
			method: 'POST',
			url: 'updateBlock.do',
			data: block,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			},
		});
	};
	
	
	return blocksAPI;
});
