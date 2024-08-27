package com.nttdata.page;

import org.openqa.selenium.By;

public class PurchaseCompletePage {

    // Aqui obtengo los elementos de la página
    public static By orderCompleteMessage = By.cssSelector("[data-test='complete-header']");
    public static By backHomeButton = By.id("back-to-products");
}
