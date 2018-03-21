package es.fpdual.admin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private List<Documento> documentos= new ArrayList<>();
		
	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	@Override
	public void altaDocumento(Documento documento) {
		if (documentos.contains(documento)) {
			throw new IllegalArgumentException ("El documento ya existe");
		}
		documentos.add(documento);
	}

	@Override
	public void modificarDocumento(Documento documento) {
		if(!documentos.contains(documento)) {
			throw new IllegalArgumentException ("El documento a modificar no existe");
		}
		documentos.set(documentos.indexOf(documento),documento);
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		Documento documentoEncontrado = null;
		
		for (int i=0; i < documentos.size();i++) {
			if (documentos.get(i).getCodigo().equals(codigo)) {
				documentoEncontrado = documentos.get(i);
				break;
			}
		}
		
		if (Objects.nonNull(documentoEncontrado)) {
			documentos.remove(documentoEncontrado);
		}
	}
		
}
