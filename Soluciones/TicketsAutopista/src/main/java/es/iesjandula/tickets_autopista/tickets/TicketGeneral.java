package es.iesjandula.tickets_autopista.tickets;

import es.iesjandula.tickets_autopista.utils.Constants;

/**
 * @author Paco Benítez
 */
public class TicketGeneral extends Ticket
{
	/**
	 * @param kmEntrada		  con los kilómetros de entrada
	 * @param precioKilometro con el precio por kilómetro
	 */
	public TicketGeneral(int kmEntrada, double precioKilometro)
	{
		super(kmEntrada, precioKilometro) ;
	}
	
	@Override
	protected double calculoDeTarifa()
	{
		// Hay que tener en cuenta que los kilómetros pueden ser en sentido ascendente o descendente
		int diferenciaKilometros = Math.abs(this.getKmSalida() - this.getKmEntrada()) ;
		
		// Resultado parcial
		double resultado 		 = diferenciaKilometros * this.getPrecioKilometro() ;
		
		int cocienteKilometros   = diferenciaKilometros / Constants.REDUCCION_GENERAL_KM_MIN ;
		if (cocienteKilometros > 0)
		{
			resultado = resultado - (resultado * Constants.REDUCCION_GENERAL_PORCENTAJE) ;
		}
		
		return resultado ;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (!super.equals(obj))
		{
			return false ;
		}
		else if (obj == null)
		{
			return false ;
		}
		else if (this == obj)
		{
			return true ;
		}
		else if (!(obj instanceof TicketGeneral))
		{
			return false ;
		}
		
		return true ;
	}
	
	@Override
	public String toString()
	{
		return "TicketGeneral [Ticket: " + super.toString() + "]" ;
	}
}
