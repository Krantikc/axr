window.FONT_BASED_MENU_WIDTH = {'CopperPlate': 90, 'JosefinSans': 67, 'RobotoSlab': 80};

window.AXStyles = {
    
    setHeaderStyle: function(style) {
    	STD_FONT_SIZE = 22;
    	var backgroundColor = style.backgroundColor;
    	var headerFontFamily = style.headerFontFamily;
    	
    	var headerFontSize = style.headerFontSize||STD_FONT_SIZE;
    	var standardSubmenuWidth = FONT_BASED_MENU_WIDTH[headerFontFamily];
    	var submenuWidth = ((headerFontSize*standardSubmenuWidth)/STD_FONT_SIZE) ;  // 90px is default sub-menu width, 22px is default font-size, + 5px margin
    	
        $('header').css({'backgroundColor':backgroundColor});
        $('#ax-header').css({'backgroundColor':backgroundColor});
        $('.ax-navbar li').css({'backgroundColor':backgroundColor});
        $('.ax-navbar li a').css({'fontFamily':style.headerFontFamily, 'color': style.color, 'fontSize': headerFontSize});
        $('#products-menu').hover( function () {
        	$(this).find("ul").css({'width':submenuWidth+'px'});
        	$(this).find("li").css({'backgroundColor':backgroundColor});
        	$(this).find("li a").css({'fontFamily':style.headerFontFamily, 'color': style.color, 'fontSize': (headerFontSize-5)});
        	
        });
        
    }
    

};