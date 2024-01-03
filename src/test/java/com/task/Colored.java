package com.task;

import java.awt.Color;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.basepackage.BaseClass;

public class Colored extends BaseClass{
	
	private static String convertRGBAtoHex(String rgbaValue) {
        String[] rgbaComponents = rgbaValue.replace("rgba(", "").replace(")", "").split(",");
        int red = Integer.parseInt(rgbaComponents[0].trim());
        int green = Integer.parseInt(rgbaComponents[1].trim());
        int blue = Integer.parseInt(rgbaComponents[2].trim());

        Color color = new Color(red, green, blue);
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }
	
public static void main(String[] args) {
	BaseClass.browserLaunch();
	BaseClass.loadUrl("https://www.iconplc.com/");
	WebElement element = driver.findElement(By.xpath("//*[@id='site-navigation']/div/ul/li/a[contains(text(), 'Solutions')]"));
	String cssValue = element.getCssValue("color");
	System.out.println(cssValue);
	String hexColor = convertRGBAtoHex(cssValue);
	System.out.println(hexColor);
	
	
}
}
