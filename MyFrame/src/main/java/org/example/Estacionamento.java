package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Estacionamento extends JFrame implements ActionListener {

    private ArrayList<JTextField> clienteHorasList; // Lista para armazenar os campos de texto de horas
    private JPanel panel; // Painel para adicionar novos clientes
    private JButton calcular; // Botão para calcular taxas
    private JButton adicionarCliente; // Botão para adicionar um novo cliente
    private JScrollPane scrollPane; // Painel rolável

    public Estacionamento() {
        clienteHorasList = new ArrayList<>(); // Inicializa a lista de campos de horas
        init();
    }

    private void init() {
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Layout vertical

        // Adicionando o painel ao JScrollPane
        scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(400, 200)); // Define o tamanho do JScrollPane
        c.add(scrollPane, BorderLayout.CENTER);

        adicionarCliente = new JButton("Adicionar Cliente");
        adicionarCliente.addActionListener(e -> addCliente());
        c.add(adicionarCliente, BorderLayout.NORTH);

        calcular = new JButton("Calcular");
        calcular.addActionListener(this);
        c.add(calcular, BorderLayout.SOUTH);

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addCliente() {
        JTextField clienteHoras = new JTextField(10);
        panel.add(new JLabel("Horas Cliente " + (clienteHorasList.size() + 1) + ": "));
        panel.add(clienteHoras);
        clienteHorasList.add(clienteHoras); // Adiciona o campo à lista
        panel.revalidate(); // Atualiza o painel para mostrar o novo campo
        panel.repaint(); // Repaint para garantir que a interface gráfica seja atualizada
    }

    public double calculateCharges(double rec1) {
        double res1 = 0;
        if (rec1 <= 3) {
            res1 = 2; // Custo fixo para até 3 horas
        } else {
            res1 = 2 + (rec1 - 3) * 0.5; // Custo adicional para horas extras
        }
        return res1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder resultados = new StringBuilder(); // Para armazenar os resultados

        for (JTextField clienteHoras : clienteHorasList) {
            try {
                String c1h = clienteHoras.getText();
                double rec1 = Double.parseDouble(c1h); // Converte para double
                double r = calculateCharges(rec1); // Calcula a taxa
                resultados.append("Cliente ").append(clienteHorasList.indexOf(clienteHoras) + 1)
                        .append(": R$ ").append(r).append("\n"); // Adiciona o resultado
            } catch (NumberFormatException ex) {
                resultados.append("Cliente ").append(clienteHorasList.indexOf(clienteHoras) + 1)
                        .append(": Erro - valor inválido\n");
            }
        }

        JOptionPane.showMessageDialog(this, resultados.toString()); // Exibe todos os resultados
    }

}