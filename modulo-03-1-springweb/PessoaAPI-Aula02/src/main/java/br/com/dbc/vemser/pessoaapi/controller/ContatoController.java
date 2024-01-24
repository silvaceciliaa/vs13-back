package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private ContatoService contatoService;

    public ContatoController() {
        contatoService = new ContatoService();
    }

    @GetMapping
    public List<Contato> list(){ //lista todos os contatos
        return contatoService.list();
    }

    @GetMapping("/byperson/{idPessoa}")
    public List<Contato> listByPerson(@PathVariable int idPessoa) {
        return contatoService.listByPeople(idPessoa);
    }

    @PostMapping // com um id da pessoa para adicionar o contato e no corpo, receber o contato para inserir
    public Contato create(@RequestBody Contato contato){
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}") //  com id do contato, deve atualizar um contato existente e receber no corpo da requisição os novos dados do contato (deve receber todos os dados)
    public Contato update(@PathVariable("idContato") Integer id,
                         @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}") // deve receber um id do contato e remover da lista
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}
