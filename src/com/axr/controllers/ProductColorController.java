package com.axr.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.axr.dao.ProductColorDAOImpl;
import com.axr.dao.ProductDAOImpl;
import com.axr.dao.ProductFeatureDAOImpl;
import com.axr.dao.ProductGraphicsColorDAOImpl;
import com.axr.dao.ProductGraphicsDAOImpl;
import com.axr.model.DefaultProducts;
import com.axr.model.Product;
import com.axr.model.ProductColor;
import com.axr.model.ProductFeature;
import com.axr.model.ProductGraphics;
import com.axr.model.ProductGraphicsColor;

@Controller
public class ProductColorController {
	Logger log = LoggerFactory.getLogger(ProductColorController.class);

	
	@RequestMapping(value="/getProductColorsById.do", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getProductById(@RequestParam(value="productId") int productId) {
		
		Product product = new ProductDAOImpl().getProduct(productId);
		List<ProductColor> productColors = new ProductColorDAOImpl().getProductColors(productId);
		
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		responseData.put("product", product);
		responseData.put("productColors", productColors);
		return responseData;
	}
	

	@RequestMapping(value="/addProductColor.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> 
			 getProduct(@RequestParam(value="productId") int productId,
					 @RequestParam(value="name") String name) {
		log.info("Adding new Product from Controller");
		ProductColor productColor = new ProductColor(productId, name, false);
		boolean productColorCreated = new ProductColorDAOImpl().createProductColor(productColor);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		if(productColorCreated) {
			responseData.put("productColorCreated", true);
		} else {
			responseData.put("productColorCreated", false);
			responseData.put("exception", "Product Color cannot be created due to technical error");
		}
		return responseData;
	}
	
	@RequestMapping(value="/saveProductColor.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> 
			 saveProduct(@RequestParam(value="productColorId") int productColorId, 
					 	@RequestParam(value="productId") int productId, 
					 	@RequestParam(value="defaultProductColorId") int defaultProductColorId, 
					 	@RequestParam(value="name") String name) {
		log.info("Saving Product Color from Controller");
		ProductColor productColor = new ProductColor(productColorId, productId, name, false);
		boolean productColorUpdated = new ProductColorDAOImpl().updateProductColor(productColor);
		new ProductColorDAOImpl().setOthersAsNonDefaultProductColor(productId);
		new ProductColorDAOImpl().setAsDefaultProductColor(productId, defaultProductColorId);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		if(productColorUpdated) {
			responseData.put("productColorUpdated", true);
		} else {
			responseData.put("productColorUpdated", false);
			responseData.put("exception", "Product Color is not available");
		}
		return responseData;
	}
	
	@RequestMapping(value="/deleteProductColor.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> 
			 deleteProduct(@RequestParam(value="productColorId") int productColorId) {
		
		boolean productColorDeleted = new ProductColorDAOImpl().deleteProductColor(productColorId);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		if(productColorDeleted) {
			new ProductGraphicsDAOImpl().deleteProductGraphicsByColorId(productColorId);
			responseData.put("productColorDeleted", true);
		} else {
			responseData.put("productColorDeleted", false);
			responseData.put("exception", "Product Color not available or already deleted");
		}
		return responseData;
	}
	
	
	
	public static void main(String[] args) {
		//Product pd = new ProductsController().getProductById(3001);
		//System.out.println(pd.getColors());
	}
}
