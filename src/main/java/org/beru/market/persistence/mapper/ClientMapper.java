package org.beru.market.persistence.mapper;

import org.beru.market.domain.Client;
import org.beru.market.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mappings({
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "apellidos",target = "lastName"),
            @Mapping(source = "idAdministrator", target = "adminId"),
            @Mapping(source = "celular",target = "phone"),
            @Mapping(source = "direccion",target = "address"),
            @Mapping(source = "correoElectronico",target = "email")
    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> clientes);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compras", ignore = true),
            @Mapping(target = "administrador", ignore = true)
    })
    Cliente toCliente(Client client);
}
