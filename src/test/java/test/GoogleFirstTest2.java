package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/*
 * Teste utilizando a configuração de interface
 */
public class GoogleFirstTest2 extends BaseTest{

	
	@Test
	public void pesquisarNoGoogle() {
		// ---------------- Montagem de cenário ------------------/
		
		WebElement inputPesquisa = driver.findElement(By.name("q")); //  procura pelo elemento com o nome "q"
		inputPesquisa.sendKeys("\"Bolo de cenoura\"" + Keys.ENTER); //  Adiciona informação e aperta Enter
		
		String resultado = driver.findElement(By.cssSelector("#react-layout article")).getText(); // Busca pelo id do CSS e captura o texto
		
		System.out.println("Texto encontrado: " + resultado); // Um print no console
		
		assertTrue(resultado.contains("cenoura")); // verifica se há o texto
		
	}

}