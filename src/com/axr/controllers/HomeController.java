package com.axr.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.axr.dao.LatestDesignDAOImpl;
import com.axr.dao.SlideDAOImpl;
import com.axr.model.Caption;
import com.axr.model.Enquiry;
import com.axr.model.LatestDesign;
import com.axr.model.Slide;
import com.axr.util.EnquiryUtil;
import com.axr.util.FileUtil;
import com.axr.util.MailUtil;

@Controller
public class HomeController {

	@RequestMapping(value="createSlide.do", method=RequestMethod.POST)
	public ModelAndView submitEnquiry( @RequestParam(value="name") String name, 
															@RequestParam(value="slideImage") MultipartFile slideImage,
															@RequestParam(value="slideTransition") String slideTransition,
															
															@RequestParam(value="captionOneImage") MultipartFile captionOneImage,
															@RequestParam(value="captionOnePosition") String captionOnePosition,
															@RequestParam(value="captionOneTransition") String captionOneTransition,
															
															@RequestParam(value="captionTwoImage") MultipartFile captionTwoImage,
															@RequestParam(value="captionTwoPosition") String captionTwoPosition,
															@RequestParam(value="captionTwoTransition") String captionTwoTransition,
															
															@RequestParam(value="captionThreePosition") String captionThreePosition,
															@RequestParam(value="captionThreeImage") MultipartFile captionThreeImage,
															@RequestParam(value="captionThreeTransition") String captionThreeTransition) {
		
		ModelAndView modelAndView = new ModelAndView();
		Map<String, Object> responseData = new HashMap<>();
		Slide slide = new Slide();
		slide.setLabel(name);
		slide.setImage(name+".jpg");
		slide.setTransition(slideTransition);
		
		Caption caption1 = new Caption();
		caption1.setTransition(captionOneTransition);
		caption1.setImage(name+"_c1.jpg");
		caption1.setPosition(captionOnePosition);
		caption1.setSlide(slide);
		
		Caption caption2 = new Caption();
		caption2.setTransition(captionTwoTransition);
		caption2.setImage(name+"_c2.jpg");
		caption2.setPosition(captionTwoPosition);
		caption2.setSlide(slide);
		
		Caption caption3 = new Caption();
		caption3.setTransition(captionThreeTransition);
		caption3.setImage(name+"_c3.jpg");
		caption3.setPosition(captionThreePosition);
		caption3.setSlide(slide);
		
		List<Caption> captions = new ArrayList<Caption>();
		captions.add(caption1);
		captions.add(caption2);
		captions.add(caption3);
		slide.setCaptions(captions);
		
		int slideId = new SlideDAOImpl().createSlide(slide);
		
		if (slideId > 0 ) {
			responseData.put("databaseUpdated", true);
			boolean slideImageUploaded = FileUtil.uploadFile("slider", slideImage, name+".jpg");
			boolean caption1Uploaded = FileUtil.uploadFile("slider", captionOneImage, name+"_c1.jpg");
			boolean caption2Uploaded = FileUtil.uploadFile("slider", captionTwoImage, name+"_c2.jpg");
			boolean caption3Uploaded = FileUtil.uploadFile("slider", captionThreeImage, name+"_c3.jpg");
			
			if (slideImageUploaded && caption1Uploaded && caption2Uploaded && caption3Uploaded) {
				modelAndView.addObject("imagesUploaded", true);
				modelAndView.addObject("success", true);
				modelAndView.addObject("redirectURL", "slider");
				modelAndView.setViewName("success");
				return modelAndView;
				
			} else {
				
				modelAndView.addObject("success", false);
				modelAndView.addObject("exception", "Failure in image upload");
			}
			
		} else {
			
			modelAndView.addObject("success", false);
			modelAndView.addObject("exception", "Failure in database update");
		}
		modelAndView.setViewName("failure");
		return modelAndView;
	}
	
	@RequestMapping(value="getSlides.do", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getSlides() {
		Map<String, Object> responseData = new HashMap<>();
		List<Slide> slides = new SlideDAOImpl().getSlides();
		
		//Map<String, Object> slideData = new HashMap<>();
		List<Object> slideData = new ArrayList<>();
		for (Slide slide : slides) {
			
			Map<String, Object> slideCaptions = new HashMap<>();
			slideCaptions.put("slide", slide);
			slideCaptions.put("captions", slide.getCaptions());
			slideData.add(slideCaptions);
		}
		
		
		responseData.put("success", "true");
		responseData.put("slidesData", slideData);
		return responseData;
	}
	
	@RequestMapping(value="deleteSlide.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteSlide(@RequestParam(value="slideId") int slideId) {
		Map<String, Object> responseData = new HashMap<>();
		boolean slideDeleted = new SlideDAOImpl().deleteSlideById(slideId);
		responseData.put("success", slideDeleted);
		return responseData;
	}
	
	
	@RequestMapping(value="addLatestDesign.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> addLatestDesign(@RequestParam(value="selectedProduct") int productId,
			                                                 @RequestParam(value="selectedColor") int productColorId,
			                                                 @RequestParam(value="selectedGraphics") int productGraphicsId,
			                                                 @RequestParam(value="graphicsColor") int productGraphicsColorId) {
		Map<String, Object> responseData = new HashMap<>();
		LatestDesign latestDesign = new LatestDesign(productId, productColorId, productGraphicsId, productGraphicsColorId);
		int latestDesignId = new LatestDesignDAOImpl().createLatestDesign(latestDesign);
		if (latestDesignId > 0) {
			responseData.put("success", true);
		}
		return responseData;
	}
	
	
	@RequestMapping(value="getLatestDesigns.do", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getLatestDesigns() {
		Map<String, Object> responseData = new HashMap<>();
		
		List<LatestDesign> latestDesigns = new LatestDesignDAOImpl().getLatestDesigns();
		responseData.put("success", true);
		responseData.put("latestDesigns", latestDesigns);
		return responseData;
	}
	
	@RequestMapping(value="deleteLatestDesign.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteLatestDesign(@RequestParam(value="latestDesignId") int latestDesignId) {
		Map<String, Object> responseData = new HashMap<>();
		boolean slideDeleted = new LatestDesignDAOImpl().deleteLatestDesignById(latestDesignId);
		responseData.put("success", slideDeleted);
		return responseData;
	}
	
}
