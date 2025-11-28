package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Manipulação dos elementos da pagina
 * @author dvaaz
 *
 */
public class GooglePO extends BasePO{

	@FindBy(name = "q") //  Busca do elemento de nome q da página
	public WebElement inputPesquisa;
	
	@FindBy(css="#react-layout article") // Busca o elemento do CSS
	public WebElement divResultadoPesquisa;
	
	public GooglePO(WebDriver driver) {
		super(driver);
	}
	
	public void pesquisar(String texto) { // recebe query
		inputPesquisa.sendKeys(texto + Keys.ENTER);
	}
	
	public String obterResultadoDaPesquisa() { // recebe o resultado solicitado
		return divResultadoPesquisa.getText();
	}
}
