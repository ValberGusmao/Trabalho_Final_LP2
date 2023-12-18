package controller;

import java.io.*;

public class EntradaArquivo {
    private File arquivo;
    public EntradaArquivo(String caminho){
        this.arquivo = new File(caminho);
        try {
            if(!arquivo.createNewFile()){
                System.out.println("O Arquivo Já existe");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void lerArquivo(Derpatamento derpatamento) throws IOException {
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        String linha;
        try {
            while ((linha = leitor.readLine()) != null) {
                if(!derpatamento.carregarEntrada(linha)){
                    System.out.println("Não foi possível alocar uma sala para a seguinte solicitação: "+linha);
                }
            }
        }
        finally {
            leitor.close();
        }
    }
}
