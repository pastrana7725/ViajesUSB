/**  
 * @Title:  ClienteService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Valentina Prado     
 * @date:   14/09/2021 4:28:47 p.�m.   
 * @version V1.0 
 * @Copyright: Universidad San Buenaventura
 */
package co.edu.usbcali.viajesusb.service;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
/**   
 * @ClassName:  ClienteService   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   14/09/2021 4:28:47 p.�m.      
 * @Copyright:  USB
 */

public interface ClienteService {

public Page<Cliente> findByEstadoOrderByNumeroIdentificacionAsc(String estado, Pageable pageable) throws Exception;
	
	public Cliente findByCorreoIgnoreCase(String correo) throws Exception;
	
	public Cliente findByNumeroIdentificacionLike(String identificacion) throws Exception;
	
	public List<Cliente> findByNombreIgnoreCaseLike(String nombre) throws Exception; 
	
	public List<Cliente> findByFechaNacimientoBetween(Date start , Date finish)throws Exception;
	
	public Integer countByEstado(String estado) throws Exception;
	
	public Page<Cliente> findByTipoIdentificacion_Codigo(String codigoTipoIdentificacion,Pageable pageable) throws Exception;
	
	public List<Cliente> findByPrimerApellidoOrSegundoApellido(String primerApellido, String segundoApellido) throws Exception;
	
	public List<ClienteDTO> ConsultarClientesPorEstado(@Param("pEstado")String estado) throws Exception;
	
	public ClienteDTO ConsultarClientesPorNumeroIdentificacion(@Param("pIdentificacion")String numeroIdentificacion) throws Exception;
	
	public List<ClienteDTO> ConsultarClientesPorTipoIdentificacion(@Param("pTipoIdentificacion")String tipoIdentificacion) throws Exception;
	
	public List<ClienteDTO> ConsultarClientesPorNombreEnOrdenAscendente(@Param("pNombre")String nombre)throws Exception;
	
	public Cliente guardarCliente(ClienteDTO clienteDTO) throws Exception;
	
	public Cliente actualizarCliente(ClienteDTO clienteDTO) throws Exception;
	
	public void eliminarCliente(Long idClie) throws Exception;
}
