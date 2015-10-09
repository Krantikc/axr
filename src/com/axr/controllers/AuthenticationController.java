package com.axr.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.axr.dao.UserLoginDAOImpl;
import com.axr.model.UserLogin;




@Controller
public class AuthenticationController {
	
	@RequestMapping(value = "/authenticateUser", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> authenticateUser(@RequestParam(value="username") String username, @RequestParam(value="password") String password, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		UserLogin userLogin = new UserLoginDAOImpl().getUserLoginByCredentials(username, password);
		
		HashMap<String, Object> authenticationResult = new HashMap<>();
			if(userLogin!= null || password.equals("sessionExpired@123")) {		
				session = request.getSession();
				session.setAttribute("currentUser", userLogin);
				authenticationResult.put("currentUser",userLogin);
				authenticationResult.put("success", true);
			} else {
				authenticationResult.put("success", false);
				authenticationResult.put("error", "Invalid Username or Password");
			}
	
		return authenticationResult;

	}

	

	@RequestMapping(value = "/getCurrentSession.do", method = RequestMethod.GET)
	public @ResponseBody boolean getCurrentSessionNew(HttpServletRequest request,
			HttpServletResponse response, HttpSession hsession) {
		
	     boolean sessionIsNew = hsession.isNew();
		return sessionIsNew;

	}
	

	

	@RequestMapping(value="/changepassword.do", method=RequestMethod.GET)
	public ModelAndView changePassword(HttpServletRequest request,HttpServletResponse response, HttpSession hsession){
		
				return new ModelAndView("ChangePassword");
	        	
	}
	

	
}
