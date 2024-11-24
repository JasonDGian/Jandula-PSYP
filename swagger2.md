# 📌 Bloque de metadatos e info.
```yaml
# Version de especificacion OpenAPI.
swagger: "2.0"
# Información general del servicio.
info:
  version: 1.0.0
  title: "titulo"
  description: "descripcion"
  contact:
    name:  "nombre"
    email: "correo"
    url: https://www.pagina.com

# Datos server & host.
host: "api.empresa.com"
basePath: "/v1"
schemes:
  - http
  - https
  
# Seccion de comunes a los endpoints.
consumes:
  - application/json
produces:
  - application/json
  - application/xml
  - application/pdf
  - text/csv
```

# 📌 Estructura basica de endpoint.
```yaml
paths:                  # Declaracion inicial de Paths (solo una vez por documento)
  /url:                 # Url de punto de ataque del endpoint.
    verbo:              # Verbo con el que se ataca al endpoint [ post, put, get, delete ]
      description:      # Breve descripcion del comportamiento del endpoint.
      operationId:      # Identifica el metodo backend que se encarga de atender a esta petición.
      consumes:         # Solo presente cuando el endpoint consume datos. [ application/json, application/xml, application/pdf ]
      produces:         # Solo presente cuando el endpoint produce datos.
      parameters:       # Parametros que el endpoint espera.
      responses:        # Respuesta que el endpoint devuelve.
```

# 📌 Parametros

## 📍 Parametros en Path
```yaml
/usuario/{id}:
    get:
      description: "Este endpoint devuelve la información de un usuario basado en su ID."
      parameters:
        - name: "id"
          in: "path"
          description: "ID del usuario"
          required: true
          type: "integer"
```
## 📍 Parametros en Query
```yaml
 parameters:
  - name: "nombreParam"
    in: "query"
    description: "Desc Param"
    required: true
    type: "string"
```
   
## 📍 Parametros en Header
```yaml
 parameters:
  - name: "nombreParam"
    in: "header"
    description: "Desc Param"
    required: true
    type: "string"
```
    
## 📍 Parametros en Body
Debe especificar que consume un `application/json`.
```yaml
consumes:
  - "application/json"
parameters:
  - in: "body"
    name: "user"
    description: "Objeto con la información del usuario"
    required: true
    schema:
      "$ref": "#/definitions/User"
```

## 📍 Parametros en fichero
Debe especificar el 'consume'.
```yaml
consumes:
  - multipart/form-data
parameters:
  - in: formData
    name: nombreParam
    type: file
    description: The file to upload.
```


   
# 📌 Respuestas
## 📍 Respuesta simple.
```yaml
responses:
  200:
    description: Reserva realizada con exito.
    schema:
      type: number
      format: float
```

## 📍 Respuesta con objeto Json.
```yaml
produces:
  - "application/json"  # Especificamos que la respuesta es JSON
responses:
  200:
    description: "Usuario encontrado correctamente"
    schema:
      $ref: "#/definitions/User" 
```
   
## 📍 Respuesta lista de objetos Json.
```yaml
produces:
  - "application/json"  # Especificamos que la respuesta es JSON
responses:
  200:
    description: "Lista de usuarios"
    schema:
      type: array # Responde con un array de Json en lugar de unico objeto.
      items:
        $ref: "#/definitions/User" 
```
   
## 📍 Respuesta con fichero para descarga.
**fichero CSV**
```yaml
produces:
  - "text/csv"  # Tipo MIME para archivos CSV
responses:
  200:
    description: "Archivo CSV descargado correctamente"
    schema:
      type: file  # Indicamos que la respuesta es un archivo
```
**fichero XML**
```yaml
produces:
  - "application/xml"  # Tipo MIME para archivos XML
responses:
  200:
    description: "Archivo XML descargado correctamente"
    schema:
      type: file  # Indicamos que la respuesta es un archivo
```
**fichero PDF**
```yaml
produces:
  - "application/pdf"  # Tipo MIME para archivos PDF
responses:
  200:
    description: "Archivo PDF descargado correctamente"
    schema:
      type: file  # Indicamos que la respuesta es un archivo
```

# 📌 Definiciones.
## 📍 Definicion simple.
```yaml
definitions:
  User:
    type: object
    properties:
      id:
        type: integer
        format: int64
        description: "El ID del usuario"
      name:
        type: string
        description: "El nombre del usuario"
      email:
        type: string
        description: "El correo electrónico del usuario"
    required:
      - id
      - name
      - email
```
   
## 📍 Definicion con herencia.
```yaml
  Employee:
    allOf:
      - $ref: '#/definitions/User'  # Hereda de la definición User
      - type: object
        properties:
          jobTitle:
            type: string
            description: "El título del trabajo del empleado"
          salary:
            type: number
            format: float
            description: "El salario del empleado"
        required:
          - jobTitle
          - salary
```

## 📍 Definicion de objeto Excepcion personalizado.
```yaml
definitions:
  Error:
    type: object
    properties:
      errorCode:
        type: integer
        format: int32
        description: "Codigo del error."
      errorMessage:
        type: string
        description: "Mensaje de la excepcion."
      stackTrace:
        type: string
        description: "Traza del error si la hubiere."
    required:
      - codigo
      - mensaje
```
