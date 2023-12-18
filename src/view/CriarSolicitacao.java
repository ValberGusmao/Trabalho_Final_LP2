package view;

import javax.swing.*;
import java.awt.event.*;

public class CriarSolicitacao extends JFrame {

    // Declara os componentes da janela
    private JLabel lAno, lCurso, lVagas, lHorario, lDisciplina, lTitulo;
    private JTextField txtAno, txtCurso, txtVagas, txtHorario, txtDisciplina;
    private JButton botaoCriar, botaoLimpar, botaoVoltar;
    private JRadioButton primeiroSem, segundoSem;
    private ButtonGroup grupo;
    private JPanel jPanel = new JPanel();

    public CriarSolicitacao() {
        // Define o título da janela
        super("Formulário");

        // Define o layout da janela como nulo
        setLayout(null);

        // Cria os componentes da janela
        lTitulo = new JLabel("Criar Solicitação");
        lAno = new JLabel("Ano:");
        lCurso = new JLabel("Curso:");
        lVagas = new JLabel("Vagas:");
        lHorario = new JLabel("Horario:");
        lDisciplina = new JLabel("Disciplina:");
        txtAno = new JTextField();
        txtAno.grabFocus();
        txtCurso = new JTextField();
        txtVagas = new JTextField();
        txtHorario = new JTextField();
        txtDisciplina = new JTextField();
        botaoCriar = new JButton("CRIAR");
        botaoLimpar = new JButton("LIMPAR");
        botaoVoltar = new JButton("VOLTAR");
        primeiroSem = new JRadioButton("1º Semestre");
        primeiroSem.setSelected(true);
        segundoSem = new JRadioButton("2º Semestre");
        grupo = new ButtonGroup();

        // Define as posições e tamanhos dos componentes
        lTitulo.setBounds(95,10,100,20);
        lAno.setBounds(0, 60, 100, 20);
        txtAno.setBounds(120, 60, 200, 20);
        primeiroSem.setBounds(30, 85, 100, 20);
        segundoSem.setBounds(160, 85, 100, 20);
        lCurso.setBounds(0, 110, 100, 20);
        txtCurso.setBounds(120, 110, 200, 20);
        lVagas.setBounds(0, 140, 100, 20);
        txtVagas.setBounds(120, 140, 200, 20);
        lHorario.setBounds(0, 170, 100, 20);
        txtHorario.setBounds(120, 170, 200, 20);
        lDisciplina.setBounds(0, 200, 100, 20);
        txtDisciplina.setBounds(120, 200, 200, 20);
        botaoCriar.setBounds(0, 240, 90, 25);
        botaoLimpar.setBounds(120, 240, 90, 25);
        botaoVoltar.setBounds(230, 240, 90, 25);

        // Adiciona os componentes à janela
        jPanel.add(lTitulo);
        jPanel.add(lAno);
        jPanel.add(txtAno);
        jPanel.add(primeiroSem);
        jPanel.add(segundoSem);
        jPanel.add(lCurso);
        jPanel.add(txtCurso);
        jPanel.add(lVagas);
        jPanel.add(txtVagas);
        jPanel.add(lHorario);
        jPanel.add(txtHorario);
        jPanel.add(lDisciplina);
        jPanel.add(txtDisciplina);
        jPanel.add(botaoCriar);
        jPanel.add(botaoLimpar);
        jPanel.add(botaoVoltar);

        setSize(720, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        jPanel.setBounds((getWidth()-320)/2,20,getWidth(),getHeight());
        jPanel.setLayout(null);
        add(jPanel);

        // Adiciona os botões de rádio ao grupo
        grupo.add(primeiroSem);
        grupo.add(segundoSem);

        // Define o tratamento dos eventos dos botões
        botaoCriar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Imprime os valores dos campos e do botão de rádio selecionado no console
                System.out.println("Campo 1: " + txtAno.getText());
                System.out.println("Campo 3: " + txtCurso.getText());
                System.out.println("Campo 4: " + txtVagas.getText());
                System.out.println("Campo 5: " + txtHorario.getText());
                System.out.println("Campo 6: " + txtDisciplina.getText());
                if (primeiroSem.isSelected()) {
                    System.out.println("Opção 1 selecionada");
                } else if (segundoSem.isSelected()) {
                    System.out.println("Opção 2 selecionada");
                } else {
                    System.out.println("Nenhuma opção selecionada");
                }
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Apaga os valores dos campos e desmarca os botões de rádio
                txtAno.setText("");
                txtCurso.setText("");
                txtVagas.setText("");
                txtHorario.setText("");
                txtDisciplina.setText("");
                grupo.clearSelection();
                primeiroSem.setSelected(true);
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fecha a janela
                dispose();
            }
        });

        // Define o tamanho e a posição da janela

    }

    public static void main(String[] args) {
        // Cria uma instância da classe Formulario
        new CriarSolicitacao();
    }
}