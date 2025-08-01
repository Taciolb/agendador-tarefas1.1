package com.tlbtech.agendadortarefas.business;

import com.tlbtech.agendadortarefas.business.dto.TarefasDTO;
import com.tlbtech.agendadortarefas.business.mapper.TarefasConverter;
import com.tlbtech.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.tlbtech.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.tlbtech.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.tlbtech.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);


        return tarefaConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }
}
