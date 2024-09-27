package es.iesjandula.sopa_de_letras;

import java.util.Map;

import es.iesjandula.sopa_de_letras.exception.SopaLetrasException;
import es.iesjandula.sopa_de_letras.modelos_de_datos.Coordenada;
import es.iesjandula.sopa_de_letras.modelos_de_datos.SopaLetras;

/**
 * @author router
 *
 */
public class Launcher
{
	/**
	 * Comienza el juego
	 */
	private void comienzaJuego()
	{
		SopaLetras sopaLetras = null ;
		
		try
		{
			sopaLetras = new SopaLetras(5) ;
			
			sopaLetras.colocarPalabraHorizontal("PEPE", new Coordenada(0, 0, true)) ;
			sopaLetras.colocarPalabraVertical("HOLA", new Coordenada(0, 4, true)) ;
			sopaLetras.colocarPalabraVertical("GATO", new Coordenada(1, 0, true)) ;
			sopaLetras.colocarPalabraHorizontal("OLA", new Coordenada(1, 3, false)) ;
			sopaLetras.colocarPalabraHorizontal("ANI", new Coordenada(2, 3, false)) ;
			sopaLetras.colocarPalabraVertical("SI", new Coordenada(3, 1, true)) ;
			sopaLetras.colocarPalabraVertical("NO", new Coordenada(4,2, false)) ;
			sopaLetras.colocarPalabraVertical("A", new Coordenada(3,3, false)) ;
			sopaLetras.colocarPalabraHorizontal("AS", new Coordenada(4,4, false)) ;
			
			Map<Character, Integer> mapa = sopaLetras.mostrarResumenDeLetras() ;
			System.out.println(mapa) ;
			
			System.out.println(sopaLetras) ;
			
		}
		catch (SopaLetrasException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Main
	 */
	public static void main(String[] args)
	{
		Launcher launcher = new Launcher() ;
		
		launcher.comienzaJuego() ;
	}
}
