package page;

import org.openqa.selenium.By;

import metodos.Metodos;

public class HomePage {
	Metodos metodo = new Metodos();
	By pesquisar = By.id("search-input");
	By lupaPesquisar = By.xpath("//*[@type='submit'][@class='button no-border  ns-icon ns-icon-search']");

	public void buscarProduto(String texto) {
metodo.escrever(pesquisar, texto);
metodo.clicar(lupaPesquisar);
	}

}
