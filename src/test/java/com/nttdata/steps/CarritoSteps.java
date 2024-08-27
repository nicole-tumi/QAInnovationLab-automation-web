package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import org.openqa.selenium.WebDriver;

public class CarritoSteps {

    private WebDriver driver;

    //constructor
    public CarritoSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Obtener el nombre del producto agregado al carrito de compras
     * @return el valor del nombre del producto agregado al carrito de compras
     */
    public String getNombreProductoAgregado(){
        return this.driver.findElement(CarritoPage.productName).getText();
    }

    /**
     * Hacer click en el botón checkout en el carrito de compras
     */
    public void clickCheckoutButton(){
        this.driver.findElement(CarritoPage.checkoutButton).click();
    }

}
