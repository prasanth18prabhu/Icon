package com.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Date {

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		
		WebDriver driver = new EdgeDriver();

		driver.get("https://jqueryui.com/datepicker/");

		driver.switchTo().frame(0); // The index might vary; inspect your page to find the correct index or use
									// other methods

		WebElement dateInput = driver.findElement(By.id("datepicker"));

		dateInput.click();

		selectDate(driver, "28");

	}

	private static void selectDate(WebDriver driver, String day) {

		WebElement datepickerTable = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']"));

		WebElement cell = datepickerTable.findElement(By.xpath("//a[text()='" + day + "']"));

		cell.click();
	}
}