package com._dam.ejercicio_pag29.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._dam.ejercicio_pag29.model.Jugador;

@RestController
@RequestMapping("/v1")
public class Controller
{
	// Solicitudes de post.
	@PostMapping(value = "/player")
	public String addNewPlayer( @RequestBody Jugador jugador) {
		// Logica de uso del objeto
		return "Objeto creado \n" + jugador.toString();
	}
	
	// Solicitudes de post.
	@PostMapping(value = "/player2")
	public String addNewPlayer( @RequestBody Map<String, Object> mapeado) {
		// Logica de uso del objeto
		return "Objeto creado \n" + mapeado.toString();
	}
	
	@PostMapping("/raw")
	public String rawBody(@RequestBody String rawBody) {
	    return "Cuerpo sin procesar: " + rawBody;
	}
	
	@GetMapping(value = "/player")
	public String getPlayer() {
		return "Get Player";
	}

	@PutMapping(value = "/new_player")
	public String putPlayer() {
		return "put";
	}
	
	@DeleteMapping(value = "/new_player")
	public String deletePlayer() {
		return "deleted";
	}
}
