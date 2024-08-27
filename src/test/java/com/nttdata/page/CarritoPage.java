package com.nttdata.page;

import org.openqa.selenium.By;

public class CarritoPage {

    // Aqui obtengo los elementos de la página
    public static By productName = By.cssSelector(".inventory_item_name[data-test='inventory-item-name']");
    public static By checkoutButton = By.id("checkout");

}
