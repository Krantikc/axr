package com.axr.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.axr.dao.BlockDAOImpl;
import com.axr.dao.ComponentDAOImpl;
import com.axr.model.Block;
import com.axr.model.Component;

@Controller
public class ComponentController {
	@RequestMapping(value="updateComponent.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateComponent( @RequestParam(value="componentId") int componentId, 
														  @RequestParam(value="name") String name,
														  @RequestParam(value="backgroundColor") String backgroundColor,
														  @RequestParam(value="fontSize") int fontSize,
														  @RequestParam(value="fontColor") String fontColor,
														  @RequestParam(value="fontHoverColor") String fontHoverColor,
														  @RequestParam(value="hoverBorderColor") String hoverBorderColor
														  ) {
		
		Component component = new Component(componentId, name, backgroundColor, fontSize, fontColor, fontHoverColor, hoverBorderColor);
		boolean isComponentUpdated = new ComponentDAOImpl().updateComponent(component);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", isComponentUpdated);
		
		return responseData;
		
	}
	
	@RequestMapping(value="getComponents.do", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getComponents() {
		
		List<Component> components = new ComponentDAOImpl().getComponents();
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", true);
		responseData.put("components", components);
		return responseData;
		
	}

}
