package runner;

import org.junit.Before;
import org.junit.Test;

import elementos.Elementos;
import metodos.Metodos;
import page.HomePage;
import page.PageResultadoBusca;

public class TestPage {
	Metodos metodo = new Metodos();
	Elementos el = new Elementos();
	HomePage home = new HomePage();
	PageResultadoBusca resuPage = new PageResultadoBusca();

	@Before
	public void iniciarTeste() {
		metodo.abrirNavegador();
		metodo.clicar(el.coockies);
		metodo.aguardarElemento(el.layer);

	}

	@Test
	public void pesquisarProduto() {
		home.buscarProduto("bota");
		resuPage.ordenarPor("Ofertas");
		resuPage.SelecioneGenero("masculino");
		metodo.aguardarElemento(el.layer);
		resuPage.selecioneOTamanho("40");
		metodo.pausa(2000);
		resuPage.selecioneCor("cinza");
		metodo.pausa(1000);
		resuPage.selecionarProduto("1");
		resuPage.finalizarCompra("40");
		resuPage.validarProdutoCarrinho();

	}

}