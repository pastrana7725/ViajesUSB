package co.edu.usbcali.viajesusb.mapper;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-10T20:49:08-0500",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class TipoDestinoMapperImpl implements TipoDestinoMapper {

    @Override
    public TipoDestinoDTO tipoDestinoToTipoDestinoDTO(TipoDestino tipoDestino) {
        if ( tipoDestino == null ) {
            return null;
        }

        TipoDestinoDTO tipoDestinoDTO = new TipoDestinoDTO();

        tipoDestinoDTO.setCodigo( tipoDestino.getCodigo() );
        tipoDestinoDTO.setDescripcion( tipoDestino.getDescripcion() );
        tipoDestinoDTO.setEstado( tipoDestino.getEstado() );
        tipoDestinoDTO.setFechaCreacion( tipoDestino.getFechaCreacion() );
        tipoDestinoDTO.setFechaModificacion( tipoDestino.getFechaModificacion() );
        tipoDestinoDTO.setIdTide( tipoDestino.getIdTide() );
        tipoDestinoDTO.setNombre( tipoDestino.getNombre() );
        tipoDestinoDTO.setUsuCreator( tipoDestino.getUsuCreator() );
        tipoDestinoDTO.setUsuModificador( tipoDestino.getUsuModificador() );

        return tipoDestinoDTO;
    }

    @Override
    public List<TipoDestinoDTO> listTipoDestinoToListTipoDestinoDTO(List<TipoDestino> lstTipoDestino) {
        if ( lstTipoDestino == null ) {
            return null;
        }

        List<TipoDestinoDTO> list = new ArrayList<TipoDestinoDTO>( lstTipoDestino.size() );
        for ( TipoDestino tipoDestino : lstTipoDestino ) {
            list.add( tipoDestinoToTipoDestinoDTO( tipoDestino ) );
        }

        return list;
    }

    @Override
    public List<TipoDestinoDTO> listTipoDestinoDTOToListTipoDestino(List<TipoDestino> lstTipoDestino) {
        if ( lstTipoDestino == null ) {
            return null;
        }

        List<TipoDestinoDTO> list = new ArrayList<TipoDestinoDTO>( lstTipoDestino.size() );
        for ( TipoDestino tipoDestino : lstTipoDestino ) {
            list.add( tipoDestinoToTipoDestinoDTO( tipoDestino ) );
        }

        return list;
    }
}
