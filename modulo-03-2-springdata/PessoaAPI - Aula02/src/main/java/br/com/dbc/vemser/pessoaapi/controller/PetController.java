package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.documentacao.IEnderecoControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import br.com.dbc.vemser.pessoaapi.service.PetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Pet")
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping
    public ResponseEntity<List<PetDTO>> list() throws Exception {
        List<PetDTO> pets = petService.list();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PetDTO> create(@Valid @RequestBody PetCreateDTO pet) throws Exception {
        PetDTO petCriado = petService.create(pet);

        return new ResponseEntity<>(petCriado, HttpStatus.OK);
    }

    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> update(@PathVariable("idPet") Integer id,
                                         @Valid @RequestBody PetCreateDTO petAtualizar) throws Exception{
        return new ResponseEntity<>(petService.update(id, petAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idPet}")
    public ResponseEntity<Void> delete(@PathVariable("idPet") Integer id) throws Exception {
        petService.delete(id);
        return ResponseEntity.ok().build();
    }


}
