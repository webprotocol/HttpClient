package com.hybrid.httpclient.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/delete")
public class DeleteMethodController {
	static Log log = LogFactory.getLog(DeleteMethodController.class);

	@RequestMapping(value="/urlencoded", method=RequestMethod.DELETE)
	@ResponseBody
	public City getDELETE(City city, HttpServletRequest request) {
		log.info("####### DELETE UrlEncoded");
		log.info("name = " + city.getName());
		city.setId(100);
		
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String name = headers.nextElement();
			String value = request.getHeader(name);
			log.info(name + " : " + value);
		}
		
		
		return city;
	}
	
	@RequestMapping(value="/json", method=RequestMethod.DELETE)
	@ResponseBody
	public City getDELETEJson(City city, HttpServletRequest request) {
		log.info("####### DELETE json");
		log.info("name = " + city.getName());
		city.setId(100);
		
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String name = headers.nextElement();
			String value = request.getHeader(name);
			log.info(name + " : " + value);
		}
		
		return city;
	}
}