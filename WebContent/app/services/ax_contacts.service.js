axrServices.
factory('contactsAPIService', function($http){
	
	var contactsAPI = {};
	
	contactsAPI.sendEnquiry = function(enquiryDetails) {
		return $http({
			method: 'POST',
			url: 'submitEnquiry.do',
			data: enquiryDetails,
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			transformRequest: function(obj) {
				var str = [];
				for(var p in obj)
					str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
			        
				return str.join("&");
			}
		});
	}
	return contactsAPI;
});

