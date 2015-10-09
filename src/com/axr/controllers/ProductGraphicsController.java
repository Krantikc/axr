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

import com.axr.dao.ProductGraphicsColorDAOImpl;
import com.axr.dao.ProductGraphicsDAOImpl;
import com.axr.dao.ProductDAOImpl;
import com.axr.dao.ProductFeatureDAOImpl;

import com.axr.model.DefaultProducts;
import com.axr.model.Product;
import com.axr.model.ProductGraphics;
import com.axr.model.ProductFeature;
import com.axr.model.ProductGraphics;
import com.axr.model.ProductGraphicsColor;

@Controller
public class ProductGraphicsController {
	Logger log = LoggerFactory.getLogger(ProductGraphicsController.class);

	
	@RequestMapping(value="/getProductGraphicsByColor.do", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getProductByColor(@RequestParam(value="productId") int productId,
															@RequestParam(value="productColorId") int productColorId) {
		
		Product product = new ProductDAOImpl().getProduct(productId);
		List<ProductGraphics> productGraphics = new ProductGraphicsDAOImpl().getProductGraphicsByColor(productId, productColorId);
		
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		responseData.put("product", product);
		responseData.put("productGraphics", productGraphics);
		return responseData;
	}
	

	@RequestMapping(value="/addProductGraphics.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> 
			 getProduct(@RequestParam(value="productId") int productId,
					 @RequestParam(value="productColorId") int productColorId,
					 @RequestParam(value="name") String name) {
		log.info("Adding new Product from Controller");
		ProductGraphics productGraphics = new ProductGraphics(productId, productColorId, name, false);
		boolean productGraphicsCreated = new ProductGraphicsDAOImpl().createProductGraphics(productGraphics);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		if(productGraphicsCreated) {
			responseData.put("productGraphicsCreated", true);
		} else {
			responseData.put("productGraphicsCreated", false);
			responseData.put("exception", "Product Graphics cannot be created due to technical error");
		}
		return responseData;
	}
	
	@RequestMapping(value="/saveProductGraphics.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> 
			 saveProduct(@RequestParam(value="productGraphicsId") int productGraphicsId, 
					 	@RequestParam(value="productId") int productId, 
					 	@RequestParam(value="productColorId") int productColorId, 
					 	@RequestParam(value="defaultProductGraphicsId") int defaultProductGraphicsId, 
					 	@RequestParam(value="name") String name) {
		log.info("Saving Product Graphics from Controller");
		ProductGraphics productGraphics = new ProductGraphics(productGraphicsId, productId, productColorId, name, false);
		boolean productGraphicsUpdated = new ProductGraphicsDAOImpl().updateProductGraphics(productGraphics);
		new ProductGraphicsDAOImpl().setOthersAsNonDefaultProductGraphics(productId, productColorId);
		new ProductGraphicsDAOImpl().setAsDefaultProductGraphics(productId, defaultProductGraphicsId);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		if(productGraphicsUpdated) {
			responseData.put("productGraphicsUpdated", true);
		} else {
			responseData.put("productGraphicsUpdated", false);
			responseData.put("exception", "Product Graphics is not available");
		}
		return responseData;
	}
	
	@RequestMapping(value="/deleteProductGraphics.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> 
			 deleteProduct(@RequestParam(value="productGraphicsId") int productGraphicsId) {
		
		boolean productGraphicsDeleted = new ProductGraphicsDAOImpl().deleteProductGraphics(productGraphicsId);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		if(productGraphicsDeleted) {
			new ProductGraphicsColorDAOImpl().deleteProductGraphicsColorByGraphicsId(productGraphicsId);
			responseData.put("productGraphicsDeleted", true);
		} else {
			responseData.put("productGraphicsDeleted", false);
			responseData.put("exception", "Product Graphics not available or already deleted");
		}
		return responseData;
	}
	
	
	
	public static void main(String[] args) {
		//Product pd = new ProductsController().getProductById(3001);
		//System.out.println(pd.getGraphicss());
	}
}
