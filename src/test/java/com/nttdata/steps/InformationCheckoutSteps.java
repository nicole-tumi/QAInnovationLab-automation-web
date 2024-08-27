package com.nttdata.steps;

import com.nttdata.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InformationCheckoutSteps {

    private WebDriver driver;

    //constructor
    public InformationCheckoutSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el nombre del comprador
     * @param nombre del usuario
     */
    public void completeName(String nombre){
        WebElement userInputElement = driver.findElement(InformationCheckoutPage.nameInput);
        userInputElement.sendKeys(nombre);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(InformationCheckoutPage.continueButton));
    }

    /**
     * Escribir el apellido del comprador
     * @param apellido del usuario
     */
    public void completeLastname(String apellido){
        WebElement userInputElement = driver.findElement(InformationCheckoutPage.lastnameInput);
        userInputElement.sendKeys(apellido);
    }

    /**
     * Escribir el apellido del comprador
     * @param postalCode del usuario
     */
    public void completePostalCode(String postalCode){
        WebElement userInputElement = driver.findElement(InformationCheckoutPage.postalInput);
        userInputElement.sendKeys(postalCode);
    }

    /**
     * Hacer click en el botón continue
     */
    public void clickContinueButton(){
        this.driver.findElement(InformationCheckoutPage.continueButton).click();
    }
}
