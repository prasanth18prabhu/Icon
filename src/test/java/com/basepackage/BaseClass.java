package com.basepackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void browserLaunch() {

		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		
	}
	
	public static void browserLaunch2(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
	}

	public static void loadUrl(String Url) {
		driver.get(Url);
	}

	public static void close() {
		driver.close();
	}

	public static void screenShot(String Url) throws IOException {
		TakesScreenshot s = (TakesScreenshot) driver;
		File inDriver = s.getScreenshotAs(OutputType.FILE);
		File toEclipse = new File(Url);
		FileHandler.copy(inDriver, toEclipse);
	}

	public static void screenshotElement(String Url) throws IOException {
		WebElement findElement = driver.findElement(By.xpath(""));
		TakesScreenshot ts = (TakesScreenshot) findElement;
		File inDriver = ts.getScreenshotAs(OutputType.FILE);
		File toEclipse = new File(Url);
		FileHandler.copy(inDriver, toEclipse);
	}
}
