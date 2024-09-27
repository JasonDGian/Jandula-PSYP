package es.pacobenitezchico.eurovision.exceptions;

/**
 * @author Paco Benítez
 */
public class EurovisionException extends Exception
{
	/** Atributo - Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor vacío
	 */
	public EurovisionException()
	{
		super() ;
	}
	
	/**
	 * @param mensaje con el mensaje
	 */
	public EurovisionException(String mensaje)
	{
		super(mensaje) ;
	}
}
