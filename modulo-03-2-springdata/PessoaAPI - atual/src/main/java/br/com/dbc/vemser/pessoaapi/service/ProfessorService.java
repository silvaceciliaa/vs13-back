package br.com.dbc.vemser.pessoaapi.service;

import java.util.List;
import java.util.ArrayList;

import br.com.dbc.vemser.pessoaapi.dto.ProfessorDTO;
import br.com.dbc.vemser.pessoaapi.entity.Professor;
import br.com.dbc.vemser.pessoaapi.repository.ProfessorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ObjectMapper objectMapper;

    public ProfessorDTO create(ProfessorDTO professorDTO) {
        Professor professor = objectMapper.convertValue(professorDTO, Professor.class);

        professor = professorRepository.save(professor);

        return objectMapper.convertValue(professor, ProfessorDTO.class);
    }

    public List<ProfessorDTO> list(){
        List<Professor> listaProfessores = professorRepository.findAll();
        List<ProfessorDTO> professorDTOList = new ArrayList<>();

        for (Professor professor : listaProfessores) {
            ProfessorDTO professorDTO = objectMapper.convertValue(professor, ProfessorDTO.class);
            professorDTOList.add(professorDTO);
        }

        return professorDTOList;

    }


}
