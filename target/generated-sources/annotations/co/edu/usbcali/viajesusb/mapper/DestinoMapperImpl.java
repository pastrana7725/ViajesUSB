package co.edu.usbcali.viajesusb.mapper;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-16T12:28:03-0500",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.3.1300.v20210419-1022, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class DestinoMapperImpl implements DestinoMapper {

    @Override
    public DestinoDTO destinoToDestinoDTO(Destino destino) {
        if ( destino == null ) {
            return null;
        }

        DestinoDTO destinoDTO = new DestinoDTO();

        destinoDTO.setNombreTipoDestino( destinoTipoDestinoNombre( destino ) );
        destinoDTO.setCodigoTipoDestino( destinoTipoDestinoCodigo( destino ) );
        destinoDTO.setIdTide( destinoTipoDestinoIdTide( destino ) );
        destinoDTO.setAire( destino.getAire() );
        destinoDTO.setCodigo( destino.getCodigo() );
        destinoDTO.setDescripcion( destino.getDescripcion() );
        destinoDTO.setEstado( destino.getEstado() );
        destinoDTO.setFechaCreacion( destino.getFechaCreacion() );
        destinoDTO.setFechaModificacion( destino.getFechaModificacion() );
        destinoDTO.setIdDest( destino.getIdDest() );
        destinoDTO.setMar( destino.getMar() );
        destinoDTO.setNombre( destino.getNombre() );
        destinoDTO.setTierra( destino.getTierra() );
        destinoDTO.setUsuCreator( destino.getUsuCreator() );
        destinoDTO.setUsuModificador( destino.getUsuModificador() );

        return destinoDTO;
    }

    @Override
    public List<DestinoDTO> ListDestinoToListDestinoDTO(List<Destino> lstDestinos) {
        if ( lstDestinos == null ) {
            return null;
        }

        List<DestinoDTO> list = new ArrayList<DestinoDTO>( lstDestinos.size() );
        for ( Destino destino : lstDestinos ) {
            list.add( destinoToDestinoDTO( destino ) );
        }

        return list;
    }

    private String destinoTipoDestinoNombre(Destino destino) {
        if ( destino == null ) {
            return null;
        }
        TipoDestino tipoDestino = destino.getTipoDestino();
        if ( tipoDestino == null ) {
            return null;
        }
        String nombre = tipoDestino.getNombre();
        if ( nombre == null ) {
            return null;
        }
        return nombre;
    }

    private String destinoTipoDestinoCodigo(Destino destino) {
        if ( destino == null ) {
            return null;
        }
        TipoDestino tipoDestino = destino.getTipoDestino();
        if ( tipoDestino == null ) {
            return null;
        }
        String codigo = tipoDestino.getCodigo();
        if ( codigo == null ) {
            return null;
        }
        return codigo;
    }

    private Long destinoTipoDestinoIdTide(Destino destino) {
        if ( destino == null ) {
            return null;
        }
        TipoDestino tipoDestino = destino.getTipoDestino();
        if ( tipoDestino == null ) {
            return null;
        }
        long idTide = tipoDestino.getIdTide();
        return idTide;
    }
}
