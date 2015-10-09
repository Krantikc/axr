axrApp.service('axLocale',
    function($locale) {
        var contentList = {
            'home': {
                'en-us':'Home'
            },
            'about': {
                'en-us':'About'
            },
            'products': {
                'en-us':'Products'
            },
            'warranty': {
                'en-us': 'Warranty'
            },
            'dealers': {
                'en-us':'Dealers'
            },
            'contactUs': {
                'en-us': 'Contact Us'
            },
            'colors': {
                'en-us': 'COLORS'
            },
            'features': {
                'en-us': 'Features'
            },
            'graphics': {
                'en-us':'Graphics'
            },
            'graphicsColors': {
                'en-us':'Graphics Colors'
            },
            'advantageAXR': {
                'en-us':'Advantage AXR'
            },
            'advantageDescription': {
                'en-us':'AXR Helmets offer the perfect blend of safety and performance.  Built to' +
                	'match international safety standards while keeping in mind an indian' +
                	'customers preferences of fit, comfort and the tropical riding'+
                	 'conditions present in the sub continent.'
            },
            'latestDesigns': {
                'en-us':'Latest Designs'
            },
            'models': {
                'en-us':'Models'
            },
            'contactUs': {
            	'en-us':'Contact Us'
            },
            'warranty': {
            	'en-us':'Warranty'
            },
            'warrantyName': {
            	'en-us':'Warranty Name'
            },
            'warrantyAge': {
            	'en-us':'Warranty Age'
            },
            'warrantyLocation': {
            	'en-us':'Warranty Location'
            },
            'warrantyProfession': {
            	'en-us':'Warranty Profession'
            },
            'warrantyProductNo': {
            	'en-us':'Warranty ProductNo'
            },
            'warrantyEmail': {
            	'en-us':'Warranty Email'
            },
            'warrantyContact': {
            	'en-us':'Warranty Contact'
            },
            'dealers': {
            	'en-us':'Dealers'
            },
            'aboutUsP1': {
            	'en-us':'AXR Helmets aims to bridge the gap between performance, comfort and affordability. The helmets are specifically selected keeping in mind the tropical weather conditions and city environments present in India. With graphics designed based on customer feedback and preferences, we aim to be an extension of the riders personality.'
            },
            'aboutUsP2': {
            	'en-us':'In order to provide a world class product all components are imported and assembled in our 10,000 sq feet facility located at Honaga Industrial Estate in Belgaum by Ryder Helmets, a company with 40 years of experience in Helmet Manufacturing specializing in Fibre Glass Shells.'
            }
        };
        this.translate = function(content) {
            return contentList[content][$locale.id];
        };
    });
