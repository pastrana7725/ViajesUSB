/**  
 * @Title:  TipoDestinoMapper.java   
 * @Package co.edu.usbcali.viajesusb.mapper   
 * @Description: description   
 * @author: Carlos Garaicoa     
 * @date:   12/10/2021 11:32:42 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;

/**   
 * @ClassName:  TipoDestinoMapper   
  * @Description: TODO   
 * @author: Diego Pastrana  
 * @date:   12/10/2021 11:32:42 a. m.      
 * @Copyright:  USB
 */
@Mapper(componentModel="spring")
public interface TipoDestinoMapper {
	
	public TipoDestinoDTO tipoDestinoToTipoDestinoDTO(TipoDestino tipoDestino);

	
	public List<TipoDestinoDTO> listTipoDestinoToListTipoDestinoDTO(List<TipoDestino> lstTipoDestino);
	public List<TipoDestinoDTO> listTipoDestinoDTOToListTipoDestino(List<TipoDestino> lstTipoDestino);
	
}
