# 📌 Directorios de Thymeleaf.
En Thymeleaf vamos a trabajar con dos directorios principalmente. `Static` y `Templates`.

## 🔸 Directorio Static.
El directorio static se utiliza para almacenar archivos estáticos que la aplicación servirá directamente al cliente. Estos archivos no se procesan por el servidor, sino que **se envían tal cual al navegador del usuario**. Esto incluye:

- **Archivos CSS:** Hojas de estilo para dar formato y diseño a las páginas web.
- **Archivos JavaScript:** Scripts para añadir funcionalidad interactiva a las páginas web.
- **Imágenes**: Archivos gráficos, como logotipos, fotos, etc.
- **Fuentes y otros recursos estáticos:** Cualquier otro recurso que deba ser accesible directamente sin necesidad de procesamiento.

**Ejemplo de uso:**  
Si colocas un archivo CSS llamado styles.css en src/main/resources/static/css, se podrá acceder a él directamente en el navegador con la URL http://localhost:8080/css/styles.css.

Para que Thymeleaf pueda servir las vistas y plantillas HTML, debemos crear el directorio en el que Spring Boot buscará los estos recursos.
El directorio en cuestion es `proyecto/src/main/resources/static` y este contendrá las plantillas HTML que deseamos servir.

## 🔸 Directorio Templates.
El directorio templates se utiliza para almacenar las plantillas Thymeleaf, que son archivos HTML que serán procesados por el servidor antes de ser enviados al cliente. Estas plantillas pueden contener código Thymeleaf que será evaluado y reemplazado por datos dinámicos en el lado del servidor.
- **Plantillas Thymeleaf:** Archivos HTML que incluyen directivas Thymeleaf para renderizar datos dinámicos desde el servidor.
- **Vistas dinámicas:** HTML que puede incluir fragmentos reutilizables y componentes que son evaluados en el servidor.

**Ejemplo de uso:** Si tienes un archivo `index.html` en `src/main/resources/templates`, y tu controlador Spring Boot lo referencia mediante `return "index"`, Thymeleaf procesará la plantilla `index.html` y generará la página HTML final que se enviará al navegador del usuario.
