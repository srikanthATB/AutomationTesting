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
import java.util.Set;
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

public class Assignment_5 {

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
			
			
//			Assignment - 5
//			============
			       
//			        2.Maximize the browser window
			driver.manage().window().maximize();
//			        3.Launch the application
			driver.get("https://demoqa.com/frames");
			       
//			        4.Locate elements
			//*[@id='frame1']
			WebElement frame = driver.findElement(By.xpath("//*[@id='frame1']"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeSelected(frame));
			driver.switchTo().frame(frame);   
//			        5.Print frame element text
			           System.out.println(frame.getText());
//			        6.Print main window element text
			       driver.switchTo().defaultContent();
			     
			       System.out.println(driver.findElement(By.xpath("//div[@id='framesWrapper']")).getText());
//			        7.Close browser window
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
	
	

}
