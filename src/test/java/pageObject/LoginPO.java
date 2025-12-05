package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

	public LoginPO(WebDriver driver) {
		super(driver);
	}
	
	// id do input de email
	@FindBy(id="email")
	public WebElement inputEmail;

	// id do input de senha
	@FindBy(id="senha")
	public WebElement inputSenha;
	
	// id do botão para entrar
	@FindBy(id="btn-entrar")
	public WebElement buttonEntrar;
	
	// query para encontrar o span onde está a mensagem
	@FindBy(css="form.form-login>div.alert>span")
	public WebElement spanMensagem;
	
	// Retorna mensagem obtida pelo query selector 
	public String obterMensagem(){
		return this.spanMensagem.getText();
	}
	
	// Metodo de entrada do input : mensagem>> tab
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto+ Keys.TAB);
	}
	
	// Retorna Titulo da página obtido pelo método do selenium getTitle
	public String obterTituloPagina() {
		return driver.getTitle();
	}

	// Método para a ação de Logar na página
	public void executarAcaoDeLogar(String email, String senha) {
		escrever(inputEmail, email);
		escrever(inputSenha, senha);
		buttonEntrar.click();		
	}
	
	
}
