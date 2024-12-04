/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyepruebas_246904;

/**
 *
 * @author OMEN
 */
public class ProyePruebas_246904 {

    public static void main(String[] args) {
        // Configura el driver de Chrome automáticamente con WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Crea la instancia de WebDriver usando ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Abre una página web
        driver.get("https://www.google.com");

        // Imprime el título de la página
        System.out.println("Title: " + driver.getTitle());

        // Cierra el navegador
        driver.quit();
    }
}
