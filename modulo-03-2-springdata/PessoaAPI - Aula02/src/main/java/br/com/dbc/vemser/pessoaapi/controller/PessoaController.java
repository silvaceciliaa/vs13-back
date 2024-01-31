package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.controller.documentacao.IPessoaControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@Tag(name = "Pessoa")
@RequestMapping("/pessoa")
// - utilizar try catches para diferentes exceptions
public class PessoaController implements IPessoaControllerDoc {

    private final PessoaService pessoaService;
    private final EmailService emailService;
    private final PropertieReader propertieReader;


    @GetMapping("/ambiente")
    public String obterAmbiente() {
        return "O ambiente é: " + propertieReader.getAmbiente();
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list(){
        try {
            List<PessoaDTO> pessoas = pessoaService.list();
            return new ResponseEntity<>(pessoas, HttpStatus.OK);
        } catch (RegraDeNegocioException re){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/byname")
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") String nome) {
        return new ResponseEntity<>(pessoaService.listByName(nome), HttpStatus.OK);
    }

    @GetMapping("/bycpf")
    public ResponseEntity<List<PessoaDTO>> listByCpf(@RequestParam("cpf") String cpf) throws Exception {
        return new ResponseEntity<>(pessoaService.findByCpf(cpf), HttpStatus.OK);
    }

    @GetMapping("/bybday")
    public ResponseEntity<List<PessoaDTO>> listByBday(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) throws Exception {
        return new ResponseEntity<>(pessoaService.listByBday(startDate, endDate), HttpStatus.OK);
    }

    @GetMapping ("/com-enderecos")
    public ResponseEntity<List<PessoaEnderecoDTO>> listWithAddress(@Valid @RequestParam(required = false) Integer idPessoa) throws Exception {
        return ResponseEntity.ok(pessoaService.listWithAddress(idPessoa));
    }

    @GetMapping("/com-contatos")
    public ResponseEntity<List<PessoaContatoDTO>> listPeopleWithContact(@Valid @RequestParam(required = false) Integer idPessoa) throws Exception {
        List<PessoaContatoDTO> pessoasComContatos = pessoaService.listContactsForPeople(idPessoa);
        return ResponseEntity.ok(pessoasComContatos);
    }

    @GetMapping("/com-pets")
    public ResponseEntity<List<PessoaPetDTO>> listPeopleWithPets(@Valid @RequestParam(required = false) Integer idPessoa) throws Exception {
        List<PessoaPetDTO> pessoasComPet = pessoaService.listWithPet(idPessoa);
        return ResponseEntity.ok(pessoasComPet);
    }


    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        log.debug("Criando pessoa");

        PessoaDTO pessoaCriada = pessoaService.create(pessoa);

        log.debug("Pessoa criada!");

        return new ResponseEntity<>(pessoaCriada, HttpStatus.OK);
    }


    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
