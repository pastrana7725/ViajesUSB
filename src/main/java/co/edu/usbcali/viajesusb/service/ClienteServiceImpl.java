/**  
 * @Title:  ClienteServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Valentina Prado     
 * @date:   14/09/2021 4:29:08 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import co.edu.usbcali.viajesusb.repository.ClienteRepository;
import co.edu.usbcali.viajesusb.utils.Constantes;
import co.edu.usbcali.viajesusb.utils.Utilities;


/**
 * @ClassName: ClienteServiceImpl
 * @Description: TODO
 * @author: Diego Pastrana
 * @date: 14/09/2021 4:29:08 p.m.
 * @Copyright: USB
 */

@Scope("singleton")
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;

	@Override
	public Page<Cliente> findByEstadoOrderByNumeroIdentificacionAsc(String estado, Pageable pageable) throws Exception {
		// NO PUEDE INGRESAR UN ESTADO VACIO
		if (estado == null || Utilities.isEmpty(estado)) {
			throw new Exception("El estado de tipo destino es obligatorio");
		}
		// EL ESTADO SOLO PUEDE CONTENER UN CARACTER
		if (Utilities.isLongerThan(estado, 1)) {
			throw new Exception("El estado solo puede contener 1 caracter");
		}

		// NO PUEDE INGRESAR UN PAGEABLE VACIO
		if (pageable == null) {
			throw new Exception("El Pageable no puede ser nulo");
		}

		// EL ESTADO SOLAMENTE ACEPTA LETRAS
		if (!Utilities.isOnlyLetters(estado)) {
			throw new Exception("El estado solo puede contener letras ");
		}

		Page<Cliente> pageCliente = null;
		pageCliente = clienteRepository.findByEstadoOrderByNumeroIdentificacionAsc(estado, pageable);
		return pageCliente;
	}

	@Override
	public Cliente findByCorreoIgnoreCase(String correo) throws Exception {
		// EL CORREO NO PUEDE SER NULO O ESTAR VACIO
		if (correo == null || Utilities.isEmpty(correo)) {
			throw new Exception("El correo es obligatorio");
		}
		// EL CORREO SOLO PUEDE CONTENER 100 CARACTERES
		if (Utilities.isLongerThan(correo, 100)) {
			throw new Exception("El correo solo puede contener 100 caracteres");
		}
		// SOLAMENTE ACEPTA LETRAS
		if (!Utilities.isValidEmail(correo)) {
			throw new Exception("El correo no tiene un formato adecuado");
		}

		Cliente cliente = clienteRepository.findByCorreoIgnoreCase(correo);
		return cliente;
	}

	@Override
	public Cliente findByNumeroIdentificacionLike(String identificacion) throws Exception {
		// NO PUEDE INGRESAR VALORES VACIOS O NULOS
		if (identificacion == null || Utilities.isLongerThan(identificacion, 15)) {
			throw new Exception("La identificacion es obligatorio");
		}
		// EL NUMERO DE IDENTIFICACION SOLO PUEDE CONTENER 15 CARACTERES
		if (Utilities.isLongerThan(identificacion, 15)) {
			throw new Exception("El numero de identificacion solo puede contener 15 caracteres");
		}
		// SOLAMENTE ACEPTA LETRAS
		if (!Utilities.isNumeric(identificacion)) {
			throw new Exception("La identificacion solo puede contener numeros");
		}

		Cliente cliente = clienteRepository.findByNumeroIdentificacionLike(identificacion);
		return cliente;
	}

	@Override
	public List<Cliente> findByNombreIgnoreCaseLike(String nombre) throws Exception {
		// NO PUEDE INGRESAR VALORES VACIOS O NULOS
		if (nombre == null || Utilities.isEmpty(nombre)) {
			throw new Exception("El nombre es obligatorio");
		}
		// EL NOMBRE SOLO PUEDE CONTENER 100 CARACTERES
		if (Utilities.isLongerThan(nombre, 100)) {
			throw new Exception("El nombre solo puede contener 100 caracteres");
		}
		// SOLAMENTE ACEPTA LETRAS
		if (!Utilities.isOnlyLetters(nombre)) {
			throw new Exception("El nombre solo puede contener letras");
		}

		List<Cliente> lstClientes;
		lstClientes = clienteRepository.findByNombreIgnoreCaseLike(nombre);
		return lstClientes;

	}

	@Override
	public List<Cliente> findByFechaNacimientoBetween(Date start, Date finish) throws Exception {

		// NO PUEDE INGRESAR VALORES VACIOS O NULOS
		if (start == null) {
			throw new Exception("La fecha inicial es obligatoria");
		}
		if (finish == null) {
			throw new Exception("La fecha final es obligatoria");
		}

		List<Cliente> lstClientes;
		lstClientes = clienteRepository.findByFechaNacimientoBetween(start, finish);
		return lstClientes;
	}

	@Override
	public Integer countByEstado(String estado) throws Exception {
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

		Integer cantidad;
		cantidad = clienteRepository.countByEstado(estado);
		return cantidad;
	}

	@Override
	public Page<Cliente> findByTipoIdentificacion_Codigo(String codigoTipoIdentificacion, Pageable pageable)throws Exception {
		// NO PUEDE INGRESAR UN ESTADO VACIO
		if (codigoTipoIdentificacion == null || Utilities.isEmpty(codigoTipoIdentificacion)) {
			throw new Exception("El tipo de identificacion de tipo destino es obligatorio");
		}
		// EL TIPO DE IDENTIFICACION SOLO PUEDE CONTENER 5 CARACTERES
		if (Utilities.isLongerThan(codigoTipoIdentificacion, 5)) {
			throw new Exception("El tipo de identificacion solo puede contener 5 caracter");
		}
		// NO PUEDE INGRESAR UN PAGEABLE VACIO
		if (pageable == null) {
			throw new Exception("El Pageable no puede ser nulo");
		}

		// EL ESTADO SOLAMENTE ACEPTA LETRAS
		if (!Utilities.isOnlyLetters(codigoTipoIdentificacion)) {
			throw new Exception("El tipo de identificacion solo puede contener letras");
		}
		Page<Cliente> pageCliente = null;
		pageCliente = clienteRepository.findByTipoIdentificacion_Codigo(codigoTipoIdentificacion, pageable);
		return pageCliente;
	}

	@Override
	public List<Cliente> findByPrimerApellidoOrSegundoApellido(String primerApellido, String segundoApellido)
			throws Exception {
		// NO PUEDE INGRESAR VALORES VACIOS O NULOS
		if (primerApellido == null || Utilities.isEmpty(primerApellido)) {
			throw new Exception("El Primer apellido es obligatorio");
		}
		// NO PUEDE INGRESAR VALORES VACIOS O NULOS
		if (segundoApellido == null || Utilities.isEmpty(segundoApellido)) {
			throw new Exception("El segundo apellido es obligatorio");
		}
		// EL PRIMER APELLIDO SOLO PUEDE CONTENER 100 CARACTERES
		if (Utilities.isLongerThan(primerApellido, 100)) {
			throw new Exception("El primer apellido de identificacion solo puede contener 2 caracteres");
		}
		// EL SEGUNDO APELLIDO SOLO PUEDE CONTENER 100 CARACTERES
		if (Utilities.isLongerThan(segundoApellido, 100)) {
			throw new Exception("El segundo apellido de identificacion solo puede contener 2 caracteres");
		}
		
		// SOLAMENTE ACEPTA LETRAS
		if (!Utilities.isOnlyLetters(primerApellido)) {
			throw new Exception("El primer apellido solo puede contener letras");
		}
		// SOLAMENTE ACEPTA LETRAS
		if (!Utilities.isOnlyLetters(segundoApellido)) {
			throw new Exception("El segundo apellido solo puede contener letras");
		}

		List<Cliente> ltsClientes;
		ltsClientes = clienteRepository.findByPrimerApellidoOrSegundoApellido(primerApellido, segundoApellido);
		return ltsClientes;
	}

	@Override
	public List<ClienteDTO> ConsultarClientesPorEstado(String estado) throws Exception {
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

		List<ClienteDTO> ltsClienteDTO;
		ltsClienteDTO = clienteRepository.ConsultarClientesPorEstado(estado);
		return ltsClienteDTO;
	}

	@Override
	public ClienteDTO ConsultarClientesPorNumeroIdentificacion(String numeroIdentificacion) throws Exception {
		// NO PUEDE INGRESAR VALORES VACIOS O NULOS
		if (numeroIdentificacion == null || Utilities.isEmpty(numeroIdentificacion)) {
			throw new Exception("La identificacion es obligatorio");
		}
		// EL NUMERO DE IDENTIFICACION SOLO PUEDE CONTENER 15 CARACTERES
		if (Utilities.isLongerThan(numeroIdentificacion, 15)) {
			throw new Exception("El numero de identificacion solo puede contener 15 caracteres");
		}
		// SOLAMENTE ACEPTA NUMEROS
		if (!Utilities.isNumeric(numeroIdentificacion)) {
			throw new Exception("La identificacion solo puede contener numeros");
		}

		ClienteDTO clienteDTO;
		clienteDTO = clienteRepository.ConsultarClientesPorNumeroIdentificacion(numeroIdentificacion);
		return clienteDTO;
	}

	@Override
	public List<ClienteDTO> ConsultarClientesPorTipoIdentificacion(String tipoIdentificacion) throws Exception {
		// NO PUEDE INGRESAR UN ESTADO VACIO
		if (tipoIdentificacion == null || Utilities.isEmpty(tipoIdentificacion)) {
			throw new Exception("El tipo de identificacion de tipo destino es obligatorio");
		}
		// EL TIPO DE IDENTIFICACION SOLO PUEDE CONTENER 5 CARACTERES
		if (Utilities.isLongerThan(tipoIdentificacion, 5)) {
			throw new Exception("El tipo de identificacion solo puede contener 5 caracteres");
		}
		// EL ESTADO SOLAMENTE ACEPTA LETRAS
		if (!Utilities.isOnlyLetters(tipoIdentificacion)) {
			throw new Exception("El tipo de identificacion solo puede contener letras ");
		}

		List<ClienteDTO> ltsClienteDTO;
		ltsClienteDTO = clienteRepository.ConsultarClientesPorTipoIdentificacion(tipoIdentificacion);
		return ltsClienteDTO;
	}

	@Override
	public List<ClienteDTO> ConsultarClientesPorNombreEnOrdenAscendente(String nombre) throws Exception {
		// NO PUEDE INGRESAR VALORES VACIOS O NULOS
		if (nombre == null || Utilities.isEmpty(nombre)) {
			throw new Exception("El nombre es obligatorio");
		}
		// EL NOMBRE SOLO PUEDE CONTENER 100 CARACTERES
		if (Utilities.isLongerThan(nombre, 100)) {
			throw new Exception("El nombre solo puede contener 100 carÃ¡cteres");
		}
		// SOLAMENTE ACEPTA LETRAS
		if (!Utilities.isOnlyLetters(nombre)) {
			throw new Exception("El nombre solo puede contener letras");
		}
		List<ClienteDTO> ltsClienteDTO;
		ltsClienteDTO = clienteRepository.ConsultarClientesPorNombreEnOrdenAscendente(nombre);
		return ltsClienteDTO;

	}

	public Cliente guardarCliente(ClienteDTO clienteDTO) throws Exception {

		Cliente cliente = new Cliente();
		TipoIdentificacion tipoIdentificacion = null;

		// VALIDACION CORREO
		if (clienteDTO.getCorreo() == null || Utilities.isEmpty(clienteDTO.getCorreo())) {
			throw new Exception("El correo es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getCorreo(), 100)) {
			throw new Exception("El correo solo puede contener 100 caracteres");
		}
		if (!Utilities.isValidEmail(clienteDTO.getCorreo())) {
			throw new Exception("El formato de su correo no adecuado");
		}
		cliente.setCorreo(clienteDTO.getCorreo());

		// VALIDACION ESTADO
		if (clienteDTO.getEstado() == null || Utilities.isEmpty(clienteDTO.getEstado())) {
			throw new Exception("El estado es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getEstado(), 1)) {
			throw new Exception("El estado solo puede contener 1 caracter");
		}
		if (!Utilities.isOnlyLetters(clienteDTO.getEstado())) {
			throw new Exception("El estado solo puede contener letras");
		}
		cliente.setEstado(clienteDTO.getEstado());

		// VALIDACION FECHA CREACION
		if (clienteDTO.getFechaCreacion() == null) {
			throw new Exception("La fecha creacion es obligatoria");
		}
		cliente.setFechaCreacion(clienteDTO.getFechaCreacion());

		// VALIDACION FECHA NACIMIENTO
		if (clienteDTO.getFechaNacimiento() == null) {
			throw new Exception("La fecha nacimiento es obligatoria");
		}
		cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());

		// VALIDACION NOMBRE
		if (clienteDTO.getNombre() == null || Utilities.isEmpty(clienteDTO.getNombre())) {
			throw new Exception("El nombre es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getNombre(), 100)) {
			throw new Exception("El nombre solo puede contener 100 caracteres");
		}
		if (!Utilities.isOnlyLetters(clienteDTO.getNombre())) {
			throw new Exception("El nombre solo puede contener letras");
		}
		cliente.setNombre(clienteDTO.getNombre());

		// VALIDACION NUMERO IDENTIFICACION
		if (clienteDTO.getNumeroIdentificacion() == null || Utilities.isEmpty(clienteDTO.getNumeroIdentificacion())) {
			throw new Exception("El numero de identificacion es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getNumeroIdentificacion(), 15)) {
			throw new Exception("El numero de identificacion solo puede contener 15 caracteres");
		}
		if (!Utilities.isNumeric(clienteDTO.getNumeroIdentificacion())) {
			throw new Exception("El numero de identificacion solo puede contener numeros");
		}
		cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());

		// VALIDACION PRIMER APELLIDO
		if (clienteDTO.getPrimerApellido() == null || Utilities.isEmpty(clienteDTO.getPrimerApellido())) {
			throw new Exception("El primer apellido es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getPrimerApellido(), 100)) {
			throw new Exception("El primer apellido solo puede contener 100 caracteres");
		}
		if (!Utilities.isOnlyLetters(clienteDTO.getPrimerApellido())) {
			throw new Exception("El primer apellido solo puede contener letras");
		}
		cliente.setPrimerApellido(clienteDTO.getPrimerApellido());

		// VALIDACION SEGUNDO APELLIDO
		if (clienteDTO.getSegundoApellido() == null || Utilities.isEmpty(clienteDTO.getSegundoApellido())) {
			throw new Exception("El segundo apellido es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getSegundoApellido(), 100)) {
			throw new Exception("El segundo apellido solo puede contener 100 caracteres");
		}
		if (!Utilities.isOnlyLetters(clienteDTO.getSegundoApellido())) {
			throw new Exception("El segundo apellido solo puede contener letras");
		}
		cliente.setSegundoApellido(clienteDTO.getSegundoApellido());

		// VALIDACION SEXO
		if (clienteDTO.getSexo() == null || Utilities.isEmpty(clienteDTO.getSexo())) {
			throw new Exception("El sexo es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getSexo(), 1)) {
			throw new Exception("El sexo solo puede contener 1 caracter");
		}
		if (!(clienteDTO.getSexo().equals(Constantes.MASCULINO) || clienteDTO.getSexo().equals(Constantes.FEMENINO))) {
			throw new Exception("El sexo solo puede ser Masculino o Femenino");
		}
		cliente.setSexo(clienteDTO.getSexo());

		// VALIDACION TELEFONO1
		if(clienteDTO.getTelefono1()!=null && !Utilities.isEmpty(clienteDTO.getTelefono1())) {
			if (Utilities.isLongerThan(clienteDTO.getTelefono1(), 15)) {
				throw new Exception("El telefono 1 solo puede contener 15 caracteres");
			}
			if (!Utilities.isNumeric(clienteDTO.getTelefono1())) {
				throw new Exception("El telefono 1 solo puede aceptar numeros");
			}
		}
		cliente.setTelefono1(clienteDTO.getTelefono1());

		// VALIDACION TELEFONO2
		if(clienteDTO.getTelefono2()!=null && !Utilities.isEmpty(clienteDTO.getTelefono2())) {
			if (Utilities.isLongerThan(clienteDTO.getTelefono2(), 15)) {
				throw new Exception("El telefono 2 solo puede contener 15 caracteres");
			}
			if (!Utilities.isNumeric(clienteDTO.getTelefono2())&& clienteDTO.getTelefono2()!=null) {
				throw new Exception("El telefono 2 solo puede aceptar numeros");
			}
		}
		cliente.setTelefono2(clienteDTO.getTelefono2());

		// VALIDACION USU CREADOR
		if(clienteDTO.getUsuCreator()!=null && !Utilities.isEmpty(clienteDTO.getUsuCreator())) {
			if (Utilities.isLongerThan(clienteDTO.getUsuCreator(), 10)) {
				throw new Exception("El usuario creador solo puede contener 10 caracter");
			}
			if (!Utilities.isOnlyLetters(clienteDTO.getUsuCreator())&& clienteDTO.getUsuCreator()!=null) {
				throw new Exception("El usuario creador solo puede contener letras");
			}
		}
		cliente.setUsuCreator(clienteDTO.getUsuCreator());

		tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado(clienteDTO.getCodigoTipoIdentificacion(),
				Constantes.ACTIVO);

		// Validamos que el tipo destino exista y este activo
		if (tipoIdentificacion == null) {
			throw new Exception("El tipo Identificacion no existe o no esta activo");
		}
		cliente.setTipoIdentificacion(tipoIdentificacion);
		clienteRepository.save(cliente);
		return cliente;
	}

	public Cliente actualizarCliente(ClienteDTO clienteDTO) throws Exception {

		Cliente cliente = null;
		TipoIdentificacion tipoIdentificacion = null;

		cliente = findById(clienteDTO.getIdClie());

		// VALIDACION CORREO
		if (clienteDTO.getCorreo() == null || Utilities.isEmpty(clienteDTO.getCorreo())) {
			throw new Exception("El correo es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getCorreo(), 100)) {
			throw new Exception("El correo solo puede contener 100 caracteres");
		}
		if (!Utilities.isValidEmail(clienteDTO.getCorreo())) {
			throw new Exception("El correo no tiene un formato adecuado");
		}
		cliente.setCorreo(clienteDTO.getCorreo());

		// VALIDACION ESTADO
		if (clienteDTO.getEstado() == null || Utilities.isEmpty(clienteDTO.getEstado())) {
			throw new Exception("El estado es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getEstado(), 1)) {
			throw new Exception("El estado solo puede contener 1 caracter");
		}
		if (!Utilities.isOnlyLetters(clienteDTO.getEstado())) {
			throw new Exception("El estado solo puede contener letras");
		}
		cliente.setEstado(clienteDTO.getEstado());

		// VALIDACION FECHA CREACION
		if (clienteDTO.getFechaCreacion() == null) {
			throw new Exception("La fecha creacion es obligatoria");
		}
		cliente.setFechaCreacion(clienteDTO.getFechaCreacion());

		// VALIDACION FECHA NACIMIENTO
		if (clienteDTO.getFechaNacimiento() == null) {
			throw new Exception("La fecha nacimiento es obligatoria");
		}
		cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());

		// VALIDACION NOMBRE
		if (clienteDTO.getNombre() == null || Utilities.isEmpty(clienteDTO.getNombre())) {
			throw new Exception("El nombre es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getNombre(), 100)) {
			throw new Exception("El nombre solo puede contener 100 caracteres");
		}
		if (!Utilities.isOnlyLetters(clienteDTO.getNombre())) {
			throw new Exception("El nombre solo puede contener letras");
		}
		cliente.setNombre(clienteDTO.getNombre());

		// VALIDACION NUMERO IDENTIFICACION
		if (clienteDTO.getNumeroIdentificacion() == null || Utilities.isEmpty(clienteDTO.getNumeroIdentificacion())) {
			throw new Exception("El numero de identificacion es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getNumeroIdentificacion(), 15)) {
			throw new Exception("El numero de identificacion solo puede contener 15 caracteres");
		}
		if (!Utilities.isNumeric(clienteDTO.getNumeroIdentificacion())) {
			throw new Exception("El numero de identificacion solo puede contener numeros");
		}
		cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());

		// VALIDACION PRIMER APELLIDO
		if (clienteDTO.getPrimerApellido() == null || Utilities.isEmpty(clienteDTO.getPrimerApellido())) {
			throw new Exception("El primer apellido es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getPrimerApellido(), 100)) {
			throw new Exception("El primer apellido solo puede contener 100 caracteres");
		}
		if (!Utilities.isOnlyLetters(clienteDTO.getPrimerApellido())) {
			throw new Exception("El primer apellido solo puede contener letras");
		}
		cliente.setPrimerApellido(clienteDTO.getPrimerApellido());

		// VALIDACION SEGUNDO APELLIDO
		if (clienteDTO.getSegundoApellido() == null || Utilities.isEmpty(clienteDTO.getSegundoApellido())) {
			throw new Exception("El segundo apellido es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getSegundoApellido(), 100)) {
			throw new Exception("El segundo apellido solo puede contener 100 caracteres");
		}
		if (!Utilities.isOnlyLetters(clienteDTO.getSegundoApellido())) {
			throw new Exception("El segundo apellido solo puede contener letras");
		}
		cliente.setSegundoApellido(clienteDTO.getSegundoApellido());

		// VALIDACION SEXO
		if (clienteDTO.getSexo() == null || Utilities.isEmpty(clienteDTO.getSexo())) {
			throw new Exception("El sexo es obligatorio");
		}
		if (Utilities.isLongerThan(clienteDTO.getSexo(), 1)) {
			throw new Exception("El sexo solo puede contener 1 caracter");
		}
		if (!(clienteDTO.getSexo().equals(Constantes.MASCULINO) || clienteDTO.getSexo().equals(Constantes.FEMENINO))) {
			throw new Exception("El sexo solo puede ser Masculino o Femenino");
		}
		cliente.setSexo(clienteDTO.getSexo());

		// VALIDACION TELEFONO1
		if(clienteDTO.getTelefono1()!=null && !Utilities.isEmpty(clienteDTO.getTelefono1())) {
			if (Utilities.isLongerThan(clienteDTO.getTelefono1(), 15)) {
				throw new Exception("El telefono 1 solo puede contener 15 caracteres");
			}
			if (!Utilities.isNumeric(clienteDTO.getTelefono1())) {
				throw new Exception("El telefono 1 solo puede aceptar numeros");
			}
		}
		cliente.setTelefono1(clienteDTO.getTelefono1());

		// VALIDACION TELEFONO2
		if(clienteDTO.getTelefono2()!=null && !Utilities.isEmpty(clienteDTO.getTelefono2())) {
			if (Utilities.isLongerThan(clienteDTO.getTelefono2(), 15)) {
				throw new Exception("El telefono 2 solo puede contener 15 caracteres");
			}
			if (!Utilities.isNumeric(clienteDTO.getTelefono2())&& clienteDTO.getTelefono2()!=null) {
				throw new Exception("El telefono 2 solo puede aceptar numeros");
			}
		}
		cliente.setTelefono2(clienteDTO.getTelefono2());

		// VALIDACION USU CREADOR
		if(clienteDTO.getUsuCreator()!=null && !Utilities.isEmpty(clienteDTO.getUsuCreator())) {
			if (Utilities.isLongerThan(clienteDTO.getUsuCreator(), 10)) {
				throw new Exception("El usuario creador solo puede contener 10 caracter");
			}
			if (!Utilities.isOnlyLetters(clienteDTO.getUsuCreator())&& clienteDTO.getUsuCreator()!=null) {
				throw new Exception("El usuario creador solo puede contener letras");
			}
		}
		cliente.setUsuCreator(clienteDTO.getUsuCreator());

		tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado(clienteDTO.getCodigoTipoIdentificacion(),
				Constantes.ACTIVO);

		// Validamos que el tipo destino exista y este activo
		if (tipoIdentificacion == null) {
			throw new Exception("El tipo Identificacion no existe o no esta activo");
		}
		cliente.setTipoIdentificacion(tipoIdentificacion);

		clienteRepository.save(cliente);
		
		return cliente;
	}

	public Cliente findById(Long idClie) throws Exception {

		// Validamos el idDest venga con info
		if (idClie == null) {
			throw new Exception("Debe ingresar un id destino");
		}

		if (!clienteRepository.findById(idClie).isPresent()) {
			throw new Exception("El destino con id: " + idClie + " no existe");
		}

		return clienteRepository.findById(idClie).get();

	}

	public void eliminarCliente(Long idClie) throws Exception {

		// VALIDAR QUE SE INGRESE EL ID DEL CLIENTE A ELIMINAR

		if (idClie.toString() == null) {
			throw new Exception("El id del cliente es obligatorio");
		}

		Optional<Cliente> destinoBD = clienteRepository.findById(idClie);

		if (destinoBD.isPresent()) {
			clienteRepository.delete(destinoBD.get());
		} else {
			throw new Exception("No se encontra ningun cliente");
		}
	}
}
