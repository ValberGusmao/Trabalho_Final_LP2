package view;

import controller.Derpatamento;
import controller.EntradaArquivo;
import controller.SalvarDados;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntradaArquivo leitura;
        SalvarDados salvarDados = new SalvarDados("dados/save.dat");
        Derpatamento derpatamento = new Derpatamento(salvarDados);

        int entradaInt = 1;
        String entradaStr;
        boolean ehInvalida, saindo = false;
        do {
            do {
                ehInvalida = false;
                try {
                    System.out.println("___________________________");
                    System.out.println("|MENU|\n1 - Mostrar Solicitações\n2 - Adicionar Solicitações\n" +
                            "3 - Adicionar Espaço\n4 - Carregar Arquivo\n5 - Sair");
                    System.out.print("-> ");
                    entradaInt = Integer.parseInt(scanner.nextLine());
                    if (entradaInt < 1 || entradaInt > 5) {
                        throw new IllegalArgumentException();
                    }
                } catch (Exception e) {
                    System.out.println("Entrada Inválida");
                    ehInvalida = true;
                }
            } while (ehInvalida);

            switch (entradaInt) {
                case 1:
                    do {
                        ehInvalida = false;
                        try {
                            System.out.println("Deseja mostrar as Solicitações por Curso(a) ou pelo Espaco(b)");
                            System.out.print("-> ");
                            entradaStr = scanner.nextLine();
                            if (entradaStr.equals("a")) {
                                derpatamento.relatorioPorCurso();
                            } else if (entradaStr.equals("b")) {
                                derpatamento.relatorioPorEspaco();
                            } else {
                                throw new Exception("Entrada Inválida, digite as letras (a) ou (b)");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            ehInvalida = true;
                        }
                    }while (ehInvalida);
                    break;
                case 2:
                    do {
                        int ano, vagas;
                        String semestre, disciplina, finalidade, dataInicio, dataFim;
                        Curso curso;
                        ehInvalida = false;
                        ArrayList<Horario> horario;

                        try {
                            System.out.println("Isso é uma Solicitação para uma Aula(a) ou para um Evento(b)");
                            System.out.println("Para voltar digite a letra (c):");
                            System.out.print("-> ");
                            entradaStr = scanner.nextLine();
                            if (entradaStr.equals("a") || entradaStr.equals("b")) {
                                System.out.println("|Criar uma Solicitação <FIXA>|");
                                System.out.println("Ano: ");
                                System.out.print("-> ");
                                ano = Integer.parseInt(scanner.nextLine());
                                System.out.println("Semestre: ");
                                System.out.print("-> ");
                                semestre = scanner.nextLine();
                                System.out.println("Curso: ");
                                System.out.print("-> ");
                                curso = new Curso(scanner.nextLine());
                                System.out.println("Vagas: ");
                                System.out.print("-> ");
                                vagas = Integer.parseInt(scanner.nextLine());
                                System.out.println("Horario: ");
                                System.out.print("-> ");
                                horario = Horario.adicionarHorario(scanner.nextLine());
                                if(entradaStr.equals("a")){
                                    System.out.println("Disciplina: ");
                                    System.out.print("-> ");
                                    disciplina = scanner.nextLine();
                                    if (derpatamento.adicionarSolicitacao (new SolicitacaoFixa(ano,
                                            semestre, curso, vagas, horario, disciplina)) == null) {
                                        throw new Exception("Não foi possível alocar uma sala");
                                    }
                                    else{
                                        System.out.println("A solicitação foi alocada com sucesso");
                                    }
                                }
                                else {
                                    System.out.println("Finalidade: ");
                                    System.out.print("-> ");
                                    finalidade = scanner.nextLine();
                                    System.out.println("Data Inicio (formato dd/mm/yyyy): ");
                                    System.out.print("-> ");
                                    dataInicio = scanner.nextLine();
                                    System.out.println("Data Fim (formato dd/mm/yyyy): ");
                                    System.out.print("-> ");
                                    dataFim = scanner.nextLine();
                                    if (derpatamento.adicionarSolicitacao(new SolicitacaoEventual(ano, semestre,
                                            curso, vagas, horario, finalidade, dataInicio, dataFim)) == null) {
                                        throw new Exception("Não foi possível alocar uma sala");
                                    }
                                    else{
                                        System.out.println("A solicitação foi alocada com sucesso");
                                    }
                                }
                            } else if (entradaStr.equals("c")) {
                                break;
                            } else {
                                throw new IllegalArgumentException("Entrada Inválida, digite as letras (a) ou (b)");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            ehInvalida = true;
                        }
                    } while (ehInvalida);
                    break;
                case 3:
                    int capacidade;
                    String nome, localizacao;

                    do{
                        ehInvalida = false;
                        try {
                            System.out.println("Alditório(a) ou Sala de Aula (b): ");
                            System.out.println("Para voltar digite a letra (c):");
                            System.out.print("-> ");
                            entradaStr = scanner.nextLine();

                            if (entradaStr.equals("a") || entradaStr.equals("b")){
                                System.out.println("|Inserir um novo Espaco|");
                                System.out.println("Capacidade: ");
                                System.out.print("-> ");
                                capacidade = Integer.parseInt(scanner.nextLine());

                                System.out.println("Nome: ");
                                System.out.print("-> ");
                                nome = scanner.nextLine();

                                System.out.println("Localização: ");
                                System.out.print("-> ");
                                localizacao = scanner.nextLine();
                                if(entradaStr.equals("a")){
                                    derpatamento.adicionarEspaco(new SalaDeAula(capacidade,nome,localizacao));
                                } else {
                                    derpatamento.adicionarEspaco(new Auditorio(capacidade,nome,localizacao));
                                }
                            } else if (!entradaStr.equals("c")) {
                                throw new Exception("Entrada Inválida, digite as letras (a) ou (b) ");
                            }
                        }
                        catch (Exception e){
                            System.out.println(e.getMessage());
                            ehInvalida = true;
                        }
                    }while (ehInvalida);
                    break;
                case 4:
                    do {
                        ehInvalida = false;
                        System.out.println("Qual o nome do arquivo de entrada (ele deve estar na pasta \"dados/\"): ");
                        System.out.print("-> ");
                        entradaStr = scanner.nextLine();
                        try {
                            leitura = new EntradaArquivo("dados/"+entradaStr);

                            System.out.println("Deseja carregar o arquivo de entrada ("
                                    +leitura.getArquivo().getName()+") (s\\n): ");
                            System.out.print("-> ");
                            entradaStr = scanner.nextLine();
                            if(entradaStr.equals("s")){
                                derpatamento.carregarEntrada(leitura);
                            }
                            else if (!entradaStr.equals("n")){
                                throw new Exception("Entrada Inválida, digite as letras (s) ou (n) ");
                            }
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                            ehInvalida = true;
                        }
                    }while (ehInvalida);

                    break;
                case 5:
                    System.out.println("Fechando o Programa...");
                    saindo = true;
                    break;
            }
            derpatamento.salvarDados();
        }while (!saindo);

    }
}