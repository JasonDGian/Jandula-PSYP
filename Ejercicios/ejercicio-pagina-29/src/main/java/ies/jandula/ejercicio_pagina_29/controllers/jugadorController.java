package ies.jandula.ejercicio_pagina_29.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ies.jandula.ejercicio_pagina_29.persistence.entity.Jugador;
import ies.jandula.ejercicio_pagina_29.persistence.repository.JugadorRepository;
import ies.jandula.ejercicio_pagina_29.services.JugadorService;

@RestController
public class jugadorController
{
	
	@Autowired
	JugadorRepository jugadorRepository;
	@Autowired
	JugadorService jugadorService;
	
	// postear un jugador
	@PostMapping(value = "/jugador")
	public Jugador guardaJugador( @RequestBody Jugador jugador ) {
		return jugadorRepository.saveAndFlush(jugador);
	}
	
	@PostMapping( value = "/jugador/modifica" )
	public String modificaJugador( @RequestBody Jugador jugador ) {
		return jugadorService.modificarJugador(jugador);
	}
	
	@GetMapping( value = "/jugador" )
	public List<Jugador> buscaJugador() {
		return jugadorRepository.findAll();
	}
	
	@GetMapping( value = "/jugador/id/" )
	public Optional<Jugador> buscaJugadorID( @RequestParam Long id ) {
		return jugadorRepository.findById(id);
	}
	
	@PostMapping(value = "/jugador/borrar")
	public String borrarPorDorsalC( @RequestParam int dorsal ) {
		return jugadorService.borrarPorDorsal(dorsal);
	}
	
}
