package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.Usuario;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.security.TokenService;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Validated
@Tag(name = "Auth")
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;
    public final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getLogin(),
                        loginDTO.getSenha()
                );

        Authentication authentication =
                authenticationManager.authenticate(
                        usernamePasswordAuthenticationToken);

        Usuario usuarioValidado = (Usuario) authentication.getPrincipal();

        return tokenService.generateToken(usuarioValidado);
    }

    @PostMapping("/cadastrar") // UsuarioDTO
    public LoginDTO signIn(@RequestBody LoginDTO usuarioLogado) {
        return usuarioService.signIn(usuarioLogado);
    }

    @GetMapping("/usuario-logado") // não retornar Usuario
    public ResponseEntity<Usuario> usuarioLogado() throws Exception{
        return new ResponseEntity<>(usuarioService.getLoggedUser(), HttpStatus.OK);
    }
}
