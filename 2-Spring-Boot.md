# 📌 Fundamentos de Spring Boot.
Spring Boot retoma la arquitectura en 3 capas de Spring y proporciona herramientas adicionales que facilitan el desarrollo de microservicios y aplicaciones web. 
Entre las herramientas adicionales encontramos los estereotipos especificos de Spring Boot.

## 🔹 Estereotipos de Spring y Spring Boot.
Aunque Spring ya ofrece varios estereotipos nativos (como `@Component`, `@Service`, `@Repository`, `@Controller`), Spring Boot añade otras anotaciones que facilitan la configuración y simplifican la creación de aplicaciones, como `@SpringBootApplication` y `@RestController`.   
    
    
<table border="1" cellpadding="10" cellspacing="0">
    <thead>
        <tr>
            <th>Anotación</th>
            <th>Descripción</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>@SpringBootApplication</td>
            <td>Una combinación de @Configuration, @EnableAutoConfiguration y @ComponentScan, que permite habilitar la autoconfiguración y el escaneo de componentes en una aplicación Spring Boot.</td>
        </tr>
        <tr>
            <td>@Repository</td>
            <td>Indica una clase que normalmente trabaja a nivel de base de datos utilizando el patrón de repositorio, facilitando la interacción con el almacenamiento de datos.</td>
        </tr>
        <tr>
            <td>@Service</td>
            <td>Se utiliza para agrupar la lógica de negocio, indicando que la clase contiene servicios que pueden ser utilizados por otros componentes de la aplicación.</td>
        </tr>
        <tr>
            <td>@Controller</td>
            <td>Marca una clase que recibe peticiones HTTP, sirviendo como controlador en una arquitectura MVC. También se utiliza para redirigir hacia plantillas HTML procesadas con motores de plantillas.</td>
        </tr>
        <tr>
            <td>@RestController</td>
            <td>Indica que la clase recibe peticiones HTTP y que sus respuestas serán serializadas automáticamente a formatos como JSON, funcionando a nivel de REST.</td>
        </tr>
        <tr>
            <td>@Component</td>
            <td>Es una anotación genérica que se utiliza para marcar una clase que debe ser gestionada por Spring, sin especificar su pertenencia a ningún otro tipo de componente.</td>
        </tr>
    </tbody>
</table>



