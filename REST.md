# :pushpin: Entendiendo REST.


## 📍 ¿Qué es REST?
REST es básicamente un conjunto de reglas para construir servicios HTTP.
Una de las ideas principales de REST es tratar todos los URLs de un servidor como puntos de acceso para los distintos recursos que almacena.

>[!NOTE]
> Es el estándar de comunicación más común entre dispositivos por internet.
  
### 🔹 ¿Qué es un servicio HTTP?
Un servicio HTTP es una interfaz que permite la comunicación entre un cliente y un servidor mediante peticiones y respuestas utilizando el protocolo HTTP.
  
- Hoy en día, las aplicaciones funcionan mediante la arquitectura cliente-servidor. Para recibir información y resultados de operaciones, la aplicación "ataca" a un servidor.
  
- Para que este servidor pueda responder, debe tener expuestos servicios que escuchen estas peticiones. 
  
El proceso de exposición y creación de estos servicios está regulado por la **convención REST**, que se basa en principios como la statelessness y el uso de recursos identificados por URLs.
  
![imagen](https://github.com/user-attachments/assets/48140efb-4645-416d-b561-d7de8f708a1f)


### 🔹 Entonces... ¿Qué es REST? 
REST o **Representational State Transfer** es una convención para servicios HTTP que proporciona principios para realizar operaciones CRUD.   
Las API que respetan las reglas que REST propone se conocen como **RESTful API**.

**Caracteristicas principales:**   
- *REST* es una interfaz para interconectar distintos sistemas mediante HTTP.
- Permite obtener datos o generar operaciones sobre estos en distintos formatos, como `XML` y `JSON`.
- Almacena lógica de negocio y sirve datos con una serie de URIs.
- Se basa en HTTP.
- Al apoyarse en HTTP utiliza los verbos relacionados como `POST` `PUT` `DELETE` `GET` `DELAY` etc...

>[!NOTE]
> REST nace como alternativa a SOAP y facilita en gran medida el desarrollo de servicios y API REST.

## 📍 RESTful APIs.
Una RESTful API organiza sus recursos en `URI`s especificos que diferencian a distintos tipos de recursos del servidor.  
Un cliente interactua con un recurso lanzando una petición al `ENDPOINT` que el servidor expone a través de `HTTP` para dicho recurso.
Las peticiones tienen un formato especifico.

![imagen](https://github.com/user-attachments/assets/4b140f3c-f8c6-466f-9021-89c57060aa68)

### 🔹 Peticiones.  
Para interactuar con el servidor, un cliente envia peticiones.
Las peticiones están formadas de la siguiente manera.   
> Petición = `VERBO` + `ENDPOINT` + `HEADER` + `CUERPO`

**Verbo o Metodo.**
Define la acción que sucede con la petición. 
**Endpoint - Punto de ataque.**
Localiza el recurso en el servidor.
- Suele ser una `URI`, en el caso de un servicio online será una `URL`.
**Header - Cabecera.**
Contiene los detalles necesarios para que se ejecute la llamada y manejar la respuesta.
- Podría contener información de autenticación, clave de encripcación, mas detalles acerca de la ubicación del recurso etc..
**Body - Cuerpo de la petición.**
Contiene información relevante para o por el servidor. 
- Por ejemplo un cuerpo puede contener nuevos datos a introducir mediante un PUT o POST.


Cada tipo de petición se define por su `verbo`.
- `GET` Recupera datos.
- `POST` Introduce datos.
- `PUT` Actualiza datos.
- `DELETE` Borra datos.

**Ejemplo GET**   
En este ejemplo se **solicita información** al servicio.
```html
<!-- Petición para el listado de clientes-->
GET http://ejemplo.com/api/customers

<!-- Respuesta obtenida -->
[
  { id: 1, nombre: "Alfredo" }
  { id: 2, nombre: "Bernarda" },
  ...
]
```
   
**Ejemplo PUT**   
En este ejemplo se solicita el **actualizar información** almacenada al servicio.
```html
<!-- Petición para actualizar un cliente concreto-->
PUT http://ejemplo.com/api/customers/1

{ nombre: "Alfredo 2" }

<!-- Respuesta obtenida -->
{ id: 1, nombre: "Alfredo 2" }
```
   
**Ejemplo DELETE**    
En este ejemplo se solicita el **borrado de información** almacenada al servicio.
```html
<!-- Petición para actualizar un cliente concreto-->
DELETE http://ejemplo.com/api/customers/1
```
   
**Ejemplo POST**    
En este ejemplo se solicita la creación de **nueva información** almacenada al servicio.
```html
<!-- Petición para crear un nuevo cliente -->
POST http://ejemplo.com/api/customers
{ nombre: "Carlos" }

<!-- Respuesta obtenida -->
{ id: 3, nombre: "Carlos" }
```
   
### 🔹 Cuerpo de petición.
Las peticiones pueden incluir un 'cuerpo', normalmente en formato JSON, que se envía junto a la petición para complementar la acción.
Por ejemplo, si queremos agregar un objeto a una base de datos, deberemos incluir en el cuerpo de una petición `POST` la información que deseamos cargar en la base de datos.

![imagen](https://github.com/user-attachments/assets/ca78e0d7-5a91-46be-9c16-d19733cf5278)

### 🔹 Respuesta de petición.
Al realizar una petición a una RESTful API recibiremos una respuesta a las peticiones que mandamos. Esta respuesta utiliza los códigos de estado de HTML para informarnos del estado o resultado de nuetra petición.
Los códigos de respuesta HTTP se dividen en `Niveles` que representan distintos tipos generales de resultado. 
   
![imagen](https://github.com/user-attachments/assets/d98ffd0b-cc29-4192-a32b-b4e4fd810fd3)

**Los códigos más comunes**   
![imagen](https://github.com/user-attachments/assets/5f0afc17-273e-4456-a49d-aaa705d56f34)   
      
### 🔹 Protocolo sin estado.
Un detalle crítico de REST es el concepto de `statelessness` o ausencia de estado. Esto significa que los participantes en la comunicación no almacenan información sobre el estado de las interacciones previas, y cada solicitud y respuesta es independiente de las demás.
   
![imagen](https://github.com/user-attachments/assets/1636377d-c11a-496a-b9c8-ae064904a625)

<!-- https://youtu.be/-mN3VyJuCjM -->

## 📍 Elementos de una RESTful API.
Una RESTFul API se basa fundamentalmente en tres elementos principales.
- Cliente
- Servidor
- Recursos

Para acceder a un recurso, un cliente debe de realizar una petición HTTP. Las peticiones



## 📍 ¿Qué es un Recurso?


## 📍 ¿Qué es una URI?


## 📍 ¿Qué tipos de parámetros existen?


## 📍 ¿Qué tipos de verbos tenemos?


## 📍 ¿Qué códigos de respuesta nos devuelve el servidor?
