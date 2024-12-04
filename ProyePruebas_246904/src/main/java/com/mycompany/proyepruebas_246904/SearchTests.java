/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyepruebas_246904;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author OMEN
 */
public class SearchTests {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchPlayStationTest() {
        driver.get("https://www.liverpool.com.mx/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search-bar']"));
        searchBox.sendKeys("playstation");
        searchBox.submit();

        // Verifica que los resultados incluyan "PlayStation 5"
        WebElement result = driver.findElement(By.xpath("//*[contains(text(),'PlayStation 5')]"));
        Assert.assertTrue(result.isDisplayed(), "PlayStation 5 no se encuentra en los resultados");

        // Selecciona el artículo
        result.click();
        WebElement productTitle = driver.findElement(By.xpath("//h1[contains(@class, 'product-title')]"));
        Assert.assertTrue(productTitle.getText().contains("PlayStation 5"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
