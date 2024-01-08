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
	
	@Test
	public static void ParticularValue() {

		BaseClass.browserLaunch();
		
		
		
		BaseClass.loadUrl("https://practice.expandtesting.com/dynamic-table");

		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		for (int i = 0; i <rows.size() ; i++) {
		    WebElement row = rows.get(i);
		    List<WebElement> column = row.findElements(By.tagName("td"));
		    for (int j = 0; j < column.size(); j++) {
		        WebElement data = column.get(j);
		       String text = data.getText();
		       if(text.equals("")){
		    	   column.get(2).getText();
		       }
		        
//		        if(i==2&&j==3) {
//		        	 String text = data.getText();
//		        	 System.out.println(text);
//		        }
		        	
		    }
		    

		}
	}
	
	
	@Test
	public static void Value() {

		BaseClass.browserLaunch();
		
		
		
		BaseClass.loadUrl("https://qavbox.github.io/demo/webtable/");

		WebElement table = driver.findElement(By.id("table01"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i=0;i<rows.size();i++){
		WebElement row = rows.get(i);
		List<WebElement> columns = row.findElements(By.tagName("td"));
		for(int j=0;j<columns.size();j++){
		String data = columns.get(j).getText();
		if(data.equals("QC ALM")){
		String output = columns.get(1).getText();
		System.out.println(output);
		}
		}
		
		}
		
	}
	
}
