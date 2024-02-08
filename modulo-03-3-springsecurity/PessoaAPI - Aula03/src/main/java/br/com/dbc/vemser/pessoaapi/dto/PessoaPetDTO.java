package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaPetDTO extends PessoaDTO {

    private PetDTO petDTO;
}
