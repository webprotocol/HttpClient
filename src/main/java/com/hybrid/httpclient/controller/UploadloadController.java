package com.hybrid.httpclient.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadloadController {
	static Log log = LogFactory.getLog(UploadloadController.class);

	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(MultipartFile f) {
		log.info("####### upload");
		log.info("fname =" + f.getName());
		log.info("foriginal filename =" + f.getOriginalFilename());
		log.info("f contenttype =" + f.getContentType());
		log.info("f size =" + f.getSize());
		
		if (f.getSize() > 0 ) {
			try {
				f.transferTo(new File("c:/" + f.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "redirect:/fileExplorer.jsp";
	}
}