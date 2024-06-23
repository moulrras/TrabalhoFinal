package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Categorias extends JFrame {
    private Carrinho carrinho;

    public Categorias(Carrinho carrinho) {
        this.carrinho = carrinho;

        setTitle("Venda de Camisas");
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

        JLabel titulo = new JLabel("Venda de Camisas");
        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        titulo.setForeground(Color.MAGENTA);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titulo, gbc);

        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton btnBasquete = new JButton("Camisas de Basquete");
        btnBasquete.setFont(new Font("Arial", Font.PLAIN, 18));
        btnBasquete.setBackground(Color.BLACK);
        btnBasquete.setForeground(Color.MAGENTA);
        btnBasquete.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(btnBasquete, gbc);

        JButton btnFutebolNacional = new JButton("Camisas de Futebol Nacionais");
        btnFutebolNacional.setFont(new Font("Arial", Font.PLAIN, 18));
        btnFutebolNacional.setBackground(Color.BLACK);
        btnFutebolNacional.setForeground(Color.MAGENTA);
        btnFutebolNacional.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(btnFutebolNacional, gbc);

        JButton btnFutebolInternacional = new JButton("Camisas de Futebol Internacionais");
        btnFutebolInternacional.setFont(new Font("Arial", Font.PLAIN, 18));
        btnFutebolInternacional.setBackground(Color.BLACK);
        btnFutebolInternacional.setForeground(Color.MAGENTA);
        btnFutebolInternacional.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(btnFutebolInternacional, gbc);

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
        gbc.gridy = 4;
        add(btnVoltar, gbc);

        btnBasquete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CamisaBasquete(carrinho).display();
            }
        });

        btnFutebolNacional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CamisaFutebolNacional(carrinho).display();
            }
        });

        btnFutebolInternacional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CamisaFutebolInternacional(carrinho).display();
            }
        });
    }

    public Categorias() {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Carrinho carrinho = new Carrinho();
                Categorias categorias = new Categorias(carrinho);
                categorias.setVisible(true);
            }
        });
    }
}
