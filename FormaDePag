package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormaDePag {
    private String nomeCliente;
    private String marcaCartao;
    private int numeroCartao;
    private int cpf;
    private int codSeg;
    private static boolean cartaoAdicionado = false;

    public FormaDePag() {
        JFrame frame = new JFrame("Adicionar Forma de Pagamento");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLayout(new GridLayout(6, 2, 10, 10));
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela

        JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
        JTextField txtNomeCliente = new JTextField(20);

        JLabel lblMarcaCartao = new JLabel("Marca do Cartão:");
        JTextField txtMarcaCartao = new JTextField(20);

        JLabel lblCpf = new JLabel("CPF:");
        JTextField txtCpf = new JTextField(14);

        JLabel lblNumeroCartao = new JLabel("Nº do Cartão:");
        JTextField txtNumeroCartao = new JTextField(20);

        JLabel lblCodSeg = new JLabel("CVV:");
        JTextField txtCodSeg = new JTextField(3);

        frame.add(lblNomeCliente);
        frame.add(txtNomeCliente);

        frame.add(lblMarcaCartao);
        frame.add(txtMarcaCartao);

        frame.add(lblCpf);
        frame.add(txtCpf);

        frame.add(lblNumeroCartao);
        frame.add(txtNumeroCartao);

        frame.add(lblCodSeg);
        frame.add(txtCodSeg);

        JButton btnGravar = new JButton("Gravar");
        btnGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeCliente = txtNomeCliente.getText();
                marcaCartao = txtMarcaCartao.getText();
                numeroCartao = Integer.parseInt(txtNumeroCartao.getText());
                cpf = Integer.parseInt(txtCpf.getText());
                codSeg = Integer.parseInt(txtCodSeg.getText());

                cartaoAdicionado = true; // Indica que um cartão foi adicionado

                JOptionPane.showMessageDialog(frame,
                        "Cartão adicionado!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        frame.add(btnGravar);

        frame.setVisible(true);
    }

    public static boolean isCartaoAdicionado() {
        return cartaoAdicionado;
    }

    public static void main(String[] args) {
        new FormaDePag();
    }

    public void setVisible(boolean b) {
    }
}
