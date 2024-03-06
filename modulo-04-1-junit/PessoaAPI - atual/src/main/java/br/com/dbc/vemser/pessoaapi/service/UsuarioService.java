package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.UsuarioCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.UsuarioDTO;
import br.com.dbc.vemser.pessoaapi.entity.Cargo;
import br.com.dbc.vemser.pessoaapi.entity.Usuario;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.CargoRepository;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final CargoRepository cargoRepository;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder bCrypt;

    public Optional<Usuario> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<Usuario> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public UsuarioDTO signIn(UsuarioCreateDTO usuarioCreateDTO) throws RegraDeNegocioException {

        // - implementar futuramente uma verificação se o login já existE

        Usuario novoUsuario = new Usuario();
        Cargo cargo = findCargoById(usuarioCreateDTO.getIdCargo());

        String senhaSecreta = bCrypt.encode(usuarioCreateDTO.getSenha());

        novoUsuario.setSenha(senhaSecreta);
        novoUsuario.setLogin(usuarioCreateDTO.getLogin());
        novoUsuario.setCargos(new HashSet<>());
        novoUsuario.getCargos().add(cargo);

        usuarioRepository.save(novoUsuario);

        return retornarDTO(novoUsuario);
    }

    public Integer getIdLoggedUser() {
        Integer findUserId = Integer.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return findUserId;
    }

    public UsuarioDTO getLoggedUser() throws RegraDeNegocioException {
        Usuario usuario = findById(getIdLoggedUser());
        return retornarDTO(usuario);
    }

    public Usuario findById(Integer idUsuario) throws RegraDeNegocioException {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() ->
                        new RegraDeNegocioException("Usuário não encontrado!"));
    }

    public Cargo findCargoById(Integer idCargo) throws RegraDeNegocioException {
        return cargoRepository.findById(idCargo)
                .orElseThrow(() ->
                        new RegraDeNegocioException("Cargo não encontrado!"));
    }

    public UsuarioDTO retornarDTO(Usuario usuario) {
        return objectMapper.convertValue(usuario, UsuarioDTO.class);
    }
}