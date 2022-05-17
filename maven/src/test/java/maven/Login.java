package maven;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class Login {

	 @Test
	 public void LoginValido() throws InterruptedException {
		 	ChromeDriver browser = new ChromeDriver();
	        browser.navigate().to("https://knooly-qa.azurewebsites.net/#/login");
	        browser.findElement(By.id("txt-email")).sendKeys("jonatas.silva@keeggo.com");
	        browser.findElement(By.id("txt-password")).sendKeys("Knooly123");
	        browser.findElement(By.id("id-sec-error-user-invalid")).submit();
	        
	        Thread.sleep(10000);
	        //tela para inserir o Token
	        Assert.assertFalse(browser.getCurrentUrl().equals("https://knooly-qa.azurewebsites.net/#/login"));
	        browser.findElement(By.id("id-sec-verification-code-verification-input")).sendKeys("654321");
	        browser.findElement(By.id("btn-send-password")).submit();
	        //Validação de login
	        Thread.sleep(10000);
	        Assert.assertTrue(browser.getCurrentUrl().equals("https://knooly-qa.azurewebsites.net/#/main/dashboard"));
	        Assert.assertTrue(browser.getPageSource().contains(" Acesso rápido "));
	        
	        browser.quit();
		 
	 }
	 @Test
	 public void loginInvalidoEmail() {
		 ChromeDriver browser = new ChromeDriver();
	        browser.navigate().to("https://knooly-qa.azurewebsites.net/#/login");
	        browser.findElement(By.id("txt-email")).sendKeys("jonatas.silva@keeggo");
	        browser.findElement(By.id("txt-password")).sendKeys("Knooly123");
	        browser.findElement(By.id("id-sec-error-user-invalid")).submit();
	        //localizar a mensagem de erro
	        Assert.assertTrue(browser.getPageSource().contains(" E-mail inválido "));
	        browser.quit();
	 }
	 
	 @Test
	 public void loginInvalidoSenha() throws InterruptedException {
		 ChromeDriver browser = new ChromeDriver();
	        browser.navigate().to("https://knooly-qa.azurewebsites.net/#/login");
	        browser.findElement(By.id("txt-email")).sendKeys("jonatas.silva@keeggo.com");
	        browser.findElement(By.id("txt-password")).sendKeys("123");
	        browser.findElement(By.id("id-sec-error-user-invalid")).submit();
	        //localizar a mensagem de erro
	        Thread.sleep(10000);
	        Assert.assertTrue(browser.getPageSource().contains("Não foi encontrado nenhum usuário ativo com as informações fornecidas"));
	        browser.quit();
	 }
}

	

