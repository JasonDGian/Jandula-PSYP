# 📌 Documentación de API en swagger 3.0
Es importante saber que existe una notable diferencia en la sintaxis y estructura entre Swagger 2.0 y 3.0. En este documento se recogen instrucciones y ejemplos de la versión 3.0 de Swagger OpenAPI.

## 📍 Estructura basica.
La estructura basica de un documento Swagger es la siguiente.
- Bloque de metadatos.
  - Versión API
  - Informacion del proyecto.
- Bloque de servidores.
  - Servidores
  - URL de ataque -- [esquema] + [host] + [endpoint base]
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
