package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clientes {

    private JPanel panel1;
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtSexo;
    private JTextField txtIdade;
    private JTextField txtEndereco;
    private JButton btnGravar;

    public Clientes() {
        JFrame frame = new JFrame("Tela de Cadastro");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLayout(new GridLayout(6, 2, 10, 10)); // Usando GridLayout
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField(20);

        JLabel lblCpf = new JLabel("CPF:");
        txtCpf = new JTextField(14);

        JLabel lblSexo = new JLabel("Sexo:");
        txtSexo = new JTextField(20);

        JLabel lblEndereco = new JLabel("Endereço:");
        txtEndereco = new JTextField(20);

        JLabel lblIdade = new JLabel("Idade:");
        txtIdade = new JTextField(20);

        btnGravar = new JButton("Gravar");
        btnGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                int cpf = Integer.parseInt(txtCpf.getText());
                String sexo = txtSexo.getText();
                String endereco = txtEndereco.getText();
                int idade = Integer.parseInt(txtIdade.getText());

                JOptionPane.showMessageDialog(frame,
                        "Nome: " + nome + "\n" +
                                "CPF: " + cpf + "\n" +
                                "Sexo: " + sexo + "\n" +
                                "Endereço: " + endereco + "\n" +
                                "Idade: " + idade);
            }
        });

        frame.add(lblNome);
        frame.add(txtNome);

        frame.add(lblCpf);
        frame.add(txtCpf);

        frame.add(lblSexo);
        frame.add(txtSexo);

        frame.add(lblEndereco);
        frame.add(txtEndereco);

        frame.add(lblIdade);
        frame.add(txtIdade);

        frame.add(new JLabel()); // Placeholder para alinhar o botão no grid
        frame.add(btnGravar);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Clientes();
            }
        });
    }

    public void setVisible(boolean b) {
    }
}
