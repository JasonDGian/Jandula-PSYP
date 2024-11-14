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


## 📍 Bloque de metadatos.
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

## 📍 Bloque de Servidores.
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
    
## 📍 Bloque de recursos (endpoints).
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

### 🔸 Media Type - Tipos de respuesta o petición.
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

    
--- 
## 📍 Sobre-escribir servidores (override).
Se pueden sobreescribir los servidores de escucha a nivel de Path.




# 🟦 Definición de respuesta lista de objetos
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

