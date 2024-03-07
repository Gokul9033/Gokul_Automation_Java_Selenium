package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {
	
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		
		//Set up the Driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Gokul_Flipkart_Automation\\driver\\chromedriver.exe");
		
		//Launch the Browser
		WebDriver driver = new ChromeDriver();
		
		//Go to the URL
		driver.get("https://www.amazon.in/-/hi/ap/signin?openid.pape.max_auth_age=3600&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fspr%2Freturns%2Fgift&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=amzn_psr_desktop_in&openid.mode=checkid_setup&language=en_IN&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
		//Maximize the Browser
		driver.manage().window().maximize();
		
		//To get the Title
		String title = driver.getTitle();
		System.out.println(title);
		
		//To get the Current URL
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		//Locators Using Xpath
		//Login
		//Account-Email
		WebElement accountEmail = driver.findElement(By.xpath("//input[@id='ap_email']"));
		accountEmail.sendKeys("9360085565");
		Thread.sleep(2000);
		//Account-Password
		WebElement accountPassword = driver.findElement(By.xpath("//input[@id='ap_password']"));
		accountPassword.sendKeys("Gokul@9033");
		Thread.sleep(2000);
		//Account- Signin
		WebElement btnSign = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		btnSign.click();
		Thread.sleep(3000);
		
		//Navigate
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		//JavaScript Using Passing & Getting values
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		//Product-name
		WebElement enterProduct = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		jk.executeScript("arguments[0].setAttribute('value','Oneplus 7T')", enterProduct);
		Thread.sleep(2000);
		//Product-search
		WebElement enterSearch = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		jk.executeScript("arguments[0].click()", enterSearch);
		Thread.sleep(3000);
		
		//Scroll Up & Down
		//Scroll-Down
		JavascriptExecutor jl = (JavascriptExecutor) driver;
		WebElement scrollDownRelated = driver.findElement(By.xpath("//span[text()='Related searches']"));
		jl.executeScript("arguments[0].scrollIntoView(true)", scrollDownRelated);
		Thread.sleep(3000);
		WebElement scrollUpPrice = driver.findElement(By.xpath("//span[text()='Price']"));
		jl.executeScript("arguments[0].scrollIntoView(true)", scrollUpPrice);
		Thread.sleep(3000);
		
		//Actions
		//LowPrice
		WebElement lowPrice = driver.findElement(By.xpath("//input[@id='low-price']"));
		lowPrice.sendKeys("10000");
		Thread.sleep(2000);
		WebElement highPrice = driver.findElement(By.xpath("//input[@id='high-price']"));
		highPrice.sendKeys("50000");
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.doubleClick(highPrice).perform();
		Thread.sleep(2000);
		a.contextClick(highPrice).perform();	
		Thread.sleep(3000);

		//Robot
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
			
		//Scroll-Up
		WebElement scrollUponeplus7T = driver.findElement(By.xpath("//span[text()='(Refurbished) OnePlus 7T (Frosted Silver, 8GB RAM, Fluid AMOLED Display, 128GB Storage']"));
		jl.executeScript("arguments[0].scrollIntoView(true)", scrollUponeplus7T);
		Thread.sleep(3000);		
				
		//Screenshot
		TakesScreenshot tk = (TakesScreenshot) driver;
	    File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File("C:\\Users\\Admin\\eclipse-workspace\\Gokul_Flipkart_Automation\\Screenshot\\Amazon.png");
		FileUtils.copyFile(src, des);
		Thread.sleep(3000);
		
		//Click-Product
		WebElement clickOneplus = driver.findElement(By.xpath("//span[text()='(Refurbished) OnePlus 7T (Frosted Silver, 8GB RAM, Fluid AMOLED Display, 128GB Storage']"));
		clickOneplus.click();
		Thread.sleep(3000);
 
	  
		
	}
 
}

