package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> list(){
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> listByIdEndereco(@PathVariable("idEndereco") int id){
        return enderecoService.listByEndereco(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByName(@PathVariable("idPessoa") int id){
        return enderecoService.listByPeople(id);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> create(@PathVariable("idPessoa") Integer id,
                                           @Valid @RequestBody Endereco endereco) throws Exception {
        endereco.setIdPessoa(id);
        return new ResponseEntity<>(enderecoService.create(endereco), HttpStatus.OK);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> update(@PathVariable("idEndereco") Integer id,
                           @Valid @RequestBody Endereco enderecoAtualizar) throws Exception{
        return new ResponseEntity<>(enderecoService.update(id, enderecoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
        return ResponseEntity.ok().build();
    }


}
