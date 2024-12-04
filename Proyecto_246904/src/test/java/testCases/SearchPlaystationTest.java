/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testCases;

import driver.Driver;
import utils.Vars;
import utils.ActionUtils;
import pages.Inicio;
import pages.search;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author OMEN
 */
public class SearchPlaystationTest {

    WebDriver driver;

    @BeforeClass
    public void startWebDriver() {
        driver = Driver.setupDriver();
        driver.get(Vars.HOMEPAGE);
        System.out.println("Iniciando prueba de búsqueda de PlayStation.");
    }

    @Test
    public void searchAndValidatePlayStation() {
        Inicio homePage = new Inicio(driver);
        search searchResultsPage = new search(driver);

        // Escribir "playstation" en la barra de búsqueda
        homePage.writeSearchBar(Vars.SEARCH_TERM_PLAYSTATION);

        // Validar si los resultados contienen "playstation"
        Assert.assertTrue(homePage.verifyResultsContain("playstation"), "Los resultados no contienen 'playstation'!");

        // Seleccionar PlayStation 5
        homePage.selectPlayStation5();

        // Validar el título del primer producto
        String productTitle = searchResultsPage.getProductTitle();
        Assert.assertTrue(productTitle.toLowerCase().contains("playstation"), "El título del primer producto no contiene 'playstation'!");
    }

}
