package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GerenciarFuncionarios extends JFrame {
    private ArrayList<Funcionario> funcionarios;

    public GerenciarFuncionarios() {
        setTitle("Gerenciar Funcionários");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        funcionarios = new ArrayList<>();

        JTextArea txtAreaFuncionarios = new JTextArea();
        txtAreaFuncionarios.setEditable(false);
        txtAreaFuncionarios.setFont(new Font("Arial", Font.PLAIN, 14));

        // Exemplo: Adicionar funcionários fictícios para demonstração
        funcionarios.add(new Funcionario("Pedro Henrique", "Gerente"));
        funcionarios.add(new Funcionario("Pedro Moreira", "Vendedor"));

        for (Funcionario funcionario : funcionarios) {
            txtAreaFuncionarios.append(funcionario.toString() + "\n\n");
        }

        JScrollPane scrollPane = new JScrollPane(txtAreaFuncionarios);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnAdicionar = new JButton("Adicionar Funcionário");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar um novo funcionário
                String nome = JOptionPane.showInputDialog(GerenciarFuncionarios.this, "Nome do funcionário:");
                String cargo = JOptionPane.showInputDialog(GerenciarFuncionarios.this, "Cargo do funcionário:");

                Funcionario novoFuncionario = new Funcionario(nome, cargo);
                funcionarios.add(novoFuncionario);
                txtAreaFuncionarios.append(novoFuncionario.toString() + "\n\n");
            }
        });

        JPanel panelBotoes = new JPanel();
        panelBotoes.add(btnAdicionar);

        add(panelBotoes, BorderLayout.SOUTH);
    }

    // Exemplo de classe Funcionario para este contexto
    private class Funcionario {
        private String nome;
        private String cargo;

        public Funcionario(String nome, String cargo) {
            this.nome = nome;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "Nome: " + nome + ", Cargo: " + cargo;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GerenciarFuncionarios().setVisible(true);
            }
        });
    }
}
