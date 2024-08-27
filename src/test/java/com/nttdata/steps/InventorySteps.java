package com.nttdata.steps;

import com.nttdata.page.InventoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

}
