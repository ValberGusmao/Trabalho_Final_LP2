package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

public class EspacoFisico implements Serializable, Comparable {
    private int capacidade;
    private String nome;
    private String localizacao;
    private Hashtable<ArrayList<Horario>,Solicitacao> solicitacoes;

    public EspacoFisico(int capacidade, String nome, String localizacao) {
        this.capacidade = capacidade;
        this.nome = nome;
        this.localizacao = localizacao;
        this.solicitacoes = new Hashtable<>();
    }

    public int getCapacidade() {
        return capacidade;
    }
    public String getNome() {
        return nome;
    }
    public String getLocalizacao() {
        return localizacao;
    }

    public Hashtable<ArrayList<Horario>, Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }
    @Override
    public boolean equals(Object obj) {
        EspacoFisico esp = (EspacoFisico) obj;
        return (esp.getNome().equals(nome)) && (esp.getLocalizacao().equals(localizacao));
    }
    @Override
    public String toString() {
        return getClass().getName().substring(6)+" - "+nome+" - "+localizacao;
    }

    @Override
    public int compareTo(Object o) {
        EspacoFisico esp = (EspacoFisico) o;
        return Integer.compare(capacidade, esp.capacidade);
    }
}
