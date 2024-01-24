package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.documentacao.IEnderecoControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Endereço")
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoController implements IEnderecoControllerDoc {

    private final EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> list(){
        List<EnderecoDTO> enderecos = enderecoService.list();
        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<List<EnderecoDTO>> listByIdEndereco(@PathVariable("idEndereco") int id){
        List<EnderecoDTO> enderecos =  enderecoService.listByEndereco(id);
        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<EnderecoDTO>> listByName(@PathVariable("idPessoa") int id){
        List<EnderecoDTO> enderecos = enderecoService.listByPeople(id);
        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer id,
                                           @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        endereco.setIdPessoa(id);
        EnderecoDTO enderecoCriado = enderecoService.create(endereco);

        return new ResponseEntity<>(enderecoCriado, HttpStatus.OK);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                           @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception{
        return new ResponseEntity<>(enderecoService.update(id, enderecoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> delete(@PathVariable("idEndereco") Integer id) throws Exception {
        enderecoService.delete(id);
        return ResponseEntity.ok().build();
    }


}
