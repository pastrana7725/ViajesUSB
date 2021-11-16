package co.edu.usbcali.viajesusb.mapper;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
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
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDTO clienteToClienteDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setCodigoTipoIdentificacion( clienteTipoIdentificacionCodigo( cliente ) );
        clienteDTO.setCorreo( cliente.getCorreo() );
        clienteDTO.setEstado( cliente.getEstado() );
        clienteDTO.setFechaCreacion( cliente.getFechaCreacion() );
        clienteDTO.setFechaModificacion( cliente.getFechaModificacion() );
        clienteDTO.setFechaNacimiento( cliente.getFechaNacimiento() );
        clienteDTO.setIdClie( cliente.getIdClie() );
        clienteDTO.setNombre( cliente.getNombre() );
        clienteDTO.setNumeroIdentificacion( cliente.getNumeroIdentificacion() );
        clienteDTO.setPrimerApellido( cliente.getPrimerApellido() );
        clienteDTO.setSegundoApellido( cliente.getSegundoApellido() );
        clienteDTO.setSexo( cliente.getSexo() );
        clienteDTO.setTelefono1( cliente.getTelefono1() );
        clienteDTO.setTelefono2( cliente.getTelefono2() );
        clienteDTO.setUsuCreator( cliente.getUsuCreator() );
        clienteDTO.setUsuModificador( cliente.getUsuModificador() );

        return clienteDTO;
    }

    @Override
    public Cliente clienteDTOTocliente(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setTipoIdentificacion( clienteDTOToTipoIdentificacion( clienteDTO ) );
        cliente.setCorreo( clienteDTO.getCorreo() );
        cliente.setEstado( clienteDTO.getEstado() );
        cliente.setFechaCreacion( clienteDTO.getFechaCreacion() );
        cliente.setFechaModificacion( clienteDTO.getFechaModificacion() );
        cliente.setFechaNacimiento( clienteDTO.getFechaNacimiento() );
        cliente.setIdClie( clienteDTO.getIdClie() );
        cliente.setNombre( clienteDTO.getNombre() );
        cliente.setNumeroIdentificacion( clienteDTO.getNumeroIdentificacion() );
        cliente.setPrimerApellido( clienteDTO.getPrimerApellido() );
        cliente.setSegundoApellido( clienteDTO.getSegundoApellido() );
        cliente.setSexo( clienteDTO.getSexo() );
        cliente.setTelefono1( clienteDTO.getTelefono1() );
        cliente.setTelefono2( clienteDTO.getTelefono2() );
        cliente.setUsuCreator( clienteDTO.getUsuCreator() );
        cliente.setUsuModificador( clienteDTO.getUsuModificador() );

        return cliente;
    }

    @Override
    public List<ClienteDTO> listClienteToListClienteDTO(List<Cliente> lstcliente) {
        if ( lstcliente == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( lstcliente.size() );
        for ( Cliente cliente : lstcliente ) {
            list.add( clienteToClienteDTO( cliente ) );
        }

        return list;
    }

    @Override
    public List<ClienteDTO> listClienteDTOToListCliente(List<ClienteDTO> lstclienteDTO) {
        if ( lstclienteDTO == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( lstclienteDTO.size() );
        for ( ClienteDTO clienteDTO : lstclienteDTO ) {
            list.add( clienteDTO );
        }

        return list;
    }

    private String clienteTipoIdentificacionCodigo(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }
        TipoIdentificacion tipoIdentificacion = cliente.getTipoIdentificacion();
        if ( tipoIdentificacion == null ) {
            return null;
        }
        String codigo = tipoIdentificacion.getCodigo();
        if ( codigo == null ) {
            return null;
        }
        return codigo;
    }

    protected TipoIdentificacion clienteDTOToTipoIdentificacion(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();

        tipoIdentificacion.setCodigo( clienteDTO.getCodigoTipoIdentificacion() );

        return tipoIdentificacion;
    }
}
