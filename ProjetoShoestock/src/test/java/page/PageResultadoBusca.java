package page;

import org.openqa.selenium.By;

import metodos.Metodos;

public class PageResultadoBusca {
	Metodos metodo = new Metodos();
	By btnOpcoes = By.xpath("//a[@qa-automation='search-order-button']");

	public void resultadoBuscaDeProduto() {
	}

	public void tipoProduto() {

	}

	public void ordenarPor(String categoria) {
		metodo.clicar(btnOpcoes);
		By escolhaCategoria = By.xpath("//div[@class='content']//a[text()='" + categoria + "']");
		metodo.clicar(escolhaCategoria);

	}

	public void selecionarProduto(String posicao) {

		By produto = By
				.xpath("//div[@class='wrapper']//a[" + posicao + "]//div[@class='item-card__images__image-link']//img");
		metodo.aguardarElemento(produto);

	}

	public void SelecioneGenero(String genero) {
		By generoProduto = By
				.xpath("//label[@class='filters__filter__list__item__label'][@for='genero-" + genero + "']");
		metodo.clicar(generoProduto);
	}

	public void selecioneOTamanho(String numero) {
		By numeroDoProduto = By.xpath("//label[@class='filters__filter__list__item__label'][text()='" + numero + "']");
		metodo.aguardarElemento(numeroDoProduto);
	}

	public void selecioneCor(String cor) {
		By corMenu = By.xpath("//span[@class='filters__filter__title__textLabel'][text()='Cor']");
		metodo.aguardarElemento(corMenu);
		//metodo.pausa(2000);
		metodo.scroll(200);
		By cores = By.xpath("//label[@class='filters__filter__list__item__label'][@for='cor-" + cor + "']");
		metodo.aguardarElemento(cores);
	}

	public void finalizarCompra(String tamanho) {
		By btnCompra = By.id("buy-button-now");
		By selecioneTamanhoParaFinalizarCompra = By.xpath("//a[@qa-option='available'][text()='" + tamanho + "']");
		metodo.clicar(selecioneTamanhoParaFinalizarCompra);
		metodo.pausa(500);
		metodo.aguardarElemento(btnCompra);
	}

	public void validarProdutoCarrinho() {
		By corProdutoCarrinho = By.xpath("//p[contains(text(),'Cinza')]");
		By tamanhoProdutoCarrinho = By.xpath("//p[contains(text(),'40')]");
		metodo.pausa(1000);
		metodo.validarMensagem(tamanhoProdutoCarrinho, "Tamanho: 40");
		metodo.validarMensagem(corProdutoCarrinho, "Cor: Cinza");
	}
}
