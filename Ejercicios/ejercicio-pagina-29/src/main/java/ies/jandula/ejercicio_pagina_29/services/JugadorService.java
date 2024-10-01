package ies.jandula.ejercicio_pagina_29.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import ies.jandula.ejercicio_pagina_29.persistence.entity.Jugador;
import ies.jandula.ejercicio_pagina_29.persistence.repository.JugadorRepository;

@Service
public class JugadorService
{

	@Autowired
	JugadorRepository jugadorRepository;

	// Crear un nuevo jugador
	public void insertarJugador(Jugador jugador)
	{
		jugadorRepository.save(jugador);
	}

	// Modificar un jugador existente
	/**
	 * El paquete de datos de "jugador nuevo" que recibe como parametro lleva una
	 * ID. Esa ID se coge para buscar un jugador en la BBDD. Si un jugador con esa
	 * ID existe entonces sus datos se sobre-escriben con el paquete de datos nuevo.
	 * 
	 * @param jugador
	 * @return jugador
	 */
	public String modificarJugador(Jugador jugador)
	{
		// Si el jugador de ID precisada existe.
		if (jugadorRepository.existsById(jugador.getId()))
		{
			// No se si esto es una guarrada o que, pero repesta un objeto "Optional" y
			// lo pasa mediante el .get() [unwrapping] a tipo jugador.
			Jugador viejoJugador = jugadorRepository.findById(jugador.getId()).get();

			actualizaJugador(viejoJugador, jugador); // En teoria esto actualiza datos

			jugadorRepository.save(viejoJugador); // Es esto siquiera necesario ?

			return "Hecho";
		}

		else
		{
			return "Jugador no encontrado.";
		}
	}

	// Busca un jugador por el ID del jugador.
	public Jugador buscaJugadorID(Long id)
	{
		return jugadorRepository.getReferenceById(id);
	}

	// Busca un jugador por la dorsal del jugador.
	public Jugador buscaJugadorDorsal(@RequestParam int dorsal)
	{
		return jugadorRepository.findByDorsal(dorsal);
	}

	// Busca todos los jugadores.
	public List<Jugador> buscaTodosJugadores()
	{
		return jugadorRepository.findAll();
	}

	// Función auxiliar de cambios en jugador.
	private Jugador actualizaJugador(Jugador viejoJugador, Jugador nuevo)
	{
		viejoJugador.setDorsal(nuevo.getDorsal());
		viejoJugador.setGoles(nuevo.getGoles());
		viejoJugador.setNombre(nuevo.getNombre());
		viejoJugador.setTarjetas(nuevo.getTarjetas());

		return viejoJugador;
	}

	// Borrar a partir de dorsal.
	public String borrarPorDorsal(int dorsal)
	{
		if (jugadorRepository.existsByDorsal(dorsal))
		{
			jugadorRepository.deleteByDorsal(dorsal);
			return "Jugador borrado.";
		} else
		{
			return "Jugador no encontrado.";
		}
	}

}
