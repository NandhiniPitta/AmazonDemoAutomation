package amazonDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrdersDemo {
	WebDriver driver;

	
	public static void main(String[] args) {
		
		System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        
        driver.findElement(By.id("nav-link-accountList")).click();
        
        
        driver.findElement(By.id("ap_email")).sendKeys("pittanandhini69@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("Amazon@1999");
        driver.findElement(By.id("signInSubmit")).click();
        
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("headphones");
        searchBox.submit();
        
        WebElement product = driver.findElement(By.partialLinkText("Classroom Headphones-Bulk 10-Pack, Student On Ear Comfy Swivel Earphones for Library, School, Airplane, Kids-for Online Learning and Travel, HQ Stereo Sound 3.5mm"));
        product.click();
        
        driver.navigate().back();        
        
        driver.findElement(By.id("nav-cart")).click();
        driver.findElement(By.name("proceedToRetailCheckout")).click();
        
        // Choose delivery address
        driver.findElement(By.id("shipToThisAddressButton")).click();
        
        WebElement radioButton = driver.findElement(By.linkText("kyc-xborder-action-type"));
        
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
        
        driver.findElement(By.partialLinkText("Payment method"));
        
        
	
		
        
        
	
	
	}
}
