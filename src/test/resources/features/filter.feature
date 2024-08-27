#language: es
@testfeature
Característica: Filter
  Yo, como usuario
  Quiero, tener una opción para filtrar los productos de mayor a menor

  @test
  Escenario: Filtrar los productos de mayor a menor
    Dado que estoy en la página de productos
    Cuando selecciono el filtro de productos y selecciono la opcion de mayor a menor
    Entonces valido que debería aparecer en la primera card el producto con mayor valor
    Y valido que el ultimo producto debe tener el menor valor