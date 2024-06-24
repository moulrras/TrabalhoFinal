package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Reclamacao extends JFrame {

    private JTextField txtNome;
    private JTextField txtCPF;
    private JTextField txtEndereco;
    private JTextField txtEmail;
    private JTextField txtTelefone;
    private JTextArea txtReclamacao;

    public static ArrayList<String> reclamacoes = new ArrayList<>();

    public Reclamacao() {
        setTitle("Anotar Reclamação");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblNome = new JLabel("Nome Completo:");
        txtNome = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblNome, gbc);
        gbc.gridx = 1;
        add(txtNome, gbc);

        JLabel lblCPF = new JLabel("CPF:");
        txtCPF = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblCPF, gbc);
        gbc.gridx = 1;
        add(txtCPF, gbc);

        JLabel lblEndereco = new JLabel("Endereço:");
        txtEndereco = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblEndereco, gbc);
        gbc.gridx = 1;
        add(txtEndereco, gbc);

        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblEmail, gbc);
        gbc.gridx = 1;
        add(txtEmail, gbc);

        JLabel lblTelefone = new JLabel("Telefone:");
        txtTelefone = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(lblTelefone, gbc);
        gbc.gridx = 1;
        add(txtTelefone, gbc);

        JLabel lblReclamacao = new JLabel("Reclamação:");
        txtReclamacao = new JTextArea(5, 20);
        txtReclamacao.setLineWrap(true);
        txtReclamacao.setWrapStyleWord(true);
        JScrollPane scrollReclamacao = new JScrollPane(txtReclamacao);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.NORTH;
        add(lblReclamacao, gbc);
        gbc.gridx = 1;
        add(scrollReclamacao, gbc);

        JButton btnSubmit = new JButton("Enviar Reclamação");
        btnSubmit.setBackground(Color.BLACK);
        btnSubmit.setForeground(Color.MAGENTA);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnSubmit, gbc);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String cpf = txtCPF.getText();
                String endereco = txtEndereco.getText();
                String email = txtEmail.getText();
                String telefone = txtTelefone.getText();
                String reclamacao = txtReclamacao.getText();

                String complaint = "Nome: " + nome + "\nCPF: " + cpf + "\nEndereço: " + endereco +
                        "\nEmail: " + email + "\nTelefone: " + telefone + "\nReclamação: " + reclamacao + "\n";
                reclamacoes.add(complaint);

                JOptionPane.showMessageDialog(Reclamacao.this, "Reclamação salva!");
                dispose();
            }
        });
    }
}