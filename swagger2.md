# 📌 Parametros
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

