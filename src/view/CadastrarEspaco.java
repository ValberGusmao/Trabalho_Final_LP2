package view;

import javax.swing.*;
import java.awt.event.*;

public class CadastrarEspaco extends JFrame {

    // Declara os componentes da janela
    private JLabel lCapacidade, lNome, lLocalizacao, lTitulo;
    private JTextField txtCapacidade, txtNome, txtLocalizacao;
    private JButton botaoCadastrar, botaoVoltar;
    private JRadioButton jrSala, jrAuditorio;
    private ButtonGroup grupo;
    private JPanel jPanel = new JPanel();

    public CadastrarEspaco() {
        // Define o título da janela
        super("Formulário");

        // Define o layout da janela como nulo
        setLayout(null);

        // Cria os componentes da janela
        lTitulo = new JLabel("Cadastrar Espaço");
        lCapacidade = new JLabel("Capacidade:");
        lNome = new JLabel("Nome:");
        lLocalizacao = new JLabel("Localização:");
        txtCapacidade = new JTextField();
        txtCapacidade.grabFocus();
        txtNome = new JTextField();
        txtLocalizacao = new JTextField();
        jrSala = new JRadioButton("Sala");
        jrSala.setSelected(true);
        jrAuditorio = new JRadioButton("Auditorio");
        grupo = new ButtonGroup();
        botaoCadastrar = new JButton("CADASTRAR");
        botaoVoltar = new JButton("VOLTAR");

        // Define as posições e tamanhos dos componentes
        lTitulo.setBounds(95,10,150,20);
        lCapacidade.setBounds(0, 60, 100, 20);
        txtCapacidade.setBounds(120, 60, 200, 20);
        lNome.setBounds(0, 90, 100, 20);
        txtNome.setBounds(120, 90, 200, 20);
        lLocalizacao.setBounds(0, 120, 100, 20);
        txtLocalizacao.setBounds(120, 120, 200, 20);
        jrSala.setBounds(40,150,100,20);
        jrAuditorio.setBounds(170,150,100,20);
        botaoCadastrar.setBounds(0, 180, 120, 25);
        botaoVoltar.setBounds(190, 180, 120, 25);

        // Adiciona os componentes à janela
        jPanel.add(lTitulo);
        jPanel.add(lCapacidade);
        jPanel.add(txtCapacidade);
        jPanel.add(lNome);
        jPanel.add(txtNome);
        jPanel.add(lLocalizacao);
        jPanel.add(txtLocalizacao);
        jPanel.add(botaoCadastrar);
        jPanel.add(botaoVoltar);
        jPanel.add(jrSala);
        jPanel.add(jrAuditorio);

        grupo.add(jrSala);
        grupo.add(jrAuditorio);

        setSize(720, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        jPanel.setBounds((getWidth()-320)/2,20,getWidth(),getHeight());
        jPanel.setLayout(null);
        add(jPanel);

        // Define o tratamento dos eventos dos botões
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Imprime os valores dos campos no console
                System.out.println("Capacidade: " + txtCapacidade.getText());
                System.out.println("Nome: " + txtNome.getText());
                System.out.println("Localização: " + txtLocalizacao.getText());
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fecha a janela
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        // Cria uma instância da classe CadastrarEspaco
        new CadastrarEspaco();
    }
}
