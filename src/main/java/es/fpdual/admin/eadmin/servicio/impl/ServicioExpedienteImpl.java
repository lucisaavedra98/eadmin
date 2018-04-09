package es.fpdual.admin.eadmin.servicio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.modelo.Expediente;
import es.fpdual.admin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.admin.eadmin.modelo.builder.ExpedienteBuilder;
import es.fpdual.admin.eadmin.repositorio.RepositorioExpediente;
import es.fpdual.admin.eadmin.repositorio.impl.RepositorioExpedienteImpl;
import es.fpdual.admin.eadmin.servicio.ServicioExpediente;

@Service
public class ServicioExpedienteImpl implements ServicioExpediente {

	RepositorioExpediente repositorioExpediente;
	
	@Autowired
	public ServicioExpedienteImpl (RepositorioExpediente repositorioExpediente) {
		this.repositorioExpediente = repositorioExpediente;
	}
	
	@Override
	public Expediente altaExpediente(Expediente expediente) {
		final Expediente expedienteModificado = 
				obtenerExpedienteConFechaCorrecta(expediente);
		
		repositorioExpediente.altaExpediente(expedienteModificado);	
		return expedienteModificado;
	}

	@Override
	public Expediente modificarExpediente(Expediente expediente) {
		final Expediente expedienteConUltimaFechaModificada =
				obtenerExpedienteConUltimaFechaModificacion(expediente);
		
		repositorioExpediente.modificarExpediente(expediente);
		return expedienteConUltimaFechaModificada;
	}

	@Override
	public void eliminarExpediente(Integer codigo) {
		repositorioExpediente.eliminarExpediente(codigo);
	}

	@Override
	public Expediente asociarDocumentoAlExpediente(Integer codigoExpediente,Documento documento) {
		return this.repositorioExpediente.asociarDocumentoAlExpediente(codigoExpediente, documento);
	}

	@Override
	public Expediente desasociarDocumentoAlExpediente(Integer codigoExpediente,Integer codigoDocumento) {
		return this.repositorioExpediente.desasociarDocumentoAlExpediente(codigoExpediente, codigoDocumento);
	}
	
	@Override
	public Expediente obtenerExpedientePorCodigo(Integer codigo) {
		final Expediente resultado = repositorioExpediente.obtenerExpedientePorCodigo(codigo);
		return null;
	}

	@Override
	public List<Expediente> obtenerTodosLosExpedientes() {
		return repositorioExpediente.obtenerTodosLosExpedientes();
	}
	
	protected Expediente obtenerExpedienteConFechaCorrecta(Expediente expediente) {
		return new ExpedienteBuilder().
				clonar(expediente).
				conFechaCreacion(dameFechaActual()).
				build();
	}
	
	protected Expediente obtenerExpedienteConUltimaFechaModificacion(Expediente expediente) {
		return new ExpedienteBuilder().
				clonar(expediente).
				conFechaUltimaModificacion(dameFechaActual()).
				build();
	}
	
	protected Date dameFechaActual() {
		return new Date();
	}
	
	protected boolean tieneIgualCodigo(Expediente expediente,Integer codigo) {
		return expediente.getCodigo().equals(codigo);
	}

}
