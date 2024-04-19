package com.tucdev.MedVoll.medico.dto;

import com.tucdev.MedVoll.endereco.Endereco;
import com.tucdev.MedVoll.medico.Medico;

public record DadosDetalhamentoMedicoDto(Long id, String nome, String email, String crm, EEspecialidade especialidade, Endereco endereco) {
    public DadosDetalhamentoMedicoDto(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
