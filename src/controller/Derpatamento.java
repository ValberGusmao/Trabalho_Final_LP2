package controller;

import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

//Principal Classe do Programa
public class Derpatamento {
    private ArrayList<EspacoFisico> espacos;
    private SalvarDados salvar;

    public Derpatamento(SalvarDados salvar) {
        this.salvar = salvar;
        carregarDados();
    }

    public void carregarDados(){
        espacos = (ArrayList<EspacoFisico>) salvar.carregarEspacos();
    }

    public void salvarDados(){
        salvar.salvarEspacos(espacos);
    }

    public boolean adicionarEspaco(EspacoFisico espacoFisico){
        if (!espacos.contains(espacoFisico)){
            espacos.add(espacoFisico);
            Collections.sort(espacos);
            return true;
        }
        return false;
    }

    public void relatorioPorEspaco(){
        for (EspacoFisico esp: espacos){
            System.out.println("\n|"+esp+"|");
            for (ArrayList<Horario> h : esp.getSolicitacoes().keySet()){
                System.out.println(esp.getSolicitacoes().get(h));
            }
        }
    }
    public void relatorioPorCurso(){
        Hashtable<String, ArrayList<Solicitacao>> hash = new Hashtable<>();
        for (EspacoFisico esp: espacos) {
            for (ArrayList<Horario> h: esp.getSolicitacoes().keySet()){
                Solicitacao sol = esp.getSolicitacoes().get(h);
                if(!hash.containsKey(sol.getCurso().getNome())){
                    hash.put(sol.getCurso().getNome(), new ArrayList<>());
                }
                hash.get(sol.getCurso().getNome()).add(sol);
            }
        }
        for (String c: hash.keySet()){
            System.out.println("|"+c+"|");
            for (Solicitacao s: hash.get(c)){
                System.out.println(s);
            }
        }

    }

    public EspacoFisico adicionarSolicitacao(Solicitacao solicitacao){
        if (solicitacao instanceof SolicitacaoFixa){
            return alocarAula((SolicitacaoFixa) solicitacao);
        }else if (solicitacao instanceof SolicitacaoEventual){
            return alocarEvento((SolicitacaoEventual) solicitacao);
        }
        return null;
    }

    private EspacoFisico alocarAula(SolicitacaoFixa solicitacao) {
        for(EspacoFisico esp: espacos){
            if(esp.getCapacidade() >= solicitacao.getVagas()){
                if (esp.getSolicitacoes().isEmpty()){
                    esp.getSolicitacoes().put(solicitacao.getHorario(), solicitacao);
                    return esp;
                }
                //Percorre todos os horarios presentes nas solicitações, e se encontrar algum horario em comum, desiste desse espaço
                boolean espacoDisponivel = true;
                for (ArrayList<Horario> horarios: esp.getSolicitacoes().keySet()) {
                    if (Horario.estaEmConflito(horarios, solicitacao.getHorario())){
                        espacoDisponivel = false;
                        break;
                    }
                }
                if (espacoDisponivel){
                    esp.getSolicitacoes().put(solicitacao.getHorario(),solicitacao);
                    return esp;
                }
            }
        }
        return null;
    }
    private EspacoFisico alocarEvento(SolicitacaoEventual solicitacao) {
        for(EspacoFisico esp: espacos){
            if(esp instanceof Auditorio){
                if(esp.getCapacidade() >= solicitacao.getVagas()){
                    if (esp.getSolicitacoes().isEmpty()){
                        esp.getSolicitacoes().put(solicitacao.getHorario(), solicitacao);
                        return esp;
                    }
                    //Percorre todos os horarios presentes nas solicitações, e se encontrar algum horario em comum, desiste desse espaço
                    boolean espacoDisponivel = true;
                    for (ArrayList<Horario> h: esp.getSolicitacoes().keySet()) {

                        // Verifica se para uma Solicitacao Eventual, a sua
                        // data de inicio do Evento entra em conflito com outo evento;
                        Solicitacao sol = esp.getSolicitacoes().get(h);
                        if (sol instanceof SolicitacaoEventual){
                            SolicitacaoEventual solEvent = (SolicitacaoEventual) sol;

                            // Se a data da nova solicitação não está no intervalo de outro evento, o horario dessa solicitação
                            // não interferi na escolha do espaço.
                            boolean dataSemConflito = solicitacao.getDataInicio().after(solEvent.getDataFim()) ||
                                    solicitacao.getDataFim().before(solEvent.getDataInicio());
                            if(dataSemConflito){
                                continue;
                            }
                        }
                        // Porem se for uma solicitação fixa ou os eventos existirem no mesmo período,
                        // tem que analisar se existe conflito de horarios
                        // Se existir, esse espaço não serve para receber a solicitação
                        if (Horario.estaEmConflito(h, solicitacao.getHorario())){
                            espacoDisponivel = false;
                            break;
                        }
                    }
                    if (espacoDisponivel){
                        esp.getSolicitacoes().put(solicitacao.getHorario(), solicitacao);
                        return esp;
                    }
                }
            }
        }
        return null;
    }
    public void carregarEntrada(EntradaArquivo entradaArquivo){
        try {
            entradaArquivo.lerArquivo(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected boolean carregarEntrada(String linha){
        String[] item = linha.split(";");
        String tipoSoli = item[0];
        try {
            if (item.length >= 7)
            {
                int ano = Integer.parseInt(item[1].trim());
                String semestre = item[2];
                Curso curso = new Curso(item[3]);
                String dado = item[4];
                int quantVagas = Integer.parseInt(item[5].trim());
                ArrayList<Horario> horario = Horario.adicionarHorario(item[6]);

                if(tipoSoli.equals("FIXA")){
                    SolicitacaoFixa soli = new SolicitacaoFixa(ano,semestre,curso,quantVagas,horario,dado);
                    return adicionarSolicitacao(soli)!=null;
                }
                else if(tipoSoli.equals("EVENTUAL")){
                    if (item.length >= 9) {
                        SolicitacaoEventual soli = new SolicitacaoEventual(ano,semestre,curso,quantVagas,horario,dado, item[7], item[8]);
                        return adicionarSolicitacao(soli)!=null;
                    }
                }
            }
        }catch (IllegalArgumentException e){
            System.out.println(e);
            System.out.println("Essa linha Não foi reconhecida como uma entrada válida: " + linha);
        }
        return false;
    }

    public ArrayList<EspacoFisico> getEspacos() {
        return espacos;
    }

    public SalvarDados getSalvar() {
        return salvar;
    }
}
