package com.task;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.basepackage.BaseClass;





public class DynamicTable extends BaseClass{
	
	
	@Parameters("BrowserOne")
	@Test

	public static void dataTable(String browserName) {

//		BaseClass.browserLaunch();
		BaseClass.browserLaunch2(browserName);

		BaseClass.loadUrl("https://practice.expandtesting.com/dynamic-table");

		List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tr"));

		for (int i = 0; i < allRows.size(); i++) {

			String rows = allRows.get(i).getText();

			if (rows.contains("Chrome")) {

				System.out.println(rows);

				break;

			}
		}

	}
	@Parameters("BrowserTwo")
	@Test(enabled=true)

	public static void dataTableParticularValue(String browserName) {

//		BaseClass.browserLaunch();
		
		BaseClass.browserLaunch2(browserName);
		
		BaseClass.loadUrl("https://practice.expandtesting.com/dynamic-table");

		List<WebElement> allDatas = driver
				.findElements(By.xpath("//td[text()='Chrome']//following-sibling::td"));

		for (int i = 0; i < allDatas.size(); i++) {

			String data = allDatas.get(i).getText();

			// System.out.println(data);

			if (data.contains("Mbps")) {

				System.out.println(data);
			}
		}

	}
}
