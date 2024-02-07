package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.Pet;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final String NOT_FOUND_MESSAGE = "ID da pessoa nao encontrada";

    public PetDTO create(PetCreateDTO petCreateDTO) throws Exception {

        Pessoa pessoa = pessoaService.returnPersonById(petCreateDTO.getIdPessoa());

        Pet pet = converterDto(petCreateDTO);
        pet.setPessoa(pessoa);
        return objectMapper.convertValue(petRepository.save(pet), PetDTO.class);
    }



    public List<PetDTO> list(){
        List<Pet> pets = petRepository.findAll();

        List<PetDTO> petsDTO = pets.stream()
                .map(pet -> new PetDTO(pet.getIdPet(),
                        pet.getPessoa().getIdPessoa(),
                        pet.getNome(),
                        pet.getTipoPet())).toList();
        return petsDTO;
    }

    public PetDTO update(Integer id, PetCreateDTO petCreateDTO) throws Exception {
        Pet petRecuperado = returnPetById(id);

        Pet petAtualizar = objectMapper.convertValue(petCreateDTO, Pet.class);

        petRecuperado.setPessoa(petAtualizar.getPessoa());
        petRecuperado.setNome(petAtualizar.getNome());
        petRecuperado.setTipoPet(petAtualizar.getTipoPet());

        PetDTO petDTOAtualizada = objectMapper.convertValue(petRecuperado, PetDTO.class);

        return petDTOAtualizada;
    }

    public void delete(Integer idPet) throws Exception {
        Pet pet = returnPetById(idPet);

        Pessoa pessoa = pessoaService.returnPersonById(pet.getPessoa().getIdPessoa());
        pet.setPessoa(null);
        pessoa.setPet(null);

        petRepository.delete(pet);
    }

    public Pet converterDto(PetCreateDTO dto) {
        return objectMapper.convertValue(dto, Pet.class);
    }


    public Pet returnPetById(Integer id) throws EntidadeNaoEncontradaException {
        return petRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }
    
}
