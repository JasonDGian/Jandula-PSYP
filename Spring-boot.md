# 📌 Spring.
Spring es un framework centrado en crear aplicaciones de calibre comercial con Java.  Esto significa que con este framework podemos evitar muchisimo "Boilerplate code" que ya no es necesario escribir a mano.
**Spring ofrece además técnicas IOC (Inversion of Control) y posibilita el uso de Transacciones.**
   
https://spring.io/   
   
# 📌 Spring boot.
Spring Boot es un **sub-framework** basado en Spring.
Dispone de algunas caracteristicas que nos permiten desarrollar aplicaciones de manera acelerada. Ofrece un sistema de autoconfiguración y "Anotaciones". Es facil de configurar y es genial
con el uso de Stand-alone APIs.

![imagen](https://github.com/user-attachments/assets/2834c714-8e95-41f2-9a98-60baee6bed7b)

   
**Al hablar de Spring Boot se mencionan ciertos terminos que es conveniente conocer.**

## 🔹 Servidores incrustados. 
Una de las principales características del framework Spring Boot es permite la ejecución de aplicaciones web sin necesidad de usar servidores de aplicaciones externos donde desplegarlas. Esto lo consigue mediante el uso de un contenedor incrustado en la misma aplicación (Tomcat, Jetty o Undertow). Estos contenedores vienen pre-configurados por defecto pero podemos modificar sus parametros si es necesario.

## 🔹 IOC - Inversion of Control.
IOC es un principio de diseño o técnica utilizada en el desarrollo de software para invertir el control del flujo de ejecución o las dependencias en una aplicación.
En lugar de hacer que programador controle el flujo de la aplicacion y que objetos se crean y cuando, este entrega este control al contenedor Spring mediante el framework.

### ▫️ IOC Container.
El contenedor IOC de Spring es uno de los puntos centrales de Spring, se encarga de crear los objetos, conectarlos entre si, configurarlos y además controla los ciclos de vida de cada objeto mediante el patrón de Inyección de Dependencias. 

>![NOTE]
> No es una tecnología, ni una convención, sino una técnica que describe cómo los objetos reciben sus dependencias.

## 🔹 Rest Controller.
En Spring Boot, un **REST Controller** es una clase que se encarga de manejar las solicitudes HTTP en una aplicación web RESTful. Se utiliza la anotación `@RestController`, que combina las anotaciones `@Controller` y `@ResponseBody`. Esto significa que los métodos de la clase devolverán directamente los datos en formato JSON o XML, sin necesidad de usar una vista.
   
![imagen](https://github.com/user-attachments/assets/b3ca6d5c-89a1-4e9e-9f33-70e2020b1246)

El concepto de REST Controller está relacionado con el concepto de Modelo-Vista-Controlador (MVC), pero se enfoca principalmente en la parte de controlador.  

En el patrón MVC:
- **Modelo**: Representa la lógica de negocio y los datos.
- **Vista**: Se encarga de la presentación de los datos al usuario.
- **Controlador**: Maneja las solicitudes y coordina entre el modelo y la vista.

En el caso de un REST Controller, la vista se omite, ya que se devuelve directamente el modelo (datos) en formato JSON o XML. Esto permite que la lógica de la aplicación se enfoque en la gestión de datos y en cómo se exponen a los clientes, sin preocuparse por la presentación visual.





# 📌 Anotaciones.
En Spring Boot, las anotaciones son, "etiquetas" que preceden a las clases y otros elementos que definen cómo deben ser manejados por el contenedor de Spring. Estas anotaciones indican al contenedor qué clases deben ser tratadas como componentes, controladores, servicios, etc.



## @Bean.
Indica que un metodo produce una instancia que debe ser gestioanda pro el ecosistema pspinrg.   
Se utilza dentro de clases con @Configuration para declara metodos que devuelvan instancias beans.
   
## @Configuration.
Se utiliza para indicar una clase que declara uno o mas metodos @Bean. Estas clases se utilizan para definir la configuracion de la aplicacio ny gestionar la creacion de beans dentro del ex

## @Autowired.
Realiaza la inyeccion de dependencias de beansa gestionados por spring automaticamente.
Se utiliza en campos metodos o constructoreds para indicar a spring que inyecte automaticamente un bean apropriado.

## @Component

@Service
@Repository
@Controller
@ComponentScan
@SpringBootApplication
@RestController

@RequestMapping, @GetMapping, @PostMapping,
@PutMapping, @DeleteMapping

@PathVariable y @RequestParam

@EnableScheduling, @Scheduled
@Transactional

