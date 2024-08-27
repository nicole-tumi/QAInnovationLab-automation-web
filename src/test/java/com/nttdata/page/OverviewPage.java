package com.nttdata.page;

import org.openqa.selenium.By;

public class OverviewPage {

    // Aqui obtengo los elementos de la página
    public static By productNameOverview = By.cssSelector(".inventory_item_name[data-test='inventory-item-name']");

    public static By finishButton = By.id("finish");

}
