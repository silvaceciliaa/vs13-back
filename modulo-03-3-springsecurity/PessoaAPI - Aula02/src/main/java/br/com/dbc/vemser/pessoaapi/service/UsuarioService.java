package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.Usuario;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
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

    public Optional<Usuario> findById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public Optional<Usuario> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO signIn(LoginDTO usuarioLogin) {

        Usuario novoUsuario = new Usuario();

        String senhaSecreta = bCrypt.encode(usuarioLogin.getSenha());

        novoUsuario.setSenha(senhaSecreta);
        novoUsuario.setLogin(usuarioLogin.getLogin());

        usuarioRepository.save(novoUsuario);

        return usuarioLogin;
    }
}