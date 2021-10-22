/**  
 * @Title:  DestinoServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Valentina Prado     
 * @date:   7/09/2021 12:22:06 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San Buenaventura
 */
package co.edu.usbcali.viajesusb.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.repository.DestinoRepository;
import co.edu.usbcali.viajesusb.utils.Constantes;
import co.edu.usbcali.viajesusb.utils.Utilities;
/**   
 * @ClassName:  DestinoServiceImpl   
  * @Description: TODO   
 * @author: Diego Pastrana    
 * @date:   7/09/2021 12:22:06 p.m.      
 * @Copyright:  USB
 */

@Scope("singleton")
@Service
public class DestinoServiceImpl implements DestinoService{

	@Autowired
	private DestinoRepository destinoRepository;
	
	@Autowired
	private TipoDestinoService tipoDestinoService;
	
	/**   
	 * <p>Title: findByTipoDestinoCodigo</p>   
	 * <p>Description: </p>   
	 * @param codigoTipoDestino
	 * @return
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.DestinoService#findByTipoDestinoCodigo(java.lang.String)   
	 */
	
	@Override
	public List<Destino> findByTipoDestino_Codigo(String codigoTipoDestino) throws Exception {
		
		List<Destino> lstDestino=null;
		
		//NO PUEDE INGRESAR VALORES VACIOS
		if(codigoTipoDestino == null || Utilities.isEmpty(codigoTipoDestino)) {
			throw new Exception("El codigo es obligatorio");
		}
		//EL CODIGO DE TIPO DESTINO DEBE TENER MAXIMO 5 CARACTERES
		if(Utilities.isLongerThan(codigoTipoDestino, 5)) {
			throw new Exception("El tipo destino solo puede contener 5 caracteres");
		}
		//SOLAMENTE ACEPTA LETRAS
		if(!Utilities.isOnlyLetters(codigoTipoDestino)){
			throw new Exception("El codigo solo puede contener letras ");
		}
		
		lstDestino=destinoRepository.findByTipoDestino_Codigo(codigoTipoDestino);
		return lstDestino;	
	}

	/**   
	 * <p>Title: findByEstado</p>   
	 * <p>Description: </p>   
	 * @param estado
	 * @param pageable
	 * @return
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.DestinoService#findByEstado(java.lang.String, org.springframework.data.domain.Pageable)   
	 */
	
	@Override
	public Page<Destino> findByEstado(String estado, Pageable pageable) throws Exception {
		//NO PUEDE INGRESAR UN ESTADO VACIO
		if(estado == null || Utilities.isEmpty(estado)) {
			throw new Exception("El estado es obligatorio");
		}
		//EL ESTADO SOLO PUEDE CONTENER UN CARACTER
		if(Utilities.isLongerThan(estado, 1)) {
			throw new Exception("El estado solo puede contener 1 caracter");
		}
		//NO PUEDE INGRESAR UN PAGEABLE VACIO
		if(pageable == null) {
			throw new Exception("El Pageable no puede ser nulo");
		}
		
		//EL ESTADO SOLAMENTE ACEPTA LETRAS
		if(!Utilities.isOnlyLetters(estado)){
			throw new Exception("El estado solo puede contener letras ");
		}
		
		Page<Destino> pageDestino= destinoRepository.findByEstado(estado, pageable);
		return pageDestino;
	}

	
	/**
	 * 
	 * @Title: guardarDestino   
	   * @Description: Este metodo guarda el destino 
	 * @param: @param destino
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public Destino guardarDestino(DestinoDTO destinoDTO) throws Exception {
		
		Destino destino= null;
		TipoDestino tipoDestino = null;
		destino = new Destino();
		
		//VALIDACION AIRE
		if (destinoDTO.getAire() == null || Utilities.isEmpty(destinoDTO.getAire())) {
			throw new Exception("El campo del aire es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getAire(), 1)) {
			throw new Exception("El campo del aire solo puede contener 1 caracter");
		}
		if (!(destinoDTO.getAire().equals(Constantes.SI)||destinoDTO.getAire().equals(Constantes.NO))) {
			throw new Exception("El campo del aire solo acepta Si o No");
		}
		destino.setAire(destinoDTO.getAire());
		
		//VALIDACION CODIGO
		if (destinoDTO.getCodigo() == null || Utilities.isEmpty(destinoDTO.getCodigo())) {
			throw new Exception("El codigo es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getCodigo(), 5)) {
			throw new Exception("El codigo solo puede contener 5 caracteres");
		}
		if (!Utilities.isOnlyLetters(destinoDTO.getCodigo())) {
			throw new Exception("El codigo solo puede contener letras");
		}
		destino.setCodigo(destinoDTO.getCodigo());
		
		//VALIDACION DESCRIPCION
		if (destinoDTO.getDescripcion() == null || Utilities.isEmpty(destinoDTO.getDescripcion())) {
			throw new Exception("La descripcion es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getDescripcion(), 300)) {
			throw new Exception("La descripcion solo puede contener 300 caracteres");
		}
		destino.setDescripcion(destinoDTO.getDescripcion());
		
		//VALIDACION ESTADO
		if (destinoDTO.getEstado() == null || Utilities.isEmpty(destinoDTO.getEstado())) {
			throw new Exception("El estado es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getEstado(), 1)) {
			throw new Exception("El estado solo puede contener 1 caracter");
		}
		if (!Utilities.isOnlyLetters(destinoDTO.getEstado())) {
			throw new Exception("El estado solo puede contener letras");
		}
		destino.setEstado(destinoDTO.getEstado());
		
		//VALIDACION FECHA CREACION
		if (destinoDTO.getFechaCreacion() == null ) {
			throw new Exception("La fecha creacion es obligatoria");
		}
		destino.setFechaCreacion(destinoDTO.getFechaCreacion());
		
		//VALIDACION MAR
		if (destinoDTO.getAire() == null || Utilities.isEmpty(destinoDTO.getMar())) {
			throw new Exception("El campo del mar es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getMar(), 1)) {
			throw new Exception("El campo del mar solo puede contener 1 caracter");
		}
		if (!(destinoDTO.getMar().equals(Constantes.SI)||destinoDTO.getMar().equals(Constantes.NO))) {
			throw new Exception("El campo del mar solo acepta Si o No");
		}
		destino.setMar(destinoDTO.getMar());
		
		//VALIDACION NOMBRE
		if (destinoDTO.getNombre() == null || Utilities.isEmpty(destinoDTO.getNombre())) {
			throw new Exception("El nombre es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getNombre(), 100)) {
			throw new Exception("El nombre solo puede contener 100 caracteres");
		}
		if (!Utilities.isOnlyLetters(destinoDTO.getNombre())) {
			throw new Exception("El nombre solo puede contener letras");
		}
		destino.setNombre(destinoDTO.getNombre());
		
		//VALIDACION TIERRA
		if (destinoDTO.getTierra() == null || Utilities.isEmpty(destinoDTO.getTierra())) {
			throw new Exception("El campo de tierra es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getTierra(), 1)) {
			throw new Exception("El campo de tierra solo puede contener 1 caracter");
		}
		if (!(destinoDTO.getTierra().equals(Constantes.SI)||destinoDTO.getTierra().equals(Constantes.NO))) {
			throw new Exception("El campo de tierra solo acepta Si o No");
		}
		destino.setTierra(destinoDTO.getTierra());
		
		//VALIDACION USUARIO CREADOR
		if (destinoDTO.getUsuCreator() == null || Utilities.isEmpty(destinoDTO.getUsuCreator())) {
			throw new Exception("El usuario creador es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getUsuCreator(), 10)) {
			throw new Exception("El usuario creador solo puede contener 10 caracter");
		}
		if (!Utilities.isOnlyLetters(destinoDTO.getUsuCreator())) {
			throw new Exception("El usuario creador solo puede contener letras");
		}
		destino.setUsuCreator(destinoDTO.getUsuCreator());
		
		//SE CONSULTA EL TIPO DESTINO DADO SU ID
		tipoDestino = tipoDestinoService.findByCodigoAndEstado(destinoDTO.getCodigoTipoDestino(),Constantes.ACTIVO);
		
		//VALIDAMOS QUE EL TIPO DESTINO EXISTA Y ESTA ACTIVO
		if(tipoDestino==null) {
			throw new Exception("El tipo destino "+destinoDTO.getCodigoTipoDestino()+" No existe");
		}
		destino.setTipoDestino(tipoDestino);
		
		destinoRepository.save(destino);
		
		return destino;
	}
	
	/**
	 * 
	 * @Title: actualizarDestino   
	   * @Description: Este metodo actualiza el destino 
	 * @param: @param destino
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public Destino actualizarDestino(DestinoDTO destinoDTO) throws Exception{
		
		Destino destino = null;
		TipoDestino tipoDestino = null;
		
		//TODO: Pendiente validaciones

		//Se arma el destino
		destino = findById(destinoDTO.getIdDest());
		
		//VALIDACION AIRE
		if (destinoDTO.getAire() == null || Utilities.isEmpty(destinoDTO.getAire())) {
			throw new Exception("El campo del aire es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getAire(), 1)) {
			throw new Exception("El campo del aire solo puede contener 1 caracter");
		}
		if (!(destinoDTO.getAire().equals(Constantes.SI)||destinoDTO.getAire().equals(Constantes.NO))) {
			throw new Exception("El campo del aire solo acepta Si o No");
		}
		destino.setAire(destinoDTO.getAire());
		
		//VALIDACION CODIGO
		if (destinoDTO.getCodigo() == null || Utilities.isEmpty(destinoDTO.getCodigo())) {
			throw new Exception("El codigo es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getCodigo(), 5)) {
			throw new Exception("El codigo solo puede contener 5 caracteres");
		}
		if (!Utilities.isOnlyLetters(destinoDTO.getCodigo())) {
			throw new Exception("El codigo solo puede contener letras");
		}
		destino.setCodigo(destinoDTO.getCodigo());
		
		//VALIDACION DESCRIPCION
		if (destinoDTO.getDescripcion() == null || Utilities.isEmpty(destinoDTO.getDescripcion())) {
			throw new Exception("La descripcion es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getDescripcion(), 300)) {
			throw new Exception("La descripcion solo puede contener 300 caracteres");
		}
		destino.setDescripcion(destinoDTO.getDescripcion());
		
		//VALIDACION ESTADO
		if (destinoDTO.getEstado() == null || Utilities.isEmpty(destinoDTO.getEstado())) {
			throw new Exception("El estado es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getEstado(), 1)) {
			throw new Exception("El estado solo puede contener 1 caracter");
		}
		if (!Utilities.isOnlyLetters(destinoDTO.getEstado())) {
			throw new Exception("El estado solo puede contener letras");
		}
		destino.setEstado(destinoDTO.getEstado());
		
		//VALIDACION FECHA CREACION
		if (destinoDTO.getFechaCreacion() == null ) {
			throw new Exception("La fecha creacion es obligatoria");
		}
		destino.setFechaCreacion(destinoDTO.getFechaCreacion());
		
		//VALIDACION MAR
		if (destinoDTO.getAire() == null || Utilities.isEmpty(destinoDTO.getMar())) {
			throw new Exception("El campo del mar es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getMar(), 1)) {
			throw new Exception("El campo del mar solo puede contener 1 caracter");
		}
		if (!(destinoDTO.getMar().equals(Constantes.SI)||destinoDTO.getMar().equals(Constantes.NO))) {
			throw new Exception("El campo del mar solo acepta Si o No");
		}
		destino.setMar(destinoDTO.getMar());
		
		//VALIDACION NOMBRE
		if (destinoDTO.getNombre() == null || Utilities.isEmpty(destinoDTO.getNombre())) {
			throw new Exception("El nombre es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getNombre(), 100)) {
			throw new Exception("El nombre solo puede contener 100 caracteres");
		}
		if (!Utilities.isOnlyLetters(destinoDTO.getNombre())) {
			throw new Exception("El nombre solo puede contener letras");
		}
		destino.setNombre(destinoDTO.getNombre());
		
		//VALIDACION TIERRA
		if (destinoDTO.getTierra() == null || Utilities.isEmpty(destinoDTO.getTierra())) {
			throw new Exception("El campo de tierra es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getTierra(), 1)) {
			throw new Exception("El campo de tierra solo puede contener 1 caracter");
		}
		if (!(destinoDTO.getTierra().equals(Constantes.SI)||destinoDTO.getTierra().equals(Constantes.NO))) {
			throw new Exception("El campo de tierra solo acepta Si o No");
		}
		destino.setTierra(destinoDTO.getTierra());
		
		//VALIDACION USUARIO CREADOR
		if (destinoDTO.getUsuCreator() == null || Utilities.isEmpty(destinoDTO.getUsuCreator())) {
			throw new Exception("El usuario creador es obligatorio");
		}
		if (Utilities.isLongerThan(destinoDTO.getUsuCreator(), 10)) {
			throw new Exception("El usuario creador solo puede contener 10 caracter");
		}
		if (!Utilities.isOnlyLetters(destinoDTO.getUsuCreator())) {
			throw new Exception("El usuario creador solo puede contener letras");
		}
		destino.setUsuCreator(destinoDTO.getUsuCreator());
		
		//Se consulta el tipo destino dado su id
		tipoDestino = tipoDestinoService.findByCodigoAndEstado(destinoDTO.getCodigoTipoDestino(), Constantes.ACTIVO);
		
		//Validamos que el tipo destino exista y este activo
		if(tipoDestino == null) {
			throw new Exception("El tipo destino "+destinoDTO.getCodigoTipoDestino() + " NO existe");
		}
		
		destino.setTipoDestino(tipoDestino);

		destinoRepository.save(destino);
		
		return destino;
		
		
	}
	
	/**
	 * 
	 * @Title: findById   
	   * @Description: TODO 
	 * @param: @param idDest
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: Optional<Destino>      
	 * @throws
	 */
	
	public Destino findById(Long idDest) throws Exception{
	
		
		//Validamos el idDest venga con info
		if(idDest == null) {
			throw new Exception("Debe ingresar un id destino");
		}
		
		if(!destinoRepository.findById(idDest).isPresent()) {
			throw new Exception("El destino con id: "+idDest + " no existe");
		}
		
		return destinoRepository.findById(idDest).get();
		
	}
	
	public void eliminarDestino(Long idDestino) throws Exception{
			
			//VALIDAR QUE SE INGRESE EL ID DEL DESTINO A ELIMINAR
			
			if(idDestino.toString() == null) {
				throw new Exception("El id destino es obligatorio");
			}
			
			Optional<Destino> destinoBD= destinoRepository.findById(idDestino);
			
			if(destinoBD.isPresent()) {
				destinoRepository.delete(destinoBD.get());
			}
			else {
				
				throw new Exception ("No se encontro ningun destino");
				
			}	
	 }
	
}
