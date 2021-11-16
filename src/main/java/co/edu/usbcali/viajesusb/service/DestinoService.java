/**  
 * @Title:  DestinoService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Valentina Prado     
 * @date:   7/09/2021 12:21:53 p.�m.   
 * @version V1.0 
 * @Copyright: Universidad San Buenaventura
 */
package co.edu.usbcali.viajesusb.service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
/**   
 * @ClassName:  DestinoService   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   7/09/2021 12:21:53 p.�m.      
 * @Copyright:  USB
 */

public interface DestinoService  {

	public List<Destino> findByTipoDestino_Codigo(String codigoTipoDestino) throws Exception;
	
	public List<Destino> findByEstado(String estado) throws Exception;
	
	public Destino guardarDestino(DestinoDTO destinoDTO) throws Exception;
	
	public Destino actualizarDestino(DestinoDTO destinoDTO) throws Exception;
	
	public void eliminarDestino(Long idDestino) throws Exception;
	
	public Destino findByCodigo(String codigo) throws Exception;
}
