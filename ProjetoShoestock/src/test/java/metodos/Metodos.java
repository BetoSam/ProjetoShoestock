package metodos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriversFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Metodos extends DriversFactory {

	public void abrirNavegador() {

		boolean headless = false;
		WebDriverManager.chromedriver().setup();
		String site = "https://www.shoestock.com.br/";
		ChromeOptions chromeOptions = new ChromeOptions();
		if (headless) {
			chromeOptions.addArguments("--headless");
		}
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		chromeOptions.addArguments("--disable-notifications");
		driver = new ChromeDriver(chromeOptions);
		driver.get(site);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fecharNavegador() {
		driver.quit();
	}

	public void clicar(By elemento) {
		driver.findElement(elemento).click();

	}

	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);
	}

	public void tirarPrint(String nomeEvidencia) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("./evidencias/" + nomeEvidencia + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void validarMensagem(By elemento, String msgEsperada) {
		String msgCapturado = driver.findElement(elemento).getText();
		assertEquals(msgEsperada, msgCapturado);

	}

	public void enter(By elemento) {
		driver.findElement(elemento).submit();
	}

	public void alert() {

		Alert alert = driver.switchTo().alert();

		alert.dismiss();
	}

	public void pausa(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scroll(int qtdScroll) {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0," + qtdScroll + ")", "");
	}

	public String pegarTextoRetorno(By elemento) {
		String texto = driver.findElement(elemento).getText();
		return texto;
	}

	public void aguardarElemento(By elemento) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elemento));
		element.click();
	}

	public void validarTitle(String titleDesejado) {
		assertEquals(titleDesejado, driver.getTitle());
	}

}
