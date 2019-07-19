package com.escola.escola.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estudante")
public class Estudante extends BaseEntity{

    @Column(name = "nome", length = 255, nullable = false, unique = true)
    private String nome;

    @Column(name = "matricula", nullable = false, length = 10, unique = true)// "MAT010203"
    private String matricula;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "turma")
    private String turma;

    @ManyToMany
    private List<Materia> materias;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getMateriasNomes() {
        String nomesMatriculas = "";

        for (Materia materia: this.materias) {
            nomesMatriculas +=  materia.getNome() + ", ";
        }

        return nomesMatriculas;
    }
}
