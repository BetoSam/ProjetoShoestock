package elementos;

import org.openqa.selenium.By;

public class Elementos {
	public By btnPesquisar = By.xpath("//*[@type='submit'][@class='button no-border  ns-icon ns-icon-search']");
	public By barraDeBusca = By.id("search-input");
	public By btnBuscar = By.xpath("//input[@id='search-input']");
	public By fecharCadastro = By.id("Layer_1");
	public By calcADOS = By.id("Calçados");
	public By tamanho38 = By.xpath("//a[@class='product-item'][@data-label='38']");
	public By produtoDemoJames = By.xpath("//div[@class='item-card__description__product-name']");
	public By btnComprar = By.id("buy-button-now");
	public By corProduto = By.xpath("//p[contains(text(),'Marrom Escuro')]");
	public By tamanhoProduto = By.xpath("//p[contains(text(),'38')]");
	public By valorProdutoPix = By.xpath("//*[@qa-auto='cart-price-payment-method']");
	public By coockies = By.xpath("//div[text()='CONCORDAR E FECHAR']");
	public By layer =By.xpath("//*[@id='Layer_1']");
}
