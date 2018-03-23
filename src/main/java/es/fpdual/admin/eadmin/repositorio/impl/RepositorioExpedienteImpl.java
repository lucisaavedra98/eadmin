package es.fpdual.admin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.modelo.Expediente;
import es.fpdual.admin.eadmin.repositorio.RepositorioExpediente;

@Repository
public class RepositorioExpedienteImpl implements RepositorioExpediente {
	
	private List<Expediente> expedientes= new ArrayList<>();

	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	@Override
	public void altaExpediente(Expediente expediente) {
		if (expedientes.contains(expediente)) {
			throw new IllegalArgumentException ("El documento ya existe");
		}
		expedientes.add(expediente);
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		if(!expedientes.contains(expediente)) {
			throw new IllegalArgumentException ("El documento a modificar no existe");
		}
		expedientes.set(expedientes.indexOf(expediente),expediente);
		
	}

	@Override
	public void eliminarExpediete(Integer codigo) {
		 Expediente expedienteEncontrado = expedientes.stream().
					filter(d -> tieneIgualCodigo(d,codigo)).
					findFirst().orElseGet(null);
		
	}

	@Override
	public void asociarDocumentoAlExpediente(Expediente expediente, Documento documento) {
		expedientes.get(this.getExpedientes().indexOf(expediente)).getDocumentos().add(documento);
	}

	@Override
	public void desasociarDocumentoAlExpediente(Expediente expediente, Documento documento) {
		expedientes.get(this.getExpedientes().indexOf(expediente)).getDocumentos().
		remove(
		expedientes.get(this.getExpedientes().indexOf(expediente)).getDocumentos().indexOf(documento));
	}
	
	protected boolean tieneIgualCodigo(Expediente expediente,Integer codigo) {
		return expediente.getCodigo().equals(codigo);
	}

	
}
