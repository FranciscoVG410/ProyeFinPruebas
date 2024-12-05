/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionUtils;

/**
 *
 * @author OMEN
 */
public class Inicio {
    WebDriver driver;

    // Elementos de la página principal
    @FindBy(xpath = "//input[@id='mainSearchbar']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@class='input-group-text']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'m-header__searchLinkResult')]//div[1]//a[1]")
    List<WebElement> searchResults;

    @FindBy(xpath = "//span[@class='a-header__strongLink nav-desktop-menu-action pr-3 pb-3']")
    private WebElement categoryButton;

    // Constructor que inicializa los elementos de la página
    public Inicio(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Escribe un término en la barra de búsqueda
    public void writeSearchBar(String item) {
        ActionUtils.sendKeys(searchBar, item);
    }

    // Hace clic en el botón de búsqueda
    public void clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        ActionUtils.click(searchButton);
    }

    // Envía un término de búsqueda y presiona Enter
    public void sendSearchBar(String item) {
        ActionUtils.sendKeys(searchBar, item + Keys.ENTER);
    }

    // Verifica si los resultados contienen un término específico
    public boolean verifyResultsContain(String term) {
        return searchResults.stream().anyMatch(result -> result.getText().toLowerCase().contains(term.toLowerCase()));
    }

    // Selecciona PlayStation 5 de los resultados
    public void selectPlayStation5() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement playStation5 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class, 'a-sayt__typeaheadLink') and .//label[contains(text(),'playstation')] and .//strong[contains(text(),'5')]]")
        ));
        playStation5.click();
    }

    // Selecciona la categoría "Perfumes Hombre" dentro de "Belleza"
    public void selectPerfumesHombre() {
        categoryButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement bellezaButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Belleza']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(bellezaButton).perform();
        WebElement perfumesHombreButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Perfumes Hombre']")));
        perfumesHombreButton.click();
    }
}
