## Bloque de metadatos.
```yaml
swagger: "2.0"
info:
  description: "descripcion larga"
  version: "1.0.0"
  title: "titulo api"
  termsOfService: "link a terminos"
  contact:
    email: "correo"
host: "dominio de la api o empresa"
basePath: "base como /v2"
schemes:
- "https"
- "http"
```

## Peticiones
**
```yaml
paths:
  /ruta-ataque:
    post:
      description: "descripcion"
      operationId: "firma metodo"
      consumes:
      - "application/json"
      - "application/xml"
      produces:
      - "application/json"
      - "application/xml"
      parameters:
      - in: "body"



    
```


** Bloque parametros - Cuerpo**
```yaml
      parameters:
      - in: "body"
        name: "body"
        description: "Pet object that needs to be added to the store"
        required: true
        schema:
          $ref: "#/definitions/Pet"
```
** Bloque parametros - Cuerpo**
```yaml
      parameters:
      - name: "nombreparam"
        in: "query"
        name: "nombreparam"
        description: "descripcion parametro"
        required: true
        schema:
          $ref: "#/definitions/Pet"
```
## Bloque de definicion









