package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaPrincipal extends JFrame {

    // Declara os componentes da janela
    private JPanel painelPrincipal, painelSolicitacao, painelEspaco, painelOpcao1, painelOpcao2;
    private JButton botaoSolicitacao, botaoEspaco, botaoOpcao1, botaoOpcao2;
    private CardLayout layout;

    public JanelaPrincipal() {
        // Define o título da janela
        super("Tela Principal");

        // Define o layout da janela como nulo
        setLayout(null);

        // Cria os componentes da janela
        painelPrincipal = new JPanel();
        painelSolicitacao = new JPanel();
        painelEspaco = new JPanel();
        painelOpcao1 = new JPanel();
        painelOpcao2 = new JPanel();
        botaoSolicitacao = new JButton("Cadastrar Solicitação");
        botaoEspaco = new JButton("Cadastrar Espaço");
        botaoOpcao1 = new JButton("Opção 1");
        botaoOpcao2 = new JButton("Opção 2");
        layout = new CardLayout();

        // Adiciona os componentes ao painel principal
        painelPrincipal.add(painelSolicitacao, "solicitacao");
        painelPrincipal.add(painelEspaco, "espaco");
        painelPrincipal.add(painelOpcao1, "opcao1");
        painelPrincipal.add(painelOpcao2, "opcao2");

        // Define o layout do painel principal como CardLayout
        painelPrincipal.setLayout(layout);

        // Adiciona o painel principal à janela
        add(painelPrincipal);

        // Adiciona os botões à janela
        add(botaoSolicitacao);
        add(botaoEspaco);
        add(botaoOpcao1);
        add(botaoOpcao2);

        // Define as posições e tamanhos dos componentes
        painelPrincipal.setBounds(0, 0, 300, 200);
        botaoSolicitacao.setBounds(0, 200, 75, 25);
        botaoEspaco.setBounds(75, 200, 75, 25);
        botaoOpcao1.setBounds(150, 200, 75, 25);
        botaoOpcao2.setBounds(225, 200, 75, 25);

        setSize(720, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Define o tratamento dos eventos dos botões
        botaoSolicitacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mostra o painel de cadastro de solicitação
                layout.show(painelPrincipal, "solicitacao");
            }
        });

        botaoEspaco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mostra o painel de cadastro de espaço
                layout.show(painelPrincipal, "espaco");
            }
        });

        botaoOpcao1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mostra o painel da opção 1
                layout.show(painelPrincipal, "opcao1");
            }
        });

        botaoOpcao2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mostra o painel da opção 2
                layout.show(painelPrincipal, "opcao2");
            }
        });

        // Define o tamanho e a posição da janela

    }

    public static void main(String[] args) {
        // Cria uma instância da classe janelaPrincipal
        new JanelaPrincipal();
    }
}
