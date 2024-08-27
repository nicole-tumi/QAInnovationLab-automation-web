package com.nttdata.steps;

import com.nttdata.page.DetalleProductoPage;
import org.openqa.selenium.WebDriver;

public class DetalleProductoSteps {

    private WebDriver driver;

    //constructor
    public DetalleProductoSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Obtener el título de la página del producto
     * @return el valor del título de la página del producto
     */
    public String productNameTitlePage(){
        return this.driver.findElement(DetalleProductoPage.productNameTitlePage).getText();
    }

    /**
     * Hacer click en el botón Add to cart
     */
    public void addToCart(){
        this.driver.findElement(DetalleProductoPage.addToCartButton).click();
    }

    /**
     * Hacer click en el botón Carrito
     */
    public void carritoButton(){
        this.driver.findElement(DetalleProductoPage.carritoButton).click();
    }


}
