/**
 * 
 */
package es.iesjandula.sopa_de_letras.exception;

/**
 * @author Paco Benítez
 */
public class SopaLetrasException extends Exception
{
	/**
	 * Default Serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor vacío
	 */
	public SopaLetrasException()
	{
		super() ;
	}
	
	/**
	 * @param mensaje con el mensaje
	 */
	public SopaLetrasException(String mensaje)
	{
		super(mensaje) ;
	}
}
