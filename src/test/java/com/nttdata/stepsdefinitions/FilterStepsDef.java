package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class FilterStepsDef {

    private WebDriver driver;

    /*private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }*/

    @Dado("que estoy en la página de productos")
    public void queEstoyEnLaPaginaDeProductos() {
        driver = getDriver();
        driver.get("https://www.saucedemo.com/");
        LoginSteps purchaseSteps = new LoginSteps(driver);
        purchaseSteps.typeUser("standard_user");
        purchaseSteps.typePassword("secret_sauce");
        purchaseSteps.login();
        screenShot();
    }

    @Cuando("selecciono el filtro de productos y selecciono la opcion de mayor a menor")
    public void seleccionoElFiltroDeProductosYSeleccionoLaOpcionDeMayorAMenor() {
        InventorySteps inventorySteps = new InventorySteps(driver);
        inventorySteps.clickFilter();
        screenShot();
        inventorySteps.clickOptionHighToLow();
    }


    @Entonces("valido que debería aparecer en la primera card el producto con mayor valor")
    public void validoQueDeberiaAparecerEnLaPrimeraCardElProductoConMayorValor() {
        InventorySteps inventorySteps = new InventorySteps(driver);
        List<WebElement> prices = inventorySteps.getProductsPrices();

        double firstPrice = 0;

        if (!prices.isEmpty()) {
            // Obtener el primer elemento de la lista
            WebElement firstPriceElement = prices.get(0);

            // Extrae el texto del primer elemento y lo convierte a un valor numérico
            String firstPriceText = firstPriceElement.getText().replace("$", "");
            firstPrice = Double.parseDouble(firstPriceText);

        } else {
            System.out.println("La lista de precios está vacía.");
        }

        double minPrice = Double.MAX_VALUE;
        double maxPrice = Double.MIN_VALUE;

        for (WebElement priceElement : prices) {
            // Extrae el texto y remueve el símbolo de dólar
            String priceText = priceElement.getText().replace("$", "");
            double price = Double.parseDouble(priceText);

            // Actualiza el mínimo y máximo
            if (price < minPrice) {
                minPrice = price;
            }
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        Assertions.assertEquals(maxPrice, firstPrice);
        screenShot();
    }

    @Y("valido que el ultimo producto debe tener el menor valor")
    public void validoQueElUltimoProductoDebeTenerElMenorValor() {
        InventorySteps inventorySteps = new InventorySteps(driver);

        inventorySteps.scrollDown();

        List<WebElement> prices = inventorySteps.getProductsPrices();

        double lastPrice = 0;

        if (!prices.isEmpty()) {
            // Obtener el ultimo elemento de la lista
            WebElement lastPriceElement = prices.get(prices.size() - 1);

            // Extrae el texto del primer elemento y lo convierte a un valor numérico
            String lastPriceText = lastPriceElement.getText().replace("$", "");
            lastPrice = Double.parseDouble(lastPriceText);

        } else {
            System.out.println("La lista de precios está vacía.");
        }

        double minPrice = Double.MAX_VALUE;
        double maxPrice = Double.MIN_VALUE;

        for (WebElement priceElement : prices) {
            // Extrae el texto y remueve el símbolo de dólar
            String priceText = priceElement.getText().replace("$", "");
            double price = Double.parseDouble(priceText);

            // Actualiza el mínimo y máximo
            if (price < minPrice) {
                minPrice = price;
            }
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        Assertions.assertEquals(minPrice, lastPrice);
        screenShot();
    }
}

