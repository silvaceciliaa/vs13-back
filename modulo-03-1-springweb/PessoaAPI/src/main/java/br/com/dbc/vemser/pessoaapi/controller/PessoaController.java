package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.controller.documentacao.IPessoaControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@Tag(name = "Pessoa")
@RequestMapping("/pessoa")
// - retirar instancias de email da service e passar para controller
public class PessoaController implements IPessoaControllerDoc {

    private final PessoaService pessoaService;
    private final EmailService emailService;
    private final PropertieReader propertieReader;


    @GetMapping("/ambiente")
    public String obterAmbiente() {
        return "O ambiente é: " + propertieReader.getAmbiente();
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list() {
        List<PessoaDTO> pessoas = pessoaService.list();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping("/byname")
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") String nome) {
        return new ResponseEntity<>(pessoaService.listByName(nome), HttpStatus.OK);
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
