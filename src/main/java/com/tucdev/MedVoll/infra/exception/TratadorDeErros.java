package com.tucdev.MedVoll.infra.exception;

import com.tucdev.MedVoll.infra.dto.DadosErroValidacaoDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException methodArgumentNotValidException){
        var erros = methodArgumentNotValidException.getFieldErrors();
        List<DadosErroValidacaoDto> dadosErroValidacaoDto = erros.stream().map(erro -> new DadosErroValidacaoDto(erro.getField(), erro.getDefaultMessage())).toList();
        return ResponseEntity.badRequest().body(dadosErroValidacaoDto);
    }

}
