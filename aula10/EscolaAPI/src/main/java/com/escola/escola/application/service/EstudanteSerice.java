package com.escola.escola.application.service;

import com.escola.escola.application.dto.EstudanteDto;
import com.escola.escola.domain.model.Erro;
import com.escola.escola.domain.model.Estudante;
import com.escola.escola.infra.repository.ErroRepository;
import com.escola.escola.infra.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudanteSerice {

    @Autowired
    EstudanteRepository estudanteRepository;

    @Autowired
    ErroRepository erroRepository;

    public EstudanteDto getEstudanteById(Long id) {
        Optional<Estudante> estudanteOptional = estudanteRepository.findById(id);

        EstudanteDto estudanteDto = null;

        if (estudanteOptional.isPresent()) {
            // existe um estudante
            Estudante estudante = estudanteOptional.get();
            estudanteDto = constroiEstudanteDTO(estudante);
        }

        return estudanteDto;
    }

    private EstudanteDto constroiEstudanteDTO(Estudante estudante) {
        EstudanteDto estudanteDto;
        estudanteDto = new EstudanteDto(
                estudante.getId(),
                estudante.getNome(),
                estudante.getMatricula(),
                estudante.getIdade(),
                estudante.getTurma(),
                estudante.getMateriasNomes()
        );
        return estudanteDto;
    }

    public List<EstudanteDto> getEstudantesFindAll() {
        List<Estudante> estudantes = (List<Estudante>)estudanteRepository.findAll();
        List<EstudanteDto> estudantesDto = new ArrayList<>();

        for(Estudante estudante : estudantes){
            estudantesDto.add( constroiEstudanteDTO(estudante) );
        }

        return estudantesDto;
    }

    public void addEstudante(EstudanteDto estudanteDto) {
        try{
            Estudante estudante = new Estudante();
            estudante.setIdade(estudanteDto.getIdade());
            estudante.setMatricula(estudanteDto.getMatricula());
            estudante.setNome(estudanteDto.getNome());
            estudante.setTurma(estudanteDto.getTurma());
            estudanteRepository.save(estudante);
        }catch(Exception exception){

            // logar o erro
            Erro erro = new Erro();
            erro.setMensagem(exception.getMessage());
            erroRepository.save(erro);

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}
