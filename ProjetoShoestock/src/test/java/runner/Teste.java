package runner;

import org.junit.Before;
import org.junit.Test;

import elementos.Elementos;
import metodos.Metodos;


public class Teste {
	Metodos metodo = new Metodos();
	Elementos el = new Elementos();

	@Before
	public void iniciarTeste() {
		metodo.abrirNavegador();
		metodo.clicar(el.coockies);

	}

	@Test
	public void testSite() {
		// Massa de teste
		String tamanhoEsperado = "Tamanho: 38";
		String corEsperada = "Cor: Marrom Escuro";
		String valorTotal = "R$ 269,91 no Pix";
		metodo.tirarPrint("evidencia homePage");
		metodo.escrever(el.barraDeBusca, "sapato democrata james masculino");
		metodo.clicar(el.btnPesquisar);
		metodo.scroll(250);
		metodo.tirarPrint("evidencia pagina do produto desejado");
		metodo.clicar(el.produtoDemoJames);
		metodo.clicar(el.tamanho38);
		metodo.tirarPrint("evidencia produto escolhido");
		metodo.aguardarElemento(el.btnComprar);
		metodo.clicar(el.btnComprar);
		metodo.pausa(500);
		metodo.tirarPrint("evidencia produto no carrinho de compra");
		metodo.validarMensagem(el.corProduto, corEsperada);
		metodo.validarMensagem(el.tamanhoProduto, tamanhoEsperado);
		metodo.validarMensagem(el.valorProdutoPix, valorTotal);
	}

	// @Test
	public void titleShoestock() {

		metodo.validarTitle("shoestock: Novas escolhas, novos caminhos | Loja de Calçados Online");

	}
}
