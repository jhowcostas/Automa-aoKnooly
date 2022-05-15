package maven;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValido {

	 @Test
	 public void LoginValido() {
		 	ChromeDriver browser = new ChromeDriver();
	        browser.navigate().to("https://knooly-qa.azurewebsites.net/#/login");
	        browser.findElement(By.id("txt-email")).sendKeys("jonatas.silva@keeggo.com");
	        browser.findElement(By.id("txt-password")).sendKeys("Knooly123");
	        browser.findElement(By.id("id-sec-error-user-invalid")).submit();
	        
	        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        Assert.assertFalse(browser.getCurrentUrl().equals("https://knooly-qa.azurewebsites.net/#/login"));
	        Assert.assertEquals("Token", browser.findElement(By.id("id-sec-vcode")).getText());	        
	        
	        browser.quit();
		 
	 }
}
