package model;

public class Proyecto {
	
	private String idProyecto;
	private String nombre;
	private String Presupuesto;
	private String FechInicio;
	private String FechFinal;
	public Proyecto() {
		super();
	}
	public Proyecto(String idProyecto, String nombre, String presupuesto, String fechInicio, String fechFinal) {
		super();
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		Presupuesto = presupuesto;
		FechInicio = fechInicio;
		FechFinal = fechFinal;
	}
	public String getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPresupuesto() {
		return Presupuesto;
	}
	public void setPresupuesto(String presupuesto) {
		Presupuesto = presupuesto;
	}
	public String getFechInicio() {
		return FechInicio;
	}
	public void setFechInicio(String fechInicio) {
		FechInicio = fechInicio;
	}
	public String getFechFinal() {
		return FechFinal;
	}
	public void setFechFinal(String fechFinal) {
		FechFinal = fechFinal;
	}
	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", nombre=" + nombre + ", Presupuesto=" + Presupuesto
				+ ", FechInicio=" + FechInicio + ", FechFinal=" + FechFinal + "]";
	}
	
	
	
	

}
