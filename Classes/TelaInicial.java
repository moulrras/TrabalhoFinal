package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {
    private Carrinho carrinho;

    public TelaInicial() {
        carrinho = new Carrinho();

        setTitle("Venda de Camisas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel background = new JLabel(new ImageIcon("path/to/background/image.jpg"));
        setContentPane(background);
        setLayout(new GridBagLayout());

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.BLACK);

        JMenuItem menuItemCarrinho = new JMenuItem("Carrinho");
        menuItemCarrinho.setForeground(Color.MAGENTA);
        menuItemCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrinho.displayCart();
            }
        });
        menuBar.add(menuItemCarrinho);

        setJMenuBar(menuBar);

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

        JButton btnCadastroClientes = new JButton("Cadastrar Cliente");
        btnCadastroClientes.setFont(new Font("Arial", Font.PLAIN, 18));
        btnCadastroClientes.setBackground(Color.BLACK);
        btnCadastroClientes.setForeground(Color.MAGENTA);
        btnCadastroClientes.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(btnCadastroClientes, gbc);

        JButton btnOlharProdutos = new JButton("Visualizar Camisas");
        btnOlharProdutos.setFont(new Font("Arial", Font.PLAIN, 18));
        btnOlharProdutos.setBackground(Color.BLACK);
        btnOlharProdutos.setForeground(Color.MAGENTA);
        btnOlharProdutos.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(btnOlharProdutos, gbc);

        JButton btnAnotarReclamacao = new JButton("Anotar Reclamação");
        btnAnotarReclamacao.setFont(new Font("Arial", Font.PLAIN, 18));
        btnAnotarReclamacao.setBackground(Color.BLACK);
        btnAnotarReclamacao.setForeground(Color.MAGENTA);
        btnAnotarReclamacao.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(btnAnotarReclamacao, gbc);

        JButton btnVerReclamacoes = new JButton("Ver Reclamações");
        btnVerReclamacoes.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVerReclamacoes.setBackground(Color.BLACK);
        btnVerReclamacoes.setForeground(Color.MAGENTA);
        btnVerReclamacoes.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(btnVerReclamacoes, gbc);

        JButton btnCadastrarFuncionarios = new JButton("Cadastrar Funcionários");
        btnCadastrarFuncionarios.setFont(new Font("Arial", Font.PLAIN, 18));
        btnCadastrarFuncionarios.setBackground(Color.BLACK);
        btnCadastrarFuncionarios.setForeground(Color.MAGENTA);
        btnCadastrarFuncionarios.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(btnCadastrarFuncionarios, gbc);

        JButton btnNovidades = new JButton("Novidades");
        btnNovidades.setFont(new Font("Arial", Font.PLAIN, 18));
        btnNovidades.setBackground(Color.BLACK);
        btnNovidades.setForeground(Color.MAGENTA);
        btnNovidades.setHorizontalAlignment(SwingConstants.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(btnNovidades, gbc);

        btnCadastroClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clientes cadastro = new Clientes();
                cadastro.setVisible(true);
            }
        });

        btnOlharProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Categorias categorias = new Categorias(carrinho);
                categorias.setVisible(true);
            }
        });

        btnAnotarReclamacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reclamacao reclamacao = new Reclamacao();
                reclamacao.setVisible(true);
            }
        });

        btnVerReclamacoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReclamacoesFeitas reclamacoesFeitas = new ReclamacoesFeitas();
                reclamacoesFeitas.setVisible(true);
            }
        });

        btnCadastrarFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GerenciarFuncionarios gerenciarFuncionarios = new GerenciarFuncionarios();
                gerenciarFuncionarios.setVisible(true);
            }
        });

        btnNovidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CategoriasChegando categoriasChegando = new CategoriasChegando(carrinho);
                categoriasChegando.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setVisible(true);
            }
        });
    }
}
