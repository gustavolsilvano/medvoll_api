package com.tucdev.MedVoll.domain.medico.dto;

import com.tucdev.MedVoll.domain.medico.Medico;

public record ListagemMedicoDto(
        String nome,
        String email,
        String crm,
        EEspecialidade especialidade
) {
    public ListagemMedicoDto(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
