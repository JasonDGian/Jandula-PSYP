# 📌 Spring.
Spring es un framework centrado en crear aplicaciones de calibre comercial con Java.  Esto significa que con este framework podemos evitar muchisimo "boilerplate code" que ya no es necesario escribir a mano.
**Spring ofrece además técnicas IOC (Inversion of Control) y posibilita el uso de Transacciones**, ademas de ofrecer una amplia gama de componentes que cubren y ofrecen un amplio rango de funcionalidadess.
   
https://spring.io/   

## 🔹 Arquitectura de 3 capas.
La arquitectura de 3 capas en Spring es un patrón de diseño que separa el código según su responsabilidad. Las clases se organizan por su función dentro de la aplicación, facilitando el mantenimiento y la claridad del sistema.

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

## 🔹 Funcionamiento básico de Spring
En el núcleo del funcionamiento de Spring como framework se encuentran las anotaciones y el principio de inversión de control.   
El programador delega a Spring la responsabilidad de instanciar y configurar determinadas clases y objetos, esto le libera de la escritura de grandes cantidades de código repetitivo. Las anotaciones utilizadas en Spring se denominan **Estereotipos de Spring**, y cada una de ellas cumple una función específica dentro de su ecosistema.

## 🔹 Inicialización de proyectos.
Para inicializar proyectos utilizamos **Spring Initializr** en www.start.spring.io. Esta herramienta facilita la configuración de las dependencias necesarias sin necesidad de editar manualmente el archivo POM en proyectos Maven. Además, si no tenemos Maven instalado, podemos usar spring.io para agregarlo como un ejecutable en la raíz del proyecto automaticamente.


# 📌 Sub-marcos y componentes de Spring.
Una de las cosas que hace de Spring una autentica maravilla son las capas y marcos de trabajo adicionales que proporciona al programador.   
Entre ellas podemos mencionar las siguientes:   
1. **Spring Web**: Starter para aplicaciones web como por ejemplo APIs REST o una aplicación MVC con plantillas (necesita motor de plantillas como Thymeleaf).
2. **Spring Data JPA**: Facilita trabajar con bases de datos, haciendo que sea más fácil guardar y leer datos.
3. **Spring Security**: Protege las aplicaciones, controlando quién puede acceder y qué pueden hacer.
4. **Spring MVC**: Organiza el código para manejar solicitudes web y mostrar páginas.
5. **Spring Session**: Gestiona las sesiones de usuarios, manteniéndolas activas aunque cambien de servidor.
6. **MySQL Driver**: Proporciona tecnicas de conexion y manipulacion para bases de datos MYSQL.

## 🔹 Spring Boot
Es un marco de trabajo que facilita la creación de aplicaciones Java, especialmente aplicaciones web. Spring Boot te permite empezar rápidamente con configuraciones mínimas, ya que proporciona configuraciones predeterminadas, sin tener que escribir mucho código o configuraciones adicionales.

## 🔹 Spring Data JPA
Es una herramienta dentro del ecosistema de Spring que simplifica la interacción con bases de datos. Usa JPA (Java Persistence API) para hacer que trabajar con bases de datos relacionales sea más fácil, permitiendo realizar consultas y operaciones en tablas de manera sencilla, con poco código.

## 🔹 Spring Security
Es un módulo que se encarga de la seguridad en aplicaciones Spring. Ayuda a proteger tu aplicación controlando el acceso a las rutas, gestionando la autenticación de usuarios (por ejemplo, inicio de sesión) y asegurando que los datos estén protegidos.

## 🔹 Spring MVC
Es un modelo que sigue el patrón de arquitectura "Modelo-Vista-Controlador" para crear aplicaciones web. Te permite manejar las solicitudes HTTP, procesar datos en el servidor y devolver respuestas, normalmente en forma de páginas web.

## 🔹 Spring Session
Es un módulo que gestiona las sesiones de usuario de manera independiente del servidor de aplicaciones. Esto permite que las sesiones de los usuarios se mantengan a través de varios servidores o instancias, lo que es útil en aplicaciones distribuidas o cuando se usa un balanceador de carga.

## 🔹 MySQL Driver
MySQL Driver no es un componente oficial de Spring, pero generalmente se refiere al uso del conector JDBC de MySQL dentro de una aplicación Spring para interactuar con bases de datos MySQL.

El MySQL JDBC Driver es una biblioteca que permite que las aplicaciones Java se conecten a bases de datos MySQL. En una aplicación Spring, este driver se incluye como dependencia (por ejemplo, en el archivo pom.xml si se usa Maven) para que la aplicación pueda realizar operaciones en la base de datos MySQL.
   
