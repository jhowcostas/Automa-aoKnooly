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
		
	   
        Thread.sleep(4000);
        //tela para inserir o Token
        browser.getCurrentUrl().equals("https://knooly-qa.azurewebsites.net/#/verification-code");
		browser.findElement(By.id("id-sec-verification-code-verification-input")).sendKeys("654321");
		browser.findElement(By.id("btn-send-password")).submit();
		Thread.sleep(3000);
		//tela logada
		browser.getCurrentUrl().equals("https://knooly-qa.azurewebsites.net/#/main/dashboard");
        Assert.assertEquals("Jonatas Silva", browser.findElement(By.id("inf-user-name")).getText());
        
		browser.findElement(By.cssSelector("body.notranslate:nth-child(2) app-main.ng-star-inserted:nth-child(2)"
				+ " section.page:nth-child(2) aside.aside section.page.width-short div.content cdk-virtual-scroll-viewport."
				+ "cdk-virtual-scroll-viewport.example-viewport.cdk-virtual-scroll-orientation-vertical div.cdk-virtual-scroll-content"
				+ "-wrapper mat-tree.mat-tree.cdk-tree.nav-menu-tree mat-nested-tree-node.mat-nested-tree-node.cdk-nested-tree-node.cdk"
				+ "-tree-node.ng-star-inserted:nth-child(1) ul:nth-child(1) li.ng-star-inserted > div.mat-tooltip-trigger.mat-tree-node")).click();
		Thread.sleep(2000);
		browser.findElement(By.id("btn-add-line-business")).click();	
		Thread.sleep(2000);
		browser.findElement(By.id("txt-LineOfBusinessName")).sendKeys("linha de negócio teste Jonatas");
		browser.findElement(By.id("btn-save-add-line-business")).click();

		
		
		
		
	}

	
}
