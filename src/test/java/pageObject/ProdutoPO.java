package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{
	
	public ProdutoPO(WebDriver driver) {
		super(driver);
	}
	
	// Ids dos botões
	@FindBy(id="btn-adicionar")
	public WebElement buttonEntrar;
	
	@FindBy(id="btn-salvar")
	public WebElement buttonSalvar;
	
	@FindBy(id="btn-sair")
	public WebElement buttonSair;
	
	@FindBy(css="Editar")
	public WebElement buttonEditar;
	
	
	// Ids dos Inputs
	@FindBy (id="codigo")
	public WebElement inputCodigo;
	
	@FindBy (id="nome")
	public WebElement inputNome;
	
	@FindBy (id="quantidade")
	public WebElement inputQuantidade;
	
	@FindBy (id="valor")
	public WebElement inputValor;
	
	@FindBy (id="data")
	public WebElement inputData;
	
	//id do span
	@FindBy(id="mensagem")
	public WebElement spanMensagem;
	
	// query para encontrar o span onde está a mensagem
	
	
	// busca os tds
    @FindBy(tagName = "td")
    private List<WebElement> tdElements;

    public List<String> verificaLista() {
        List<String> listaElementos = new ArrayList<>();
        
        // Itera sobre a lista de elementos <td> e adiciona seu texto à lista de strings
        for (WebElement td : tdElements) {
            listaElementos.add(td.getText());
        }
        
        // Retorna a lista com os textos dos <td> encontrados
        return listaElementos;
    }
    
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto+ Keys.TAB);
	}
    
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
    public void apertarBotao(WebElement botao) {
    	botao.sendKeys(Keys.ENTER);
    }
    
    public void sair() {
    	this.buttonSair.click();;
    }
    
    // Método para a execução de entrada de um objeto
    public void entrarComElemento(String codigo, String nome, String quantidade, String valor, String data) {
    	this.apertarBotao(buttonEntrar);
    	escrever(inputCodigo, codigo);
    	escrever(inputNome, nome);
    	escrever(inputQuantidade, quantidade);
    	escrever(inputValor, valor);
    	escrever(inputData, data);
    	buttonSalvar.click();
    }
	
	

}
