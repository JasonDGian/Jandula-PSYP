package es.iesjandula.tickets_autopista.tickets;

/**
 * @author Paco Benítez
 */
public interface ITicket
{
	/** 
	 * Registrar salida 
	 *
	 * @param kmSalida con los kilómetros de salida
	 * 
	 */
	public void registrarSalida(int kmSalida) ;
}
