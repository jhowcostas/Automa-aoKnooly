package CadastroDeNegocio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastrarLinhaDeNegocio {
	
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
	public void novaLinhaDeNegocio() throws InterruptedException {
		this.browser = new ChromeDriver();
        browser.navigate().to(URL_LOGIN);
		browser.findElement(By.id("txt-email")).sendKeys("jonatas.silva@keeggo.com");
	    browser.findElement(By.id("txt-password")).sendKeys("Knooly123");
	    browser.findElement(By.id("id-sec-error-user-invalid")).submit();
		
	   
        Thread.sleep(10000);
        //tela para inserir o Token
        browser.getCurrentUrl().equals("https://knooly-qa.azurewebsites.net/#/verification-code");
		browser.findElement(By.id("id-sec-verification-code-verification-input")).sendKeys("654321");
		browser.findElement(By.id("btn-send-password")).submit();
		Thread.sleep(3000);
		//tela logada
		browser.getCurrentUrl().equals("https://knooly-qa.azurewebsites.net/#/main/dashboard");
        Assert.assertEquals("Jonatas Silva", browser.findElement(By.id("inf-user-name")).getText());
        
		browser.findElement(By.className("mat-icon notranslate iconMenuHover material-icons-round material-icons mat-icon-no-color ng-star-inserted")).submit();
		Thread.sleep(2000);
		browser.findElement(By.id("btn-add-line-business")).submit();	
		browser.findElement(By.id("txt-LineOfBusinessName")).sendKeys("linha de negócio teste Jonatas");
		browser.findElement(By.id("btn-save-add-line-business")).submit();
	}
}
