package Login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testesLogin {
	
private WebDriver browser;
	

	
		private static final String URL_LOGIN = "https://knooly-qa.azurewebsites.net/#/login";
		
		@BeforeEach
	    public void iniciarPaginaLogin() {
			this.browser = new ChromeDriver();
	        browser.navigate().to(URL_LOGIN);
	        	    }
		
		@AfterEach
	    public void afterEach(){
			this.browser.quit();
	    }
		
		@Test
		public void efetuarLoginDadosValidos() throws InterruptedException {
		    browser.findElement(By.id("txt-email")).sendKeys("jonatas.silva@keeggo.com");
		    browser.findElement(By.id("txt-password")).sendKeys("Knooly123");
		    browser.findElement(By.id("id-sec-error-user-invalid")).submit();
			
		   
	        Thread.sleep(3000);
	        //tela para inserir o Token
	        browser.getCurrentUrl().equals("https://knooly-qa.azurewebsites.net/#/verification-code");
			browser.findElement(By.id("id-sec-verification-code-verification-input")).sendKeys("654321");
			browser.findElement(By.id("btn-send-password")).submit();
			Thread.sleep(3000);
			//tela logada
			browser.getCurrentUrl().equals("https://knooly-qa.azurewebsites.net/#/main/dashboard");
	        Assert.assertEquals("Jonatas Silva", browser.findElement(By.id("inf-user-name")).getText());	        
			
		}
		
		@Test
		public void emailLoginInvalido() throws InterruptedException {
		    browser.findElement(By.id("txt-email")).sendKeys("jonatas.silva@keeggo");
		    browser.findElement(By.id("txt-password")).sendKeys("Knooly123");
		    browser.findElement(By.id("id-sec-error-user-invalid")).submit();
			Thread.sleep(2000);
			Assert.assertTrue(browser.getPageSource().contains(" E-mail inválido "));
		}
		
		@Test
		public void senhaLoginInvalido() throws InterruptedException{
		    browser.findElement(By.id("txt-email")).sendKeys("jonatas.silva@keeggo.com");
		    browser.findElement(By.id("txt-password")).sendKeys("Knooly");
		    browser.findElement(By.id("id-sec-error-user-invalid")).submit();
			Thread.sleep(2000);
			Assert.assertTrue(browser.getPageSource().contains("Não foi encontrado nenhum usuário ativo com as informações fornecidas"));
		}
		
		
		
}


