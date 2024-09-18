package evalInicial.ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import evalInicial.ejercicio1.excepciones.ExcepcionPalabra;
import evalInicial.ejercicio1.excepciones.ExcepcionSopaLetras;

public class SopaLetras {

	private char[][] tabla;

	// Constructor
	SopaLetras(int numChars) throws ExcepcionSopaLetras {

		if (numChars <= 0) {
			throw new ExcepcionSopaLetras("La tabla no puede tener tamaño inferior o igual a 0");
		} else {
			tabla = new char[numChars][numChars];
			this.inicializaLetras();
		}
	}

	// Introduce una palabra en la sopa de letras si cabe. De no caber, lanza una
	// excepción.
	public void colocarPalabraHorizontal(String palabra, Coordenada coordenada, boolean Inverso)
			throws ExcepcionPalabra {

		// Si la longitud de la palabra supera los espacios disponibles.
		if (palabra.length() > (this.tabla[coordenada.altitud].length - coordenada.latitud)) {
			throw new ExcepcionPalabra("ERROR: La palabra " + palabra + " excede el tamaño en la tabla.");
		}

		else {
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
	}

	// Metodo que coloca una palabra vertical.
	public void colocarPalabraVertical(String palabra, Coordenada coordenada, boolean Inverso) throws ExcepcionPalabra {

		// Si la longitud de la palabra supera los espacios disponibles.
		if (palabra.length() > (this.tabla.length - coordenada.altitud)) {
			throw new ExcepcionPalabra("ERROR: La palabra " + palabra + " excede el tamaño en la tabla.");
		}

		else {

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
	 * Convierte el contenido de la variable 'tabla' en una cadena de caracteres con
	 * formato legible y ordenado.
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

	// Metodo to string especifico para guardar en ficheros.
	public String toStrigDeDesarga() {

		StringBuilder cadenaSopa = new StringBuilder();

		for (int i = 0; i < this.tabla.length; i++) {

			for (int j = 0; j < this.tabla[i].length; j++) {

				cadenaSopa.append(this.tabla[i][j]);

			}

			cadenaSopa.append("\n");

		}

		return cadenaSopa.toString();

	}

	// Guarda la sopa de letras generada en un fichero llamado partida.txt
	public void enviarDatosAFichero() {

		try {
			BufferedWriter escritorArchivo = new BufferedWriter(new FileWriter("partida.txt"));
			escritorArchivo.write(this.toStrigDeDesarga());
			escritorArchivo.close();
		}

		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void cargarDatosDeFichero() {
		boolean terminado = false;
		int columnas = 0;
		int filas = 0;
		String linea;
		int leido;
		int LF = '\n';

		// Bloque para establecer la longitud de las filas y columnas de la matriz.
		try {

			BufferedReader lectorLinea = new BufferedReader(new FileReader("partida.txt"));

			while (!terminado) {

				linea = lectorLinea.readLine();

				if (linea == null) {
					terminado = true;
				} else {

					if (linea != null && linea.length() > columnas) {
						columnas = linea.length();
					}

					filas++;

				}

			}

			lectorLinea.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.tabla = new char[filas][columnas];
		
		// Bloque para cargar los datos.
		try {
			int columna = 0;
			int fila = 0;
			
			BufferedReader lectorArchivo = new BufferedReader(new FileReader("partida.txt"));

			terminado = false;
			while (!terminado) {

				leido = lectorArchivo.read();

				if (leido < 0) {
					terminado = true;
				} 
				else 
				{
					// Si encuentra salto de linea.
					if (leido == LF) 
					{
						// aumentar la variable que controla la columna.
						columna++;
						fila = 0;
					}
					// Si encuentra caracter.
					else					
					{
						// introduce el caracter y aumenta la variable que controla posicion de fila.
						this.tabla[columna][fila] = (char) leido;
						fila++;
					}
				}

			}

			lectorArchivo.close();
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}



	// Metodo que incluye una logica para cargar ficheros de output con espacios.
	public void cargarDatosDeFicheroConEspacios() {

		int LF = '\n';
		int espacio = ' ';
		boolean terminado = false;

		// segun el numero de caracteres, establecer la longitud de la matriz.
		// iterar por cada linea, almacenando cada caracter en una posicion de la
		// matriz.

		// leer el fichero.
		try {
			BufferedReader lectorArchivo = new BufferedReader(new FileReader("partida.txt"));

			terminado = false;
			int leido;
			int columna = 0;
			int fila = 0;

			// Mientras que el lector no encuentre señal de salida (-1).
			while (!terminado) {

				leido = lectorArchivo.read();

				if (leido < 0) {
					terminado = true;
				} else {
					// Si encuentra salto de linea.
					if (leido == LF) {
						// aumentar la variable que controla la columna.
						columna++;
						fila = 0;
					}
					// Si encuentra caracter.
					else if (leido != espacio) {
						// introduce el caracter y aumenta la variable que controla posicion de fila.
						this.tabla[columna][fila] = (char) leido;
						fila++;
					}
				}

			}

			lectorArchivo.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
