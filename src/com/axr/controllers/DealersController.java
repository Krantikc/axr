package com.axr.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.axr.dao.BlockDAOImpl;
import com.axr.dao.DealersDAOImpl;
import com.axr.model.Block;
import com.axr.model.Dealer;
import com.axr.util.FileUtil;

@Controller
public class DealersController {

	@RequestMapping(value="createDealer.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> createDealer(@RequestParam(value="name") String name,
														  @RequestParam(value="address") String address,
														  @RequestParam(value="contact") String contact) {
		
		Dealer dealer = new Dealer(name, address, contact);
		int dealerId = new DealersDAOImpl().createDealer(dealer);
		Map<String, Object> responseData = new HashMap<>();
		if (dealerId > 0) {
			responseData.put("success", true);
		} else {
			responseData.put("success", false);
		}
		
		
		return responseData;
		
	}
	
	@RequestMapping(value="updateDealer.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateDealer( @RequestParam(value="dealerId") int dealerId, 
			 											  @RequestParam(value="name") String name,
														  @RequestParam(value="address") String address,
														  @RequestParam(value="contact") String contact) {
		
		Dealer dealer = new Dealer(dealerId, name, address, contact);
		boolean isDealerUpdated = new DealersDAOImpl().updateDealer(dealer);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", isDealerUpdated);
		
		return responseData;
		
	}
	
	@RequestMapping(value="getDealers.do", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getDealers() {

		List<Dealer> dealers = new DealersDAOImpl().getDealers();
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", true);
		responseData.put("dealers", dealers);
		
		return responseData;
		
	}
	
	@RequestMapping(value="deleteDealer.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteDealer( @RequestParam(value="dealerId") int dealerId) {
		boolean isDealerDeleted = new DealersDAOImpl().deleteDealer(dealerId);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", isDealerDeleted);
		return responseData;
		
	}
	
}
