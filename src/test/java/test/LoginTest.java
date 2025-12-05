package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pageObject.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTestLogin{
	
	public static LoginPO loginPage;
	
	@BeforeClass
	public static void prepararTeste() {
		loginPage = new LoginPO(driver);
	}
	
	/**
	 * TC001 - Não deve logar no sistema com email e senha vazios
	 */
	@Test
	public void TC001_NaoDeveLogarNoSistemaComEmailESenhaVazios() {
		loginPage.executarAcaoDeLogar("", "");
		
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC002_NaoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {
		loginPage.executarAcaoDeLogar("", "123456");
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC003_DeveLogarNoSistemaComEmailESenhaCorretos() {
		loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
		
		String titulo = loginPage.obterTituloPagina();
		
		assertEquals(titulo, "Controle de Produtos");
	}

}
