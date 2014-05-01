package com.openrdf.utils.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

/**
 * REST Client, to invoke Other API
 * 
 * @description 本程序用于来自谢先斌毕业论文，如有使用请联系作 者，注明出处。
 * @URL 代码地址：http://github.com/openRDF/rdf_fronts
 * @rdf package com.openrdf.utils.rest.client;
 * @dateTime 2014-3-23
 * @author XieXianbin
 * @email a.b@hotmail.com
 *
 */

public class RESTClient {

	private Logger logger = Logger.getLogger(RESTClient.class);
	private int timeout = 5000;
	private int cach_size = 5 * 1024 * 1024;
	
	// get method
	public String RESTGET(String url){
		
		
		return null;
	}
	
	// post method 
	public Map<String, Object> RESTPOST(String url, String headers, String payload){
		try {
			// vert header to JSON Object
//			Object headersJSON = JSONObject.fromObject(headers);
//			byte[] headersByte = String.valueOf(headersJSON).getBytes("UTF-8");
			// payload 
			Object payloadJSON = JSONObject.fromObject(payload);
			byte[] payloadByte = String.valueOf(payloadJSON).getBytes("UTF-8");
			
			// URL
			URL urls = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) urls.openConnection();
			// set HTTP URL Connection
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setConnectTimeout(timeout);
			httpURLConnection.setDoInput(true);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			httpURLConnection.setRequestProperty("Content-Length", String.valueOf(payloadByte.length));
			// request 
			OutputStream outputStream = httpURLConnection.getOutputStream();
			outputStream.write(payloadByte);
			outputStream.flush();
			outputStream.close();
			
			// read response
			InputStream inputStream = null;
			if(httpURLConnection.getResponseCode() < 400){
				inputStream = httpURLConnection.getInputStream();
			}else{
				inputStream = httpURLConnection.getErrorStream();
			}
			BufferedReader responseReader = new BufferedReader(new InputStreamReader(inputStream), cach_size);
			StringBuilder responseString = new StringBuilder();
			String s;
			while((s = responseReader.readLine()) != null){
				responseString.append(s);
			}
			responseReader.close();
			httpURLConnection.disconnect();
			// to String response
			String response = responseString.toString();
			// get result
			Map<String, Object> responseMap = new HashMap<String, Object>();
			responseMap.put("Status", httpURLConnection.getResponseCode());
			responseMap.put("Response", response);
			
			// return 
			return responseMap;
		} catch (UnsupportedEncodingException e) {
			logger.error("UnsupportedEncodingException");
		} catch (MalformedURLException e) {
			logger.error("Malformed URL Exception.");
		} catch (ProtocolException e) {
			logger.error("ProtocolException");
		} catch (IOException e) {
			logger.error("IOException");
		}
		
		return null;
	}
}
