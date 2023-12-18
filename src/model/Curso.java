package model;

import java.io.Serializable;

public class Curso implements Serializable {
    private String nome;

    public Curso(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }
}
