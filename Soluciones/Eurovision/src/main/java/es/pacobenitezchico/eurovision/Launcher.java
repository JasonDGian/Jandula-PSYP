package es.pacobenitezchico.eurovision;

/**
 * @author Paco Benítez
 */
public class Launcher 
{
	/**
	 * @param args con los argumentos de entrada
	 */
	public static void main(String[] args)
	{
		// Nueva instancia de eurovision
		Eurovision eurovision = new Eurovision() ;
		
		// Comienza el concurso!
		eurovision.comienzaConcurso() ;
		
		// Imprimir listado por orden alfabético
		eurovision.imprimirListadoPorOrdenAlfabetico() ;
		
		// Impirmir listado de puntuaciones de altas a bajas
		eurovision.imprimirListadoDePuntuacionesDeAltasABajas() ;
	}
}
