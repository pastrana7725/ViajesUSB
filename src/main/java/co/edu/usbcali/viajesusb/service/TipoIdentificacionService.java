/**  
 * @Title:  TipoIdentificacionService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Valentina Prado     
 * @date:   14/09/2021 5:10:33 p.�m.   
 * @version V1.0 
 * @Copyright: Universidad San Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.util.List;
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;

public interface TipoIdentificacionService {

	public List<TipoIdentificacion> findByEstadoOrderByNombreAsc(String estado) throws Exception;

	public TipoIdentificacion findByCodigoAndEstado(String codigo, String estado) throws Exception;

	public TipoIdentificacion guardarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception;

	public TipoIdentificacion actualizarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception;

	public void eliminarTipoIdentificacion(Long idTide) throws Exception;

}
