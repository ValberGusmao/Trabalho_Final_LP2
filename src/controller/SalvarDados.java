package controller;

import model.EspacoFisico;
import model.Solicitacao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SalvarDados {
    private File arquivo;

    public SalvarDados(String caminho) {
        this.arquivo = new File(caminho);
    }

    public List<EspacoFisico> carregarEspacos(){
        List<EspacoFisico> espacos;
        ObjectInputStream entrada = null;
        try {
            entrada = new ObjectInputStream(new FileInputStream(arquivo));
            espacos = (List<EspacoFisico>) entrada.readObject();
            return espacos;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new ArrayList<EspacoFisico>();

    }

    public void salvarEspacos(final List<EspacoFisico> espacos){
        if (espacos.isEmpty()) {
            return; // não salva uma lista vazia
        }
        ObjectOutputStream saida = null;
        try {
            saida = new ObjectOutputStream(new FileOutputStream(arquivo));
            saida.writeObject(espacos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (saida != null) {
                try {
                    saida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public File getArquivo() {
        return arquivo;
    }
}
