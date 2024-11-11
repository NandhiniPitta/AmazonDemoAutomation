package amazonDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class OrderDemo2 {
	
	WebDriver driver;

	@BeforeClass
	void setup() {
		
		
		System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("nav-link-accountList")).click();
	}
	
	@Test(priority = 1)
	void createaccount() {

        driver.findElement(By.id("ap_email")).sendKeys("pittanandhini69@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("Amazon@1999");
        driver.findElement(By.id("signInSubmit")).click();
	}
	
	@Test(priority = 2)
	void searchheadphones() {
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("headphones");
        searchBox.submit();
        
        WebElement product = driver.findElement(By.partialLinkText("Classroom Headphones-Bulk 10-Pack, Student On Ear Comfy Swivel Earphones for Library, School, Airplane, Kids-for Online Learning and Travel, HQ Stereo Sound 3.5mm"));
        product.click();
        driver.navigate().back();
	}
	
	@Test(priority = 3)
	void Cart() {
		driver.findElement(By.id("nav-cart")).click();
        driver.findElement(By.name("proceedToRetailCheckout")).click();
        
        // Choose delivery address
        driver.findElement(By.id("shipToThisAddressButton")).click();
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();	
	}

}
