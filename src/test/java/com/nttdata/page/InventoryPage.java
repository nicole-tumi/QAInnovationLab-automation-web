package com.nttdata.page;

import org.openqa.selenium.By;

public class InventoryPage {

    // Aqui obtengo los elementos de la página

    public static By productsTitle = By.cssSelector("span.title");
    public static By itemsCards = By.cssSelector("div.inventory_item");

    public static By productCardTitle = By.id("item_4_title_link");

    //Combobox - filtro de productos
    public static By optionDropdownFilter = By.cssSelector(".product_sort_container");

    //Obtener la opcion de filtro de mayor a menor
    public static By optionHighToLow = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]");

    //Obtener la seccion del precio
    public static By productsPriceArray = By.cssSelector(".inventory_item_price");

}
