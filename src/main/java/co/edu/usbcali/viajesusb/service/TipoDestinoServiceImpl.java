/**  
 * @Title:  TipoDestinoImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Valentina Prado     
 * @date:   7/09/2021 11:53:13 a.m.   
 * @version V1.0 
 * @Copyright: Universidad San Buenaventura
 */
package co.edu.usbcali.viajesusb.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;
import co.edu.usbcali.viajesusb.repository.TipoDestinoRepository;
import co.edu.usbcali.viajesusb.utils.Utilities;
/**   
 * @ClassName:  TipoDestinoImpl   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   7/09/2021 11:53:13 a.m.      
 * @Copyright:  USB
 */

@Scope("singleton")
@Service
public class TipoDestinoServiceImpl implements TipoDestinoService {

	@Autowired
	private TipoDestinoRepository tipoDestinoRepository;
	@Autowired
	private DestinoService destinoService;
	
	/**   
	 * <p>Title: findByCodigo</p>   
	 * <p>Description: </p>   
	 * @param codigo
	 * @return
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#findByCodigo(java.lang.String)   
	 */
	
	@Override
	public TipoDestino findByCodigo(String codigo) throws Exception {
		//NO PUEDE INGRESAR UN CODIGO VACIO
		if(codigo == null || Utilities.isEmpty(codigo)) {
			throw new Exception("El codigo es obligatorio");
		}
		//EL CODIGO DE TIPO DESTINO DEBE TENER MAXIMO 5 CARACTERES
		if(Utilities.isLongerThan(codigo, 5)) {
			throw new Exception("El tipo destino solo puede contener 5 caracteres");
		}
		//EL CODIGO SOLAMENTE ACEPTA LETRAS
		if(!Utilities.isOnlyLetters(codigo)){
			System.out.println(codigo);
			throw new Exception("El codigo solo puede contener letras ");
		}
	
		TipoDestino tipoDestino=null;
				
		tipoDestino=tipoDestinoRepository.findByCodigo(codigo);
			
		return tipoDestino;
		
	}
	
	@Override
	public TipoDestino findByCodigoAndEstado(String codigo, String estado) throws Exception {
		//NO PUEDE INGRESAR UN CODIGO VACIO
		if(codigo == null || Utilities.isEmpty(codigo)) {
			throw new Exception("El codigo es obligatorio");
		}
		//NO PUEDE INGRESAR UN CODIGO VACIO
		if(estado==null || Utilities.isEmpty(estado)) {
			throw new Exception("El estado es obligatorio");
		}
		//EL ESTADO SOLO PUEDE CONTENER UN CARACTER
		if(Utilities.isLongerThan(estado, 1)) {
			throw new Exception("El estado solo puede contener 1 carÃ¡cter");
		}
		//EL CODIGO DE TIPO DESTINO DEBE TENER MAXIMO 5 CARACTERES
		if(Utilities.isLongerThan(codigo, 5)) {
			throw new Exception("El tipo destino solo puede contener 5 caracteres");
		}
		//EL CODIGO SOLAMENTE ACEPTA LETRAS
		if(!Utilities.isOnlyLetters(codigo)){
			throw new Exception("El codigo solo puede contener letras ");
		}
		//EL CODIGO SOLAMENTE ACEPTA LETRAS
		if(!Utilities.isOnlyLetters(estado)){
			throw new Exception("El estado solo puede contener letras ");
		}
		
		
		TipoDestino tipoDestino=null;
				
		tipoDestino=tipoDestinoRepository.findByCodigoAndEstado(codigo, estado);
			
		return tipoDestino;
		
	}
	
	@Override
	public List<TipoDestino> findByEstadoOrderByNombreDesc(String estado) throws Exception{
		
		//NO PUEDE INGRESAR UN ESTADO VACIO
		if(estado == null || Utilities.isEmpty(estado)) {
			throw new Exception("El estado es obligatorio");
		}
		//EL ESTADO SOLO PUEDE CONTENER UN CARACTER
		if(Utilities.isLongerThan(estado, 1)) {
			throw new Exception("El estado solo puede contener 1 caracter");
		}
		//EL ESTADO SOLAMENTE ACEPTA LETRAS
		if(!Utilities.isOnlyLetters(estado)){
			throw new Exception("El estado solo puede contener letras ");
		}

		List<TipoDestino> lstTipoDestino;
				
		lstTipoDestino=tipoDestinoRepository.findByEstadoOrderByNombreDesc(estado);
			
		return lstTipoDestino;
		
	}
	
	public TipoDestino debeGuardarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws Exception{
		
		TipoDestino tipoDestino= new TipoDestino();
		
		//VALIDACION CODIGO
		if (tipoDestinoDTO.getCodigo() == null || Utilities.isEmpty(tipoDestinoDTO.getCodigo())) {
			throw new Exception("El codigo es obligatorio");
		}
		if (Utilities.isLongerThan(tipoDestinoDTO.getCodigo(), 5)) {
			throw new Exception("El codigo solo puede contener 5 caracteres");
		}
		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getCodigo())) {
			throw new Exception("El codigo solo puede contener letras");
		}
		tipoDestino.setCodigo(tipoDestinoDTO.getCodigo());
		
		//VALIDACION DESCRIPCION
		if (tipoDestinoDTO.getDescripcion() == null || Utilities.isEmpty(tipoDestinoDTO.getDescripcion())) {
			throw new Exception("La descripcion es obligatorio");
		}
		if (Utilities.isLongerThan(tipoDestinoDTO.getDescripcion(), 300)) {
			throw new Exception("La descripcion solo puede contener 300 caracteres");
		}
		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getDescripcion())) {
			throw new Exception("La descripcion solo  puede contener letras");
		}
		tipoDestino.setDescripcion(tipoDestinoDTO.getDescripcion());
		
		//VALIDACION ESTADO
		if (tipoDestinoDTO.getEstado() == null || Utilities.isEmpty(tipoDestinoDTO.getEstado())) {
			throw new Exception("El estado es obligatorio");
		}
		if (Utilities.isLongerThan(tipoDestinoDTO.getEstado(), 1)) {
			throw new Exception("El estado solo puede contener 1 caracter");
		}
		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getEstado())) {
			throw new Exception("El estado solo puede contener letras");
		}
		tipoDestino.setEstado(tipoDestinoDTO.getEstado());
		
		//VALIDACION FECHA CREACION
		if (tipoDestinoDTO.getFechaCreacion() == null ) {
			throw new Exception("La fecha creacion es obligatoria");
		}
		tipoDestino.setFechaCreacion(tipoDestinoDTO.getFechaCreacion());
		
		//VALIDACION NOMBRE
		if (tipoDestinoDTO.getNombre() == null || Utilities.isEmpty(tipoDestinoDTO.getNombre())) {
			throw new Exception("El nombre es obligatorio");
		}
		if (Utilities.isLongerThan(tipoDestinoDTO.getNombre(), 100)) {
			throw new Exception("El nombre solo puede contener 100 caracteres");
		}
		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getNombre())) {
			throw new Exception("El nombre solo puede contener letras");
		}
		tipoDestino.setNombre(tipoDestinoDTO.getNombre());
		
		//VALIDACION USUARIO CREADOR
		if (tipoDestinoDTO.getUsuCreator() == null || Utilities.isEmpty(tipoDestinoDTO.getUsuCreator())) {
			throw new Exception("El usuario creador es obligatorio");
		}
		if (Utilities.isLongerThan(tipoDestinoDTO.getUsuCreator(), 10)) {
			throw new Exception("El usuario creador solo puede contener 10 caracter");
		}
		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getUsuCreator())) {
			throw new Exception("El usuario creador solo puede contener letras");
		}
		tipoDestino.setUsuCreator(tipoDestinoDTO.getUsuCreator());
		
		tipoDestinoRepository.save(tipoDestino);
		
		return tipoDestino;
	}
	
	public TipoDestino debeActualizarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws Exception{
		
		TipoDestino tipoDestino= null;
		tipoDestino= findById(tipoDestinoDTO.getIdTide());
		
		//VALIDACION CODIGO
		if (tipoDestinoDTO.getCodigo() == null || Utilities.isEmpty(tipoDestinoDTO.getCodigo())) {
			throw new Exception("El codigo es obligatorio");
		}
		if (Utilities.isLongerThan(tipoDestinoDTO.getCodigo(), 5)) {
			throw new Exception("El codigo solo puede contener 5 caracteres");
		}
		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getCodigo())) {
			throw new Exception("El codigo solo puede contener letras");
		}
		tipoDestino.setCodigo(tipoDestinoDTO.getCodigo());
		
		//VALIDACION DESCRIPCION
		if (tipoDestinoDTO.getDescripcion() == null || Utilities.isEmpty(tipoDestinoDTO.getDescripcion())) {
			throw new Exception("La descripcion es obligatorio");
		}
		if (Utilities.isLongerThan(tipoDestinoDTO.getDescripcion(), 300)) {
			throw new Exception("La descripcion solo puede contener 300 caracteres");
		}
		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getDescripcion())) {
			throw new Exception("La descripcion solo  puede contener letras");
		}
		tipoDestino.setDescripcion(tipoDestinoDTO.getDescripcion());
		
		//VALIDACION ESTADO
		if (tipoDestinoDTO.getEstado() == null || Utilities.isEmpty(tipoDestinoDTO.getEstado())) {
			throw new Exception("El estado es obligatorio");
		}
		if (Utilities.isLongerThan(tipoDestinoDTO.getEstado(), 1)) {
			throw new Exception("El estado solo puede contener 1 caracter");
		}
		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getEstado())) {
			throw new Exception("El estado solo puede contener letras");
		}
		tipoDestino.setEstado(tipoDestinoDTO.getEstado());
		
		//VALIDACION FECHA CREACION
		if (tipoDestinoDTO.getFechaCreacion() == null ) {
			throw new Exception("La fecha creacion es obligatoria");
		}
		tipoDestino.setFechaCreacion(tipoDestinoDTO.getFechaCreacion());
		
		//VALIDACION NOMBRE
		if (tipoDestinoDTO.getNombre() == null || Utilities.isEmpty(tipoDestinoDTO.getNombre())) {
			throw new Exception("El nombre es obligatorio");
		}
		if (Utilities.isLongerThan(tipoDestinoDTO.getNombre(), 100)) {
			throw new Exception("El nombre solo puede contener 100 caracteres");
		}
		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getNombre())) {
			throw new Exception("El nombre solo puede contener letras");
		}
		tipoDestino.setNombre(tipoDestinoDTO.getNombre());
		
		//VALIDACION USUARIO CREADOR
		if (tipoDestinoDTO.getUsuCreator() == null || Utilities.isEmpty(tipoDestinoDTO.getUsuCreator())) {
			throw new Exception("El usuario creador es obligatorio");
		}
		if (Utilities.isLongerThan(tipoDestinoDTO.getUsuCreator(), 10)) {
			throw new Exception("El usuario creador solo puede contener 10 caracter");
		}
		if (!Utilities.isOnlyLetters(tipoDestinoDTO.getUsuCreator())) {
			throw new Exception("El usuario creador solo puede contener letras");
		}
		tipoDestino.setUsuCreator(tipoDestinoDTO.getUsuCreator());
		
		tipoDestinoRepository.save(tipoDestino);
		
		return tipoDestino;
	}
	
	public TipoDestino findById(Long idTiDe) throws Exception{
	
		
		//Validamos el idDest venga con info
		if(idTiDe == null) {
			throw new Exception("Debe ingresar un id destino");
		}
		
		if(!tipoDestinoRepository.findById(idTiDe).isPresent()) {
			throw new Exception("El tipo destino con id: "+idTiDe + " no existe");
		}
		
		return tipoDestinoRepository.findById(idTiDe).get();
		
	}
	
	
	public void eliminarTipoDestino(Long idtide) throws Exception{
		
		//VALIDAR QUE SE INGRESE EL ID DEL TIPO DESTINO A ELIMINAR
		
		if(idtide.toString() == null) {
			throw new Exception("El id del tipo destino es obligatorio");
		}
		
		Optional<TipoDestino> tipoDestinoBD= tipoDestinoRepository.findById(idtide);
		List<Destino> destinosBD = destinoService.findByTipoDestino_Codigo(findById(idtide).getCodigo());
		
		if(tipoDestinoBD.isPresent()) {
			if(destinosBD.isEmpty()) {
				tipoDestinoRepository.delete(tipoDestinoBD.get());
			}
			else {
				throw new Exception("No se puede eliminar un tipo destino que este en uso");
			}
			
		}
		else {
			throw new Exception("No se encontro algun tipo destino");
		}
	
	}
}
