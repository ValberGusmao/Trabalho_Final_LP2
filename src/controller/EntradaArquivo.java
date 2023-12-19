package controller;

import java.io.*;

//Classe responsável por manipular um arquivo de entrada passado para o programa.
public class EntradaArquivo {
    private File arquivo;
    public EntradaArquivo(String caminho){
        this.arquivo = new File(caminho);
    }
    //Como o arquivo de entrada apenas precisa ser lido, essa é a principal função da classe
    public void lerArquivo(Derpatamento derpatamento) throws IOException {
        String linha;
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))){
            while ((linha = leitor.readLine()) != null) {
                if(!derpatamento.carregarEntrada(linha)){
                    System.out.println("Não foi possível alocar uma sala para a seguinte solicitação: "+linha);
                }
            }
        }
    }

    public File getArquivo() {
        return arquivo;
    }
}
