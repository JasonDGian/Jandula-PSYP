package es.iesjandula.sopa_de_letras.modelos_de_datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.iesjandula.sopa_de_letras.exception.SopaLetrasException;
import es.iesjandula.sopa_de_letras.utils.Constants;

/**
 * @author Paco Benítez
 */
public class SopaLetras
{
	/** Atributo - Longitud filas y columnas */
	private int longitudFilasColumnas ;
	
	/** Atributo - Tablero */
	private List<List<Character>> tablero ;
	
	/**
	 * @param longitudFilasColumnas con la longitud filas y columnas del tablero
	 * @throws SopaLetrasException con la exception
	 */
	public SopaLetras(int longitudFilasColumnas) throws SopaLetrasException
	{
		if (longitudFilasColumnas <= 0)
		{
			throw new SopaLetrasException("La longitud de filas debe ser mayor que cero") ;
		}
		
		this.longitudFilasColumnas = longitudFilasColumnas ;
		
		// Inicializa el array
		this.tablero 			   = new ArrayList<List<Character>>() ;
		
		// Inicializa el tablero
		this.inicializaTablero() ;
	}

	/**
	 * Inicialización del tablero
	 */	
	private void inicializaTablero()
	{
		for (int i=0 ; i < this.longitudFilasColumnas ; i++)
		{
			List<Character> columna = new ArrayList<Character>() ;
			
			for (int j=0 ; j < this.longitudFilasColumnas ; j++)
			{
				columna.add(Constants.VALOR_POR_DEFECTO_TABLERO) ;
			}
			
			this.tablero.add(columna) ;
		}
	}
	
	/**
	 * @param palabra con la palabra
	 * @param coordenada con la coordenada
	 * @throws SopaLetrasException con la excepcion
	 */
	public void colocarPalabraHorizontal(String palabra, Coordenada coordenada) throws SopaLetrasException
	{
		if (palabra == null || palabra.isEmpty())
		{
			throw new SopaLetrasException("La palabra a introducir debe estar rellena") ;
		}
		else if (coordenada.isOrdenNatural() && (coordenada.getColumna() + palabra.length() - 1 >= this.longitudFilasColumnas))
		{
			throw new SopaLetrasException("La palabra '" + palabra + "' no cabe en el tablero de forma horizontal en orden natural") ;
		}
		else if (!coordenada.isOrdenNatural() && (palabra.length() - 1 - coordenada.getColumna() > 0))
		{
			throw new SopaLetrasException("La palabra '" + palabra + "' no cabe en el tablero de forma horizontal en orden inverso") ;
		}
		else if (coordenada.isOrdenNatural())
		{
			this.colocarPalabraHorizontalOrdenNatural(palabra, coordenada) ;
		}
		else
		{
			this.colocarPalabraHorizontalOrdenInverso(palabra, coordenada) ;	
		}
	}

	/**
	 * @param palabra con la palabra
	 * @param coordenada con la coordenada
	 * @throws SopaLetrasException con la excepcion
	 */
	private void colocarPalabraHorizontalOrdenNatural(String palabra, Coordenada coordenada) throws SopaLetrasException
	{
		// Chequear si alguna posición está rellena
		for (int i = 0 ; i < palabra.length() ; i++)
		{
			if (!this.tablero.get(coordenada.getFila()).get(coordenada.getColumna()+i).equals(Constants.VALOR_POR_DEFECTO_TABLERO))
			{
				throw new SopaLetrasException("La palabra '" + palabra + "' no puede rellenarse en la posición [" + coordenada.getFila() + ", " + coordenada.getColumna() + "], ya que existe un valor") ;
			}
		}
		
		for (int i = 0 ; i < palabra.length() ; i++)
		{
            this.tablero.get(coordenada.getFila()).set(coordenada.getColumna()+i, palabra.charAt(i)) ;
        }
	}
	
	/**
	 * @param palabra con la palabra
	 * @param coordenada con la coordenada
	 * @throws SopaLetrasException con la excepcion
	 */
	private void colocarPalabraHorizontalOrdenInverso(String palabra, Coordenada coordenada) throws SopaLetrasException
	{
		// Chequear si alguna posición está rellena
		for (int i = palabra.length() - 1 ; i >= 0 ; i--)
		{
			if (!this.tablero.get(coordenada.getFila()).get(coordenada.getColumna()-i).equals(Constants.VALOR_POR_DEFECTO_TABLERO))
			{
				throw new SopaLetrasException("La palabra '" + palabra + "' no puede rellenarse en la posición [" + coordenada.getFila() + ", " + coordenada.getColumna() + "], ya que existe un valor") ;
			}
		}
		
		for (int i = palabra.length() - 1 ; i >= 0 ; i--)
		{
            this.tablero.get(coordenada.getFila()).set(coordenada.getColumna()-i, palabra.charAt(i)) ;
        }
	}
	
	/**
	 * @param palabra con la palabra
	 * @param coordenada con la coordenada
	 * @throws SopaLetrasException con la excepcion
	 */
	public void colocarPalabraVertical(String palabra, Coordenada coordenada) throws SopaLetrasException
	{
		if (palabra == null || palabra.isEmpty())
		{
			throw new SopaLetrasException("La palabra a introducir debe estar rellena") ;
		}
		else if (coordenada.isOrdenNatural() && (coordenada.getFila() + palabra.length() - 1 >= this.longitudFilasColumnas))
		{
			throw new SopaLetrasException("La palabra '" + palabra + "' no cabe en el tablero de forma vertical en orden natural") ;
		}
		else if (!coordenada.isOrdenNatural() && (palabra.length() - 1 - coordenada.getFila() > 0))
		{
			throw new SopaLetrasException("La palabra '" + palabra + "' no cabe en el tablero de forma vertical en orden inverso") ;
		}
		else if (coordenada.isOrdenNatural())
		{
			this.colocarPalabraVerticalOrdenNatural(palabra, coordenada) ;
		}
		else
		{
			this.colocarPalabraVerticalOrdenInverso(palabra, coordenada) ;	
		}
	}
	
	/**
	 * @param palabra con la palabra
	 * @param coordenada con la coordenada
	 * @throws SopaLetrasException con la excepcion
	 */
	private void colocarPalabraVerticalOrdenNatural(String palabra, Coordenada coordenada) throws SopaLetrasException
	{
		// Chequear si alguna posición está rellena
		for (int i = 0 ; i < palabra.length() ; i++)
		{
			if (!this.tablero.get(coordenada.getFila()+i).get(coordenada.getColumna()).equals(Constants.VALOR_POR_DEFECTO_TABLERO))
			{
				throw new SopaLetrasException("La palabra '" + palabra + "' no puede rellenarse en la posición [" + coordenada.getFila() + ", " + coordenada.getColumna() + "], ya que existe un valor") ;
			}
		}
		
		for (int i = 0 ; i < palabra.length() ; i++)
		{
            this.tablero.get(coordenada.getFila()+i).set(coordenada.getColumna(), palabra.charAt(i)) ;
        }
	}
	
	/**
	 * @param palabra con la palabra
	 * @param coordenada con la coordenada
	 * @throws SopaLetrasException con la excepcion
	 */
	private void colocarPalabraVerticalOrdenInverso(String palabra, Coordenada coordenada) throws SopaLetrasException
	{
		// Chequear si alguna posición está rellena
		for (int i = palabra.length() - 1 ; i >= 0 ; i--)
		{
			if (!this.tablero.get(coordenada.getFila()-i).get(coordenada.getColumna()).equals(Constants.VALOR_POR_DEFECTO_TABLERO))
			{
				throw new SopaLetrasException("La palabra '" + palabra + "' no puede rellenarse en la posición [" + coordenada.getFila() + ", " + coordenada.getColumna() + "], ya que existe un valor") ;
			}
		}
		
		for (int i = palabra.length() - 1 ; i >= 0 ; i--)
		{
            this.tablero.get(coordenada.getFila()-i).set(coordenada.getColumna(), palabra.charAt(i)) ;
        }
	}
	
	/**
	 * @return un mapa resumen con el número de veces que aparece cada carácter
	 */
	public Map<Character, Integer> mostrarResumenDeLetras()
	{
		Map<Character, Integer> mapa = new HashMap<Character, Integer>() ;
		
		for (int i=0 ; i < this.longitudFilasColumnas ; i++)
		{
			for (int j=0 ; j < this.longitudFilasColumnas ; j++)
			{
				char caracter			 = this.tablero.get(i).get(j) ;
				Integer numeroCaracteres = mapa.get(caracter) ;
				
				if (numeroCaracteres == null)
				{
					mapa.put(caracter, 1) ;
				}
				else
				{
					mapa.put(caracter, numeroCaracteres + 1) ;
				}
			}
		}
		
		return mapa ;
	}
	
	@Override
	public String toString()
	{
		String representacion = "" ;
		
		for (int i=0 ; i < this.longitudFilasColumnas ; i++)
		{
			String representacionFila = "" ;
			
			for (int j=0 ; j < this.longitudFilasColumnas ; j++)
			{
				representacionFila = representacionFila + " " + this.tablero.get(i).get(j) ;
			}
			
			representacion = representacion + representacionFila + "\n" ;
		}
		
		return representacion ;
	}
}
