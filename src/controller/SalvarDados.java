package controller;

import model.EspacoFisico;
import model.Solicitacao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Classe responsável por salvar e recuperar o estado do programa
//Diferente da classe EntradaArquivo que trabalha com arquivo txt, esta funciona com ObjectStream para salvar os dados
public class SalvarDados {
    private File arquivo;

    public SalvarDados(String caminho) {
        this.arquivo = new File(caminho);
    }

    protected List<EspacoFisico> carregarEspacos(){
        List<EspacoFisico> espacos;
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arquivo))){
            espacos = (List<EspacoFisico>) entrada.readObject();
            return espacos;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    protected void salvarEspacos(final List<EspacoFisico> espacos){
        if (espacos.isEmpty()) {
            return;
        }
        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(arquivo))){
            saida.writeObject(espacos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getArquivo() {
        return arquivo;
    }
}
