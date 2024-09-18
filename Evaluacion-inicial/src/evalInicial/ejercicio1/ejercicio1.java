package evalInicial.ejercicio1;

import evalInicial.ejercicio1.excepciones.ExcepcionPalabra;
import evalInicial.ejercicio1.excepciones.ExcepcionSopaLetras;

public class ejercicio1 {

	public static void main(String[] args) {

		try {

			// Genera la sopa de letras.
			SopaLetras sopa = new SopaLetras(10);
			// sopa.inicializaAsteriscos();

			// Coloca palabras en la sopa.
			try {
				sopa.colocarPalabraVertical("Conocer", new Coordenada(0, 0), false);
				sopa.colocarPalabraVertical("Formacion", new Coordenada(1, 1), false);
				sopa.colocarPalabraHorizontal("Caracter", new Coordenada(0, 0), false);
				sopa.colocarPalabraHorizontal("Tenor", new Coordenada(3, 1), true);
				sopa.colocarPalabraHorizontal("Disponer", new Coordenada(7, 0), false);
				sopa.colocarPalabraVertical("Tono", new Coordenada(2, 2), false);
				sopa.colocarPalabraVertical("Raton", new Coordenada(0, 2), false);
				sopa.colocarPalabraVertical("Roedor", new Coordenada(0, 7), false);
				sopa.colocarPalabraVertical("Raros", new Coordenada(5, 7), false);
				sopa.colocarPalabraHorizontal("Sol", new Coordenada(9, 7), false);
				sopa.colocarPalabraHorizontal("Negar", new Coordenada(9, 1), false);
				sopa.colocarPalabraHorizontal("Roca", new Coordenada(5, 4), true);
				sopa.colocarPalabraVertical("Sorpresa", new Coordenada(0, 9), false);

			} catch (ExcepcionPalabra e) {
				System.out.println(e.getMessage());

			}

			// Cuarda la sopa en un fichero.
			//sopa.enviarDatosAFichero();

			// Muestra la sopa por pantalla.
			System.out.println(sopa);

			// Muestra el resumen de letras.
			sopa.muestraResumenDeLetras();

			SopaLetras sopa2 = new SopaLetras(10);

			// Carga la sopa de letras desde fichero.
			sopa2.cargarDatosDeFichero();

			// Muestra la sopa (una vez cargada.)
			System.out.println(sopa2);

		} catch (ExcepcionSopaLetras e) {
			System.out.println(e.getMessage());
		}

	}
}
