package com.tucdev.MedVoll.endereco;

import com.tucdev.MedVoll.endereco.dto.DadosEnderecoDto;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEnderecoDto endereco) {
        this.logradouro = endereco.logradouro();
        this.cep = endereco.cep();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.complemento = endereco.complemento();
        this.numero = endereco.numero();
    }

    public void atualizarInformacoes(DadosEnderecoDto dadosEndereco) {
        if (dadosEndereco.complemento() != null) this.complemento = dadosEndereco.complemento();
        if (dadosEndereco.logradouro() != null) this.logradouro = dadosEndereco.logradouro();
        if (dadosEndereco.cep() != null) this.cep = dadosEndereco.cep();
        if (dadosEndereco.bairro() != null) this.bairro = dadosEndereco.bairro();
        if (dadosEndereco.cidade() != null) this.cidade = dadosEndereco.cidade();
        if (dadosEndereco.uf() != null) this.uf = dadosEndereco.uf();
        if (dadosEndereco.numero() != null) this.numero = dadosEndereco.numero();
    }
}
