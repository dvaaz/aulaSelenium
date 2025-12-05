package test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Montagem de Infraestrutura
 * Edge só permite conexões locais
 * 
 */
public class BaseTestEdge {
	protected static WebDriver driver; 
	// protected = para o pacote, static final = uma constante
	protected static final String URL_BASE = "C:/Users/36129382024.1m/Documents/darley_senac/Testes%20de%20Software/sistema/login.html";
	protected static final String PATH_DRIVE = "src/test/resources/msedgedriver.exe"; // Versão 143.0.3650.66 

	@BeforeClass //  Inicia antes da classe filha
	public static void iniciar() {
		System.setProperty("webdriver.edge.driver: 143.0.3650.66", PATH_DRIVE); // Set o driver e o seu endereço
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
