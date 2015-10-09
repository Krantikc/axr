package com.axr.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

import com.axr.dao.ProductGraphicsColorDAOImpl;
import com.axr.dao.ProductDAOImpl;
import com.axr.model.Product;
import com.axr.model.ProductGraphicsColor;
import com.axr.util.FileUtil;

@Controller
@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB
maxFileSize=1024*1024*50,          // 50 MB
maxRequestSize=1024*1024*100)
public class ProductGraphicsColorController {
	Logger log = LoggerFactory.getLogger(ProductGraphicsColorController.class);
	final static String FRONT_ANGLE = "f";
	final static String RIGHT_ANGLE = "r";
	final static String BACK_ANGLE = "b";
	final static String LEFT_ANGLE = "l";
	
	@RequestMapping(value="/getProductGraphicsColorsByGraphics.do", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getProductGraphicsColorsByGraphics(@RequestParam(value="productId") int productId,
															@RequestParam(value="productGraphicsId") int productGraphicsId) {
		
		Product product = new ProductDAOImpl().getProduct(productId);
		List<ProductGraphicsColor> productGraphicsColors = new ProductGraphicsColorDAOImpl().getProductGraphicsColorsByGraphics(productId, productGraphicsId);
		
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		responseData.put("product", product);
		responseData.put("productGraphicsColors", productGraphicsColors);
		return responseData;
	}
	

	@RequestMapping(value="/addProductGraphicsColor.do", method=RequestMethod.POST)
	public ModelAndView 
			 addProductGraphicsColor(@RequestParam(value="productId") String productIdStr,
					 @RequestParam(value="productColorId") String productColorIdStr,
					 @RequestParam(value="productGraphicsId") String productGraphicsIdStr,
					 @RequestParam(value="productColorName") String productColorName,
					 @RequestParam(value="productGraphicsName") String productGraphicsName,
					 
					 @RequestParam(value="name") String name, 
					 @RequestParam("frontAngle") MultipartFile frontAngle,
					 @RequestParam("rightAngle") MultipartFile rightAngle,
					 @RequestParam("backAngle") MultipartFile backAngle,
					 @RequestParam("leftAngle") MultipartFile leftAngle,
					 HttpServletRequest request) {
		
    	
		log.info("Adding new Product Graphics Color from Controller");
		ModelAndView modelAndView = new ModelAndView();
		String folderName = "products/" + productIdStr;
		int productId = Integer.parseInt(productIdStr);
		int productColorId = Integer.parseInt(productColorIdStr);
		int productGraphicsId = Integer.parseInt(productGraphicsIdStr);
		ProductGraphicsColor productGraphicsColor = new ProductGraphicsColor(productId, productGraphicsId, name, false);
		int graphicsColorId = new ProductGraphicsColorDAOImpl().createProductGraphicsColor(productGraphicsColor);
		Map<String, Object> responseData = new HashMap<>();
		if(graphicsColorId != 0) {
			String fileType = ".jpg";
			String fileName = productId + "_" + productColorId + "_" + productGraphicsId + "_" + graphicsColorId + "_";
			FileUtil.uploadFile(folderName, frontAngle, fileName + FRONT_ANGLE + fileType);
			FileUtil.uploadFile(folderName, rightAngle, fileName + RIGHT_ANGLE + fileType);
			FileUtil.uploadFile(folderName, backAngle, fileName + BACK_ANGLE + fileType);
			FileUtil.uploadFile(folderName, leftAngle, fileName + LEFT_ANGLE + fileType);
			
			responseData.put("productGraphicsColorCreated", true);
			responseData.put("success", "true");
			
		} else {
			responseData.put("productGraphicsColorCreated", false);
			responseData.put("exception", "Product GraphicsColor cannot be created due to technical error");
		}
		
		String redirectUrl = "/products/graphicscolor/"+ productId + "/" + 
							 productColorId + "/" + productGraphicsId  + "/" + 
							 productColorName  + "/" + productGraphicsName;
		modelAndView.addObject("redirectUrl", redirectUrl);
		modelAndView.setViewName("success");
		return modelAndView;
	}

	@RequestMapping(value="/saveProductGraphicsColor.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> 
			 saveProductGraphicsColor(@RequestParam(value="productGraphicsColorId") int productGraphicsColorId, 
					 	@RequestParam(value="productId") int productId, 
					 	@RequestParam(value="productGraphicsId") int productGraphicsId, 
					 	@RequestParam(value="defaultProductGraphicsColorId") int defaultProductGraphicsColorId, 
					 	@RequestParam(value="name") String name) {
		log.info("Saving Product Graphics Color from Controller");
		ProductGraphicsColor productGraphicsColor = new ProductGraphicsColor(productGraphicsColorId, productId, productGraphicsId, name, false);
		boolean productGraphicsColorUpdated = new ProductGraphicsColorDAOImpl().updateProductGraphicsColor(productGraphicsColor);
		new ProductGraphicsColorDAOImpl().setOthersAsNonDefaultProductGraphicsColor(productId, productGraphicsId);
		new ProductGraphicsColorDAOImpl().setAsDefaultProductGraphicsColor(productId, defaultProductGraphicsColorId);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		if(productGraphicsColorUpdated) {
			responseData.put("productGraphicsColorUpdated", true);
		} else {
			responseData.put("productGraphicsColorUpdated", false);
			responseData.put("exception", "Product GraphicsColor is not available");
		}
		return responseData;
	}
	
	@RequestMapping(value="/deleteProductGraphicsColor.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> 
			 deleteProductGraphicsColor(@RequestParam(value="productGraphicsColorId") int productGraphicsColorId) {
		
		boolean productGraphicsColorDeleted = new ProductGraphicsColorDAOImpl().deleteProductGraphicsColor(productGraphicsColorId);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		if(productGraphicsColorDeleted) {
			FileUtil.deleteFile("products", productGraphicsColorId +"", ".jpg", true);
			responseData.put("productGraphicsColorDeleted", true);
		} else {
			responseData.put("productGraphicsColorDeleted", false);
			responseData.put("exception", "Product GraphicsColor not available or already deleted");
		}
		return responseData;
	}
	
	
	
	public static void main(String[] args) {
		//Product pd = new ProductsController().getProductById(3001);
		//System.out.println(pd.getGraphicss());
	}
}
