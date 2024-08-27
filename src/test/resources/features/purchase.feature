#language: es
@testfeature
Característica: Purchase
  Yo, como usuario
  Quiero, tener una opción para comprar un producto

  @test
  Escenario: Comprar producto
    Dado que me encuentro en la página de productos
    Cuando selecciono un producto
    Y verifico que el titulo de la vista de la pagina de detalle del producto sea "Sauce Labs Backpack"
    Y selecciono el boton Add to cart para añadirlo al carrito de compras
    Y reviso el carrito de compras y debe figurar el nombre del producto como "Sauce Labs Backpack"
    Y selecciono el boton Checkout
    Y completo los datos de identificación con nombre: "Nicole" con apellido "Tumi" y con codigo postal "04001"
    Y selecciono el boton Continue
    Y valido que el nombre del producto sea "Sauce Labs Backpack"
    Y selecciono el boton Finish para finalizar la compra
    Entonces valido que debería aparecer el mensaje de confirmacion de compra "Thank you for your order!"