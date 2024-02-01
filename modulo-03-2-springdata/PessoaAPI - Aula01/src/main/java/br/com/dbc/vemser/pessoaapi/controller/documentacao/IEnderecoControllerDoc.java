package br.com.dbc.vemser.pessoaapi.controller.documentacao;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface IEnderecoControllerDoc {

    @Operation(summary = "Listar endereços", description = "Lista todos os endereços do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> list();

//    @Operation(summary = "Listar endereços por id", description = "Lista todos os endereços do banco pelo id informado")
//    @ApiResponses(
//            value = {
//                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
//                    @ApiResponse(responseCode = "400", description = "Erro no envio da URL da requisição"),
//                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
//            }
//    )
//
//    @GetMapping
//    public ResponseEntity<List<EnderecoDTO>> listByIdEndereco(@PathVariable("idEndereco") int id);

//    @Operation(summary = "Listar endereços pelo id da pessoa", description = "Lista todos os endereços do banco pelo id da pessoa informada")
//    @ApiResponses(
//            value = {
//                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
//                    @ApiResponse(responseCode = "400", description = "Erro no envio da URL da requisição"),
//                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
//            }
//    )
//
//    @GetMapping
//    public ResponseEntity<List<EnderecoDTO>> listByName(@PathVariable("idPessoa") int id);

    @Operation(summary = "Adicionar endereços", description = "Adiciona uma endereço ao banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna endereço adicionado"),
                    @ApiResponse(responseCode = "201", description = "Retorna o corpo do endereço criado"),
                    @ApiResponse(responseCode = "400", description = "Erro no envio do body ou URL informado"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )

    @PostMapping
    public ResponseEntity<EnderecoDTO> create(@Valid @RequestBody EnderecoCreateDTO endereco) throws Exception;

    @Operation(summary = "Alterar endereços", description = "Altera dados de um endereço ao banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna endereço alterado"),
                    @ApiResponse(responseCode = "204", description = "Alterações salvas"),
                    @ApiResponse(responseCode = "400", description = "Erro no envio do body ou URL da request"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )

    @PutMapping
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                                              @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception;
    @Operation(summary = "Deletar endereços", description = "Deleta o endereço do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço deletado"),
                    @ApiResponse(responseCode = "400", description = "Erro no envio do URL da request"),
                    @ApiResponse(responseCode = "500", description = "Ocorreu uma exceção")
            }
    )

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable("idEndereco") Integer id) throws Exception;
}
