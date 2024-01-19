package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;

import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public List<Contato> list(){ //lista todos os contatos
        return contatoService.list();
    }

    @GetMapping("/byperson") // recebe o id da pessoa e mostra os seus contatos
    public List<Contato> listByName(@RequestParam("id") int id) {
        return contatoService.listByPeople(id);
    }

    @PostMapping // com um id da pessoa para adicionar o contato e no corpo, receber o contato para inserir
    public ResponseEntity<Contato> create(@Valid @RequestBody Contato contato) throws Exception {

        return new ResponseEntity<>(contatoService.create(contato), HttpStatus.OK);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id,
                         @Valid @RequestBody Contato contatoAtualizar) throws Exception {
        return new ResponseEntity<>(contatoService.update(id, contatoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
