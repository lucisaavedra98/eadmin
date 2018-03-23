package es.fpdual.admin.eadmin.modelo.builder;

import java.util.Date;

import es.fpdual.admin.eadmin.modelo.EstadoExpediente;

public class ExpedienteBuilder {
	protected Integer codigo;
	protected String nombre;
	protected Date fechaCreacion;
	protected Date fechaUltimaModificacion;
	protected Boolean publico;
	protected Date fechaArchivado= null;
	protected EstadoExpediente estado;
	
}
