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

public class Assignment_3 {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

//		Browser settings
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
		options.addArguments("--disable-notifications");

//		1. Launch the Browser window (Browser = Chrome) 
//		WebDriver driver = new ChromeDriver(options);

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		try {

			// Assignment -3
			// ============

//			        2. Maximize the browser window
			driver.manage().window().maximize();
//			        3. Delete all the cookies
			driver.manage().deleteAllCookies();
//			        4. Enter URL and Launch the application (https://demoqa.com/buttons)
			driver.get("https://demoqa.com/buttons");
//			        5. Collect button elements (    https://demoqa.com/buttons)
			List<WebElement> buttons = driver.findElements(By.tagName("button"));
//			        6. Perform double click action
//			       driver.findElement(By.xpath("//div[contains(text(),'Elements')]")).click();
//			       driver.findElement(By.xpath("//span[contains(text(),'Buttons')]")).click();
			Actions action = new Actions(driver);
			action.doubleClick(driver.findElement(By.xpath("//button[contains(text(),'Double Click Me')]"))).perform();

//			        7. Perform Right Click Action
			action.contextClick(driver.findElement(By.xpath("//button[contains(text(),'Right Click Me')]"))).perform();

//			        8. Perform Mouse hover action on 'click me' button
			action.moveToElement(driver.findElement(By.xpath("//button[text()='Click Me']"))).perform();

//			        9. Naviagate to drag and drop elements page(https://demoqa.com/droppable)
			driver.navigate().to("https://demoqa.com/droppable");
//			        10.Perform drag and drop action
			WebElement source = driver.findElement(By.xpath("//div[text()='Drag me']"));
			WebElement destination = driver.findElement(By.xpath("(//p[text()='Drop here'])[1]"));
			action.dragAndDrop(source, destination).perform();
//			        11. Navigate to google page(https://www.google.co.in/)
			driver.navigate().to("https://www.google.co.in/");

//			        12. Search for information related to selenium and press enter button
			driver.findElement(By.id("APjFqb")).sendKeys("selenium" + Keys.ENTER);

			Thread.sleep(3000);
			driver.findElement(By.className("recaptcha-checkbox-border")).click();
			Thread.sleep(3000);
//			        13. Select all search results and paste it in the search box (Keyboard actions)
//			     driver.findElement(By.cssSelector("div[id='search']")).sendKeys(Keys.CONTROL+"A"+Keys.CONTROL+"C");
			action.moveToElement(driver.findElement(By.cssSelector("div[id='search']")))
					.sendKeys(Keys.CONTROL + "A" + Keys.CONTROL + "C").perform();
//			     ((JavascriptExecutor) driver).executeScript("arguments[0].sendKeys("+Keys.CONTROL+"A"+Keys.CONTROL+"C"+");", driver.findElement(By.cssSelector("div[id='search']")));

			driver.findElement(By.id("APjFqb")).sendKeys(Keys.CONTROL + "V");

//			        14. Close browser window
//			     driver.close();
		}

		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
//			driver.quit();
		}

	}

}
