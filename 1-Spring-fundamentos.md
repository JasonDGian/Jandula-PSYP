# 📌 Fundamentos de Spring.
Spring Boot utiliza una arquitectura de tres capas, donde se diferencian los controladores REST, la capa de acceso a datos y la lógica de negocio. En cada capa existen responsabilidades claramente definidas para asegurar una separación adecuada de preocupaciones.

## 🔹 Arquitectura en 3 capas.
La arquitectura de 3 capas en Spring Boot es un patrón de diseño que separa el código según su responsabilidad. Las clases se organizan por su función dentro de la aplicación, facilitando el mantenimiento y la claridad del sistema.
   
<p align="center">
  <img width="200px" align="right" src="https://github.com/user-attachments/assets/cacf5340-8afd-4e13-add6-399acc3ae98f">    
</p>
   
<table>
  <tr><td>🟤 <strong>PRESENTACIÓN</strong>. </td></tr>
  <tr><td> - Aiende a las peticiones HTTP y responde a ellas. </br>
    - Recibe los datos y los pasa a la caba de servicio. </br>
    - Devuelve vistas en formato HTML o datos en formato JSON.
</td></tr>
  <tr><td>🔵 <strong>SERVICIO.</strong></tr>
  <tr><td>- Contiene la lógica de negocio.</br>
  - Procesa la información recibida de la capa de presentación.</br>
  - Realiza las validaciones calculos y aplica las reglas de negocio.
</td></tr>
  <tr><td>🟣 <strong>ACCESO A DATOS.</strong></td></tr>
  <tr><td>- Maneja la interacción con la base de datos.</br>
    - Realiza las operaciones CRUD a través de consultas y transacciones.</br>
    - Encapsula el acceso a los datos, proporcionando una abstracción a la capa de servicio.
</td></tr>
  </tr>
  <tr><td>🟡 <strong>CAPA DE CONFIGURACION - Capa adicional.</strong></td></tr>
  <tr><td>- Clases genéricas que no encajan específicamente en otras capas, pero que son gestionadas por el contenedor de Spring.</br>
    - Pueden incluir componentes reutilizables, servicios auxiliares o configuraciones personalizadas.
</td></tr>
</table>



## 🔹 Inicialización de proyectos.
Para inicializar proyectos utilizamos **Spring Initializr** en www.start.spring.io. Esta herramienta facilita la configuración de las dependencias necesarias sin necesidad de editar manualmente el archivo POM en proyectos Maven. Además, si no tenemos Maven instalado, podemos usar spring.io para agregarlo como un ejecutable en la raíz del proyecto automaticamente.


## 🔹 Funcionamiento base.
En el núcleo del funcionamiento de Spring como framework se encuentran las anotaciones y el principio de inversión de control. El programador delega al framework la responsabilidad de instanciar y configurar determinadas clases y objetos, lo que le permite evitar la escritura de grandes cantidades de código repetitivo, conocido como "boilerplate code". Las anotaciones utilizadas en Spring se denominan Estereotipos de Spring, y cada una de ellas cumple una función específica dentro de su ecosistema.

## 🔹 Estereotipos de Spring.
Los estereotipos en Spring son anotaciones que identifican y asignan comportamientos específicos a las clases Java dentro del framework. Estas anotaciones permiten al framework reconocer el rol de una clase en la aplicación y aplicar las configuraciones o comportamientos adecuados automáticamente, como la gestión de dependencias o el manejo de transacciones.

### @Repository.
Indica una interfaz que normalmente trabajará a nivel de base de datos con el patron repositorio.
  
### @Service.
Sirve para agrupar logica de negocio.

### @Controller
Sirve para indicar que la clase recibe peticiones HTTP.
Este tipo de anotacion sirve para indicar la redireccion hacia plantillas html programadas con motores de plantillas.

### @RestController.
Sirve para indicar que la clase recibe peticiones HTTP pero funcionará a nivel de REST.

### @Component. 
Es un tipo generico, una clase que queremos que gestione spring sin especificar su pertenencnia a ningun otro tipo de componente.

# Inyeccion de beans.
La inyeccion de beans se puede hacer de tres maneras.
1. A nivel de Campo.
2. A nivel de Constructor.
3. A nivel de Metodo Setter

Metodo @AutoWired.


- Spring web: Starter para aplicaciones web como por ejemplo APIs REST o una aplicacion MVC con plantillas (necesitaria motor de plantillas como Thymeleaf).
- MySQL Driver: Proporciona tecnicas de conexion y manipulacion para bases de datos MYSQL.
- Spring jpa: Es el framework que facilita la interaccion con la base de datos evitando asi tener que escribir MySQL a pelo.

![imagen](https://github.com/user-attachments/assets/9240861d-7ccc-45ee-a064-f0ae823f01a4)

