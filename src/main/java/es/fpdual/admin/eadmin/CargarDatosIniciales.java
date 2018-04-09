package es.fpdual.admin.eadmin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.modelo.EstadoDocumento;
import es.fpdual.admin.eadmin.modelo.EstadoExpediente;
import es.fpdual.admin.eadmin.modelo.Expediente;
import es.fpdual.admin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.admin.eadmin.repositorio.RepositorioExpediente;

@Component
public class CargarDatosIniciales implements ApplicationRunner {
	private final RepositorioDocumento repositorioDocumento;
	private final RepositorioExpediente repositorioExpediente;

	private static final Date FECHA = new Date();

	@Autowired
	public CargarDatosIniciales(RepositorioDocumento repositorioDocumento,
			RepositorioExpediente repositorioExpediente) {
		this.repositorioDocumento = repositorioDocumento;
		this.repositorioExpediente = repositorioExpediente;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Documento documento1 = new Documento(1, "documento1", FECHA, FECHA, true, EstadoDocumento.ACTIVO);
		Documento documento2 = new Documento(2, "documento2", FECHA, FECHA, true, EstadoDocumento.ACTIVO);
		Documento documento3 = new Documento(3, "documento3", FECHA, FECHA, true, EstadoDocumento.ACTIVO);
		Documento documento4 = new Documento(4, "documento4", FECHA, FECHA, true, EstadoDocumento.ACTIVO);
		Documento documento5 = new Documento(5, "documento5", FECHA, FECHA, true, EstadoDocumento.ACTIVO);

		Expediente expediente1 = new Expediente(1, "documento1", FECHA, FECHA, true, EstadoExpediente.INICIADO, null);
		Expediente expediente2 = new Expediente(2, "documento2", FECHA, FECHA, true, EstadoExpediente.INICIADO, null);
		Expediente expediente3 = new Expediente(3, "documento3", FECHA, FECHA, true, EstadoExpediente.INICIADO, null);
		Expediente expediente4 = new Expediente(4, "documento4", FECHA, FECHA, true, EstadoExpediente.INICIADO, null);
		Expediente expediente5 = new Expediente(5, "documento5", FECHA, FECHA, true, EstadoExpediente.INICIADO, null);

		repositorioDocumento.escribirAltaDocumento(documento1);
		repositorioDocumento.escribirAltaDocumento(documento2);
		repositorioDocumento.escribirAltaDocumento(documento3);
		repositorioDocumento.escribirAltaDocumento(documento4);
		repositorioDocumento.escribirAltaDocumento(documento5);
		repositorioDocumento.guardarDocumentosEnArchivoTexto();
		repositorioDocumento.escribirModificarDocumento(documento2);
		repositorioDocumento.escribirModificarDocumento(documento4);
		repositorioDocumento.guardarDocumentosEnArchivoTexto();
		repositorioDocumento.escribirEliminarDocumento(documento1.getCodigo());
		repositorioDocumento.escribirEliminarDocumento(documento3.getCodigo());
		repositorioDocumento.escribirEliminarDocumento(documento5.getCodigo());
		repositorioDocumento.guardarDocumentosEnArchivoTexto();
		
		repositorioExpediente.escribirEnArchivoAltaExpediente(expediente1);
		repositorioExpediente.escribirEnArchivoAltaExpediente(expediente2);
		repositorioExpediente.escribirEnArchivoAltaExpediente(expediente3);
		repositorioExpediente.escribirEnArchivoAltaExpediente(expediente4);
		repositorioExpediente.escribirEnArchivoAltaExpediente(expediente5);
		repositorioExpediente.guardarExpedientesEnArchivoTexto();
		repositorioExpediente.escribirEnArchivoModificarExpediente(expediente2);
		repositorioExpediente.escribirEnArchivoModificarExpediente(expediente4);
		repositorioExpediente.guardarExpedientesEnArchivoTexto();
		repositorioExpediente.escribirEnArchivoEliminarExpediente(expediente1.getCodigo());
		repositorioExpediente.escribirEnArchivoEliminarExpediente(expediente3.getCodigo());
		repositorioExpediente.escribirEnArchivoEliminarExpediente(expediente5.getCodigo());
		repositorioExpediente.guardarExpedientesEnArchivoTexto();
	}

}
