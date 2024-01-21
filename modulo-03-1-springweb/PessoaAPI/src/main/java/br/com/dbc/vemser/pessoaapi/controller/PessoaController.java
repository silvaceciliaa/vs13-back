package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import javax.validation.Valid;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {

    private final PessoaService pessoaService;
    private final PropertieReader propertieReader;
    private final ObjectMapper objectMapper;


    @GetMapping("/ambiente")
    public String obterAmbiente() {
        return "O ambiente é: " + propertieReader.getAmbiente();
    }

    @GetMapping // GET localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> list() {
        List<PessoaDTO> pessoas = pessoaService.list();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa&var2=xxx
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

//    @GetMapping("/byname/{nome}") // GET localhost:8080/pessoa/byname/nome
//    public List<Pessoa> listByNamePath(@PathVariable("nome") String nome) {
//        return pessoaService.listByName(nome);
//    }

    @PostMapping // POST localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        log.debug("Criando pessoa");

        PessoaDTO pessoaCriada = pessoaService.create(pessoa);
        log.debug("Pessoa criada!");

        //return ResponseEntity.ok(pessoaService.create(pessoa));
        return new ResponseEntity<>(pessoaCriada, HttpStatus.OK);
    }


    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {

        Pessoa pessoaAtualizada = pessoaService.update(id, pessoaAtualizar);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaAtualizada, PessoaDTO.class);

        return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
