package ies.jandula.calculadora.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    // Método GET para la suma, con parámetros en la query.
    @GetMapping("/suma")
    public int suma(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        return a + b;
    }

    // Método POST para la resta, con parámetros en el cuerpo (en este caso, usa RequestBody o Path).
    @PostMapping("/resta")
    public int resta(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        return a - b;
    }

    // Método POST para la multiplicación, con parámetros en la ruta.
    @PostMapping("/multiplica/{a}/{b}")
    public int multiplica(@PathVariable int a, @PathVariable int b) {
        return a * b;
    }

    // Método POST para la división, con parámetros en la query.
    @PostMapping("/division")
    public int division(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return a / b;
    }
    
    //Funcion recursiva para obtener el factorial.
    public int factorial(int num) {
    	// caso base.
    	if ( num == 0 ) { return 1;}
    	// llamada recursiva.
		return num * factorial(num-1);
    }
    
    // Funcion fibonacci. F(n)=F(n−1)+F(n−2)
    public int fibonacci( int num ) {
    	// caso base.
    	if ( num == 0) { return 0;}
    	if ( num == 1) { return 1;}
    	
		return fibonacci(num-1) + fibonacci(num-2);
    }
    
    // Listado de numeros pares hasta X numero.
    public List<Integer> paresHasta( int num){
    	
       	List<Integer> pares = new ArrayList<>();
    	
    	for ( int i = 1 ; i <= num ; i++ ) {
    		if ( i % 2 == 0) { pares.add(i); }
    	}
    	
		return pares;    	
    }
    
    // Listado de numeros impares hasta X numero.
    public List<Integer> imparesHasta(int num){
    	
       	List<Integer> impares = new ArrayList<>();
    	
    	for ( int i = 1 ; i <= num ; i++ ) {
    		if ( i % 2 != 0) { impares.add(i); }
    	}
    	
		return impares;    	
    }
    
    // Numeros Perfectos.
    public boolean esPerfecto( int num ) {
    	
    	int totalDivisores = 0;
    	
    	// Sacamos los divisores del numero pasado como parametro.
    	for ( int i = 1; i < num/2 ; i++ ) {
    		if (num%i==0) { totalDivisores = totalDivisores + i;}
    	}
    	
    	// Devolvemos el resultado booleano.
		return totalDivisores == num;
    	
    }

    public boolean esPrimo (int num) {
    	
    	// Si el numero es <1 return false.
    	if (num<=1) { return false;}
    	// Si el numero es mayor a 1.
    	else {
	    	// Itera desde 2 hasta num -1
	    	for ( int i = 2 ; i<num ; i++ ) {
	    		if ( num % i == 0 ) { return false; }
	    	}
    	}

    	return true;
    }
    
    public List<Integer> primosHasta(int num){

    	List<Integer> listaPrimos = new ArrayList<>();   	
    	
    	for ( int i = 2; i<=num ; i++ ) {
    		if ( esPrimo(i) ) { listaPrimos.add(i); } 
    	}
    	return listaPrimos;
    }
}
