package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SolicitacaoEventual extends Solicitacao{
    private String finalidade;
    private Date dataInicio;
    private Date dataFim;

    public SolicitacaoEventual(int ano, String semestre, Curso curso, int vagas, ArrayList<Horario> horario, String finalidade, String dataInicio, String dataFim) {
        super(ano, semestre, curso, vagas, horario);
        this.finalidade = finalidade;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataInicio = sdf.parse(dataInicio);
            this.dataFim = sdf.parse(dataFim);;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("As datas estão num formato Inválido");
        }
    }

    public String getFinalidade() {
        return finalidade;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() +
                ", finalidade = " + finalidade +
                ", dataInicio = " + sdf.format(dataInicio) +
                ", dataFim = " + sdf.format(dataFim);
    }
}
