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
public class SearchSmartTVTest {

    WebDriver driver;

    @BeforeClass
    public void startWebDriver() {
        driver = Driver.setupDriver();
        driver.get(Vars.HOMEPAGE);
        System.out.println("Iniciando prueba de búsqueda de Smart TV.");
    }

    @Test
    public void searchSmartTVAndApplyFilters() {
        Inicio homePage = new Inicio(driver);
        search searchResultsPage = new search(driver);

        // Escribir "smart tv" en la barra de búsqueda
        homePage.sendSearchBar(Vars.SEARCH_TERM_SMARTTV);

        // Validar que los filtros Tamaño y Precio se muestran
        Assert.assertTrue(searchResultsPage.areFiltersDisplayed(), "Los filtros Tamaño y Precio no se muestran.");

        // Aplicar filtros: Tamaño: 55 pulgadas, Precio: > 10,000, Marca: Sony
        searchResultsPage.applyFilters("55 pulgadas", "10000-700000", "SONY");
    }

}
