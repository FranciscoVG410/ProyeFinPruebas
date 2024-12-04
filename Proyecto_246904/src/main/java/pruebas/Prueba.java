/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static utils.ActionUtils.takeScreenshot;

/**
 *
 * @author OMEN
 */
public class Prueba {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        // Tomar un screenshot de prueba
        takeScreenshot(driver, "testScreenshot");

        driver.quit();
    }
}
