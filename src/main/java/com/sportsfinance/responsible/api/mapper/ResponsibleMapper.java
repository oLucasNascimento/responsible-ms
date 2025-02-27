package com.sportsfinance.responsible.api.mapper;

import com.sportsfinance.responsible.api.dto.ResponsibleDTO;
import com.sportsfinance.responsible.domain.model.Responsible;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ResponsibleMapper {

    Responsible toResponsible(ResponsibleDTO responsibleDTO);
    ResponsibleDTO toResponsibleDTO(Responsible responsible);

}
