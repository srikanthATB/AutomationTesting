package com.assignments;

import java.awt.AWTException;
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

public class Assignment_2 {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		/*
		 * Assignment - 2 ============ // 1. Launch browser window(Chrome)
		 * 
		 * // 2. Maximize the browser window
		 * 
		 * // 3. Delete all the cookies
		 * 
		 * // 4. Enter URL and Launch the application
		 * (https://demoqa.com/automation-practice-form)
		 * 
		 * // 5. Wait for Page-load
		 * 
		 * // 6. Enter First name and Last name
		 * 
		 * // 7. Enter Email
		 * 
		 * // 8. Select Gender (Female)
		 * 
		 * // 9. Enter mobile number
		 * 
		 * // 10.Select DOB (1-Feb-1991)
		 * 
		 * // 11.Search and Select Computer Science
		 * 
		 * // 12.Select Hobbies as Sports and Reading
		 * 
		 * // 13.Upload photo
		 * 
		 * // 14. Wait till window open to upload the file
		 * 
		 * // 15. Upload file
		 * 
		 * // 16. Wait till file upload
		 * 
		 * // 17.Submit Details
		 * 
		 * // 18. Close browser window
		 */

//		Browser settings
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-notifications");

//		1. Launch the Browser window (Browser = Chrome) 
//		WebDriver driver = new ChromeDriver(options);

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		try {

			// 2. Maximize the browser window
			driver.manage().window().maximize();

			// 3. Delete all the cookies
			driver.manage().deleteAllCookies();

			// 4. Enter URL and Launch the application

			driver.get("https://demoqa.com/automation-practice-form");

			// 5. Wait for Page-load
//			Fluent Wait
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(2));
			fluentWait.until(ExpectedConditions
					.numberOfElementsToBeMoreThan(By.cssSelector("img[src='/images/Toolsqa.jpg']"), 0));

			// 6. Enter First name and Last name
			WebElement currentAddress = driver.findElement(By.id("currentAddress-label"));
			scroll(currentAddress);
			driver.findElement(By.id("firstName")).sendKeys("admin");
			driver.findElement(By.id("lastName")).sendKeys("admin");

			// 7. Enter Email
			driver.findElement(By.cssSelector("input[placeholder='name@example.com']")).sendKeys("admin@gmail.com");

			// 8. Select Gender (Female)
//			Actions act =  new Actions(driver);
//			act.moveToElement(driver.findElement(By.cssSelector("input[value='Female']"))).click().perform();
//			driver.findElement(By.cssSelector("input[value='Male']")).click();
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.cssSelector("input[value='Female']"))).click().perform();

			// 9. Enter mobile number
			driver.findElement(By.cssSelector("input[placeholder='Mobile Number']")).sendKeys("9988776655");

//	        10.Select DOB (1-Feb-1991)
			scroll(currentAddress);
			driver.findElement(By.cssSelector("input[id='dateOfBirthInput']")).click();
//			act.moveToElement(driver.findElement(By.cssSelector("input[id='dateOfBirthInput']"))).click().perform();

			WebElement year = driver.findElement(By.cssSelector("select[class='react-datepicker__year-select']"));
			year.click();
			selectByVisibleText(year, "1991");
			WebElement month = driver.findElement(By.cssSelector("select[class='react-datepicker__month-select']"));
			month.click();
			selectByVisibleText(month, "February");
			driver.findElement(By.xpath("(//div[contains(@aria-label,'February')] )[1]")).click();

//	        11.Search and Select Computer Science

//	        12.Select Hobbies as Sports and Reading
			act.moveToElement(driver.findElement(By.cssSelector("input[id='hobbies-checkbox-1']"))).click().perform();

//	        13.Upload photo

//			driver.findElement(By.cssSelector("input[id='uploadPicture']")).sendKeys(System.getProperty("user.dir")+"\\TestData\\images1.jpg");	

//	        14. Wait till window open to upload the file
//			selectFile(System.getProperty("user.dir")+"\\TestData\\images1.jpg");
//			act.moveToElement(driver.findElement(By.cssSelector("input[id='uploadPicture']"))).click().perform();
			act.moveToElement(driver.findElement(By.cssSelector("input[id='uploadPicture']"))).click().perform();
			Thread.sleep(2000);
			// C:\Users\BandariSrikanth\Desktop\My\Practice\Eclipse\SrikanthAutomationMavenProject\TestData\images1.jpg
//			selectFile(System.getProperty("user.dir")+"\\TestData\\images1.jpg");

			// 15. Upload file

//	        16. Wait till file upload

//			driver.findElement(By.id("submit")).click();  
//	        18. Close browser window

			setClipboardData(System.getProperty("user.dir") + "\\TestData\\images1.jpg");
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();

			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(4000);
			robot.keyRelease(KeyEvent.VK_ENTER);

//		        17.Submit Details
			Thread.sleep(2000);
			WebElement submit = driver.findElement(By.cssSelector("button[id='submit']"));
			if (submit.isDisplayed() == true) {
				if (submit.isEnabled() == true) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
				}
			}
			Thread.sleep(2000);
			WebElement close = driver.findElement(By.cssSelector("button[id='closeLargeModal']"));
			if (close.isDisplayed() == true) {
				if (close.isEnabled() == true) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", close);
				}
			}

//			   driver.findElement(By.cssSelector(" button[id='submit']")).click();

//		        18. Close browser window
			Thread.sleep(5000);
			driver.close();

		}

		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			driver.quit();
		}

	}

	public static void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void scroll(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);

	}

	public static void selectByVisibleText(WebElement ele, String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}

	public static void selectFile(String path) throws AWTException, InterruptedException {
		Robot robot = new Robot();
		Thread.sleep(2000);
		// ctrl+c - clipboard (copying path to clipboard)
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		new Actions(driver)
//        .keyDown(Keys.CONTROL)
//        .sendKeys("v")
//        .keyUp(Keys.CONTROL)
//        .keyDown(Keys.ENTER)
//        .perform();
//		new Actions(driver).keyDown(Keys.ENTER).keyUp(Keys.ENTER)
//         .perform();
		new Actions(driver).sendKeys(Keys.ENTER);
	}

}
