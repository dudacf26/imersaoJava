package com.escola.escola.application.dto;

public class EstudanteDto {

    public EstudanteDto(){}
    public EstudanteDto(Long id,
                        String nome,
                        String matricula,
                        Integer idade,
                        String turma,
                        String matriculas
    ) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
        this.turma = turma;
        this.matriculas = matriculas;
    }

    private Long id;
    private String nome;
    private String matricula;
    private Integer idade;
    private String turma;
    private String matriculas;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getTurma() {
        return turma;
    }

    public String getMatriculas() {
        return matriculas;
    }
}
