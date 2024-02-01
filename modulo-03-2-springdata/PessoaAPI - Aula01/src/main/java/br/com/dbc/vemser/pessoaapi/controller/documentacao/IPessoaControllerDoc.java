package br.com.dbc.vemser.pessoaapi.controller.documentacao;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface IPessoaControllerDoc {

    @Operation(summary = "Exibe ambiente", description = "Mostra em qual ambiente o usuário está")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o ambiente"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )
    @GetMapping("/ambiente")
    public String obterAmbiente();
    @Operation(summary = "Listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list();

    @Operation(summary = "Listar pessoas por nome", description = "Lista todas as pessoas do banco com o nome informado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "400", description = "Erro no envio da URL da requisição"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") String nome);

    @Operation(summary = "Adicionar pessoas", description = "Adiciona uma pessoa ao banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna pessoa adicionada"),
                    @ApiResponse(responseCode = "201", description = "Retorna o corpo da pessoa criada"),
                    @ApiResponse(responseCode = "400", description = "Erro no envio do body"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception;

    @Operation(summary = "Alterar pessoas", description = "Altera dados de uma pessoa ao banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna pessoa alterada"),
                    @ApiResponse(responseCode = "204", description = "Alterações salvas"),
                    @ApiResponse(responseCode = "400", description = "Erro no envio do body ou URL da request"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )

    @PutMapping
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id, @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception;

    @Operation(summary = "Deletar pessoas", description = "Deleta a pessoa do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa deletada"),
                    @ApiResponse(responseCode = "400", description = "Erro no envio do URL da request"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception;
}
