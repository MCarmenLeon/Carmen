package model;

public class Trabajador {
	
	private String idTrabajador;
	private String Dni;
	private String Nombre;
	private String Apellidos;
	private String Genero;

	public Trabajador() {
		super();
	}

	public Trabajador(String idTrabajador, String dni, String nombre, String apellidos, String genero) {
		super();
		this.idTrabajador = idTrabajador;
		Dni = dni;
		Nombre = nombre;
		Apellidos = apellidos;
		Genero = genero;
	}


	public String getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(String idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	@Override
	public String toString() {
		return "Trabajador [Dni=" + Dni + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Genero=" + Genero
				+ ", getDni()=" + getDni() + ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos()
				+ ", getGenero()=" + getGenero() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	}

