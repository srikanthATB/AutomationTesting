package com.assignments;

import java.beans.Visibility;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment_23 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/**
		 * Selenium Assignment - 1 ==================== 1. Launch browser window(Chrome)
		 * 2. Maximize the browser window 3. Delete all the cookies 4. Enter URL and
		 * Launch the application (https:parabank.parasoft.com/parabank/index.htm) 5.
		 * Verify application title (ParaBank | Welcome | Online Banking) 6. Verify
		 * application logo 7. Verify application caption (Experience the difference) 8.
		 * Enter Invalid credentials in Username and Password textboxes 9. Verify button
		 * label (LOG IN) and Click on Login Button 10. Verify error message is coming
		 * 11. Click on Admin page link 12. Wait for admin page 13. Select Data access
		 * mode as ' SOAP' 14. Scroll-down till Loan provider 15. Select Loan provider
		 * as 'Web Service' 16. Click on Submit button 17. wait for Successful
		 * submission message 18. Click on Services Link 19. Wait for Services page 20.
		 * Scroll-down till Bookstore services 21. Get total rows, columns in the
		 * bookstore service table 22. Get Column headers of book store services table
		 * 23. Get all the data from book store service table 24. Close browser window
		 */

//		Browser settings
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-notifications");

//		1. Launch the Browser window (Browser = Chrome) 
		WebDriver driver = new ChromeDriver(options);

		try {

			// 2. Maximize the browser window
			driver.manage().window().maximize();

			// 3. Delete all the cookies
			driver.manage().deleteAllCookies();

			// 4. Enter URL and Launch the application
			// (https:parabank.parasoft.com/parabank/index.htm)
			driver.get("https:parabank.parasoft.com/parabank/index.htm");

			// 5. Verify application title (ParaBank | Welcome | Online Banking)
			String title = driver.getTitle();
			Assert.assertEquals("ParaBank | Welcome | Online Banking", title);

			// 6. Verify application logo
			Assert.assertTrue(driver.findElement(By.className("logo")).isDisplayed());

			// 7. Verify application caption (Experience the difference)
			Assert.assertEquals("Experience the difference", driver.findElement(By.cssSelector("p.caption")).getText());

			// 8. Enter Invalid credentials in Username and Password textboxes
			driver.findElement(By.cssSelector("[name='username']")).sendKeys("admin");
			driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin");

			// 9. Verify button label (LOG IN) and Click on Login Button
			WebElement login = driver.findElement(By.cssSelector("[value='Log In']"));
			Assert.assertTrue(login.isDisplayed());
			Assert.assertEquals("Log In", login.getDomAttribute("value"));
			Assert.assertTrue(login.isEnabled());
			login.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
			// 10. Verify error message is coming
			Assert.assertEquals("The username and password could not be verified.",
					driver.findElement(By.cssSelector("p.error")).getText());

			// 11. Click on Admin page link
			// a[text()='Admin Page']
//			driver.findElement(By.partialLinkText("Admin Page")).click();
			driver.findElement(By.xpath("//li[text()='Solutions']/following-sibling::li[5]")).click();

			// 12. Wait for admin page
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Administration')]")));

			// 13. Select Data access mode as ' SOAP'
			driver.findElement(By.cssSelector("input#accessMode1")).click();

			// 14. Scroll-down till Loan provider

			WebElement element = driver.findElement(
					By.cssSelector("#adminForm > table:nth-child(8) > tbody > tr:nth-child(4) > td:nth-child(1) > b"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(1000);

			// 16. Click on Submit button

			WebElement submit = driver.findElement(By.cssSelector("input[value='Submit']"));
			Assert.assertTrue(submit.isDisplayed());
			Assert.assertEquals("Submit", submit.getDomAttribute("value"));
			Assert.assertTrue(submit.isEnabled());
			submit.click();

			// 17. wait for Successful submission message

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'successfully')]")));

			// 18. Click on Services Link
//			driver.findElement(By.partialLinkText("Services")).click();
			driver.findElement(By.xpath("//li[text()='Solutions']/following-sibling::li[2]")).click();

			// 19. Wait for Services page
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//span[contains(text(),'Available Bookstore SOAP services:')]")));

			// 20. Scroll-down till Bookstore services
			WebElement element1 = driver.findElement(By.cssSelector("#rightPanel > span:nth-child(9)"));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(1000);

			// 21. Get total rows, columns in the bookstore service table
			List<WebElement> rows = driver.findElements(
					By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]/tbody/tr"));
			List<WebElement> cols = driver.findElements(
					By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]/tbody/tr[1]/td"));
			System.out.println("Rows : " + rows + " Columns : " + cols);

			// 22. Get Column headers of book store services table

			for (WebElement webElement : cols) {
				System.out.print(webElement.getText() + "    ||    ");
			}
			System.out.println();
			for (int row = 2; row <= rows.size(); row++) {

				for (int col = 1; col <= cols.size(); col++) {
					System.out.print(driver.findElement(
							By.xpath("//span[text()='Bookstore services:']/following-sibling::table[1]/tbody/tr[" + row
									+ "]/td[" + col + "]"))
							.getText() + " || ");
				}
				System.out.println();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			driver.close();
//			driver.quit();
		} finally {
			driver.close();
			driver.quit();
		}

	}

}
