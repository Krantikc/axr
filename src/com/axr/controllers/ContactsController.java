package com.axr.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.axr.model.Enquiry;
import com.axr.util.EnquiryUtil;
import com.axr.util.MailUtil;

@Controller
public class ContactsController {

	@RequestMapping(value="submitEnquiry.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> submitEnquiry( @RequestParam(value="name") String name, 
															 @RequestParam(value="email") String email, 
															 @RequestParam(value="mobile") String mobile, 
															 @RequestParam(value="message") String message ) {
		
		String fromMail = "kranti4all@gmail.com";
		String toMail = "kranti.chavannavar@gmail.com";
		String subject = "Customer's Enquiry";
		String salutation = "Dear Sir/Madam,";
		String bodyMsg = "";
		
		bodyMsg = "Name: "		+ name 		+ "\n" +
				  "Email: "		+ email 	+ "\n" +
				  "mobile: "	+ mobile 	+ "\n" +
				  "message: "	+ message;
		
		MailUtil.sendMail(fromMail, toMail, subject, salutation, bodyMsg);
		new EnquiryUtil().createEnquiry(new Enquiry(name, email, mobile, message));
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("success", "true");
		return responseData;
	}
}
