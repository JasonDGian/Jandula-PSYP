# 📌 REST CONTROLLER.
Un controlador o manejador de peticiones HTTP de springboot tiene la siguiente estructura.

```java
package com._dam.ejercicio_pag29.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller
{
	@RequestMapping("/test")
	public String helloG()
	{
		return "<h1>Holla!</h1>";
	}
	
}
```

![imagen](https://github.com/user-attachments/assets/236117d1-19e6-43f4-88d8-cfa87ee1e1c7)


## Explicación.
`@RestController`   
declara la clase como un controlador en Spring que maneja solicitudes HTTP, combinando la funcionalidad de @Controller y @ResponseBody. Esto significa que los métodos dentro de la clase devolverán directamente datos en lugar de una vista.  

Al combinarlo con la anotación `@RequestMapping("/v1")`, se define una **URL base** para todas las rutas dentro de esta clase. Es decir, todas las rutas adicionales definidas en esta clase tendrán este prefijo en la URL.   
Por ejemplo, si dentro de la clase defines una ruta `@GetMapping("/items")`, la URL completa sería `/v1/items`.

`@RequestMapping("/test")`
Esta anotación define que el método que sigue se va a invocar cuando se realice una solicitud a la URL o endpoint '/test'.   
@RequestMapping se utiliza para mapear rutas específicas a los métodos de un controlador. En este caso, cualquier solicitud HTTP que vaya a /test será manejada por el método que viene a continuación.


