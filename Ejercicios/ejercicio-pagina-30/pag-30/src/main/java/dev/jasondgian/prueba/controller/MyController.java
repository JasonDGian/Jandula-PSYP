package dev.jasondgian.prueba.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class MyController
{

	public MyController()
	{
		// Spring requirement.
	}

	@GetMapping(value = "/userVisits")
	public ResponseEntity<Integer> handleRequest(HttpSession session)
	{
		
		Integer userVisits = (Integer) session.getAttribute("userVisits");
		
		if ( userVisits == null ) {
			userVisits = 0;
		}
		
		userVisits ++;
		
		System.out.println("User visits: " + userVisits);
		
		
		// Guarda el valor de la variable en la información de estado de sesión del usuario.
		session.setAttribute( "userVisits" , userVisits);
		
		// Devuelve como mensaje de estado un 200 OK.
		// Devuelve en el cuerpo del mensaje el numero de visitas (peticiones get escuchadas.).
		return ResponseEntity.ok().body(userVisits); 
		
	}

}
