package com.tucdev.MedVoll.domain.medico.dto;

import com.tucdev.MedVoll.domain.endereco.dto.DadosEnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarMedicoDto(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotNull
        @Valid
        DadosEnderecoDto dadosEndereco
) {
}
