package com.infosys.chatbot;



import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class CrucibleIntegration {
	public static void main(String[] args) {
		try{
			URL url = new URL("https://github.com/Padmaja7/newApp/commits/master");
			URLConnection con = url.openConnection();
			InputStream in = con.getInputStream();
			String encoding = con.getContentType();  // ** WRONG: should use "con.getContentType()" instead but it returns something like "text/html; charset=UTF-8" so this value must be parsed to extract the actual encoding
			if (encoding == null)
				encoding = "UTF-8";
			else
				encoding = "UTF-8";
			String body = IOUtils.toString(in, encoding);
			//System.out.println(body);
			Document doc = Jsoup.connect("https://github.com/Padmaja7/newApp/commits/master").get();
			//System.out.println(doc.select(".commit-title a"));
			System.out.println("Commit Information :"+ doc.getElementsByClass("message").text());
			System.out.println("Committed by :"+ doc.getElementsByClass("user-mention").text());
			System.out.println("Committed at :"+ doc.getElementsByClass("commit-group-title").text().split("on")[1]);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
