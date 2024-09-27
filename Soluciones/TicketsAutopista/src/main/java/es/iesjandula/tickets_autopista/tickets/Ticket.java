package es.iesjandula.tickets_autopista.tickets;

/**
 * @author Paco Benítez
 */
public abstract class Ticket implements ITicket
{
	/** Atributo - Kilómetro de entrada */
	private int kmEntrada ;
	
	/** Atributo - Kilómetro de salida */
	private int kmSalida ;
	
	/** Atributo - Precio por kilómetro */
	private double precioKilometro ;
	
	/** Atributo - Tarifa final */
	private double tarifaFinal ;

	/**
	 * @param kmEntrada		  con los kilómetros de entrada
	 * @param precioKilometro con el precio por kilómetro
	 */
	protected Ticket(int kmEntrada, double precioKilometro)
	{
		this.kmEntrada 		 = kmEntrada ;
		this.precioKilometro = precioKilometro ;
		
		this.kmSalida		 = -1 ;
		this.tarifaFinal	 = -1 ;
	}
	
	/**
	 * Registrar salida
	 * 
	 * @param kmSalida con el kilómetro de salida
	 */
	public void registrarSalida(int kmSalida)
	{
		// Asigno el kilométro de salida
		this.kmSalida 	 = kmSalida ;
		
		// Calculo de la tarifa final en base a las hijas
		this.tarifaFinal = this.calculoDeTarifa() ;
	}
	
	/**
	 * @return la tarifa final
	 */
	protected abstract double calculoDeTarifa() ;

	/**
	 * @return kilómetros de entrada
	 */
	protected int getKmEntrada()
	{
		return this.kmEntrada ;
	}

	/**
	 * @return kilómetros de salida
	 */
	protected int getKmSalida()
	{
		return this.kmSalida ;
	}

	/**
	 * @return precio del kilómetro
	 */
	protected double getPrecioKilometro()
	{
		return this.precioKilometro ;
	}

	/**
	 * @return la tarifa final
	 */
	public double getTarifaFinal()
	{
		return this.tarifaFinal ;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false ;
		}
		else if (this == obj)
		{
			return true ;
		}
		else if (!(obj instanceof Ticket))
		{
			return false ;
		}
		
		Ticket other = (Ticket) obj ;
		
		if (this.kmEntrada != other.kmEntrada)
		{
			return false ;
		}
		else if (this.kmSalida != other.kmSalida)
		{
			return false ;
		}
		else if (this.precioKilometro != other.precioKilometro)
		{
			return false ;
		}
		else if (this.tarifaFinal != other.tarifaFinal)
		{
			return false ;
		}
		
		return true ;
	}

	@Override
	public String toString()
	{
		return "Ticket [kmEntrada=" + this.kmEntrada + ", kmSalida=" + this.kmSalida + ", precioKilometro=" + this.precioKilometro + ", tarifaFinal=" + this.tarifaFinal + "]";
	}	
}
