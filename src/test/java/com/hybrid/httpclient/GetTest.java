package com.hybrid.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class GetTest {
	static Log log = LogFactory.getLog(GetTest.class);

	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();

		HttpGet get = new HttpGet("http://localhost:8080/HttpClient/city/");
		
		HttpResponse response = client.execute(get);
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
