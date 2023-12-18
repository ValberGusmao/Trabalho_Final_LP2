package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Solicitacao implements Serializable {
    private int ano;
    private String semestre;
    private Curso curso;
    private int vagas;
    private ArrayList<Horario> horario;

    public Solicitacao(int ano, String semestre, Curso curso, int vagas, ArrayList<Horario> horario) {
        this.ano = ano;
        this.semestre = semestre;
        this.curso = curso;
        this.vagas = vagas;
        this.horario = horario;
    }

    public int getAno() {
        return ano;
    }

    public String getSemestre() {
        return semestre;
    }

    public Curso getCurso() {
        return curso;
    }

    public int getVagas() {
        return vagas;
    }

    public ArrayList<Horario> getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return  "ano = " + ano +
                ", semestre = " +  semestre +
                ", curso = " + curso +
                ", vagas = " + vagas +
                ", horario = " + horario;
    }
}
