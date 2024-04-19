package com.tucdev.MedVoll.domain.usuario.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacaoDto(
        @NotBlank
        String login,

        @NotBlank
        String senha
) {
}
