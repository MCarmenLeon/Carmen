package model;

import java.util.List;

public class Equipo {
	
	private int idEquipo;
	private int idProyecto;
	private int idTrabajador;
	private Cargo idCargo;
	public Equipo() {
	
	}
	public Equipo(int idEquipo, int idProyecto, int idTrabajador, Cargo idCargo) {
		super();
		this.idEquipo = idEquipo;
		this.idProyecto = idProyecto;
		this.idTrabajador = idTrabajador;
		this.idCargo = idCargo;
	}
	public int getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	public int getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
	public int getIdTrabajador() {
		return idTrabajador;
	}
	public void setIdTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
	}
	public Cargo getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(Cargo idCargo) {
		this.idCargo = idCargo;
	}
}
