package com.tlbtech.agendadortarefas.business.mapper;

import com.tlbtech.agendadortarefas.business.dto.TarefasDTO;
import com.tlbtech.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);

}
