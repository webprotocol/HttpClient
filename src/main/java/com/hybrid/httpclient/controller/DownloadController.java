package com.hybrid.httpclient.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

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

@Controller
public class DownloadController {
	static Log log = LogFactory.getLog(DownloadController.class);

	@RequestMapping(value="/down", method=RequestMethod.GET)
	public String download(HttpServletRequest request, HttpServletResponse response, String name) throws IOException {
		log.info("####### download");
		log.info("name = " + name);

		if (name == null) {
			log.info("name null error");
			request.setAttribute("error", "name null error");
			return "downError";
		}
		File downFile = new File(name);
		log.info("file name = " + downFile.getName());
		if (!downFile.exists()) {
			log.info("name not exists error");
			request.setAttribute("error", "name not exists error");
			return "downError";
		}
		
		String filename = new String(downFile.getName().getBytes("euc-kr"), "iso-8859-1");
		response.reset();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename +"\"");
		
		OutputStream out=null;
		try {
			out = response.getOutputStream();
			FileInputStream file = new FileInputStream(downFile);
			FileCopyUtils.copy(file, out);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}
}