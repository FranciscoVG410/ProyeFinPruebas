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
public class BellezaCategoryTest {

    WebDriver driver;

    @BeforeClass
    public void startWebDriver() {
        driver = Driver.setupDriver();
        driver.get(Vars.HOMEPAGE);
        System.out.println("Iniciando prueba de búsqueda de perfumes para hombre.");
    }

    @Test
    public void searchPerfumeDior() {
        Inicio homePage = new Inicio(driver);
        search searchResultsPage = new search(driver);

        // Seleccionar la categoría "Perfumes Hombre"
        homePage.selectPerfumesHombre();

        // Aplicar filtro para seleccionar Dior
        searchResultsPage.applyFilterDior();
    }

    @AfterClass
    public void tearDown() {
        ActionUtils.takeScreenshot(driver, "TC_SearchPerfumesForMen");
        System.out.println("Prueba de perfumes para hombre terminada.");
        driver.close();
    }
}
