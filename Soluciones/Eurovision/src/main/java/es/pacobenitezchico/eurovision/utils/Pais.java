package es.pacobenitezchico.eurovision.utils;

import java.util.HashMap;
import java.util.Map;

import es.pacobenitezchico.eurovision.exceptions.EurovisionException;

/**
 * @author Paco Benítez
 */
public class Pais implements Comparable<Pais>
{
	/** Atributo - Nombre del país */
	private String nombre ;
	
	/** Atributo - Total de puntuaciones obtenidas */
	private int totalPuntuacionesObtenidas ;
	
	/** Atributo - Mis votaciones a otros países */
	private Map<Integer, Pais> misVotaciones ;
	
	/**
	 * @param nombre con el nombre del país
	 */
	public Pais(String nombre) 
	{
		this.nombre 					= nombre ;
		this.totalPuntuacionesObtenidas = 0 ;
		this.misVotaciones 				= new HashMap<Integer, Pais>() ;
	}

	/**
	 * @return el nombre de mi país
	 */
	public String getNombre() 
	{
		return this.nombre ;
	}

	/**
	 * @return el total de puntuaciones obtenidas
	 */
	public int getTotalPuntuacionesObtenidas()
	{
		return this.totalPuntuacionesObtenidas ;
	}
	
	/**
	 * @return un mapa con mis votaciones
	 */
	public Map<Integer, Pais> getMisVotaciones() 
	{
		return this.misVotaciones ;
	}

	/**
	 * @param puntos con los puntos a sumarme
	 */
	private void sumarAMisPuntos(int puntos) 
	{
		this.totalPuntuacionesObtenidas += puntos ;
	}
	
	/**
	 * @param puntos con los puntos a votar a un país determinado
	 * @param pais	 con el país a votar
	 * @throws EurovisionException con una excepción
	 */
	public void votarPais(int puntos, Pais pais) throws EurovisionException
	{
		// Verificar que no soy yo el país
		if (this.nombre.equalsIgnoreCase(pais.getNombre()))
		{
			throw new EurovisionException(this.nombre + " está intentándose votar a si mismo") ;
		}
		
		// Verificar si ya usé estos puntos
		if (this.misVotaciones.containsKey(puntos)) 
		{
			throw new EurovisionException(this.nombre + " ya usó " + puntos + " previamente") ;
		}
		
		// Verificar si ya voté a este país
		if (this.misVotaciones.containsValue(pais)) 
		{
			throw new EurovisionException(this.nombre + " ya votó previamente a " + pais.getNombre()) ;	
		}
		
		// Introducir en el mapa si no hay excepción
		this.misVotaciones.put(puntos, pais) ;
		
		// Sumo a los puntos de dicho pais
		pais.sumarAMisPuntos(puntos) ;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) 
		{
			return true ;
		}
		else if (obj == null) 
		{
			return false ;
		}
		if (!(obj instanceof Pais)) 
		{
			return false ;
		}
		
		Pais other = (Pais) obj ;
				
		return this.nombre.equals(other.nombre) ;
	}
	
	@Override
	public int hashCode() 
	{
		return this.nombre.hashCode() ;
	}

	/**
	 * @param pais con el pais a comparar
	 */
	public int compareTo(Pais pais)
	{
		return this.nombre.compareTo(pais.getNombre()) ;
	}
	
	@Override
	public String toString()
	{
		return this.nombre + ":" + this.totalPuntuacionesObtenidas ;
	}
}
