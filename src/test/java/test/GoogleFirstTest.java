package test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Teste Monolitico
 * @author dvaaz
 *
 */
public class GoogleFirstTest {
	private WebDriver driver;
	private String URL_BASE = "https://www.duckduckgo.com"; // Injeção da URL para busca 
	private String PATH_DRIVE = "src/test/resources/chromedriver.exe"; // Localização do driver na arquitetura do programa

	private void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // Gerenciar: janela, maximizar
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Gerenciar: timeout, 10 segundos
		
		driver.get(URL_BASE);		
	}

	@Test
	public void pesquisarNoGoogle() {
		//Montagem do cenário
		iniciar();
		
		WebElement inputPesquisa = driver.findElement(By.name("q")); // Variavel que carrega o elmento (obtido por documentação ou inspecão no site)
		inputPesquisa.sendKeys("\"receita de bolo de cenoura\"" + Keys.ENTER); // Informação enviada
		
		String resultado = driver.findElement(By.cssSelector("#react-layout article")).getText();
		
		System.out.println("Texto encontrado: " + resultado);
		
		assertTrue(resultado.contains("bolo de cenoura")); // Busca a String "bolo de cenoura"
		
		driver.quit();
		
		
	}

}
