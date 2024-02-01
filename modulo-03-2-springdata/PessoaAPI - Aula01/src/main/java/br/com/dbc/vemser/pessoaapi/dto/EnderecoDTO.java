package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
//        private Integer idPessoa;

        private String logradouro;

        private Integer numero;
        private String complemento;

        private String cep;

        private String cidade;

        private String estado;

        private String pais;

}
