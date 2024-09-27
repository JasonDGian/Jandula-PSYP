package es.iesjandula.tickets_autopista.tickets;

import es.iesjandula.tickets_autopista.utils.Constants;

/**
 * @author Paco Benítez
 */
public class TicketEspecial extends Ticket
{
	/** Atributo - Número de pasajeros */
	private int numeroPasajeros ;
	
	/**
	 * @param kmEntrada		  con los kilómetros de entrada
	 * @param precioKilometro con el precio por kilómetro
	 * @param numeroPasajeros con el número de pasajeros
	 */
	public TicketEspecial(int kmEntrada, double precioKilometro, int numeroPasajeros)
	{
		super(kmEntrada, precioKilometro) ;
		
		this.numeroPasajeros = numeroPasajeros ;
	}

	@Override
	protected double calculoDeTarifa()
	{
		// Hay que tener en cuenta que los kilómetros pueden ser en sentido ascendente o descendente
		int diferenciaKilometros = Math.abs(this.getKmSalida() - this.getKmEntrada()) ;
		
		// Resultado parcial
		double resultado 		 = this.numeroPasajeros * diferenciaKilometros * this.getPrecioKilometro() ;

		if (diferenciaKilometros >= Constants.REDUCCION_AUTOBUSES_KM_MIN)
		{
			resultado = resultado - (resultado * Constants.REDUCCION_AUTOBUSES_PORCENTAJE) ;
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
		else if (!(obj instanceof TicketEspecial))
		{
			return false ;
		}
		
		TicketEspecial other = (TicketEspecial) obj ;
		
		return numeroPasajeros == other.numeroPasajeros ;
	}

	@Override
	public String toString()
	{
		return "TicketEspecial [Ticket: " + super.toString() + ", numeroPasajeros=" + this.numeroPasajeros + "]" ;
	}
}
