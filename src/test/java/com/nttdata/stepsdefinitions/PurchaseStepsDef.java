package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.DetalleProductoSteps;
import com.nttdata.steps.CarritoSteps;
import com.nttdata.steps.InformationCheckoutSteps;
import com.nttdata.steps.OverviewPageSteps;
import com.nttdata.steps.PurchaseCompleteSteps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class PurchaseStepsDef {

    private WebDriver driver;


    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }
    private DetalleProductoSteps detalleProductoSteps(WebDriver driver) {
        return new DetalleProductoSteps(driver);
    }
    private CarritoSteps carritoSteps(WebDriver driver) {
        return new CarritoSteps(driver);
    }
    private InformationCheckoutSteps informationCheckoutSteps(WebDriver driver) {
        return new InformationCheckoutSteps(driver);
    }
    private OverviewPageSteps overviewPageSteps(WebDriver driver) {
        return new OverviewPageSteps(driver);
    }

    @Dado("que me encuentro en la página de productos")
    public void queMeEncuentroEnLaPaginaDeProductos() {
        driver = getDriver();
        driver.get("https://www.saucedemo.com/");
        LoginSteps purchaseSteps = new LoginSteps(driver);
        purchaseSteps.typeUser("standard_user");
        purchaseSteps.typePassword("secret_sauce");
        purchaseSteps.login();
        screenShot();
    }

    @Cuando("selecciono un producto")
    public void seleccionoUnProducto() {
        inventorySteps(driver).seleccionarProductCardTitle();
    }

    @Y("verifico que el titulo de la vista de la pagina de detalle del producto sea {string}")
    public void verificoQueElTituloDeLaVistaDeLaPaginaDeDetalleDelProductoSea(String expectedProductTitlePage) {
        String productTitlePage =  detalleProductoSteps(driver).productNameTitlePage();
        //prueba: validamos el título de la pagina del producto
        Assertions.assertEquals(expectedProductTitlePage, productTitlePage);
        screenShot();

    }

    @Y("selecciono el boton Add to cart para añadirlo al carrito de compras")
    public void seleccionoElBotonAddToCartParaAnadirloAlCarritoDeCompras() {
        detalleProductoSteps(driver).addToCart();
    }

    @Y("reviso el carrito de compras y debe figurar el nombre del producto como {string}")
    public void revisoElCarritoDeComprasYDebeFigurarElNombreDelProductoComo(String expectedProductoAgregado) {
        detalleProductoSteps(driver).carritoButton();
        String productoAgregado =  new CarritoSteps(driver).getNombreProductoAgregado();
        //prueba: validamos el título del  en la página carrito
        Assertions.assertEquals(expectedProductoAgregado, productoAgregado);
        screenShot();
    }

    @Y("selecciono el boton Checkout")
    public void seleccionoElBotonCheckout() {
        carritoSteps(driver).clickCheckoutButton();
    }

    @Y("completo los datos de identificación con nombre: {string} con apellido {string} y con codigo postal {string}")
    public void completoLosDatosDeIdentificacionConNombreConApellidoYConCodigoPostal(String nombres, String apellidos, String codigoPostal) {
        informationCheckoutSteps(driver).completeName(nombres);
        informationCheckoutSteps(driver).completeLastname(apellidos);
        informationCheckoutSteps(driver).completePostalCode(codigoPostal);
        screenShot();
    }

    @Y("selecciono el boton Continue")
    public void seleccionoElBotonContinue() {
        informationCheckoutSteps(driver).clickContinueButton();
    }

    @Y("valido que el nombre del producto sea {string}")
    public void validoQueElNombreDelProductoSea(String expectedProductOverview) {
        String productoOverview =  new OverviewPageSteps(driver).getNombreProductoOverview();
        //prueba: validamos el título del producto en la página overview
        Assertions.assertEquals(expectedProductOverview, productoOverview);
        screenShot();
    }

    @Y("selecciono el boton Finish para finalizar la compra")
    public void seleccionoElBotonFinishParaFinalizarLaCompra() {
        overviewPageSteps(driver).clickFinishButton();
    }

    @Entonces("valido que debería aparecer el mensaje de confirmacion de compra {string}")
    public void validoQueDeberiaAparecerElMensajeDeConfirmacionDeCompra(String expectedOrderCompleteMessage) {
        String orderCompleteMessage =  new PurchaseCompleteSteps(driver).getOrderCompleteMessage();
        //prueba: validamos el mensaje de éxito de compra
        Assertions.assertEquals(expectedOrderCompleteMessage, orderCompleteMessage);
        screenShot();
    }
}
