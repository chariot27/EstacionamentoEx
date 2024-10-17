package org.example;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        // Exibe a mensagem de inicialização
        JOptionPane.showMessageDialog(null, "Iniciando AXIS...", "Init", JOptionPane.INFORMATION_MESSAGE);

        String escolha = JOptionPane.showInputDialog("1 - Continuar\n2 - Sair\n");
        int chosed = Integer.parseInt(escolha);

        if (chosed == 1) {
            init();
        } else if (chosed == 2) {
            JOptionPane.showMessageDialog(null, "Encerrando AXIS...", "Closing", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public void init() {
        JLabel loginLabel, passLabel;
        JTextField login, pass;
        JButton enter;

        // Cria um painel com GridBagLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre os componentes

        // Configura os componentes
        loginLabel = new JLabel("Login");
        login = new JTextField(15);
        login.setMaximumSize(new Dimension(Integer.MAX_VALUE, login.getPreferredSize().height));

        passLabel = new JLabel("Password");
        pass = new JTextField(15);
        pass.setMaximumSize(new Dimension(Integer.MAX_VALUE, pass.getPreferredSize().height));

        enter = new JButton("Enter");

        // Adiciona os componentes ao painel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(loginLabel, gbc);

        gbc.gridx = 1;
        panel.add(login, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passLabel, gbc);

        gbc.gridx = 1;
        panel.add(pass, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // O botão ocupa duas colunas
        panel.add(enter, gbc);

        // Configura a janela
        getContentPane().add(panel);
        setTitle("AXIS Login");
        setSize(400, 200); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao fechar a janela
        setVisible(true); // Torna a janela visível
    }

}