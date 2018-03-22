package es.fpdual.admin.eadmin.modelo;

import java.util.Date;

public abstract class ModeloBaseAdministracionElectronica {
	protected Integer codigo;
	protected String nombre;
	protected Date fechaCreacion;
	protected Date fechaUltimaModificacion;
	protected Boolean publico;
	
	//Constructor
	public ModeloBaseAdministracionElectronica(Integer codigo, String nombre, Date fechaCreacion,
			Date fechaUltimaModificacion, Boolean publico) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		this.publico = publico;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public Boolean getPublico() {
		return publico;
	}

	@Override
	public String toString() {
		return "ModeloBaseAdministracionElectronica [codigo=" + codigo + ", nombre=" + nombre + ", fechaCreacion="
				+ fechaCreacion + ", publico=" + publico + "]";
	}
	
	@Override
	public int hashCode() {
		return codigo.hashCode() + nombre.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ModeloBaseAdministracionElectronica) {
			return codigo.equals(((ModeloBaseAdministracionElectronica) obj).getCodigo()) && nombre.equals(((ModeloBaseAdministracionElectronica) obj).getNombre());
		}
		return false;
	}
	
}
