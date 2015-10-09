package com.axr.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.axr.dao.ProductDAOImpl;
import com.axr.dao.ProductFeatureDAOImpl;
import com.axr.dao.ProductGraphicsColorDAOImpl;
import com.axr.model.Product;
import com.axr.model.ProductFeature;
import com.axr.model.ProductGraphicsColor;
import com.axr.util.FileUtil;

@Controller
@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB
maxFileSize=1024*1024*50,          // 50 MB
maxRequestSize=1024*1024*100)
public class ProductFeaturesController {
	Logger log = LoggerFactory.getLogger(ProductFeaturesController.class);
	
	@RequestMapping(value="/getProductFeatures.do", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getProductFeatures(@RequestParam(value="productId") int productId) {
		
		Product product = new ProductDAOImpl().getProduct(productId);
		List<ProductFeature> productFeatures = new ProductFeatureDAOImpl().getProductFeatures(productId);
		
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		responseData.put("product", product);
		responseData.put("productFeatures", productFeatures);
		return responseData;
	}
	

	@RequestMapping(value="/addProductFeature.do", method=RequestMethod.POST)
	public ModelAndView 
			 addProductFeature(@RequestParam(value="productId") int productId,
									 @RequestParam(value="featureName") String featureName,
									 @RequestParam("featureImage") MultipartFile featureImage,
									 HttpServletRequest request) {
		
    	
		log.info("Adding new Product Feature from Controller");
		ModelAndView modelAndView = new ModelAndView();
		String folderName = "products/" + productId + "/features";
		ProductFeature productFeature = new ProductFeature(productId, featureName);
		int productFeatureId = new ProductFeatureDAOImpl().createProductFeature(productFeature);
		Map<String, Object> responseData = new HashMap<>();
		if(productFeatureId != 0) {
			String fileType = ".jpg";
			String fileName = productId + "_" + productFeatureId;
			FileUtil.uploadFile(folderName, featureImage, fileName + fileType);
			
			responseData.put("productFeatureCreated", true);
			responseData.put("success", "true");
			
		} else {
			responseData.put("productFeatureCreated", false);
			responseData.put("exception", "Product Feature cannot be created due to technical error");
		}
		String redirectUrl = "/products/features/"+ productId;
		modelAndView.addObject("redirectUrl", redirectUrl);
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	@RequestMapping(value="/deleteProductFeature.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> 
			 deleteProductFeature(@RequestParam(value="productFeatureId") int productFeatureId) {
		
		boolean productFeaturerDeleted = new ProductFeatureDAOImpl().deleteProductFeature(productFeatureId);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		if(productFeaturerDeleted) {
			FileUtil.deleteFile("products/features", productFeatureId +"", ".jpg", true);
			responseData.put("productFeatureDeleted", true);
		} else {
			responseData.put("productFeatureDeleted", false);
			responseData.put("exception", "Product Feature not available or already deleted");
		}
		return responseData;
	}
	
	
}
