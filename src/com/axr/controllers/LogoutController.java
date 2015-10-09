package com.axr.controllers;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.axr.model.UserLogin;

@Controller
public class LogoutController {

	@RequestMapping(value="/logoutUser.do", method=RequestMethod.GET)
	public @ResponseBody boolean logout(HttpServletRequest request, HttpSession hsession, HttpServletResponse response){
		
		
		Date dateLogout = new Date();
		System.out.println("logout: "+dateLogout);		
		UserLogin userLogin = (UserLogin) hsession.getAttribute("currentUser");
		if(userLogin!=null){
			hsession.invalidate();
			hsession=null;		  
		}
	
		return true;
	}
}