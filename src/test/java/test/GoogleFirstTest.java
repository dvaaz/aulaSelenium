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
	private String URL_BASE = "https://www.duckduckgo.com";
	private String PATH_DRIVE = "src/test/resources/chromedriver1420744459.exe";

	private void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(URL_BASE);		
	}

	@Test
	public void pesquisarNoGoogle() {
		//Montagem do cenário
		iniciar();
		
		WebElement inputPesquisa = driver.findElement(By.name("q"));
		inputPesquisa.sendKeys("receita de bolo de cenoura" + Keys.ENTER);
		
		String resultado = driver.findElement(By.cssSelector("#react-layout article")).getText();
		
		System.out.println("Texto encontrado: " + resultado);
		
		assertTrue(resultado.contains("cenoura"));
		
		driver.quit();
		
		
	}

}
