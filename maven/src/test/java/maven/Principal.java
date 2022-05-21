package maven;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Principal {
	  
	
	public Login paginaLogin;
	
		private static final String URL_LOGIN = "https://knooly-qa.azurewebsites.net/#/login";
		private WebDriver browser;
		
		@BeforeEach
	    public void beforeEach(){
	        //this.paginaLogin = new iniciarPaginaLogin();
			this.browser = new ChromeDriver();
	        browser.navigate().to(URL_LOGIN);
	    }
		
		@AfterEach
	    public void afterEach(){
	        this.paginaLogin.fechar();
	    }
		
		@Test
		public void efetuarLoginDadosValidos() throws InterruptedException {
			paginaLogin.preencheDadosLogin("jonatas.silva@keeggo.com","Knooly123");
			paginaLogin.submeteBotaoParaLogar();
			
	        Thread.sleep(10000);
	        //tela para inserir o Token
	        Assert.assertFalse(paginaLogin.isPaginaLogin());
	        paginaLogin.preencherTokenValido();
	        paginaLogin.validacaoUrlLoginRealizado();
			
		}
		
		@Test
		public void emailLoginInvalido() throws InterruptedException {
			paginaLogin.preencheDadosLogin("jonatas.silva@keeggo","Knooly123");
			paginaLogin.submeteBotaoParaLogar();
			Thread.sleep(10000);
			paginaLogin.emailInvalido();
		}
		
		@Test
		public void senhaLoginInvalido() throws InterruptedException{
			paginaLogin.preencheDadosLogin("jonatas.silva@keeggo.com","123");
			paginaLogin.submeteBotaoParaLogar();
			Thread.sleep(10000);
			paginaLogin.MensagemSenhaInvalida();
		}
		
		
		
}
