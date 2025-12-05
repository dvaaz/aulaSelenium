package test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Montagem de Infraestrutura
 * Inclui o 
 */
public class BaseTestProduto {
	protected static WebDriver driver; 
	// protected = para o pacote, static final = uma constante
	protected static final String URL_BASE = "C:/Users/36129382024.1m/Documents/darley_senac/Testes%20de%20Software/sistema/produtos.html";
	protected static final String PATH_DRIVE = "src/test/resources/chromedriver.exe";

	@BeforeClass //  Inicia antes da classe filha
	public static void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE); // Set o driver e o seu endereço
		driver = new ChromeDriver(); // Toma o comando do navegador
		driver.manage().window().maximize(); // abrir a janela e maximar
		driver.get(URL_BASE); // abrir a pagina requisitada
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // configura o tempo de resposta
	}
	
	@AfterClass // Assim que a classe finalizar
	public static void finalizar() {
		driver.quit();
	}
	
	

}
