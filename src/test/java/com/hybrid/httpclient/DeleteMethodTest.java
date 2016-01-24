package com.hybrid.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.util.FileCopyUtils;

public class DeleteMethodTest {
	static Log log = LogFactory.getLog(DeleteMethodTest.class);

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		HttpClient client =  new DefaultHttpClient();
		
		try {
			/*
			 * HttpPost
			 */
			HttpDelete delete = new HttpDelete(new URI("http://localhost:8080/HttpClient/delete/json?name=xxx&name=yyy"));
			
			/*
			 * Parameter set
			 */
//			String string =	  "{"
//							+ "	\"name\" : [\"홍길이야\"],"
//							+ " \"countryCode\" : \"KOR\""
//							+ "}";
//			StringEntity entity = new StringEntity(string, "utf-8");
//			entity.setContentType("application/json");
//			delete.set
			
			/*
			 * response
			 */
			HttpResponse response = client.execute(delete);
			
			/*
			 * response Headers
			 */
			for (Header h : response.getAllHeaders()) {
				log.info(h);
			}

			/*
			 * response body
			 */
			HttpEntity responseEndity = response.getEntity();
			
			FileCopyUtils.copy(responseEndity.getContent(), System.out);
			
			log.info("end...");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void postUrlEncodeForm() {
		
		@SuppressWarnings("deprecation")
		HttpClient client =  new DefaultHttpClient();
		
		try {
			/*
			 * HttpPost
			 */
			HttpPost post = new HttpPost(new URI("http://localhost:8080/HttpClient/post/urlencoded"));
			
			/*
			 * Parameter set
			 */
			List<NameValuePair> parameters = new ArrayList<>();
			parameters.add(new BasicNameValuePair("name", "홍길동"));
			parameters.add(new BasicNameValuePair("countryCode", "KOR"));
			
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parameters, Charset.forName("utf-8"));
			post.setEntity(entity);
			
			/*
			 * response
			 */
			HttpResponse response = client.execute(post);
			
			/*
			 * response Headers
			 */
			for (Header h : response.getAllHeaders()) {
				log.info(h);
			}

			/*
			 * response body
			 */
			HttpEntity responseEndity = response.getEntity();
			
			FileCopyUtils.copy(responseEndity.getContent(), System.out);
			
			log.info("end...");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
