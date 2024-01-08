package com.task;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.basepackage.BaseClass;

public class Broken extends BaseClass{
	@Test
	public void brokenLink() throws IOException {
		BaseClass.browserLaunch();
		BaseClass.loadUrl("https://practice.expandtesting.com/dropdown");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
 
		for( WebElement li: links) {
			String url=li.getAttribute("href");
			URL link=new URL(url);
			HttpURLConnection huc= (HttpURLConnection) link.openConnection() ;
			huc.connect();
			int responseCode=huc.getResponseCode();
			if(responseCode>200) {
				System.out.println(url+ "-" + "is Broken Link");
			} else {
				System.out.println(url+ "-" + "is Valid Link");
			}




 
		}



}

 
}
