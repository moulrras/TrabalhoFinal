package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cupom extends JFrame {
    public Cupom() {
        setTitle("Gerar Cupom");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblCodigo = new JLabel("Código do Cupom:");
        JTextField txtCodigo = new JTextField(15);
        txtCodigo.setEditable(false);
        txtCodigo.setText(gerarCodigoCupom());

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblCodigo, gbc);
        gbc.gridx = 1;
        add(txtCodigo, gbc);

        JButton btnGerarNovo = new JButton("Gerar Novo Cupom");
        btnGerarNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCodigo.setText(gerarCodigoCupom());
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnGerarNovo, gbc);
    }

    private String gerarCodigoCupom() {
        // Gera um código de cupom aleatório ou baseado em alguma lógica específica
        return "ABC123";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Cupom().setVisible(true);
            }
        });
    }
}
