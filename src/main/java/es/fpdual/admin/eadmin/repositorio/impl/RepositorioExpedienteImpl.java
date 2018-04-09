package es.fpdual.admin.eadmin.repositorio.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.modelo.Expediente;
import es.fpdual.admin.eadmin.repositorio.RepositorioExpediente;

@Repository
public class RepositorioExpedienteImpl implements RepositorioExpediente {

	private static final Logger LOGGER = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);

	private List<Expediente> expedientes = new ArrayList<>();

	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	@Override
	public void altaExpediente(Expediente expediente) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El documento ya existe");
		}
		expedientes.add(expediente);
		System.out.println("Se ha insertado un expediente!");
		LOGGER.info(expediente.toString() + " ha sido insertado correctamente.");
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		if (!expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El documento a modificar no existe");
		}
		expedientes.set(expedientes.indexOf(expediente), expediente);
		LOGGER.info(expediente.toString() + " ha sido modificado correctamente.");
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void eliminarExpediente(Integer codigo) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Expediente expedienteEncontrado = expedientes.stream().filter(d -> tieneIgualCodigo(d, codigo)).findFirst()
				.orElseGet(null);

		if (expedienteEncontrado != null) {
			expedientes.remove(expedienteEncontrado);
			LOGGER.info(expedienteEncontrado.toString() + " ha sido eliminado correctamente.");
		}
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public Expediente asociarDocumentoAlExpediente(Integer codigoExpediente, Documento documento) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Expediente expedienteEncontrado = expedientes.stream().filter(d -> tieneIgualCodigo(d, codigoExpediente))
				.findFirst().orElseGet(null);

		if (expedienteEncontrado != null) {
			expedienteEncontrado.getDocumentos().add(documento);
			LOGGER.info(documento.toString() + " ha sido asociado al expediente " + expedienteEncontrado.getCodigo());
		}
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return null;
	}

	@Override
	public Expediente desasociarDocumentoAlExpediente(Integer codigoExpediente, Integer codigoDocumento) {
		Expediente expedienteEncontrado = expedientes.stream().filter(d -> tieneIgualCodigo(d, codigoExpediente))
				.findFirst().orElseGet(null);
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (expedienteEncontrado != null) {
			expedienteEncontrado.getDocumentos().remove(codigoDocumento);
			LOGGER.info("Documento con código " + codigoExpediente + " ha sido desasociado del expediente con código: "
					+ codigoExpediente);
		}
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return null;
	}

	@Override
	public void escribirEnArchivoAltaExpediente(Expediente expediente) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El expediente ya existe");
		}

		else {
			expedientes.add(expediente);
			LOGGER.info(expediente.toString() + " se ha creado correctamente.");

			System.out.println("INICIANDO ESCRITURA EN ALTA..");
			LOGGER.info("Iniciando escritura de fichero...");

			String ruta = "AltaExpediente.txt";
			File archivo = new File(ruta);
			FileWriter file = null;
			PrintWriter pw = null;

			if (archivo.exists()) {
				LOGGER.info("Modificando fichero existente...");
			}

			else {
				LOGGER.info("Creando fichero nuevo...");
			}
			try {
				file = new FileWriter(ruta, true);
				pw = new PrintWriter(file);
				pw.println(expediente.devolverDatosDeExpediente());
				pw.close();
				LOGGER.info("Fin escritura de fichero...");
			} catch (IOException e) {
				e.printStackTrace();
				pw.close();
				LOGGER.info("Fin escritura de fichero...");
			}
		}
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());

	}

	@Override
	public void escribirEnArchivoModificarExpediente(Expediente expediente) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (!expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El documento a modificar no existe");
		}

		else {
			expedientes.set(expedientes.indexOf(expediente), expediente);
			LOGGER.info(expediente.toString() + " ha sido modificado correctamente.");

			System.out.println("INICIANDO ESCRITURA EN MODIFICACIÓN..");
			LOGGER.info("Iniciando escritura de fichero...");

			String ruta = "ModificarExpediente.txt";
			File archivo = new File(ruta);
			FileWriter file = null;
			PrintWriter pw = null;

			if (archivo.exists()) {
				LOGGER.info("Modificando fichero existente...");
			}

			else {
				LOGGER.info("Creando fichero nuevo...");
			}
			try {
				file = new FileWriter(ruta, true);
				pw = new PrintWriter(file);
				pw.println(expediente.devolverDatosDeExpediente());
				pw.close();
				LOGGER.info("Fin escritura de fichero...");
			} catch (IOException e) {
				e.printStackTrace();
				pw.close();
				LOGGER.info("Fin escritura de fichero...");
			}

		}
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void escribirEnArchivoEliminarExpediente(Integer codigo) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Expediente expedienteEncontrado = expedientes.stream().filter(d -> tieneIgualCodigo(d, codigo)).findFirst()
				.orElseGet(null);

		if (Objects.nonNull(expedienteEncontrado)) {
			expedientes.remove(expedienteEncontrado);
			LOGGER.info(expedienteEncontrado.toString() + " ha sido eliminado correctamente.");

			System.out.println("INICIANDO ESCRITURA EN ELIMINAR..");
			LOGGER.info("Iniciando escritura de fichero...");

			String ruta = "EliminarExpediente.txt";
			File archivo = new File(ruta);
			FileWriter file = null;
			PrintWriter pw = null;

			if (archivo.exists()) {
				LOGGER.info("Modificando fichero existente...");
			}

			else {
				LOGGER.info("Creando fichero nuevo...");
			}
			try {
				file = new FileWriter(ruta, true);
				pw = new PrintWriter(file);
				pw.println(expedienteEncontrado.devolverDatosDeExpediente());
				pw.close();
				LOGGER.info("Fin escritura de fichero...");
			} catch (IOException e) {
				e.printStackTrace();
				pw.close();
				LOGGER.info("Fin escritura de fichero...");
			}
		}

		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public List<Expediente> obtenerTodosLosExpedientes() {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		LOGGER.info("MOSTRANDO TODOS LOS DOCUMENTOS:");
		LOGGER.info("");
		LOGGER.info("**************************************************************************");
		for (Expediente expediente : expedientes) {
			LOGGER.info("Expediente:" + expediente.getCodigo());
			LOGGER.info("Nombre:" + expediente.getNombre());
			LOGGER.info("Fecha de creación:" + expediente.getFechaCreacion());
			LOGGER.info("Fecha de última modificación:" + expediente.getFechaUltimaModificacion());
			LOGGER.info("Público:" + expediente.getPublico());
			LOGGER.info("Estado:" + expediente.getEstado());
			LOGGER.info("Lista:" + expediente.getDocumentos());
			LOGGER.info("");
			LOGGER.info("**************************************************************************");

		}
		LOGGER.info("TODOS LOS EXPEDIENTES LISTADOS");
		LOGGER.info("FIN");
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return expedientes;
	}

	@Override
	public Expediente obtenerExpedientePorCodigo(Integer codigo) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Optional<Expediente> expedienteEncontrado = expedientes.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();
		LOGGER.info("MOSTRANDO TODOS LOS EXPEDIENTES:");
		LOGGER.info("");
		for (Expediente expediente : expedientes) {
			LOGGER.info("Expediente:" + expediente.getCodigo());
			LOGGER.info("Nombre:" + expediente.getNombre());
			LOGGER.info("Fecha de creación:" + expediente.getFechaCreacion());
			LOGGER.info("Fecha de última modificación:" + expediente.getFechaUltimaModificacion());
			LOGGER.info("Público:" + expediente.getPublico());
			LOGGER.info("Estado:" + expediente.getEstado());
			LOGGER.info("Lista:" + expediente.getDocumentos());
			LOGGER.info("");
			LOGGER.info("**************************************************************************");

		}
		LOGGER.info("EXPEDIENTE LISTADO");

		if (expedienteEncontrado.isPresent()) {
			LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
			return expedienteEncontrado.get();
		}
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return null;
	}

	public void guardarExpedientesEnArchivoTexto() {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());

		String ruta = "ListaDeTodosLosExpedientes.txt";
		File archivo = new File(ruta);
		FileWriter file = null;
		PrintWriter pw = null;

		System.out.println("INICIANDO");

		LOGGER.info("Iniciando escritura de fichero...");
		if (archivo.exists()) {
			LOGGER.info("Modificando fichero existente...");
		}

		else {
			LOGGER.info("Creando fichero nuevo...");
		}

		try {
			file = new FileWriter(ruta, true);
			pw = new PrintWriter(file);

			for (Expediente expediente : expedientes) {
				pw.println(expediente.devolverDatosDeExpediente());
			}

			pw.println("++++++++++++++++++++++++++++++++++++++++++++++++");
			pw.close();
			LOGGER.info("Fin escritura de fichero...");
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
			LOGGER.info("Fin escritura de fichero...");
		}
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	protected boolean tieneIgualCodigo(Expediente expediente, Integer codigo) {
		return expediente.getCodigo().equals(codigo);
	}

}
