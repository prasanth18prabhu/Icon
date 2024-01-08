package com.task;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.basepackage.BaseClass;



public class Date_Picker extends BaseClass {
	@Test

	public static void datePicker() throws IOException {

		BaseClass.browserLaunch();

		BaseClass.loadUrl("https://jqueryui.com/datepicker/");

		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

		driver.switchTo().frame(frame);

		driver.findElement(By.id("datepicker")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));
		
		
		Scanner scanner = new Scanner(System.in);

		String userDate = scanner.next();

		String expectedYear = userDate.split("/")[2].trim();

		String expectedDay = userDate.split("/")[0].trim();

		String splitedMonth = userDate.split("/")[1].trim();

		int expMonth = Integer.parseInt(splitedMonth);

		List<String> li = new ArrayList<>();

		li.addAll(Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December"));

		String expectedMonth = li.get(expMonth - 1);

		System.out.println(expectedMonth);

		try {
			SelectDate(expectedDay, expectedMonth, expectedYear);

		} catch (IOException e) {

			e.printStackTrace();
		}

		WebElement date = driver.findElement(By.className("hasDatepicker"));

		if (date.isDisplayed()) {

			Assert.assertTrue(true);

			BaseClass.screenShot(
					"C:\\Users\\VDI003\\eclipse-workspace\\45\\PS\\Icon\\src\\test\\resources\\Screenshots\\DatePicker1Pass.jpeg");

		} else {

			Assert.assertTrue(false);

			BaseClass.screenShot(
					"C:\\Users\\VDI003\\eclipse-workspace\\45\\PS\\Icon\\src\\test\\resources\\Screenshots\\DatePicker1Pass.jpeg");

		}

	}

	public static String[] getMonthYear(String monthYearValue) {

		return monthYearValue.split(" ");

	}

	public static void SelectDate(String expectedDay, String expectedMonth, String expectedYear) throws IOException {

		String monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();

		while (!(getMonthYear(monthYearValue)[0].equals(expectedMonth)
				&& getMonthYear(monthYearValue)[1].equals(expectedYear))) {

			if (Integer.parseInt(expectedYear) < 2023) {

				driver.findElement(By.xpath("//span[text()='Prev']")).click();

				monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();

			} else {

				driver.findElement(By.xpath("//span[text()='Next']")).click();

				monthYearValue = driver.findElement(By.className("ui-datepicker-title")).getText();

			}

		}

		driver.findElement(By.xpath("//a[text()='" + expectedDay + "']")).click();

	}
}
