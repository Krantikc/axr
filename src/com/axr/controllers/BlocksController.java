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
import com.axr.dao.ProductGraphicsColorDAOImpl;
import com.axr.model.Block;
import com.axr.model.Enquiry;
import com.axr.model.ProductGraphicsColor;
import com.axr.util.EnquiryUtil;
import com.axr.util.FileUtil;
import com.axr.util.MailUtil;

@Controller
public class BlocksController {

	@RequestMapping(value="updateBlock.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateBlock( @RequestParam(value="blockId") int blockId, 
			 											  @RequestParam(value="title") String title,
														  @RequestParam(value="backgroundColor") String backgroundColor,
														  @RequestParam(value="borderColor") String borderColor,
														  @RequestParam(value="titleFontSize") int titleFontSize,
														  @RequestParam(value="titleFontColor") String titleFontColor,
														  @RequestParam(value="descFontSize") int descFontSize,
														  @RequestParam(value="descFontColor") String descFontColor) {
		
		Block block = new Block(blockId, backgroundColor, title, borderColor, titleFontSize, titleFontColor, descFontSize, descFontColor);
		boolean isBlockUpdated = new BlockDAOImpl().updateBlock(block);
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", isBlockUpdated);
		
		return responseData;
		
	}
	
	@RequestMapping(value="getBlocks.do", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBlocks() {

		List<Block> blocks = new BlockDAOImpl().getBlocks();
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", true);
		responseData.put("blocks", blocks);
		
		return responseData;
		
	}
	
	@RequestMapping(value="/uploadFonts.do", method=RequestMethod.POST)
	public ModelAndView 
			 addProductGraphicsColor(@RequestParam(required=false, value="headerFont") MultipartFile headerFont,
					 				 @RequestParam(required=false, value="titleFont") MultipartFile titleFont,
					 				 @RequestParam(required=false, value="generalFont") MultipartFile generalFont,
					 				 HttpServletRequest request) {
		
		 	ModelAndView modelAndView = new ModelAndView();
			String folderName = "fonts/";

			if(headerFont.getSize()!=0) {
				String fileName = "headerFont";
				String fileType = headerFont.getOriginalFilename().substring(headerFont.getOriginalFilename().indexOf("."));
				FileUtil.uploadFile(folderName, headerFont, fileName + fileType);
			}
			
			if(titleFont.getSize()!=0) {
				String fileName = "titleFont";
				String fileType = titleFont.getOriginalFilename().substring(titleFont.getOriginalFilename().indexOf("."));
				FileUtil.uploadFile(folderName, titleFont, fileName + fileType);
			}
			
			if(generalFont.getSize()!=0) {
				String fileName = "generalFont";
				String fileType = generalFont.getOriginalFilename().substring(generalFont.getOriginalFilename().indexOf("."));
				FileUtil.uploadFile(folderName, generalFont, fileName + fileType);
			}
			String redirectUrl = "/blocks";
			modelAndView.addObject("redirectUrl", redirectUrl);
			modelAndView.setViewName("success");
			return modelAndView;
	}
}
