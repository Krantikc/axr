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
public class ProductsController {
	Logger log = LoggerFactory.getLogger(ProductsController.class);

	@RequestMapping(value="/getAllProducts.do", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllProducts() {
		log.info("Getting All Products from Controller");
		List<Product> allProducts = new ProductDAOImpl().getAllProducts();
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		responseData.put("productsList", allProducts);
		return responseData;
	}
	
	@RequestMapping(value="/getProductById.do", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getProductById(@RequestParam(value="productId") int productId) {
		
		
		
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		responseData.put("product", "");
		return responseData;
	}
	
	@RequestMapping(value="/getProduct.do", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> 
			 getProduct(@RequestParam(value="productId") int productId, 
						@RequestParam(value="colorId") int colorId, 
						@RequestParam(value="graphicsId") int graphicsId,
						@RequestParam(value="graphicsColorId") int graphicsColorId) {
		
		
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		responseData.put("product", "");
		return responseData;
	}
	
	@RequestMapping(value="/addProduct.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> 
			 getProduct(@RequestParam(value="name") String name, 
						@RequestParam(value="description") String description) {
		log.info("Adding new Product from Controller");
		Product product = new Product(name, description);
		boolean productCreated = new ProductDAOImpl().createProduct(product);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		if(productCreated) {
			responseData.put("productCreated", true);
		} else {
			responseData.put("productCreated", false);
			responseData.put("exception", "Product cannot be created due to technical error");
		}
		
		responseData.put("product", product);
		return responseData;
	}
	
	@RequestMapping(value="/saveProduct.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> 
			 saveProduct(@RequestParam(value="productId") int productId, 
					 	@RequestParam(value="name") String name, 
						@RequestParam(value="description") String description) {
		log.info("Saving Product from Controller");
		Product product = new Product(productId, name, description);
		boolean productUpdated = new ProductDAOImpl().updateProduct(product);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		if(productUpdated) {
			responseData.put("productUpdated", true);
		} else {
			responseData.put("productUpdated", false);
			responseData.put("exception", "Product not available");
		}
		return responseData;
	}
	
	@RequestMapping(value="/deleteProduct.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> 
			 deleteProduct(@RequestParam(value="productId") int productId) {
		
		boolean productDeleted = new ProductDAOImpl().deleteProduct(productId);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		if(productDeleted) {
			new ProductColorDAOImpl().deleteProductColorByProductId(productId);
			new ProductFeatureDAOImpl().deleteProductFeatureByProductId(productId);
			new ProductGraphicsDAOImpl().deleteProductGraphicsByProductId(productId);
			new ProductGraphicsColorDAOImpl().deleteProductGraphicsColorByProductId(productId);
			responseData.put("productDeleted", true);
		} else {
			responseData.put("productDeleted", false);
			responseData.put("exception", "Product not available or already deleted");
		}
		return responseData;
	}
	
	
	
	public static void main(String[] args) {
		//Product pd = new ProductsController().getProductById(3001);
		//System.out.println(pd.getColors());
	}
}
