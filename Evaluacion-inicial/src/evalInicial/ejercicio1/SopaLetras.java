package evalInicial.ejercicio1;

import java.util.HashMap;
import java.util.Random;

import evalInicial.ejercicio1.excepciones.ExcepcionPalabra;
import evalInicial.ejercicio1.excepciones.ExcepcionSopaLetras;

public class SopaLetras {

	private char[][] tabla;

	// Constructor
	SopaLetras(int numChars) throws ExcepcionSopaLetras {

		if (numChars < 0) {

			throw new ExcepcionSopaLetras("La tabla no puede tener tamaño inferior o igual a 0");

		} else if (numChars > 0) {

			tabla = new char[numChars][numChars];
			this.inicializaLetras();
		}

		else {
			numChars = 5;
			this.inicializaAsteriscos();
		}
	}

	// Metodo que coloca una palabra horizontal.
	public void colocarPalabraHorizontal(String palabra, Coordenada coordenada, boolean Inverso)
			throws ExcepcionPalabra {

		// Si la longitud de la palabra supera los espacios disponibles.
		if (palabra.length() > (this.tabla[coordenada.altitud].length - coordenada.latitud)) {
			throw new ExcepcionPalabra("ERROR: La palabra excede el tamaño en la tabla.");
		}

		palabra = palabra.toUpperCase();

		if (Inverso) {
			palabra = invertirPalabra(palabra);
		}

		int indiceLetra = 0;
		for (int posicionLetra = coordenada.latitud; indiceLetra < palabra.length(); posicionLetra++) {

			tabla[coordenada.altitud][posicionLetra] = palabra.charAt(indiceLetra);
			indiceLetra++;
		}

	}

	// Metodo que coloca una palabra vertical.
	public void colocarPalabraVertical(String palabra, Coordenada coordenada, boolean Inverso) throws ExcepcionPalabra {

		// Si la longitud de la palabra supera los espacios disponibles.
		if (palabra.length() > (this.tabla.length - coordenada.altitud)) {
			throw new ExcepcionPalabra("ERROR: La palabra excede el tamaño en la tabla.");
		}

		palabra = palabra.toUpperCase();

		if (Inverso) {
			palabra = invertirPalabra(palabra);
		}

		int indiceLetra = 0;
		for (int posicionLetra = coordenada.altitud; indiceLetra < palabra.length(); posicionLetra++) {

			tabla[posicionLetra][coordenada.latitud] = palabra.charAt(indiceLetra);
			indiceLetra++;
		}

	}

	// Metodo que recibe una palabra y devuelve esa misma palabra con caracteres en
	// orden inverso.
	public static String invertirPalabra(String palabra) {
		StringBuilder palabraInversa = new StringBuilder(palabra);
		return palabraInversa.reverse().toString();
	}

	// Sobre-escribe todas posiciones de la tabla con asteriscos.
	public void inicializaAsteriscos() {
		for (int fila = 0; fila < this.tabla.length; fila++) {
			for (int columna = 0; columna < this.tabla[fila].length; columna++) {
				tabla[fila][columna] = '*';
			}
		}
	}

	// Sobre-escribe todas posiciones de la tabla con caracteres aleatorios.
	public void inicializaLetras() {

		Random rand = new Random();

		char letraRandom;

		for (int fila = 0; fila < this.tabla.length; fila++) {

			for (int columna = 0; columna < this.tabla[fila].length; columna++) {
				letraRandom = (char) (rand.nextInt(26) + 'A');
				tabla[fila][columna] = letraRandom;
			}
		}
	}

	// Muestra un recuento de cuantas veces aparece cada caracter.
	public void muestraResumenDeLetras() {

		HashMap<Character, Integer> recuentoLetras = new HashMap<>();

		for (int columna = 0; columna < this.tabla.length; columna++) {

			for (int fila = 0; fila < this.tabla[columna].length; fila++) {

				if (recuentoLetras.containsKey(this.tabla[columna][fila])) {

					// logica de auemntar valor asociado a clave.
					recuentoLetras.put(this.tabla[columna][fila], recuentoLetras.get(this.tabla[columna][fila]) + 1);

				}

				else {
					// logica de introducir clave con valor inicializado a 1
					recuentoLetras.put(this.tabla[columna][fila], 1);
				}

			}

		}

		System.out.println(recuentoLetras);

	}

	/*
	Convierte el contenido de la variable 'tabla' en una cadena de caracteres con
	formato legible y ordenado.
	*/
	@Override
	public String toString() {

		StringBuilder cadenaSopa = new StringBuilder();

		for (int i = 0; i < this.tabla.length; i++) {

			for (int j = 0; j < this.tabla[i].length; j++) {

				cadenaSopa.append(this.tabla[i][j] + "  ");

			}

			cadenaSopa.append("\n");

		}

		return cadenaSopa.toString();

	}

}
