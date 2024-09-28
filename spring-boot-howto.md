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


## 🔹 Explicación base.
`@RestController` 
<img align="right" height="200" src="https://github.com/user-attachments/assets/a2c0b328-f409-4f0b-ba36-074f5ef600e3"><img>  
Declara la clase como un controlador en Spring que maneja solicitudes HTTP, combinando la funcionalidad de `@Controller` y `@ResponseBody`. Esto significa que los métodos dentro de la clase devolverán directamente datos en lugar de una vista.  
   
Al combinarlo con la anotación `@RequestMapping("/v1")`, se define una **URL base** para todas las rutas dentro de esta clase. Es decir, todas las rutas adicionales definidas en esta clase tendrán este prefijo en la URL.   
Por ejemplo, si dentro de la clase defines una ruta `@GetMapping("/items")`, la URL completa sería `/v1/items`.

`@RequestMapping("/test")`
Esta anotación define que el método que sigue se va a invocar cuando se realice una solicitud a la URL o endpoint '/test'.   
`@RequestMapping` se utiliza para mapear rutas específicas a los métodos de un controlador. En este caso, cualquier solicitud HTTP que vaya a /test será manejada por el método que viene a continuación.

## 🔹 Mapear peticiones especificas.
Es posible mapear peticiones especificas y responder de manera distintas segun cuales estas sean.   
   
Ejemplo:   
Esta petición responde solo a peticiones de tipo GET.   
En la anotación `@RequestMapping` incluimos la definición de la url a la que responde y el tipo de petición.   
```java
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String helloG()
	{
		return "<h1>Holla!</h1>";
	}
```

Pero tambien podemos hacer uso de derivacods de @RequesMapping y mapear directamente el verbo objetivo.
Las anotaciones son:
- @PostMapping
- @GetMapping
- @PutMapping
- @DeleteMapping

En ellas debemos especificar si atienden a una url concreta distinta a la raiz.
![imagen](https://github.com/user-attachments/assets/c9e7d0cf-921c-4653-9991-34376c5d5114)

# 📌 Creando objetos mediante peticiones POST.
Para configurar la creación de objetos mediante peticiones debemos seguir el siguiente flujo de trabajo.
1. Definir el objeto.
	Es posible que el objeto esté basado en un elemento de base de datos, de ser el caso construiriamos el objeto teniendo esto en cuenta.
2. Definir una accion de @PostMapping en el controlador.
	
3. Probar el post request con un json de prueba.
4. Mapear el JSON al objeto.
5. Configurar la respuesta.



















   
