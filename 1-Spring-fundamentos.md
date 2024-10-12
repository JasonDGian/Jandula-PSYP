# 📌 Fundamentos de Spring.
Spring Boot utiliza una arquitectura de tres capas, donde se diferencian los controladores REST, la capa de acceso a datos y la lógica de negocio. En cada capa existen responsabilidades claramente definidas para asegurar una separación adecuada de preocupaciones.


## Inicialización de proyectos.
PAra inicializar proyectos usamos spring initalizer en www.start.spring.io
Esta herramienta es util para configurar las dependencias necesarias sin tener que tocar manualmente el POM del proyecto maven. Además podemos utilizar spring.io si no tenemos maven instalado para incluirlo en forma de ejecutable en la raiz del proyecto.

![imagen](https://github.com/user-attachments/assets/9d0cf5cd-54c8-41e4-9e5c-bfbcfac800f2)




## Dependencias.

- Spring web: Starter para aplicaciones web como por ejemplo APIs REST o una aplicacion MVC con plantillas (necesitaria motor de plantillas como Thymeleaf).
- MySQL Driver: Proporciona tecnicas de conexion y manipulacion para bases de datos MYSQL.
- Spring jpa: Es el framework que facilita la interaccion con la base de datos evitando asi tener que escribir MySQL a pelo.


# Estereotipos de Spring.
Los estereotipos son anotaciones que identifican y asignan una serie de comportamientos y caracteristicas a las clases Java dentro del framework de Spring.

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
