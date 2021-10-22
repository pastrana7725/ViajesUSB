/**  
 * @Title:  TipoIdentificacionServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Valentina Prado     
 * @date:   14/09/2021 5:10:57 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San Buenaventura
 */

package co.edu.usbcali.viajesusb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;
import co.edu.usbcali.viajesusb.repository.TipoIdentificacionRepository;
import co.edu.usbcali.viajesusb.utils.Utilities;

/**
 * @ClassName: TipoIdentificacionServiceImpl
 * @Description: TODO
 * @author: Diego Pastrana
 * @date: 14/09/2021 5:10:57 p. m.
 * @Copyright: USB
 */

@Scope("singleton")
@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {

	@Autowired
	private TipoIdentificacionRepository tipoIdentificacionRepository;
	@Autowired
	private ClienteService clienteService;

	@Override
	public List<TipoIdentificacion> findByEstadoOrderByNombreAsc(String estado) throws Exception {
		// NO PUEDE INGRESAR UN ESTADO VACIO
		if (estado == null || Utilities.isEmpty(estado)) {
			throw new Exception("El estado de tipo destino es obligatorio");
		}
		// EL ESTADO SOLO PUEDE CONTENER UN CARACTER
		if (Utilities.isLongerThan(estado, 1)) {
			throw new Exception("El estado solo puede contener 1 caracter");
		}
		// EL ESTADO SOLAMENTE ACEPTA LETRAS
		if (!Utilities.isOnlyLetters(estado)) {
			throw new Exception("El estado solo puede contener letras ");
		}
		List<TipoIdentificacion> lstTipoIdentificacion;
		lstTipoIdentificacion = tipoIdentificacionRepository.findByEstadoOrderByNombreAsc(estado);
		return lstTipoIdentificacion;
	}

	@Override
	public TipoIdentificacion findByCodigoAndEstado(String codigo, String estado) throws Exception {
		// NO PUEDE INGRESAR UN ESTADO VACIO
		if (estado == null || Utilities.isEmpty(estado)) {
			throw new Exception("El estado de tipo destino es obligatorio");
		}
		// NO PUEDE INGRESAR UN CODIGO VACIO
		if (codigo == null || Utilities.isEmpty(codigo)) {
			throw new Exception("El tipo de identificacion de tipo destino es obligatorio");
		}
		// EL ESTADO SOLO PUEDE CONTENER UN CARACTER
		if (Utilities.isLongerThan(estado, 1)) {
			throw new Exception("El estado solo puede contener 1 caracteres");
		}
		// EL TIPO DE IDENTIFICACION SOLO PUEDE CONTENER 5 CARACTERES
		if (Utilities.isLongerThan(codigo, 5)) {
			throw new Exception("El tipo de identificacion solo puede contener 5 caracteres");
		}
		// EL ESTADO SOLAMENTE ACEPTA LETRAS
		if (!Utilities.isOnlyLetters(estado)) {
			throw new Exception("El estado solo puede contener letras ");
		}
		// EL CODIGO SOLAMENTE ACEPTA LETRAS
		if (!Utilities.isOnlyLetters(codigo)) {
			throw new Exception("El tipo de identificacion solo puede contener letras ");
		}
		TipoIdentificacion tipoIdentificacion;
		tipoIdentificacion = tipoIdentificacionRepository.findByCodigoAndEstado(codigo, estado);
		return tipoIdentificacion;
	}

	public TipoIdentificacion guardarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception {

		TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();

		// VALIDACION CODIGO
		if (tipoIdentificacionDTO.getCodigo() == null || Utilities.isEmpty(tipoIdentificacionDTO.getCodigo())) {
			throw new Exception("El codigo es obligatorio");
		}
		if (!Utilities.isOnlyLetters(tipoIdentificacionDTO.getCodigo())) {
			throw new Exception("El codigo solo puede contener letras");
		}
		if (Utilities.isLongerThan(tipoIdentificacionDTO.getCodigo(), 5)) {
			throw new Exception("El codigo solo puede contener 5 caracteres");
		}
		tipoIdentificacion.setCodigo(tipoIdentificacionDTO.getCodigo());

		// VALIDACION ESTADO
		if (tipoIdentificacionDTO.getEstado() == null || Utilities.isEmpty(tipoIdentificacionDTO.getEstado())) {
			throw new Exception("El estado es obligatorio");
		}
		if (Utilities.isLongerThan(tipoIdentificacionDTO.getEstado(), 1)) {
			throw new Exception("El estado solo puede contener 1 caracter");
		}
		if (!Utilities.isOnlyLetters(tipoIdentificacionDTO.getEstado())) {
			throw new Exception("El estado solo puede contener letras");
		}
		tipoIdentificacion.setEstado(tipoIdentificacionDTO.getEstado());

		// VALIDACION FECHA CREACION
		if (tipoIdentificacionDTO.getFechaCreacion() == null) {
			throw new Exception("La fecha creacion es obligatoria");
		}
		tipoIdentificacion.setFechaCreacion(tipoIdentificacionDTO.getFechaCreacion());

		// VALIDACION NOMBRE
		if (tipoIdentificacionDTO.getNombre() == null || Utilities.isEmpty(tipoIdentificacionDTO.getNombre())) {
			throw new Exception("El nombre es obligatorio");
		}
		if (Utilities.isLongerThan(tipoIdentificacionDTO.getNombre(), 100)) {
			throw new Exception("El nombre solo puede contener 100 caracteres");
		}
		if (!Utilities.isOnlyLetters(tipoIdentificacionDTO.getNombre())) {
			throw new Exception("El nombre solo puede contener letras");
		}
		tipoIdentificacion.setNombre(tipoIdentificacionDTO.getNombre());

		// VALIDACION USUARIO CREADOR
		if (tipoIdentificacionDTO.getUsuCreador() == null || Utilities.isEmpty(tipoIdentificacionDTO.getUsuCreador())) {
			throw new Exception("El usuario creador es obligatorio");
		}
		if (Utilities.isLongerThan(tipoIdentificacionDTO.getUsuCreador(), 10)) {
			throw new Exception("El usuario creador solo puede contener 10 caracter");
		}
		if (!Utilities.isOnlyLetters(tipoIdentificacionDTO.getUsuCreador())) {
			throw new Exception("El usuario creador solo puede contener letras");
		}
		tipoIdentificacion.setUsuCreador(tipoIdentificacionDTO.getUsuCreador());

		tipoIdentificacionRepository.save(tipoIdentificacion);

		return tipoIdentificacion;
	}

	public TipoIdentificacion actualizarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception {

		TipoIdentificacion tipoIdentificacion = null;
		tipoIdentificacion = findById(tipoIdentificacionDTO.getIdTiId());

		// VALIDACION CODIGO
		if (tipoIdentificacionDTO.getCodigo() == null || Utilities.isEmpty(tipoIdentificacionDTO.getCodigo())) {
			throw new Exception("El codigo es obligatorio");
		}
		if (Utilities.isLongerThan(tipoIdentificacionDTO.getCodigo(), 5)) {
			throw new Exception("El codigo solo puede contener 5 caracteres");
		}
		if (!Utilities.isOnlyLetters(tipoIdentificacionDTO.getCodigo())) {
			throw new Exception("El codigo solo puede contener letras");
		}
		tipoIdentificacion.setCodigo(tipoIdentificacionDTO.getCodigo());

		// VALIDACION ESTADO
		if (tipoIdentificacionDTO.getEstado() == null || Utilities.isEmpty(tipoIdentificacionDTO.getEstado())) {
			throw new Exception("El estado es obligatorio");
		}
		if (Utilities.isLongerThan(tipoIdentificacionDTO.getEstado(), 1)) {
			throw new Exception("El estado solo puede contener 1 caracter");
		}
		if (!Utilities.isOnlyLetters(tipoIdentificacionDTO.getEstado())) {
			throw new Exception("El estado solo puede contener letras");
		}
		tipoIdentificacion.setEstado(tipoIdentificacionDTO.getEstado());

		// VALIDACION FECHA CREACION
		if (tipoIdentificacionDTO.getFechaCreacion() == null) {
			throw new Exception("La fecha creacion es obligatoria");
		}
		tipoIdentificacion.setFechaCreacion(tipoIdentificacionDTO.getFechaCreacion());

		// VALIDACION NOMBRE
		if (tipoIdentificacionDTO.getNombre() == null || Utilities.isEmpty(tipoIdentificacionDTO.getNombre())) {
			throw new Exception("El nombre es obligatorio");
		}
		if (Utilities.isLongerThan(tipoIdentificacionDTO.getNombre(), 100)) {
			throw new Exception("El nombre solo puede contener 100 caracteres");
		}
		if (!Utilities.isOnlyLetters(tipoIdentificacionDTO.getNombre())) {
			throw new Exception("El nombre solo puede contener letras");
		}
		tipoIdentificacion.setNombre(tipoIdentificacionDTO.getNombre());

		// VALIDACION USUARIO CREADOR
		if (tipoIdentificacionDTO.getUsuCreador() == null || Utilities.isEmpty(tipoIdentificacionDTO.getUsuCreador())) {
			throw new Exception("El usuario creador es obligatorio");
		}
		if (Utilities.isLongerThan(tipoIdentificacionDTO.getUsuCreador(), 10)) {
			throw new Exception("El usuario creador solo puede contener 10 caracter");
		}
		if (!Utilities.isOnlyLetters(tipoIdentificacionDTO.getUsuCreador())) {
			throw new Exception("El usuario creador solo puede contener letras");
		}
		tipoIdentificacion.setUsuCreador(tipoIdentificacionDTO.getUsuCreador());

		tipoIdentificacionRepository.save(tipoIdentificacion);

		return tipoIdentificacion;
	}

	public TipoIdentificacion findById(Long idTiId) throws Exception {

		// Validamos el idDest venga con info
		if (idTiId == null) {
			throw new Exception("Debe ingresar un id de tipo identificacion");
		}

		if (!tipoIdentificacionRepository.findById(idTiId).isPresent()) {
			throw new Exception("El tipo de identificacion no existe");
		}

		return tipoIdentificacionRepository.findById(idTiId).get();

	}

	public void eliminarTipoIdentificacion(Long idTide) throws Exception {

		// VALIDAR QUE SE INGRESE EL ID DEL TIPO IDENTIFICACION A ELIMINAR

		if (idTide == null) {
			throw new Exception("El id del tipo Identificacion es obligatorio");
		}

		Optional<TipoIdentificacion> tipoIdentificacionBD = tipoIdentificacionRepository
				.findById(idTide);
		List<ClienteDTO> listClientes = clienteService.ConsultarClientesPorTipoIdentificacion(findById(idTide).getCodigo());

		if (tipoIdentificacionBD.isPresent()) {

			if (listClientes.isEmpty()) {
				tipoIdentificacionRepository.delete(tipoIdentificacionBD.get());
			} else {
				throw new Exception("No se puede eliminar un tipo de identificacion si existen clientes usandolo");
			}
		} else {
			throw new Exception("No se encontró ningún tipo identificacion");

		}
	}

}
