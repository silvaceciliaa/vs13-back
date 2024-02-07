package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ProfessorDTO;
import br.com.dbc.vemser.pessoaapi.service.ProfessorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "Professor")
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> list(){
        List<ProfessorDTO> professores = professorService.list();
        return new ResponseEntity<>(professores, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProfessorDTO> adicionar(@Valid @RequestBody ProfessorDTO professorDTO){
        ProfessorDTO professorCriado = professorService.create(professorDTO);

        return new ResponseEntity<>(professorCriado, HttpStatus.OK);
    }
}
