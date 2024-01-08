package com.task;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.basepackage.BaseClass;

public class Datepicker2 extends BaseClass{
	public static void datePicker2() throws IOException {
		 
	
		
		BaseClass.browserLaunch();
		BaseClass.loadUrl("https://jqueryui.com/datepicker/");
 
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
 
		driver.switchTo().frame(frame);
 
		driver.findElement(By.id("datepicker")).click();
 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));
 
 
		Date currentDate = new Date();
		Calendar calen = Calendar.getInstance();
		calen.setTime(currentDate);
		calen.add(calen.YEAR, -1);
		calen.add(calen.MONTH, -1);
		calen.add(calen.DAY_OF_MONTH, -1);
		Date targetDate = calen.getTime();
 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		String targetD = sdf.format(targetDate);
		System.out.println("Target Date is:"+targetD);
		
		test.info("Selected the date as Minus one day, one week, one year ");
		
 
		String exMon = targetD.split("/")[1].trim();
		int eMon = Integer.parseInt(exMon);
		String exYr = targetD.split("/")[2].trim();
     	String exD=targetD.split("/")[0].trim();
     	
     	List<String> li=new ArrayList<> ();  //List Concept
      	
        li.addAll(Arrays.asList("January","February","March","April","May","June","July","August","September","October","November","December"));
        	
        String month3=	li.get(eMon-1);
        System.out.println(month3);
        
        try {
			SelectDate1(exD, month3, exYr );   // used try and catch block
			
			test.info("Date Picked as per requirement");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement date1= driver.findElement(By.className("hasDatepicker"));
	
		if (date1.isDisplayed()) {
 
			Assert.assertTrue(true);
 
			BaseClass.screenShot(
					"C:\\Users\\amanickam\\eclipse-workspace\\SampleProject1\\ScreenShot\\DatePicker2.jpeg");
 
			test.pass("Date Picked",
					MediaEntityBuilder.createScreenCaptureFromPath(
							"C:\\Users\\amanickam\\eclipse-workspace\\SampleProject1\\ScreenShot\\DatePicker2.jpeg")
							.build());
 
		} else {
 
			Assert.assertTrue(false);
 
			BaseClass.screenShot(
					"C:\\Users\\amanickam\\eclipse-workspace\\SampleProject1\\ScreenShot\\DatePicker2.jpeg");
 
			test.fail("Date not picked",
					MediaEntityBuilder.createScreenCaptureFromPath(
							"C:\\Users\\amanickam\\eclipse-workspace\\SampleProject1\\ScreenShot\\DatePicker2.jpeg")
							.build());
 
		}
	}
 
	public static String[] getMonthYear1(String monthYearVal) {
 
		return monthYearVal.split(" ");
 
	}
 
	public static void SelectDate1(String exDay, String exMonth, String exYear) throws IOException {
 
		// String
		// CurrentYr=driver.findElement(By.className("ui-datepicker-year")).getText();
 
		String monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
 
		while (!(getMonthYear1(monthYearVal)[0].equals(exMonth) && getMonthYear1(monthYearVal)[1].equals(exYear))) {
 
			if (Integer.parseInt(exYear) < 2023) {
 
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
 
				monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
 
			} else {
 
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
 
			}
 
		}
 
		driver.findElement(By.xpath("//a[text()='" + exDay + "']")).click();
 
 
}
	
}
}
