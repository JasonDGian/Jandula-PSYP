# 📌 Apuntes en vivo.
El scan de componentes va de paquete actual hacia abajo. Si tenemos un componente por encima de la clase donde tenemos la anotación de Scan no la va a encontrar. 



**Recursiva factorial**
```java
public int factorial( int num ){
// caso base
if ( num == 0 ){ return 1;}
// llamada recursiva
return num * factorial(num-1);
}
```

**Fibonacci**
```java
// se obtiene un numero y
public int fibonacci ( int num ){
// caso base
if (num == 0){ return 1;}
// llamada recursiva.
return num + fibonacci(num-1);
}
```
