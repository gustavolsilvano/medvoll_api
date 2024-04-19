package com.tucdev.MedVoll.controller;

import com.tucdev.MedVoll.domain.usuario.Usuario;
import com.tucdev.MedVoll.domain.usuario.dto.DadosAutenticacaoDto;
import com.tucdev.MedVoll.infra.security.TokenService;
import com.tucdev.MedVoll.infra.security.dto.DadosTokenJwtDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    @PostMapping("/")
    public ResponseEntity login(@RequestBody @Valid DadosAutenticacaoDto dadosAutenticacaoDto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dadosAutenticacaoDto.login(), dadosAutenticacaoDto.senha());
        var authentication = authenticationManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJwtDto(tokenJWT));
    }
}
