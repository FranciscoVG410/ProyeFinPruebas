/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

/**
 *
 * @author OMEN
 */
public class ActionUtils {

    // Realiza clic en un elemento
    public static void click(WebElement webElement) {
        webElement.click();
    }

    // Envia texto a un campo de entrada
    public static void sendKeys(WebElement webElement, String textToSend) {
        webElement.sendKeys(textToSend);
    }

    // Obtiene el texto de un elemento
    public static String getText(WebElement webElement) {
        return webElement.getText();
    }

    // Verifica si un elemento es visible en la página
    public static boolean validateElementDisplayed(WebElement webElement) {
        return webElement.isDisplayed();
    }

    // Toma una captura de pantalla y la guarda con el nombre de la prueba
    public static void takeScreenshot(WebDriver webdriver, String testCaseName) {
        File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "./test-output/ExecutionResults";
        try {
            FileHandler.createDir(new File(screenshotPath));
            FileHandler.copy(srcFile, new File(screenshotPath + File.separator + testCaseName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
