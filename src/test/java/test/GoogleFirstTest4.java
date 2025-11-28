package test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;

import pageObject.GooglePO;

/**
 * Utilizando o pageObject
 * @author dvaaz
 *
 */
public class GoogleFirstTest4 extends BaseTest{

	private static GooglePO googlePage;
	
	@BeforeClass
	public static void prepararTestes() {
		driver.get("https://www.duckduckgo.com");
		googlePage = new GooglePO(driver);
	}
	
	@Test
	public void pesquisarNoGoogle() {
		// ---------------- Montagem de cenário ------------------/
		
		googlePage.inputPesquisa.sendKeys("\"bolo de cenoura\"" + Keys.ENTER);
		
		String resultado = googlePage.divResultadoPesquisa.getText();
		
		System.out.println("Texto encontrado: " + resultado); // Um print no console
		
		assertTrue(resultado.contains("cenoura")); // verifica se há o texto
		
	}
	
	@Test
	public void pesquisarNoGoogle2() {
		// ---------------- Montagem de cenário ------------------/
		
//		googlePage.inputPesquisa.sendKeys("\"bolo de cenoura\"" + Keys.ENTER);
		googlePage.pesquisar("\"bolo de cenoura\"");
		
//		String resultado = googlePage.divResultadoPesquisa.getText();
		String resultado = googlePage.obterResultadoDaPesquisa();
		
		System.out.println("Texto encontrado: " + resultado); // Um print no console
		
		assertTrue(resultado.contains("cenoura")); // verifica se há o texto
		
	}


}