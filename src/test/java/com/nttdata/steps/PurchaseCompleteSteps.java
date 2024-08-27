package com.nttdata.steps;

import org.openqa.selenium.WebDriver;
import com.nttdata.page.PurchaseCompletePage;

public class PurchaseCompleteSteps {

    private WebDriver driver;

    //constructor
    public PurchaseCompleteSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Obtener el mensaje de exito de compra
     * @return el valor del mensaje de exito de compra
     */
    public String getOrderCompleteMessage(){
        return this.driver.findElement(PurchaseCompletePage.orderCompleteMessage).getText();
    }

}
