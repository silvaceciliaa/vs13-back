package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.Usuario;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder bCrypt;

    public Optional<Usuario> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<Usuario> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO signIn(LoginDTO usuarioLogin) {

        Usuario novoUsuario = new Usuario();

        String senhaSecreta = bCrypt.encode(usuarioLogin.getSenha());

        novoUsuario.setSenha(senhaSecreta);
        novoUsuario.setLogin(usuarioLogin.getLogin());
        // - inserir com cargos

        usuarioRepository.save(novoUsuario);

        return usuarioLogin;
    }

    public Integer getIdLoggedUser() {
        Integer findUserId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findUserId;
    }

    public Usuario getLoggedUser() throws RegraDeNegocioException {
        return findById(getIdLoggedUser());
    }

    public Usuario findById(Integer idUsuario) throws RegraDeNegocioException {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() ->
                        new RegraDeNegocioException("Usuário não encontrado!"));
    }
}