package es.iesjandula.tickets_autopista;

import es.iesjandula.tickets_autopista.tickets.Ticket;
import es.iesjandula.tickets_autopista.tickets.TicketEspecial;
import es.iesjandula.tickets_autopista.tickets.TicketGeneral;

/**
 * @author Paco Benítez
 */
public class Launcher
{
	/** Constante - Precio KM - Autopista de Estepona */
	private static final double PRECIO_KM_AUTOPISTA_ESTEPONA = 0.14 ;

	/** Constante - Precio KM - Autopista de Barcelona - Valencia */
	private static final double PRECIO_KM_AUTOPISTA_BAR_VAL  = 0.09 ;
	
	/** Constante - Precio KM - Autopista Ficticia */
	private static final double PRECIO_KM_AUTOPISTA_FICTICIA = 0.06 ;
	
	/**
	 * Comparativa de los tickets especial y general por menos de 100 km
	 */
	public void comparativaTicketEspecialYGeneralPorMenosDe100Km()
	{
		Ticket ticketTurismo = new TicketGeneral(100, PRECIO_KM_AUTOPISTA_ESTEPONA) ;
		
		ticketTurismo.registrarSalida(170) ;
		System.out.println("La tarifa de este turismo es: " + ticketTurismo.getTarifaFinal()) ;
		
		Ticket ticketAutobus = new TicketEspecial(100, PRECIO_KM_AUTOPISTA_ESTEPONA, 60) ;
		
		ticketAutobus.registrarSalida(170) ;
		System.out.println("La tarifa de este autobus es: " + ticketAutobus.getTarifaFinal()) ;
	}
	
	/**
	 * Comparativa de los tickets especial y general por más de 100 km
	 */
	public void comparativaTicketEspecialYGeneralPorMasDe100Km()
	{
		Ticket ticketTurismo = new TicketGeneral(100, PRECIO_KM_AUTOPISTA_BAR_VAL) ;
		
		ticketTurismo.registrarSalida(421) ;
		System.out.println("La tarifa de este turismo es: " + ticketTurismo.getTarifaFinal()) ;
		
		Ticket ticketAutobus = new TicketEspecial(100, PRECIO_KM_AUTOPISTA_BAR_VAL, 60) ;
		
		ticketAutobus.registrarSalida(421) ;
		System.out.println("La tarifa de este autobus es: " + ticketAutobus.getTarifaFinal()) ;
	}
	
	/**
	 * Comparativa de los tickets especial y general por más de 100 km
	 */
	public void comparativaTicketEspecialYGeneralPorMasDe500Km()
	{
		Ticket ticketTurismo = new TicketGeneral(100, PRECIO_KM_AUTOPISTA_FICTICIA) ;
		
		ticketTurismo.registrarSalida(1200) ;
		System.out.println("La tarifa de este turismo es: " + ticketTurismo.getTarifaFinal()) ;
		
		Ticket ticketAutobus = new TicketEspecial(100, PRECIO_KM_AUTOPISTA_FICTICIA, 60) ;
		
		ticketAutobus.registrarSalida(1200) ;
		System.out.println("La tarifa de este autobus es: " + ticketAutobus.getTarifaFinal()) ;
	}
	
	/**
	 * Main para realizar pruebas
	 */
	public static void main(String[] args)
	{
		Launcher launcher = new Launcher() ;
		
		launcher.comparativaTicketEspecialYGeneralPorMenosDe100Km() ;
		
		launcher.comparativaTicketEspecialYGeneralPorMasDe100Km() ;
		
		launcher.comparativaTicketEspecialYGeneralPorMasDe500Km() ;
	}
}
