package com.nttdata.page;

import org.openqa.selenium.By;

public class InventoryPage {

    // Aqui obtengo los elementos de la página

    public static By productsTitle = By.cssSelector("span.title");
    public static By itemsCards = By.cssSelector("div.inventory_item");

    public static By productCardTitle = By.id("item_4_title_link");
}
