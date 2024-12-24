# 📌 Fundamentos

1. Cuando un cliente envía una petición, esta pasa por la "Filter Chain" de Spring Security (y otros filtros registrados en el servidor). Los filtros son responsables de manejar tareas como autenticación, autorización, logging, CORS, etc.   
 
2. Si la petición no cumple con las reglas establecidas en algún filtro (por ejemplo, el usuario no está autenticado o no tiene permiso), se detiene el procesamiento y se devuelve una respuesta de error.   

3. Si la petición pasa por todos los filtros con éxito, es enviada al controlador correspondiente.   

4. El controlador procesa la lógica de negocio relacionada con la solicitud y genera una respuesta.

5. La respuesta generada por el controlador pasa nuevamente por la cadena de filtros en el camino de vuelta al cliente. Esto es importante porque algunos filtros pueden modificar o inspeccionar la respuesta antes de enviarla al cliente.

## 🔸 FilterChain.
La "Filter Chain" (cadena de filtros) en Spring Boot es un mecanismo general que permite interceptar y procesar solicitudes y respuestas HTTP antes de que lleguen al controlador o sean enviadas al cliente. 
   
![imagen](https://github.com/user-attachments/assets/5e10afbd-1777-40f0-adc1-c50d73914758)

## 🔸 Authentication Filter
El `Authentication Filter` es el filtro que introduce el modulo de Spring Security al estar activo en el servidor. Este filtro **se dedicará a interceptar las peticiones HTTP relacionadas a la autenticación.** De estas peticiones extraerá los credenciales de autenticación, recogerá estos valores y creará un **objeto de autenticación** a partir de ellos.

![imagen](https://github.com/user-attachments/assets/506a1ffa-866c-4110-bde7-5bed43ec879e)



## 🔸 Session ID
El **Session ID** es un identificador único generado por el servidor para asociar una sesión del cliente con un conjunto de datos almacenados en el servidor. Este identificador es crucial en aplicaciones web donde se requiere mantener el estado entre el cliente y el servidor.    
#### ¿Para que sirve?
El Session ID en Spring Security sirve para identificar de manera única la sesión de un usuario en el servidor, permitiendo mantener su estado (como autenticación y datos asociados) entre múltiples solicitudes durante su interacción con la aplicación.
   
**Lo más importante sobre el Session ID en Spring Security:**
- Identificador único: Asocia una sesión del cliente con datos en el servidor.
- Autenticación: Permite mantener el estado de autenticación entre solicitudes.
- Uso principal: Facilita la experiencia de usuario al no requerir múltiples autenticaciones dentro de una sesión.
- Mejores prácticas: Cookies deben configurarse con HttpOnly, Secure, y SameSite para mayor seguridad.

>[!NOTE]
>El session ID no contiene datos del usuario, solo ayuda a no tener que re-autenticarse para cada petición enviada al servidor.

# 📌 Cambiar de contraseña en el `application.yaml`.
Podemos especificar un usuario y una contraseña para spring security desde el fichero de configuración application.yaml. Para ello introducimos estos parametros.
```yaml
spring:
  security:
    user:
      name: nombre
      password: contraseña
```

# 📌 Fundamentos

# 📌 Fundamentos

# 📌 Autenticación en Postman.
Para autenticarse en postman y poder acceder a los servicios y realizar pruebas seguimos estos pasos.
1. Pinchamos en `Authorization`
2. Abrimos el combobox.
3. Seleccionamos `Basic Auth`
4. Introducimos credenciales.

![imagen](https://github.com/user-attachments/assets/0d7d901d-7657-41c8-9b55-72fef549f781)
