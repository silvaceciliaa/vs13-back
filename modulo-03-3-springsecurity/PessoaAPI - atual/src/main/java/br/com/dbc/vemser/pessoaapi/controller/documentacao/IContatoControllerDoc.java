package br.com.dbc.vemser.pessoaapi.controller.documentacao;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface IContatoControllerDoc {

    @Operation(summary = "Listar contatos", description = "Lista todos os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )

    @GetMapping
    public ResponseEntity<List<ContatoDTO>> list();

    @Operation(summary = "Adicionar contatos", description = "Adiciona um contato ao banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna contato adicionado"),
                    @ApiResponse(responseCode = "201", description = "Retorna o corpo do endereço criado"),
                    @ApiResponse(responseCode = "400", description = "Erro no envio do body ou URL informado"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )

    @PostMapping("idPessoa")
    public ResponseEntity<ContatoDTO> create(@RequestParam("idPessoa") String idPessoa, @Valid @RequestBody ContatoCreateDTO contato) throws Exception;

    @Operation(summary = "Alterar contatos", description = "Altera dados de um contato ao banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna contato alterado"),
                    @ApiResponse(responseCode = "204", description = "Alterações salvas"),
                    @ApiResponse(responseCode = "400", description = "Erro no envio do body ou URL da request"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )

    @PutMapping
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id, @Valid @RequestBody ContatoCreateDTO contatoAtualizar) throws Exception;

    @Operation(summary = "Deletar contatos", description = "Deleta o contato do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato deletado"),
                    @ApiResponse(responseCode = "400", description = "Erro no envio do URL da request"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws Exception;

}
