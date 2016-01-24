package com.hybrid.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class PostTest {
	static Log log = LogFactory.getLog(PostTest.class);

	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();

		HttpPost post = new HttpPost("http://localhost:8080/HttpClient/city/");
		
		String json = "{\"name\": \"홍길동\"}";
		StringEntity entity = new StringEntity(json, "utf-8");
		
		post.setEntity(entity);
		post.addHeader("Content-Type", "application/json");
		
		HttpResponse response = client.execute(post);
		log.info(response.getStatusLine());
		
		InputStream in =  response.getEntity().getContent();
		Scanner scan = new Scanner(in);
		
		Header[] headers = response.getAllHeaders();
		for (Header h : headers)
			log.info(h);
		
		
		
		log.info("length = " + response.getEntity().getContentLength());
		while(scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}
		

	}

}
