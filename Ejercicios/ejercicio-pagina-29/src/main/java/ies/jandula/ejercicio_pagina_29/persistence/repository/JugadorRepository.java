package ies.jandula.ejercicio_pagina_29.persistence.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ies.jandula.ejercicio_pagina_29.persistence.entity.Jugador;
import jakarta.transaction.Transactional;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long>
{
	
	// Metodo de busqueda personalizado. (nombre por convencion)
	// Parece que no hace falta implementar el metodo en cuestión y dejar que Sprind Data se encargue de todo. 
	// Flipante.
	Jugador findByDorsal( int dorsal);
	
	
	// Metodo vacio porque no devuelve nada (duh) -> Transactional porque debe de estar envuelto en transaccion sql.
	@Transactional
	void deleteByDorsal( int dorsal ); 
	

	// TODO:  Controlar si esto se implementa.
	boolean existsByDorsal( int dorsal);
}
