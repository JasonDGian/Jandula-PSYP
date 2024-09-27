package es.pacobenitezchico.eurovision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import es.pacobenitezchico.eurovision.exceptions.EurovisionException;
import es.pacobenitezchico.eurovision.utils.Constants;
import es.pacobenitezchico.eurovision.utils.Pais;

import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Paco Benítez
 *
 */
public class Eurovision
{
	/** Atributo - Mapa de puntuaciones finales */
	private Map<Integer, List<Pais>> mapaPuntuacionesFinales ;
	
	/** Atributo - Lista de países finalistas */
	private List<Pais> paisesFinalistas ;
	
	/** Atributo - Lista de países no clasificados */
	private List<Pais> paisesNoClasificados ;
	
	/**
	 * Constructor por defecto
	 */
	public Eurovision() 
	{
		this.mapaPuntuacionesFinales = new TreeMap<Integer, List<Pais>>(Collections.reverseOrder()) ;
		this.paisesFinalistas 		 = new ArrayList<Pais>() ;
		this.paisesNoClasificados 	 = new ArrayList<Pais>() ;
		
		// Inicializa la lista de países
		this.inicializarListaDePaises() ;
		
		// Ordena la lista de países finalistas
		Collections.sort(this.paisesFinalistas) ;
	}
	
	/**
	 * Inicializar lista de países
	 */
	private void inicializarListaDePaises()
	{
		// Países finalistas
		
		
		// País organizador
		this.paisesFinalistas.add(new Pais(Constants.PAIS_ORGANIZADOR)) ;
		
		// Big Five
		for (String bigFiveItem: Constants.BIG_FIVE) 
		{
			this.paisesFinalistas.add(new Pais(bigFiveItem)) ;
		}
		
		// Resto de paises
		for (String restoPaisesItem: Constants.RESTO_PAISES_FINAL) 
		{
			this.paisesFinalistas.add(new Pais(restoPaisesItem)) ;
		}
		
		
		// Países no clasificados
		
		
		for (String restoPaises: Constants.PAISES_NO_CLASIFICADOS) 
		{
			this.paisesNoClasificados.add(new Pais(restoPaises)) ;
		}
	}
	
	/**
	 * Comienza concurso!
	 */
	public void comienzaConcurso()
	{
		// Comienza las votaciones de los países no finalistas
		this.comienzaVotacionesPaisesNoFinalistas() ;
		
		// Comienza las votaciones de los países finalistas
		this.comienzaVotacionesPaisesFinalistas() ;
		
		// Crear mapa con puntuaciones finales
		this.crearMapaConPuntuacionesFinales() ;
	}

	/**
	 * Comienza votaciones de los países no finalistas
	 */
	private void comienzaVotacionesPaisesNoFinalistas()
	{
		// Para cada país no clasificado ...
		for (Pais paisNoClasificado : this.paisesNoClasificados) 
		{
			// ... y para todos los puntos de ese país ...
			for (int puntos : Constants.PUNTUACIONES)
			{
				// Genera aleatoriamente un país y añádele esos puntos
				this.generaPaisAleatorioYVotar(paisNoClasificado, puntos) ;
			}
		}		
	}

	/**
	 * Comienza votaciones de los países no finalistas
	 */
	private void comienzaVotacionesPaisesFinalistas()
	{
		// Para cada país finalista ...
		for (Pais paisFinalista : this.paisesFinalistas) 
		{
			// ... y para todos los puntos de ese país ...
			for (int puntos : Constants.PUNTUACIONES)
			{
				// Genera aleatoriamente un país y añádele esos puntos
				this.generaPaisAleatorioYVotar(paisFinalista, puntos) ;
			}
		}
	}
	
	/**
	 * @param paisVotante con el pais que vota
	 * @param puntos      con los puntos que vota
	 */
	private void generaPaisAleatorioYVotar(Pais paisVotante, int puntos)
	{
		// Nueva instancia de random
		Random random 			 = new Random() ;
		
		// Booleano que controlará cuando terminar esta votación
		boolean votacionCorrecta = false ;
		
		while (!votacionCorrecta)
		{
			// Genera un número aleatorio entre los paises finalistas
			int indiceListaPaisElegido = random.nextInt(this.paisesFinalistas.size()) ;
			
			try
			{
				// Cojo al país aleatorio del array
				Pais paisElegido = this.paisesFinalistas.get(indiceListaPaisElegido) ;
						
				// Intento hacer la votación
				paisVotante.votarPais(puntos, paisElegido) ;
				
				// Si llega aquí es porque todo fue bien
				votacionCorrecta = true ;
			}
			catch (EurovisionException eurovisionException)
			{
				System.out.println("Debemos votar de nuevo ya que hubo un error en esta votación: " + eurovisionException.getMessage()) ;
			}
		}
	}
	
	/**
	 * Crear mapa con puntuaciones finales
	 */
	private void crearMapaConPuntuacionesFinales()
	{
		// Para los países finalistas ...
		for (Pais paisFinalista : this.paisesFinalistas)
		{
			// Verifico si existe ya una lista con países con estos puntos
			List<Pais> paisesConEstosPuntos = this.mapaPuntuacionesFinales.get(paisFinalista.getTotalPuntuacionesObtenidas()) ;
			
			// Si no existe la lista ...
			if (paisesConEstosPuntos == null)
			{
				// ... la creo ...
				paisesConEstosPuntos = new ArrayList<Pais>() ;
				
				// ... y la añado al mapa
				this.mapaPuntuacionesFinales.put(paisFinalista.getTotalPuntuacionesObtenidas(), paisesConEstosPuntos) ;
			}
			
			// Añado el país a la lista
			paisesConEstosPuntos.add(paisFinalista) ;
		}
	}
	
	/**
	 * Imprimir listado por orden alfabético
	 */
	public void imprimirListadoPorOrdenAlfabetico()
	{
		System.out.println("IMPRIMIENDO LISTADO POR ORDEN ALFABÉTICO...") ;
		
		for (Pais pais : this.paisesFinalistas)
		{
			System.out.println(pais) ;
		}
		
		System.out.println("LISTADO POR ORDEN ALFABÉTICO FINALIZADO") ;
	}

	/**
	 * Imprimir listado de puntuaciones de altas a bajas
	 */
	public void imprimirListadoDePuntuacionesDeAltasABajas()
	{
		System.out.println("IMPRIMIENDO LISTADO POR ORDEN DE PUNTUACIÓN...") ;
		
		Set<Entry<Integer, List<Pais>>> entries = this.mapaPuntuacionesFinales.entrySet() ;
		
		for (Entry<Integer, List<Pais>> entry : entries)
		{ 
			System.out.println(entry.getValue()) ;
		}
		
		System.out.println("LISTADO POR ORDEN DE PUNTUACIÓN FINALIZADO") ;
	}
}
