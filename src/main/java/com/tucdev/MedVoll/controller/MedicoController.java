package com.tucdev.MedVoll.controller;

import com.tucdev.MedVoll.domain.medico.Medico;
import com.tucdev.MedVoll.domain.medico.MedicoRepository;
import com.tucdev.MedVoll.domain.medico.dto.AtualizarMedicoDto;
import com.tucdev.MedVoll.domain.medico.dto.DadosCadastroMedicoDto;
import com.tucdev.MedVoll.domain.medico.dto.DadosDetalhamentoMedicoDto;
import com.tucdev.MedVoll.domain.medico.dto.ListagemMedicoDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

//{
//"nome": "Rodrigo Ferreira",
//"email": "rodrigo.ferreira@voll.med",
//"crm": "123456",
//"especialidade": "ortopedia",
//"telefone": "94981836852",
//"endereco": {
//"logradouro": "rua 1",
//"bairro": "bairro",
//"cep": "12345678",
//"cidade": "Brasilia",
//"uf": "DF",
//"numero": "1",
//"complemento": "complemento"
//}
//}

@RestController
@RequestMapping("/medicos")
@AllArgsConstructor
public class MedicoController {

    private MedicoRepository medicoRepository;
    @PostMapping("/")
    @Transactional
    public ResponseEntity cadastrar(
            @Valid
            @RequestBody
            DadosCadastroMedicoDto dadosCadastroMedicoDto, UriComponentsBuilder uriComponentsBuilder){
        var medico = new Medico(dadosCadastroMedicoDto);
        var medicoCriado = medicoRepository.save(medico);

        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medicoCriado.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedicoDto(medico));
    }


    @GetMapping("/")
    public ResponseEntity<Page<ListagemMedicoDto>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = medicoRepository.findAllByAtivoTrue(paginacao).map(ListagemMedicoDto::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{medicoId}")
    @Transactional
    public ResponseEntity atualizar(
            @PathVariable("medicoId") Long medicoId,
            @RequestBody @Valid AtualizarMedicoDto atualizarMedicoDto
            ){
            Medico medico = medicoRepository.getReferenceById(medicoId);
            medico.atualizarInformacoes(atualizarMedicoDto);
            return ResponseEntity.ok(new DadosDetalhamentoMedicoDto(medico));
    }

    @DeleteMapping("/{medicoId}")
    @Transactional
    public ResponseEntity excluir(
            @PathVariable("medicoId") Long medicoId
    ){
        Medico medico = medicoRepository.getReferenceById(medicoId);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{medicoId}")
    public ResponseEntity detalhar(@PathVariable("medicoId") Long medicoId){
        var medico = medicoRepository.getReferenceById(medicoId);
        return ResponseEntity.ok(new DadosDetalhamentoMedicoDto(medico));
    }
}
