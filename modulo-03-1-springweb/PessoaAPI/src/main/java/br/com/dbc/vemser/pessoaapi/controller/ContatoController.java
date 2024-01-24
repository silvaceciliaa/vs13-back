package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.documentacao.IContatoControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;

import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "contato")
@RequestMapping("/contato")
public class ContatoController implements IContatoControllerDoc {

    private final ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<ContatoDTO>> list(){
        List<ContatoDTO> contatos = contatoService.list();
        return new ResponseEntity<>(contatos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ContatoDTO>> listByName(@PathVariable("id") int id) {
        List<ContatoDTO> contatos = contatoService.listByPeople(id);
        return new ResponseEntity<>(contatos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContatoDTO> create(@Valid @RequestBody ContatoCreateDTO contato) throws Exception {

        ContatoDTO contatoCriado = contatoService.create(contato);
        return new ResponseEntity<>(contatoCriado, HttpStatus.OK);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                         @Valid @RequestBody ContatoCreateDTO contatoAtualizar) throws Exception {
        return new ResponseEntity<>(contatoService.update(id, contatoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
