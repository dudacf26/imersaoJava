package com.escola.escola.application.controller;

import com.escola.escola.application.dto.EstudanteDto;
import com.escola.escola.application.service.EstudanteSerice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Api(value = "EstudanteController", description = "Gerencia os estudantes")
@RestController
public class EstudanteController {

    @Autowired
    private EstudanteSerice estudanteService;

    @ApiOperation( value = "busca estudante por id", response = EstudanteDto.class, tags="findEstudanteById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso", response = EstudanteDto.class),
            @ApiResponse(code = 500, message = "Erro", response = Exception.class)
    })
    @GetMapping("/findEstudanteById/{id}")
    public EstudanteDto findEstudanteById(@PathVariable Long id){
        return estudanteService.getEstudanteById(id);
    }

    @ApiOperation(value="Encontra todos estudantes", response=ArrayList.class, tags="findAllEstudantes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso", response = ArrayList.class),
            @ApiResponse(code = 500, message = "Erro", response = Exception.class)
    })
    @GetMapping("/findEstudantes")
    public List<EstudanteDto> findAllEstudantes(){
        return estudanteService.getEstudantesFindAll();
    }

    @ApiOperation(value ="Adiciona estudantes", tags = "addEstudante")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 400, message = "Erro na requisição", response = ResponseStatusException.class),
    })
    @PostMapping("/addEstudante/")
    public void addEstudante(@RequestBody EstudanteDto estudanteDto){
        estudanteService.addEstudante(estudanteDto);
    }







}
