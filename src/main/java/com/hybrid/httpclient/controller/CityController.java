package com.hybrid.httpclient.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/city")
public class CityController {
	static Log log = LogFactory.getLog(CityController.class);

	@RequestMapping(value="/", method=RequestMethod.GET)
	@ResponseBody
	public City getGET(HttpSession session) {
		log.info("####### GET");
		City c = new City();
		return c;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	@ResponseBody
	public City getPOST(@RequestBody City city) {
		log.info("####### POST");
		return city;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	@ResponseBody
	public String getPUT() {
		log.info("####### PUT");
		return "put";
	}
	
	@RequestMapping(value="/", method=RequestMethod.DELETE)
	@ResponseBody
	public String getDELETE() {
		log.info("####### DELETE");
		return "delete";
	}
	
	@RequestMapping(value="/", method=RequestMethod.PATCH)
	@ResponseBody
	public String getPATCH() {
		log.info("####### PATCH");
		return "patch";
	}
	
}