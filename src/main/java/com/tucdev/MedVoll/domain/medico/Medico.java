package com.tucdev.MedVoll.medico;

import com.tucdev.MedVoll.endereco.Endereco;
import com.tucdev.MedVoll.medico.dto.AtualizarMedicoDto;
import com.tucdev.MedVoll.medico.dto.DadosCadastroMedicoDto;
import com.tucdev.MedVoll.medico.dto.EEspecialidade;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private EEspecialidade especialidade;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Medico(DadosCadastroMedicoDto dadosCadastroMedicoDto){
        this.ativo = true;
        this.crm = dadosCadastroMedicoDto.crm();
        this.email = dadosCadastroMedicoDto.email();
        this.telefone = dadosCadastroMedicoDto.telefone();
        this.nome = dadosCadastroMedicoDto.nome();
        this.especialidade = dadosCadastroMedicoDto.especialidade();
        this.endereco = new Endereco(dadosCadastroMedicoDto.endereco());
    }

    public void atualizarInformacoes(AtualizarMedicoDto atualizarMedicoDto){
        if (atualizarMedicoDto.nome() != null) this.nome = atualizarMedicoDto.nome();
        if (atualizarMedicoDto.telefone() != null) this.telefone = atualizarMedicoDto.telefone();
        if (atualizarMedicoDto.dadosEndereco() != null) this.endereco.atualizarInformacoes(atualizarMedicoDto.dadosEndereco());
    }

    public void excluir(){
        this.ativo = false;
    }
}
