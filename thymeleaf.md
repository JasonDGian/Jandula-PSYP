# 📌 Modelo Vista Controlador.
En el patrón MVC, el Controlador recibe las solicitudes del usuario, procesa la lógica necesaria, manipula el Modelo y envía el Modelo a la Vista. La Vista entonces utiliza los datos del Modelo para generar la representación final que se devuelve al cliente.
   
![imagen](https://github.com/user-attachments/assets/34925c2d-f520-431c-b3ae-37f27ff6f6f4)


# 📌 Directorios de Thymeleaf.
En Thymeleaf vamos a trabajar con dos directorios principalmente. `Static` y `Templates`.

## 🔸 Directorio Static.
El directorio static se utiliza para almacenar archivos estáticos que la aplicación servirá directamente al cliente. Estos archivos no se procesan por el servidor, sino que **se envían tal cual al navegador del usuario**. Esto incluye:

- **Archivos CSS:** Hojas de estilo para dar formato y diseño a las páginas web.
- **Archivos JavaScript:** Scripts para añadir funcionalidad interactiva a las páginas web.
- **Imágenes**: Archivos gráficos, como logotipos, fotos, etc.
- **Fuentes y otros recursos estáticos:** Cualquier otro recurso que deba ser accesible directamente sin necesidad de procesamiento.

**Ejemplo de uso:**  
Si colocas un archivo CSS llamado `styles.css` en `src/main/resources/static/css`, se podrá acceder a él directamente en el navegador con la URL http://localhost:8080/css/styles.css.

## 🔸 Directorio Templates.
El directorio templates se utiliza para almacenar las plantillas Thymeleaf, que son archivos HTML que serán procesados por el servidor antes de ser enviados al cliente. Estas plantillas pueden contener código Thymeleaf que será evaluado y reemplazado por datos dinámicos en el lado del servidor.
- **Plantillas Thymeleaf:** Archivos HTML que incluyen directivas Thymeleaf para renderizar datos dinámicos desde el servidor.
- **Vistas dinámicas:** HTML que puede incluir fragmentos reutilizables y componentes que son evaluados en el servidor.

**Ejemplo de uso:** Si tienes un archivo `index.html` en `src/main/resources/templates`, y tu controlador Spring Boot lo referencia mediante `return "index"`, Thymeleaf procesará la plantilla `index.html` y generará la página HTML final que se enviará al navegador del usuario.


# 📌 Enlazando plantillas.
Para enlazar plantillas de Thymeleaf unas con otras haremos uso del `href=""` de HTML pero en lugar de referenciar un fichero con extension `.html` enlazaremos a una llamada a un recurso o endpoint del controlador.    
**Ejemplo de llamada a otra plantilla**    
```html
<ul>
    <li><a href="/home">Home</a></li>
    <li><a href="/login">Login</a></li>
</ul>
```
>[!NOTE]
>Nota como en lugar de enlazar a `/home.html` enlazamos directamente a `/home` y como es el servidor el encargador de servir la página tras la llamada. 

# 📌 Clase Model.
Así que, en resumen, el modelo en el patrón MVC juega un papel crucial al encapsular y manejar los datos y la lógica de negocio, permitiendo que esos datos sean utilizados por la vista para su presentación al usuario.

**Controllador** 
   
![imagen](https://github.com/user-attachments/assets/98944692-448b-4185-8d2a-651c347976a7)
   
**Vista** 
   
![imagen](https://github.com/user-attachments/assets/9fbe0fdf-2b85-4fb5-ba03-5fb262b6cf19)



# 📌 Manejo de elementos en plantillas.

## 📍 Introducir un fragmento html en otras paginas.
Es posible introducir un fragmento en todas las paginas que lo necesiten, para ello usamos la siguiente sintaxis.

**Definición el fragmento:**
```html
<div th:fragments="navbar">
 <!-- CONTENIDO DEL FRAGMENTO -->
</div>
```







