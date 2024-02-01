package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DadosPessoaisService {

    private final DadosPessoaisClient client;

    public DadosPessoaisDTO create(DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return client.post(dadosPessoaisDTO);

    }

    public List<DadosPessoaisDTO> list(){
        return client.getAll();
    }

    public DadosPessoaisDTO update(String cpf, DadosPessoaisDTO dadosPessoaisDTO){
        return client.put(cpf, dadosPessoaisDTO);
    }

    public void delete(String cpf){
        client.delete(cpf);
    }

    public DadosPessoaisDTO listByCpf(String cpf){
        return client.get(cpf);
    }

}
