package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.service.DadosPessoaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController {

    private final DadosPessoaisService dadosPessoaisService;

    @GetMapping
    public ResponseEntity<List<DadosPessoaisDTO>> get(){
        List<DadosPessoaisDTO> pessoas = dadosPessoaisService.list();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> getByCpf(@PathVariable("cpf") String cpf){
        return new ResponseEntity<>(dadosPessoaisService.listByCpf(cpf), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DadosPessoaisDTO> post(@Valid @RequestBody DadosPessoaisDTO dados) throws Exception{
        return new ResponseEntity<>(dadosPessoaisService.create(dados), HttpStatus.OK);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> put(@PathVariable("cpf") String cpf,
                                                @Valid @RequestBody DadosPessoaisDTO dados) throws Exception{
        return new ResponseEntity<>(dadosPessoaisService.update(cpf, dados), HttpStatus.OK);

    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable("cpf") String cpf) throws Exception{
        dadosPessoaisService.delete(cpf);
        return ResponseEntity.ok().build();
    }

}
