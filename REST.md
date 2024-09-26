# :pushpin: Entendiendo REST.

## 📍 ¿Qué es REST?
REST es básicamente un conjunto de reglas para construir servicios HTTP.  
  
**¿Qué es un servicio HTTP?**   
Un servicio HTTP es una interfaz que permite la comunicación entre un cliente y un servidor mediante peticiones y respuestas utilizando el protocolo HTTP.
  
- Hoy en día, las aplicaciones funcionan mediante la arquitectura cliente-servidor. Para recibir información y resultados de operaciones, la aplicación "ataca" a un servidor.
  
- Para que este servidor pueda responder, debe tener expuestos servicios que escuchen estas peticiones. 
  
El proceso de exposición y creación de estos servicios está regulado por la **convención REST**, que se basa en principios como la statelessness y el uso de recursos identificados por URLs.
  
![imagen](https://github.com/user-attachments/assets/48140efb-4645-416d-b561-d7de8f708a1f)
  

### 🔹 Entonces... ¿Qué es REST? 
REST o **Representational State Transfer** es una convención para servicios HTTP que proporciona principios para realizar operaciones CRUD.   
   
**Caracteristicas principales:**   
- *REST* es una interfaz para interconectar distintos sistemas mediante HTTP.
- Permite obtener datos o generar operaciones sobre estos en distintos formatos, como `XML` y `JSON`.
- Almacena lógica de negocio y sirve datos con una serie de URIs.
- Se basa en HTTP.
- Al apoyarse en HTTP utiliza los verbos relacionados como `POST` `PUT` `DELETE` `GET` `DELAY` etc...

>[!NOTE]
> REST nace como alternativa a SOAP y facilita en gran medida el desarrollo de servicios y API REST.

¿Por qué se usa REST?

**Tipos de peticiones.**   
Cada tipo de petición se define por su `verbo`.
- `GET` Recupera datos.
- `POST` Introduce datos.
- `PUT` Actualiza datos.
- `DELETE` Borra datos.

**Ejemplo GET**   
En este ejemplo se **solicita información** al servicio.
```html
<!-- Petición para el listado de clientes-->
GET /api/customers

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
PUT /api/customers/1

{ nombre: "Alfredo 2" }

<!-- Respuesta obtenida -->
{ id: 1, nombre: "Alfredo 2" }
```


**Ejemplo DELETE**    
En este ejemplo se solicita el **borrado de información** almacenada al servicio.
```html
<!-- Petición para actualizar un cliente concreto-->
DELETE /api/customers/1
```

**Ejemplo POST**    
En este ejemplo se solicita la creación de **nueva información** almacenada al servicio.
```html
<!-- Petición para crear un nuevo cliente -->
POST /api/customers
{ nombre: "Carlos" }

<!-- Respuesta obtenida -->
{ id: 3, nombre: "Carlos" }
```

## 📍 ¿Qué es un Recurso?


## 📍 ¿Qué es una URI?


## 📍 ¿Qué tipos de parámetros existen?


## 📍 ¿Qué tipos de verbos tenemos?


## 📍 ¿Qué códigos de respuesta nos devuelve el servidor?
