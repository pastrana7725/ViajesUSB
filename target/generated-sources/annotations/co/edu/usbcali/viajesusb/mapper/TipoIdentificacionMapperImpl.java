package co.edu.usbcali.viajesusb.mapper;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-10T20:49:05-0500",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class TipoIdentificacionMapperImpl implements TipoIdentificacionMapper {

    @Override
    public TipoIdentificacionDTO tipoIdentificacionToTipoIdentificacionDTO(TipoIdentificacion tipoDestino) {
        if ( tipoDestino == null ) {
            return null;
        }

        TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();

        tipoIdentificacionDTO.setCodigo( tipoDestino.getCodigo() );
        tipoIdentificacionDTO.setEstado( tipoDestino.getEstado() );
        tipoIdentificacionDTO.setFechaCreacion( tipoDestino.getFechaCreacion() );
        tipoIdentificacionDTO.setFechaModificacion( tipoDestino.getFechaModificacion() );
        tipoIdentificacionDTO.setIdTiId( tipoDestino.getIdTiId() );
        tipoIdentificacionDTO.setNombre( tipoDestino.getNombre() );
        tipoIdentificacionDTO.setUsuCreador( tipoDestino.getUsuCreador() );
        tipoIdentificacionDTO.setUsuModificador( tipoDestino.getUsuModificador() );

        return tipoIdentificacionDTO;
    }

    @Override
    public List<TipoIdentificacionDTO> listTipoIdentificacionToListTipoIdentificacionDTO(List<TipoIdentificacion> lsttipoDestino) {
        if ( lsttipoDestino == null ) {
            return null;
        }

        List<TipoIdentificacionDTO> list = new ArrayList<TipoIdentificacionDTO>( lsttipoDestino.size() );
        for ( TipoIdentificacion tipoIdentificacion : lsttipoDestino ) {
            list.add( tipoIdentificacionToTipoIdentificacionDTO( tipoIdentificacion ) );
        }

        return list;
    }

    @Override
    public List<TipoIdentificacionDTO> listTipoIdentificacionDTOToListTipoIdentificacion(List<TipoIdentificacion> lsttipoDestino) {
        if ( lsttipoDestino == null ) {
            return null;
        }

        List<TipoIdentificacionDTO> list = new ArrayList<TipoIdentificacionDTO>( lsttipoDestino.size() );
        for ( TipoIdentificacion tipoIdentificacion : lsttipoDestino ) {
            list.add( tipoIdentificacionToTipoIdentificacionDTO( tipoIdentificacion ) );
        }

        return list;
    }
}
