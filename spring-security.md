# 📌 Fundamentos

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
