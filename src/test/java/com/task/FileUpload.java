package com.task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.basepackage.BaseClass;



public class FileUpload extends BaseClass {

	@Test

	public static void fileUploadUsingSendKeys() {

		BaseClass.browserLaunch();

		BaseClass.loadUrl("https://omayo.blogspot.com/");

		driver.findElement(By.id("uploadfile")).sendKeys("C:\\Users\\VDI003\\Downloads\\sample.pdf");

	}

	@Test(enabled = true)

	public static void fileUploadUsingRobot() throws AWTException {

		BaseClass.browserLaunch();

		BaseClass.loadUrl("https://practice.expandtesting.com/upload");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

		WebElement button = driver.findElement(By.xpath("//form[@method='POST']//div"));
		

		button.click();

		Robot robot = new Robot();

		StringSelection ss = new StringSelection("C:\\Users\\VDI003\\Downloads\\sample.pdf");

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		robot.setAutoDelay(2000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//button[text()='Upload']")).click();

	}

}
