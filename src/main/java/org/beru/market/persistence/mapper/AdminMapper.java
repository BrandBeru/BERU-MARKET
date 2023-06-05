package org.beru.market.persistence.mapper;

import org.beru.market.domain.Admin;
import org.beru.market.persistence.entity.Administrador;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel ="spring" )
public interface AdminMapper {
    @Mappings({
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "correoElectronico", target = "email"),
            @Mapping(source = "contrasena", target = "password"),
            @Mapping(source = "fechaCreacion", target = "creationDate"),
    })
    Admin toAdmin(Administrador administrador);
    @InheritInverseConfiguration
    @Mapping(target = "clientes", ignore = true)
    Administrador toAdministrador(Admin admin);
}
