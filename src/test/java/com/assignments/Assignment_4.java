package com.assignments;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.beans.Visibility;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment_4 {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

//		Browser settings
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-notifications");

//		1. Launch the Browser window (Browser = Chrome) 
//		WebDriver driver = new ChromeDriver(options);

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		try {
			
			
//			Assignment - 4
//			============
//			        1.Launch Chrome Browser
			       
//			        2.Maximize the browser window
			driver.manage().window().maximize();
//			        3.Launch the application
			driver.get("https://demoqa.com/alertsWindows");
//			        4.Locate Alert buttons
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[text()='Alerts']")));
			Thread.sleep(1000);
//			Actions action = new Actions(driver);
//			action.moveToElement(driver.findElement(By.xpath("//span[text()='Alerts']"))).click().perform();
			
//			        5.Launch Information alert
			javaScriptClick(driver.findElement(By.xpath("//button[@id='alertButton']")));
			Thread.sleep(1000);
//			        6.Print Alert message
			    driver.switchTo().alert().getText();
			    Thread.sleep(1000);
//			        7.Click on OK button
			    driver.switchTo().alert().accept();
			    Thread.sleep(1000);
//			        8.Launch confirmation alert
			    javaScriptClick(driver.findElement(By.xpath("//button[@id='confirmButton']")));
			    Thread.sleep(1000);
//			        9.Print Alert message
			    driver.switchTo().alert().getText();
			    Thread.sleep(1000);
//			        10.Click on Cancel button
			    driver.switchTo().alert().dismiss();
			    Thread.sleep(1000);
//			        11.Launch prompt alert with dialog box alert
			    javaScriptClick(driver.findElement(By.xpath("//button[@id='promtButton']")));
			    Thread.sleep(1000);
//			        12.Print message
			    driver.switchTo().alert().getText();
			    Thread.sleep(1000);
//			        13.Enter Text in Alert
			    driver.switchTo().alert().sendKeys("OK");
			    Thread.sleep(1000);
//			        14.Click on OK button
			    driver.switchTo().alert().accept();
			
//			        14. Close browser window
			    Thread.sleep(5000);
			     driver.close();
		}

		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
//			driver.quit();
		}

	}
	
	public static void javaScriptClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele);

	}

}
