# 📌 Fundamentos

1. Cuando un cliente envía una petición, esta pasa por la "Filter Chain" de Spring Security (y otros filtros registrados en el servidor). Los filtros son responsables de manejar tareas como autenticación, autorización, logging, CORS, etc.   
 
2. Si la petición no cumple con las reglas establecidas en algún filtro (por ejemplo, el usuario no está autenticado o no tiene permiso), se detiene el procesamiento y se devuelve una respuesta de error.   

3. Si la petición pasa por todos los filtros con éxito, es enviada al controlador correspondiente.   

4. El controlador procesa la lógica de negocio relacionada con la solicitud y genera una respuesta.

5. La respuesta generada por el controlador pasa nuevamente por la cadena de filtros en el camino de vuelta al cliente. Esto es importante porque algunos filtros pueden modificar o inspeccionar la respuesta antes de enviarla al cliente.

## 🔸 FilterChain.
La "Filter Chain" (cadena de filtros) en Spring Boot es un mecanismo general que permite interceptar y procesar solicitudes y respuestas HTTP antes de que lleguen al controlador o sean enviadas al cliente. 
   
![imagen](https://github.com/user-attachments/assets/5e10afbd-1777-40f0-adc1-c50d73914758)

## 🔸 Authentication Filter,
El `Authentication Filter` es el filtro que introduce el modulo de Spring Security al estar activo en el servidor. Este filtro **se dedicará a interceptar las peticiones HTTP relacionadas a la autenticación.** De estas peticiones extraerá los credenciales de autenticación, recogerá estos valores y creará un **objeto de autenticación** a partir de ellos.
    
![imagen](https://github.com/user-attachments/assets/506a1ffa-866c-4110-bde7-5bed43ec879e)
    
>[!IMPORTANT]
>**El objeto de autenticación que se genera mediante el Authentication Filter es potencialmente incompleto.** Este objeto solo llevará los datos necesarios para el intento de inicio de sesión. En caso de que el objeto completo contenga otros detalles como roles, tipos de usuario, etc no estarán presentes en el momento de su creación.
     
## 🔸 Authentication Manager.
El `Authentication Manager` recibe el `Authentication Object` y se encarga de referir el objeto de autenticación al `proveedor de autenticación` configurado en la aplicación.
- Es como si el manager decide quien debe de realizar la operación basandose en los ficheros de configuración.
     
![imagen](https://github.com/user-attachments/assets/6787f41b-ed58-456c-b16b-1ddf30b21b2d)
    
## 🔸 Authentication Provider.
El `Authentication Provider` es el componente **responsable de comprobar si los credenciales de autenticación son correctos o no**. Para que un proveedor de autenticación pueda hacer su trabajo necesita dos elementos.
1. `PasswordEncoder` - Codificador de contraseñas para comparar con claves almacenadas en BBDD.
2. `UserDetailService` - Servicio de detalles de usuario.
    
![imagen](https://github.com/user-attachments/assets/d3e08bc1-f127-439f-bb9f-aef5a877c812)

    
## 🔸 PasswordEncoder.
El `Password Encoder` es una herramienta de apoyo para el `Authentication Provider` que permite codificar la contraseña recibida en texto plano para poder compararla con la contraseña almacenada en BBDD. Esto se hace porque las contraseñas se almacenan cifradas
en BBDD, nunca en texto plano, ya que esto supondría un enorme fallo de seguridad.
    
![imagen](https://github.com/user-attachments/assets/29983778-ddbd-413c-8746-80b3a99188a5)

## 🔸 UserDetailService.
Este componente es invocado por el AuthenticationProvider para completar el objeto de autenticación. Recoge de un origen de datos todos las propiedades que conforman el objeto del usuario que se autentica. Este objeto recupera todos los datos del usuario y lo convierte en un `UserDetailObject` para asi retornarlo. 
    
![imagen](https://github.com/user-attachments/assets/55e46bde-0ce3-46dc-8467-6269a3187e4c)


    
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
