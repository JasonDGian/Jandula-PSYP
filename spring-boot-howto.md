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

--- 
TODO - POR TERMINAR.
# 📌 Creando objetos mediante peticiones POST.
Para configurar la creación de objetos mediante peticiones debemos seguir el siguiente flujo de trabajo.
1. Definir el objeto.
2. Crear un controlador
3. Definir una accion de @PostMapping en el controlador.
4. Probar el post request con un json de prueba.
5. Mapear el JSON al objeto.
6. Configurar la respuesta.



## 🔹 1. Definir el objeto.
El primer paso es definir una clase que representará el objeto que deseas crear. Si la petición POST contiene datos que se deben mapear a un objeto en tu aplicación, debes crear un Data Transfer Object (DTO) o una entidad, dependiendo de si este objeto va a persistir o no.

## 🔹 2. Crear un Controlador
Luego de crear un objeto, debes definir un controlador en Spring Boot que maneje las peticiones HTTP POST y reciba el objeto a través del cuerpo de la solicitud (request body).
```java
@PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {
        // Aquí podrías guardar el objeto en una base de datos o procesarlo
        System.out.println("Persona recibida: " + persona.getNombre() + ", " + persona.getEdad());

        // Retornamos la persona creada (podría ser útil en algunos casos)
        return persona;
    }
```
TODO - POR TERMINAR.   
    
---   


# 📌 Obtener datos de una petición.
En Spring Boot, podemos extraer datos de una petición HTTP de varias formas utilizando anotaciones específicas.

## 🔹 Obtener datos desde el body.
Para obtener datos desde el body lo hacemos mediante la anotación - **`@RequestBody`**.    
Este es útil cuando la petición está formateada en XML o en JSON.    

### ▫️ Mapeado a objeto.
Al recibir cuerpos en formato JSON o XML, podemos mapearlos directamente a objetos Java. En este ejemplo, un objeto JSON se convierte automáticamente en una instancia de la clase `Jugador`.
```java
@PostMapping(value = "/player")
public String addNewPlayer( @RequestBody Jugador jugador) {
	// Logica de uso del objeto: Aqui podemos interactuar con los valores
	// del objeto JSON que han sido instanciados en un objeto JAVA.
	return "Objeto creado \n" + jugador.toString();
}
```

### ▫️ Uso de valores de un JSON dinamico.
Si no conocemos la estructura exacta del JSON, podemos usar un Map<String, Object> para mapear datos dinámicos. En este caso, Spring Boot convertirá el JSON en un mapa, donde las claves del JSON serán las claves del mapa y sus valores correspondientes los valores del JSON.
```java
@PostMapping("/player")
public String addPlayer(@RequestBody Map<String, Object> playerData) {
    return "Datos recibidos: " + playerData;
}
```

### ▫️ Uso de valores brutos de un JSON (Formato String).
Podemos obtener el contenido del body como una cadena String, lo que es útil cuando queremos procesar el contenido en bruto.
```java
@PostMapping("/raw")
public String rawBody(@RequestBody String rawBody) {
    return "Cuerpo sin procesar: " + rawBody;
}
```

---
## 🔹 Obtener datos desde el header.
Para obtener datos desde el header lo hacemos mediante la anotación - **`@RequestBody`**
```java
// Metodo de petición POST que espera un cuerpo.
@PostMapping
public int resta( @RequestHeader( value = "a" ) int a, @RequestHeader( value = "b") int b) 
{
	return a - b;
}
```

---
## 🔹 Obtener datos desde parametros.
Para obtener datos desde los parametros de petición lo hacemos mediante la anotación - **`@RequestParam`**
```java
// Metodo de petición GET que espera dos parametros por query.
@GetMapping
public int resta( @RequestParam( value = "a" ) int a, @RequestParam( value = "b") int b) 
{
	return a - b;
}
```
---
## 🔹 Obtener datos desde el path.
Para obtener datos desde el path lo hacemos mediante la anotación - **`@PathVariable`**
```java
// Método de petición POST que espera dos parámetros en la URL como path variables.
@PostMapping("/resta/{a}/{b}")
public int resta(@PathVariable int a, @PathVariable int b) {
    return a - b;
}
```

--
## 🔹 Obtener valores desde variable en YAML.
1. Definir el valor en el fichero yaml.
	```yaml
	urlCors: http://localhost:8888/incidencias  		
	``` 
2. Importar el valor en la clase donde deseamos usarla
	```java
	package es.iesjandula.ReaktorIssuesServer.security;
	
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.web.servlet.config.annotation.CorsRegistry;
	import org.springframework.web.servlet.config.annotation.EnableWebMvc;
	import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
	
	/**
	 * Configuración CORS para la aplicación.
	 * <p>
	 * Esta clase define una configuración personalizada para los mapeos de CORS (Cross-Origin Resource Sharing).
	 * Utiliza un bean para habilitar y configurar el acceso desde diferentes orígenes al endpoint "/incidencias".
	 * <p>
	 * El propósito de esta configuración es permitir que clientes desde diferentes dominios puedan realizar
	 * solicitudes HTTP al servicio de incidencias.
	 * </p>
	 */
	@Configuration
	@EnableWebMvc // Anotación que sirve para 
	public class CorsConfiguration implements WebMvcConfigurer
	{

	/**
	 * Define a que URL atiende de manera abierta la API mediante tecnicas CORS.
	 */
	@Value("${urlCors}")
	private String urlCors; // Actualmente solo una string porque la variable urlcors solo contiene una url.
	
	// Configuración del mapeado de CORS
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping(urlCors)
	            .allowedMethods("PUT", "DELETE", "POST", "GET");
	    }
	
	}

 	```




   
