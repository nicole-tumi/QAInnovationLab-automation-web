package com.nttdata.steps;

import com.nttdata.page.InventoryPage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.nttdata.core.DriverManager.getDriver;

// Aqui se interactua con la interfaz tanto para enviar datos como para obtener

public class InventorySteps {

    private WebDriver driver;

    //constructor
    public InventorySteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Obtener el título de la pantalla de productos
     * @return el valor del título de la pantalla de productos
     */
    public String getTitle(){
        return this.driver.findElement(InventoryPage.productsTitle).getText();
    }

    /**
     * Retorna la cantidad de items
     * @return la cantidad de items
     */
    public int getItemSize(){
        List<WebElement> items = this.driver.findElements(InventoryPage.itemsCards);
        return items.size();
    }

    /**
     * Obtener el título de la card del producto
     * @return el valor del título de la card del producto
     */
    public String getProductCardTitle(){
        return this.driver.findElement(InventoryPage.productCardTitle).getText();
    }

    /**
     * Hacer click en la redirección del nombre del producto
     */
    public void seleccionarProductCardTitle(){
        this.driver.findElement(InventoryPage.productCardTitle).click();
    }

    /**
     * Seleccionar el filtro de los productos
     */
    public void clickFilter(){
        this.driver.findElement(InventoryPage.optionDropdownFilter).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Espera de hasta 30 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryPage.optionHighToLow));
    }

    /**
     * Seleccionar la opcion mayor a menor
     */
    public void clickOptionHighToLow(){
        this.driver.findElement(InventoryPage.optionHighToLow).click();
    }

    /**
     * Obtener el arreglo de los precios de los productos
     * @return el valor del arreglo de los precios de los productos
     */
    public List<WebElement> getProductsPrices(){
        return this.driver.findElements(InventoryPage.productsPriceArray);
    }

    /**
     * Scrollear en la ventana
     */
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,400)");
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
