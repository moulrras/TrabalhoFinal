package Classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clientes {

    private JPanel panel1;
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtSexo;
    private JTextField txtIdade;
    private JTextField txtEndereço;
    private JButton btnGravar;

    public Clientes() {
        JFrame frame = new JFrame("Tela de Cadastro");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField(20);

        JLabel lblCpf = new JLabel("CPF:");
        txtCpf = new JTextField(14);

        JLabel lblSexo = new JLabel("Sexo:");
        txtSexo = new JTextField(20);

        JLabel lblEndereço = new JLabel("Endereço:");
        txtEndereço = new JTextField(14);

        JLabel lblIdade = new JLabel("Idade:");
        txtIdade = new JTextField(20);

        btnGravar = new JButton("Gravar");

        btnGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                int cpf = Integer.parseInt(txtCpf.getText());
                String sexo = txtSexo.getText();
                String endereço = txtEndereço.getText();
                int idade = Integer.parseInt(txtIdade.getText());

                JOptionPane.showMessageDialog(null,
                                "Nome: " + nome + "\n" +
                                "CPF: " + cpf + "\n" +
                                "Sexo: " + sexo + "\n" +
                                "Endereço: " + endereço + "\n " + "Idade: "+ idade);
            }
        });

        panel1 = new JPanel();
        panel1.add(lblIdade);
        panel1.add(txtIdade);
        panel1.add(lblNome);
        panel1.add(txtNome);
        panel1.add(lblCpf);
        panel1.add(txtCpf);
        panel1.add(lblSexo);
        panel1.add(txtSexo);
        panel1.add(lblEndereço);
        panel1.add(txtEndereço);
        panel1.add(btnGravar);

        frame.add(panel1);
        frame.pack();

        frame.setLocationRelativeTo(null);
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
