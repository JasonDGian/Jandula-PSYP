package com._dam.ejercicio_pag29.model;

/**
 * Clase que representa un jugador.
 */
public class Jugador
{

	// Atributos.
	private int dorsal;
	private String nombre;
	private int goles;
	private int tarjetas;

	// Constructor vacio.
	public Jugador()
	{
	}

	// Constructor parametrizado.
	public Jugador(int dorsal, String nombre, int goles, int tarjetas)
	{
		super();
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.goles = goles;
		this.tarjetas = tarjetas;
	}

	
	// Metodos de acceso.
	public int getDorsal()
	{
		return dorsal;
	}

	public void setDorsal(int dorsal)
	{
		this.dorsal = dorsal;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public int getGoles()
	{
		return goles;
	}

	public void setGoles(int goles)
	{
		this.goles = goles;
	}

	public int getTarjetas()
	{
		return tarjetas;
	}

	public void setTarjetas(int tarjetas)
	{
		this.tarjetas = tarjetas;
	}
	
	// Metodo toString generico.
	@Override
	public String toString()
	{
		return "Jugador [dorsal=" + dorsal + ", nombre=" + nombre + ", goles=" + goles + ", tarjetas=" + tarjetas + "]";
	}

}
