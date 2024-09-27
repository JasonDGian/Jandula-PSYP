/**
 * 
 */
package es.iesjandula.sopa_de_letras.modelos_de_datos;

/**
 * @author Paco Benítez
 */
public class Coordenada
{
	/** Atributo - Fila */
	private int fila ;
	
	/** Atributo - Columna */
	private int columna ;
	
	/** Atributo - Orden Natural */
	private boolean ordenNatural ;

	/**
	 * @param fila	  	   con la fila
	 * @param columna 	   con la columna
	 * @param ordenNatural a true si el sentido es natural
	 */
	public Coordenada(int fila, int columna, boolean ordenNatural)
	{
		this.fila    	  = fila ;
		this.columna 	  = columna ;
		this.ordenNatural = ordenNatural ;
	}

	public int getFila()
	{
		return this.fila ;
	}

	/**
	 * @return con la columna
	 */
	public int getColumna()
	{
		return this.columna ;
	}
	
	public boolean isOrdenNatural()
	{
		return this.ordenNatural ;
	}
}
