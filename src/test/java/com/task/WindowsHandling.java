package com.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.basepackage.BaseClass;

public class WindowsHandling extends BaseClass {

	@Test
	public void handleSingleWindow() {

		BaseClass.browserLaunch();

		BaseClass.loadUrl("https://letcode.in/windows");

		driver.manage().window().maximize();

		String parentWindow = driver.getWindowHandle();

		driver.findElement(By.xpath("(//button[contains(@class,'button is-fullwidth')])[1]")).click();

		Set<String> windowHandle = driver.getWindowHandles();

		for (String window : windowHandle) {

			if (!parentWindow.equals(window)) {

				driver.switchTo().window(window);

				driver.findElement(By.xpath("//*[text()='Log in']")).click();

			}

		}
	}

	@Test
	public static void handleMultipleWindow() {

		BaseClass.browserLaunch();

		BaseClass.loadUrl("https://letcode.in/windows");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//button[contains(@class,'button is-fullwidth')])[2]")).click();

		Set<String> windowHandle = driver.getWindowHandles();
		

		List<String> li = new ArrayList<String>(windowHandle);
//		
		driver.switchTo().window(li.get(1));

		for (int i = 0; i < li.size(); i++) {

			if (i == 3) {

				driver.switchTo().window(li.get(i));

				String currentUrl = driver.getCurrentUrl();

				System.out.println(currentUrl);

			}

		}

	}

}
