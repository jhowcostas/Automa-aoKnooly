package maven;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    private static final String URL_LOGIN = "https://knooly-qa.azurewebsites.net/#/login";
	private WebDriver browser;
   
    public void iniciarPaginaLogin() {
        this.browser = new ChromeDriver();
        browser.navigate().to(URL_LOGIN);
    }
    
    public void fechar(){
        this.browser.quit();
    }
    
    public boolean isPaginaLogin(){
   	 	return browser.getCurrentUrl().equals(URL_LOGIN);
   	 	}
	
    public void preencheDadosLogin(String username, String password) {
	    browser.findElement(By.id("txt-email")).sendKeys(username);
	    browser.findElement(By.id("txt-password")).sendKeys(password);
	 	}
	      
	 public void submeteBotaoParaLogar() {
		browser.findElement(By.id("id-sec-error-user-invalid")).submit();
	 	}
	 
	public boolean validacaoUrlLoginRealizado() {
		return browser.getCurrentUrl().equals("https://knooly-qa.azurewebsites.net/#/main/dashboard");
	    }
	    	        
     public void emailInvalido() {
    	Assert.assertTrue(browser.getPageSource().contains(" E-mail inválido "));
     	}
     
	public void preencherTokenValido() {
		browser.findElement(By.id("id-sec-verification-code-verification-input")).sendKeys("654321");
		browser.findElement(By.id("btn-send-password")).submit();
	} 

	 public void MensagemSenhaInvalida(){
	    Assert.assertTrue(browser.getPageSource().contains("Não foi encontrado nenhum usuário ativo com as informações fornecidas"));
	        
	 }
	 	 
}

	

