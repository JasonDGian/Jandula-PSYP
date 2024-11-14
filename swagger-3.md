# 📌 Documentación de API en swagger 3.0
Es importante saber que existe una notable diferencia en la sintaxis y estructura entre Swagger 2.0 y 3.0. En este documento se recogen instrucciones y ejemplos de la versión 3.0 de Swagger OpenAPI.

## 📍 Estructura basica.
La estructura basica de un documento Swagger es la siguiente.
- Bloque de metadatos.
  - Versión API
  - Informacion del proyecto.
- Bloque de servidores.
  - Servidores
  - URL de ataque -- [esquema] + [host] : [puertos] + [endpoint base]
- Bloque de recursos (endpoints).
- Bloque de defincion de objetos.


### 🔸 Bloque de metadatos.
Toda documentación swagger debe incluir información acerca de la versión de la API empleada.
```yaml
# Versión de la API
openapi: 3.0.0

# Información acerca del proyecto.
info:
  title: Titulo de la herramienta.
  description: Breve descripcion que puede ser multilinea que define el proyetco.
  version: 0.1.2
```

### 🔸 Bloque de Servidores.
La seccion de servidores especifica los servidores y las URL base para los recursos que se pueden llamar en la API. Se puede definir uno o más servidores y URLs
```yaml
# Servidores de la API
servers:
  - url: http://api.example.com/v1
    description: Optional server description, e.g. Main (production) server
  - url: http://staging-api.example.com
    description: Optional server description, e.g. Internal staging server for testing
```
    
>[!CAUTION]
>Para definir varios los esquemas HTTP y HTTPS se deben de recoger las URLs con ambos protocolos.
> ```yaml
>servers:
>  - url: http://api.example.com
>  - url: https://api.example.com
> ```
    
### 🔸 Bloque de recursos (endpoints).
En esta sección se definen los puntos de ataque que sirven los recursos de la API y los metodos que estos atienden.
```yaml
# Endpoints
paths:
  # Endpoint de usuarios.
  /users:
    # Peticiones GET
    get:
      summary: Devuelve una lista de usuarios
      description: Devuelve una lista de usuarios
      responses:
        "200":
          description: Responde con un objeto Json.
          # Contenido de la respuesta.
          content:
            application/json:
              schema:
                type: array
                items:
                  type: string
```
### 🔸 Bloque de definicion (objetos).
En el ultimo bloque se definen los objetos que empleamos en nuestros endpoints.
```yaml
# Definicion de objetos
components:
  schemas:
    Asignatura: # Objeto asignatura
      type: object
      properties:
        identificador:
          type: integer
          format: int32
        nombre:
          type: string
        apellidos:
          type: string
        correo:
          type: string
        telefono:
          type: string
        creditos:
          type: integer
          format: int32
        horasSemanales:
          type: integer
          format: int32
```
  
       
--- 
# 📌 Otras notas

### 📍 Sobre-escribir servidores (override).
Se pueden sobreescribir los servidores de escucha a nivel de Path.   
Para ello usamos la siguiente sintaxis:
```yaml
servers:
  - url: https://api.ejemplo.com/v1

paths:
  /alumnos:
    description: Api de gestion de alumnos
    servers:
      - url: https://alumnos.ejemplo.com
        description: Sobreescribe el servidor de escucha para las peticiones de '/alumnos'
    ...

/profesores:
    get:
      servers:
        - url: https://profesores.ejemplo.com
          description: Sobreescribe el servidor de escucha para las peticiones de '/profesores'
```

### 📍 Media Type - Tipos de respuesta o petición.
En las respuestas o peticiones podemos definir el tipo de cuerpo o dato que utilizan.
```yaml
paths:
  /employees:
    get:
      summary: Returns a list of employees.
      responses:
        "200": # Response
          description: OK
          content: # Response body
            application/json: # Media type
              schema: # Must-have
                type: object # Data type
                properties:
                  id:
                    type: integer
                  name:
                    type: string
                  fullTime:
                    type: boolean
                example: # Sample data
                  id: 1
                  name: Jessica Right
                  fullTime: true
```


### 📍 Definición de respuesta lista de objetos
```yaml
  # Endpoint de alumnado
  /alumnado:
  
    # Peticiones GET
    get:
      summary: Devuelve un listado de alumnos basado en un filtro
      responses:
        200:
          description: Listado obtenido con exito.
          # Especifica el contenido de la respuesta
          content:
            # Indica una respuesta en formato Json
            application/json:
              schema:
                # Establece una respuesta Array
                type: array 
                # Define el objeto del Array.
                items:
                  $ref: "#/components/schemas/Alumno" # Referencia a la definicion del esquema alumno.
```

### 📍 Parametros de peticiones.
**Peticion con parametros**
```yaml
    get:
      operationId: listarAlumnos
      summary: Devuelve un listado de alumnos basado en un filtro
      parameters:
        - name: dni
          in: query
          description: DNI del alumno.
          required: false
          schema:
            type: string       
      responses:
        200:
          description: Listado obtenido con exito.
          # Cuerpo de la respuesta
          content:
            # Indica una respuesta en formato Json
            application/json:
              schema:
                # Establece una respuesta Array
                type: array 
                # Define el objeto del Array.
                items:
                  $ref: "#/components/schemas/Alumno" # Referencia a la definicion del esquema alumno.
```



**Ejemplo de descripcion**
```yaml
# Versión de la API
openapi: 3.0.0

# Información acerca del proyecto.
info:
  title: API-alumnado
  description: API de gestión de alumnado, asignaturas y matriculadas.
  version: 1.0.0
  contact:
    name: David Jason G
    email: davjasg@gmail.com

# Servidores que atienden
servers: 
  # Servidor de desarrollo y pruebas
  - url: http://localhost:8080
    description: Servidor de desarrollo

# Recursos del servicio
paths:

  # Endpoint de alumnado
  /alumnado:
  
    # Petición GET /alumnado
    get:
      operationId: listarAlumnos
      summary: Devuelve un listado de alumnos basado en un filtro
      # Parámetros de la petición
      parameters:
        # Parámetro 1
        - name: dni
          in: query
          description: DNI del alumno.
          required: false
          schema:
            type: string
        # Parámetro 2
        - name: nombre
          in: query
          description: Nombre del alumno.
          required: false
          schema:
            type: string
        # Parámetro 3
        - name: apellido
          in: query
          description: Apellido del alumno.
          required: false
          schema:
            type: string
        # Parámetro 4
        - name: telefono
          in: query
          description: Teléfono del alumno.
          required: false
          schema:
            type: string
        # Parámetro 5
        - name: correo
          in: query
          description: Correo electrónico del alumno.
          required: false
          schema:
            type: string
        
      # Respuestas de GET /alumnado.
      responses:
        200:
          description: Listado obtenido con éxito.
          # Cuerpo de la respuesta
          content:
            # Indica una respuesta en formato Json
            application/json:
              schema:
                # Establece una respuesta Array
                type: array 
                # Define el objeto del Array.
                items:
                  $ref: "#/components/schemas/Alumno" # Referencia a la definición del esquema alumno.
        500:
          description: Informa de error - Internal Server Error
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
                
    # Petición POST /alumnado
    post:
      operationId: crearAlumno
      summary: Recibe un json en el cuerpo y crea el alumno correspondiente.
      # Cuerpo de la petición
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: "#/components/schemas/Alumno" # Referencia a la definición del esquema alumno.
      # Respuestas que devuelve.
      responses:
        201:
          description: Confirma la creación del nuevo alumno
        401:
          description: Error de parametros de entrada.
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
        500:
          description: Informa de error - Internal Server Error
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
                
    # Petición PUT /alumnado
    put:
      operationId: actualizaAlumno
      summary: Recibe un json en el cuerpo y actualiza el alumno correspondiente.
      # Cuerpo de la petición
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: "#/components/schemas/Alumno" # Referencia a la definición del esquema alumno.
      # Respuestas que devuelve.
      responses:
        200:
          description: Confirma la actualización del nuevo alumno
        404:
          description: Informa de error - Alumno no encontrado
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
        500:
          description: Informa de error - Internal Server Error
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
                
    # Petición DELETE /alumnado
    delete:
      operationId: borraAlumno
      summary: Recibe un json en el cuerpo y borra el alumno correspondiente.
      # Parámetros de la petición.
      parameters:
        - name: dni
          in: query
          description: DNI del alumno a borrar
          required: true
          schema:
            type: string
          
      # Respuestas que devuelve.
      responses:
        204:
          description: Confirma el borrado del alumno
        404:
          description: Informa de error - Alumno no encontrado
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
        500:
          description: Informa de error - Internal Server Error
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
                
                
# Endpoint de asignatura
  /asignatura:
  
    # Petición GET /asignatura
    get: 
      operationId: listaAsignaturas
      summary: Devuelve una lista de asignaturas basada en filtro.
   
      # Parámetros de la petición
      parameters:
        # Parámetro 1
        - name: identificador
          in: query
          description: ID de la asignatura
          required: false
          schema:
            type: integer
            format: int32
        # Parámetro 2
        - name: nombre
          in: query
          description: Nombre de la asignatura.
          required: false
          schema:
            type: string
        # Parámetro 3
        - name: creditos
          in: query
          description: Valor de créditos ECTS de la asignatura.
          required: false
          schema:
            type: integer
            format: int32
        # Parámetro 4
        - name: horas
          in: query
          description: Horas semanales que tiene la asignatura
          required: false
          schema:
            type: integer
            format: int32
            
      responses:
        200:
          description: Devuelve una lista de asignaturas.
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: "#/components/schemas/Asignatura" # Referencia a la definición del esquema asignatura.
        404:
          description: Informa de error - Asignatura no encontrada
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
        500:
          description: Informa de error - Internal Server Error
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
                
    # Petición POST /asignatura
    post:
      operationId: creaAsignatura
      summary: Recibe un json en el cuerpo y crea la asignatura correspondiente.
      # Cuerpo de la petición
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: "#/components/schemas/Asignatura" # Referencia a la definición del esquema asignatura.
      # Respuestas que devuelve.
      responses:
        201:
          description: Confirma la creación de la nueva asignatura
        401:
          description: Error de parametros de entrada.
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
        500:
          description: Informa de error - Internal Server Error
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
                
    # Petición PUT /asignatura
    put:
      operationId: actualizaAsignatura
      summary: Recibe un json en el cuerpo y actualiza la asignatura correspondiente.
      # Cuerpo de la petición
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: "#/components/schemas/Asignatura" # Referencia a la definición del esquema asignatura.
      # Respuestas que devuelve.
      responses:
        200:
          description: Confirma la actualización de la asignatura
        404:
          description: Informa de error - Asignatura no encontrada
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
        500:
          description: Informa de error - Internal Server Error
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
                
    # Petición DELETE /asignatura
    delete:
      operationId: borraAsignatura
      summary: Recibe un json en el cuerpo y borra la asignatura correspondiente.
      # Parámetros de la petición.
      parameters:
        - name: identificador
          in: query
          description: ID de la asignatura a borrar
          required: true
          schema:
            type: string
          
      # Respuestas que devuelve.
      responses:
        204:
          description: Confirma el borrado de la asignatura
        404:
          description: Informa de error - Asignatura no encontrada
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
        500:
          description: Informa de error - Internal Server Error
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
                  
                  
  # Carga de ficheros.
  /ficheroAsignatura:
    get:
      operationId: descargaFicheroAsignatura
      summary: Descarga un fichero con los datos de las asignaturas.
      responses:
        200:
          description: Confirma el exito de la peticion de descarga y entrega el fichero.
          content:
            text/plain: # Tipo MIME de fichero de texto.
              schema:
                type: string
                format: byte   # Representa el archivo como flujo de bytes
        403:
          description: Operacion no autorizada
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
        500:
          description: Informa de error - Internal Server Error
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
        
    # Peticion POST en /ficheroAsignatura        
    post:
      operationId: cargaFicheroAsignatura
      summary: Carga un fichero con los datos de las asignaturas.
      # Cuerpo de la peticion que describe el fichero
      requestBody:
        required: true
        content:
          text/plain:
            schema:
              type: string
              format: byte
      responses:
        200:
          description: Confirma el exito de la peticion de carga del fichero.
        403:
          description: Operacion no autorizada
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
        500:
          description: Informa de error - Internal Server Error
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
                  
  # Carga de ficheros.
  /ficheroAlumno:
    get:
      operationId: descargaFicheroAlumno
      summary: Descarga un fichero con los datos de los alumnos.
      responses:
        200:
          description: Confirma el exito de la peticion de descarga y entrega el fichero.
          content:
            text/plain: # Tipo MIME de fichero de texto.
              schema:
                type: string
                format: byte   # Representa el archivo como flujo de bytes
        403:
          description: Operacion no autorizada
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
        500:
          description: Informa de error - Internal Server Error
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
        
    # Peticion POST en /ficheroAsignatura        
    post:
      operationId: cargaFicheroAlumno
      summary: Carga un fichero con los datos de los alumnos.
      # Cuerpo de la peticion que describe el fichero
      requestBody:
        required: true
        content:
          text/plain:
            schema:
              type: string
              format: byte
      responses:
        200:
          description: Confirma el exito de la peticion de carga del fichero.
        403:
          description: Operacion no autorizada
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error" 
        500:
          description: Informa de error - Internal Server Error
          content:
            application/json:
              schema:
                $ref: "#/components/schemas/Error"              
                  
                  
# Definición de objetos
components:
  schemas:
    Asignatura: # Objeto asignatura
      type: object
      properties:
        identificador:
          type: integer
          format: int32
        nombre:
          type: string
        creditos:
          type: integer
          format: int32
        horasSemanales:
          type: integer
          format: int32
          
    Alumno: # Objeto alumno
      type: object
      properties:
        dni:
          type: string
        nombre:
          type: string
        apellidos:
          type: string
        correo:
          type: string
        telefono:
          type: string
        asignatura:
          $ref: "#/components/schemas/Asignatura"  # Referencia al esquema Asignatura
          
    Error:
      type: object
      properties:
        codigo:
          type: string
        mensaje:
          type: string
        stack:
          type: string     
```
