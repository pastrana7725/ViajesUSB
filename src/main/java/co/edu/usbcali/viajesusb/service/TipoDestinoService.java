/**  
 * @Title:  TipoDestinoService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Valentina Prado     
 * @date:   7/09/2021 11:51:02 a.�m.   
 * @version V1.0 
 * @Copyright: Universidad San Buenaventura
 */
package co.edu.usbcali.viajesusb.service;
import java.util.List;
import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;
/**   
 * @ClassName:  TipoDestinoService   
  * @Description: TODO   
 * @author: Diego Pastrana     
 * @date:   7/09/2021 11:51:02 a.�m.      
 * @Copyright:  USB
 */

public interface TipoDestinoService {
	
	public TipoDestino findByCodigo(String codigo) throws Exception;
	
	public TipoDestino findByCodigoAndEstado(String codigo, String estado) throws Exception;
	
	public List<TipoDestino> findByEstadoOrderByNombreDesc(String estado) throws Exception;
	
	public TipoDestino debeGuardarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws Exception;
	
	public TipoDestino debeActualizarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws Exception;
	
	public void eliminarTipoDestino(Long idtide) throws Exception;
}
