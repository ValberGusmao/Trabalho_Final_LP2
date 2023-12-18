package model;

import java.util.ArrayList;

public class SolicitacaoFixa extends Solicitacao{
    private String disciplina;

    public SolicitacaoFixa(int ano, String semestre, Curso curso, int vagas, ArrayList<Horario> horario, String disciplina) {
        super(ano, semestre, curso, vagas, horario);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", disciplina = " + disciplina;
    }

}
