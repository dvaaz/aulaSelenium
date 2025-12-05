package test;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTestProduto{
	public static ProdutoPO produtoPage; 
	
	@BeforeClass
	public static void prepararTestes() {
		produtoPage = new ProdutoPO(driver); 
	}
	
	
	@Test 
	public void TC001_NaoDeveDeixarCamposDoProdutoVazios() {
		produtoPage.buttonEntrar.click();
		produtoPage.buttonEntrar.click();
		produtoPage.entrarComElemento( "", "", "", "", "");
		String mensagem = produtoPage.obterMensagem();
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
		produtoPage.sair();
	}
	
	
	
	@Test 
	public void TC002_CodigoPreenchidoPoremOutrosAtributosNaoPreenchidos() {
		produtoPage.entrarComElemento( "111", "", "", "", "");
		String mensagem = produtoPage.obterMensagem();
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
		produtoPage.sair();
	}
	
	
	
	@Test 
	public void TC005_PreencherCamposDeProdutosCorretamente() {
		produtoPage.entrarComElemento( "100", "cachaça", "3", "10", "01-10-2000");
//		String mensagem = produtoPage.obterMensagem();
//		assertEquals(mensagem, "");
//		
		
		List<String> entrada = new ArrayList<>();
		entrada.add("100");
		entrada.add("cachaça");
		entrada.add("3");
		entrada.add("10");
		entrada.add("01-10-2000");
		
		List<String> saida = produtoPage.verificaLista();
		Integer tamanhoLista = produtoPage.verificaLista().size();
		
		produtoPage.sair();
		assertEquals(entrada.get(1), saida.get(1));
		
		
		
	}
	
}
