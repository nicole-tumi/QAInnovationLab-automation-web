package com.nttdata.steps;

import org.openqa.selenium.WebDriver;
import com.nttdata.page.OverviewPage;

public class OverviewPageSteps {

    private WebDriver driver;

    //constructor
    public OverviewPageSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Obtener el nombre del producto en la pagina overview
     * @return el valor del nombre del producto en la pagina overview
     */
    public String getNombreProductoOverview(){
        return this.driver.findElement(OverviewPage.productNameOverview).getText();
    }

    /**
     * Hacer click en el botón finish en la vista overview
     */
    public void clickFinishButton(){
        this.driver.findElement(OverviewPage.finishButton).click();
    }
}
