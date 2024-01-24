package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final EmailService emailService;

    private final ObjectMapper objectMapper;

    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO) throws Exception {

        if (!pessoaJaExiste(enderecoCreateDTO.getIdPessoa())){
            throw new RegraDeNegocioException("Pessoa não existe!");
        }

        Endereco enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
        enderecoEntity = enderecoRepository.create(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);

        sendWelcomeEmail(enderecoDTO);

        return enderecoDTO;
    }

    public List<EnderecoDTO> list(){
        List<Endereco> enderecoEntityList = enderecoRepository.list();
        List<EnderecoDTO> endercoDTOList = new ArrayList<>();

        for(Endereco enderecoEntity : enderecoEntityList) {
            EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
            endercoDTOList.add(enderecoDTO);
        }

        return endercoDTOList;
    }

    public EnderecoDTO update(Integer id,
                           EnderecoCreateDTO enderecoCreateDTO) throws Exception {
        Endereco novoEndereco = getEndereco(id);

        Endereco enderecoAtualizar = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);

        novoEndereco.setIdPessoa(enderecoAtualizar.getIdPessoa());
        novoEndereco.setTipoEndereco(enderecoAtualizar.getTipoEndereco());
        novoEndereco.setLogradouro(enderecoAtualizar.getLogradouro());
        novoEndereco.setNumero(enderecoAtualizar.getNumero());
        novoEndereco.setComplemento(enderecoAtualizar.getComplemento());
        novoEndereco.setCep(enderecoAtualizar.getCep());
        novoEndereco.setCidade(enderecoAtualizar.getCidade());
        novoEndereco.setEstado(enderecoAtualizar.getEstado());
        novoEndereco.setPais(enderecoAtualizar.getPais());

        EnderecoDTO enderecoDTOAtualizado = objectMapper.convertValue(novoEndereco, EnderecoDTO.class);

        sendUpdateEmail(enderecoDTOAtualizado);

        return enderecoDTOAtualizado;
    }

    public void delete(Integer id) throws Exception{
        Endereco enderecoADeletar = getEndereco(id);
        enderecoRepository.delete(enderecoADeletar);

        EnderecoDTO enderecoDTOAtualizado = objectMapper.convertValue(enderecoADeletar, EnderecoDTO.class);

        sendDeleteEmail(enderecoDTOAtualizado);
    }

    public List<EnderecoDTO> listByPeople(int id){
        List<Endereco> enderecos = enderecoRepository.listByPeople(id);

        List<EnderecoDTO> enderecosDTOs = new ArrayList<>();

        for (Endereco endereco : enderecos){
            EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
            enderecosDTOs.add(enderecoDTO);
        }
        return enderecosDTOs;
    }

    public List<EnderecoDTO> listByEndereco(int id){
        List<Endereco> enderecos = enderecoRepository.listByEndereco(id);

        List<EnderecoDTO> enderecoDTOS = new ArrayList<>();

        for (Endereco endereco : enderecos){
            EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
            enderecoDTOS.add(enderecoDTO);
        }
        return enderecoDTOS;
    }

    private boolean pessoaJaExiste(int id) {
        try {
            pessoaService.getPessoa(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    private Endereco getEndereco(Integer id) throws Exception{

        List<Endereco> enderecos = enderecoRepository.list();

        for (Endereco endereco : enderecos){
            if (endereco.getIdEndereco().equals(id)){
                return endereco;
            }
        }
        throw new RegraDeNegocioException("Endereço não encontrado");
    }

    private void sendWelcomeEmail(EnderecoDTO enderecoDTO) throws Exception{
        try {
            emailService.sendEmailAddress("Endereço cadastrado no sistema!", "welcome-address-email-template.ftl", enderecoDTO);
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private void sendUpdateEmail(EnderecoDTO enderecoDTO) throws Exception{ // - usar object
        try {
            emailService.sendEmailAddress("Alteração nos dados da sua conta", "alter-data-email-template.ftl", enderecoDTO);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private void sendDeleteEmail(EnderecoDTO enderecoDTO) throws Exception{
        try {
            emailService.sendEmailAddress("Você deletou o endereço do nosso sistema :(", "delete-address-email-template.ftl", enderecoDTO);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
}
