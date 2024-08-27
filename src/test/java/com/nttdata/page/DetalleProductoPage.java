package com.nttdata.page;

import org.openqa.selenium.By;

public class DetalleProductoPage {

    // Aqui obtengo los elementos de la página

    public static By productNameTitlePage = By.cssSelector("[data-test='inventory-item-name']");

    public static By addToCartButton = By.id("add-to-cart");

    public static By carritoButton = By.cssSelector("a[data-test='shopping-cart-link']");

}
