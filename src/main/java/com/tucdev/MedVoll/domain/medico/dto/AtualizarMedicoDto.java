package com.tucdev.MedVoll.medico.dto;

import com.tucdev.MedVoll.endereco.Endereco;
import com.tucdev.MedVoll.endereco.dto.DadosEnderecoDto;
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
