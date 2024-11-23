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
    name: upfile
    type: file
    description: The file to upload.
```


   
# 📌 Respuestas
## 📍 Respuesta
```yaml

```
   
## 📍 Respuesta
```yaml

```
   
## 📍 Respuesta
```yaml

```
