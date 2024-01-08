package com.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.basepackage.BaseClass;

public class Colored extends BaseClass{
	

public static void main(String[] args) {
	BaseClass.browserLaunch();
	BaseClass.loadUrl("https://www.iconplc.com/");
	WebElement element = driver.findElement(By.xpath("//*[@id='site-navigation']/div/ul/li/a[contains(text(), 'Solutions')]"));
	String cssValue = element.getCssValue("color");
	System.out.println(cssValue);
	String height = element.getCssValue("height");
	System.out.println(height);
	String width = element.getCssValue("width");
	System.out.println(width);
	String size = element.getCssValue("font-size");
	System.out.println(size);
	
	
}
}
