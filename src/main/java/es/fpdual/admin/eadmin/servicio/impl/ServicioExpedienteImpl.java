package es.fpdual.admin.eadmin.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;

import es.fpdual.admin.eadmin.modelo.Expediente;
import es.fpdual.admin.eadmin.repositorio.RepositorioExpediente;
import es.fpdual.admin.eadmin.servicio.ServicioExpediente;

public class ServicioExpedienteImpl implements ServicioExpediente {

	RepositorioExpediente repositorioExpediente;
	
	@Autowired
	public ServicioExpedienteImpl (RepositorioExpediente repositorioExpediente) {
		this.repositorioExpediente = repositorioExpediente;
	}
	
	@Override
	public Expediente altaExpediente(Expediente expediente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expediente modificarExpediente(Expediente expediente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarExpediente(Integer codigoExpediente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Expediente asociarDocumentoAlExpediente(Integer codigoExpediente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expediente desasociarDocumentoAlExpediente(Integer codigoExpediente) {
		// TODO Auto-generated method stub
		return null;
	}

}
