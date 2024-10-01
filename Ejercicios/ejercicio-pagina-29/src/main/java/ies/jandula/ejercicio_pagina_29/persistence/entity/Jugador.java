package ies.jandula.ejercicio_pagina_29.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Para generar getters+setters.
@NoArgsConstructor // Para generar un constructor sin argumentos.
@AllArgsConstructor // Para generar un constructor con todos los argumentos
@Entity // Para convertir el objeto en una entidad.
public class Jugador
{
	@Id
	@Column(name = "jugador_id")
	private long id;
	
	@Column
	private int dorsal;
	
	@Column
	private String nombre;
	
	@Column
	private int goles;
	
	@Column
	private int tarjetas;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

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
	
	
	
}
