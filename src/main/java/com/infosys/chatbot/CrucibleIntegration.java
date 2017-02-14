package com.infosys.chatbot;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.io.IOUtils;
public class CrucibleIntegration {
	public static void main(String[] args) {
		try{
			URL url = new URL("http://localhost:8060/cru/CR-1#c2");
			URLConnection con = url.openConnection();
			InputStream in = con.getInputStream();
			String encoding = con.getContentType();  // ** WRONG: should use "con.getContentType()" instead but it returns something like "text/html; charset=UTF-8" so this value must be parsed to extract the actual encoding
			if (encoding == null)
				encoding = "UTF-8";
			else
				encoding = "UTF-8";
			String body = IOUtils.toString(in, encoding);
			System.out.println(body);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
