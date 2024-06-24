package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoriasChegando extends JFrame {
    private Carrinho carrinho;

    public CategoriasChegando(Carrinho carrinho) {
        this.carrinho = carrinho;

        setTitle("Próximas Chegadas de Camisas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.BLACK);

        JMenuItem menuItemCarrinho = new JMenuItem("Carrinho");
        menuItemCarrinho.setIcon(new ImageIcon("path/to/cart/icon.png"));
        menuItemCarrinho.setForeground(Color.MAGENTA);
        menuItemCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrinho.displayCart();
            }
        });
        menuBar.add(menuItemCarrinho);

        setJMenuBar(menuBar);

        getContentPane().setBackground(Color.BLACK);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titulo = new JLabel("Próximas Chegadas de Camisas");
        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        titulo.setForeground(Color.MAGENTA);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titulo, gbc);

        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton btnChegando = new JButton("Camisas que Estão para Chegar");
        btnChegando.setFont(new Font("Arial", Font.PLAIN, 18));
        btnChegando.setBackground(Color.BLACK);
        btnChegando.setForeground(Color.MAGENTA);
        btnChegando.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(btnChegando, gbc);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Arial", Font.PLAIN, 16));
        btnVoltar.setBackground(Color.BLACK);
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(btnVoltar, gbc);

        btnChegando.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CamisasChegando(carrinho).display();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Carrinho carrinho = new Carrinho();
                CategoriasChegando categorias = new CategoriasChegando(carrinho);
                categorias.setVisible(true);
            }
        });
    }
}
