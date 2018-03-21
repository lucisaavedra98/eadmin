package es.fpdual.admin.eadmin.modelo;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.admin.eadmin.repositorio.impl.RepositorioDocumentoImpl;

public class RepositorioDocumentoImplTest {
	RepositorioDocumentoImpl repositorioDocumento;
	Documento documento1,documento2;
	
	@Before
	public void Inicializar() {
		RepositorioDocumentoImpl repositorioDocumento= new RepositorioDocumentoImpl();
		
		documento1 =new Documento (1,"prueba 1",new Date(),true,EstadoDocumento.ACTIVO);
		documento2 =new Documento (2,"prueba 2",new Date(),true,EstadoDocumento.ACTIVO);
	}
	
	@Test
	public void pruebaAlta () {
		repositorioDocumento.altaDocumento(documento1);
		repositorioDocumento.altaDocumento(documento1);
	}
	
}
