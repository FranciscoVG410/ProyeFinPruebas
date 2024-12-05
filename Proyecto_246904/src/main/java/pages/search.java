/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author OMEN
 */
public class search {

    WebDriver driver;

    // Elementos de la página de resultados
    @FindBy(xpath = "//h3[@class='card-title a-card-description']/span")
    WebElement productTitle;

    @FindBy(xpath = "//button[normalize-space()='Precios']")
    WebElement filterPrice;

    @FindBy(xpath = "//button[normalize-space()='Tamaño']")
    WebElement filterSize;

    @FindBy(xpath = "//button[normalize-space()='Marcas']")
    WebElement filterBrand;

    // Constructor que inicializa los elementos de la página
    public search(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Obtiene el título del primer producto
    public String getProductTitle() {
        return productTitle.getText();
    }

    // Verifica si los filtros están visibles
    public boolean areFiltersDisplayed() {
        return filterSize.isDisplayed() && filterPrice.isDisplayed();
    }

    // Aplica filtros de tamaño, precio y marca
    public void applyFilters(String size, String price, String brand) {
        By sizeOption = By.xpath("//input[@id='variants.normalizedSize-" + size + "']");
        driver.findElement(sizeOption).click();
        sleep(5000); // Espera entre filtros

        By priceOption = By.xpath("//input[@id='variants.prices.sortPrice-" + price + "']");
        driver.findElement(priceOption).click();
        sleep(5000);

        By brandOption = By.xpath("//input[@id='brand-" + brand + "']");
        driver.findElement(brandOption).click();
        sleep(5000);
    }

    // Aplica el filtro de la marca Dior
    public void applyFilterDior() {
        By brandOptionExtra = By.xpath("//a[@id='Marcas']");
        driver.findElement(brandOptionExtra).click();
        By sizeOption = By.xpath("//input[@id='brand-DIOR']");
        driver.findElement(sizeOption).click();
        sleep(5000);
    }

    // Método para pausar la ejecución
    private void sleep(int timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
