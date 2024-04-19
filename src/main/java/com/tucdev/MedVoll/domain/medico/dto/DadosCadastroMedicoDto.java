package com.tucdev.MedVoll.domain.medico.dto;

import com.tucdev.MedVoll.domain.endereco.dto.DadosEnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedicoDto(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        EEspecialidade especialidade,
        @NotNull
        @Valid
        DadosEnderecoDto endereco
) {
}
