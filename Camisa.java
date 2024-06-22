package Classes;

import javax.swing.*;
import java.awt.*;

public class Camisa {
    protected String[] imagePaths;
    protected String[] prices;
    protected String descricao;
    protected Carrinho carrinho;

    public Camisa(String[] imagePaths, String[] prices, String descricao, Carrinho carrinho) {
        this.imagePaths = imagePaths;
        this.prices = prices;
        this.descricao = descricao;
        this.carrinho = carrinho;
    }

    public void display() {
        JFrame frame = new JFrame(descricao);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        for (int i = 0; i < imagePaths.length; i++) {
            java.net.URL imgURL = getClass().getResource(imagePaths[i]);
            if (imgURL != null) {
                ImageIcon icon = new ImageIcon(imgURL);
                Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                JLabel label = new JLabel(new ImageIcon(img));
                JLabel priceLabel = new JLabel(prices[i]);
                priceLabel.setHorizontalAlignment(SwingConstants.CENTER);

                JButton addToCartButton = new JButton("Adicionar ao Carrinho");
                int index = i;
                addToCartButton.addActionListener(e -> {
                    carrinho.addItem(imagePaths[index], prices[index]);
                });

                JPanel imagePanel = new JPanel(new BorderLayout());
                imagePanel.add(label, BorderLayout.CENTER);
                imagePanel.add(priceLabel, BorderLayout.SOUTH);
                imagePanel.add(addToCartButton, BorderLayout.NORTH);
                panel.add(imagePanel);
            } else {
                System.err.println("Couldn't find file: " + imagePaths[i]);
            }
        }

        frame.add(new JScrollPane(panel));
        frame.setVisible(true);
    }
}

class CamisaBasquete extends Camisa {
    public CamisaBasquete(Carrinho carrinho) {
        super(
                new String[]{"/imagens/lakers2.jpg", "/imagens/bulls.jpg", "/imagens/gsw.jpg", "/imagens/celtics.jpg"},
                new String[]{"R$69,99", "R$69,99", "R$69,99", "R$69,99"},
                "Camisas de Basquete",
                carrinho
        );
    }
}

class CamisaFutebolNacional extends Camisa {
    public CamisaFutebolNacional(Carrinho carrinho) {
        super(
                new String[]{"/imagens/atletico.jpg", "/imagens/cruzeiro.jpg", "/imagens/flamengo.jpg", "/imagens/inter.jpg"},
                new String[]{"R$99,99", "R$99,99", "R$99,99", "R$99,99"},
                "Camisas de Futebol Nacionais",
                carrinho
        );
    }
}

class CamisaFutebolInternacional extends Camisa {
    public CamisaFutebolInternacional(Carrinho carrinho) {
        super(
                new String[]{"/imagens/barcelona.jpg", "/imagens/realmadrid.jpg", "/imagens/borussia.jpg", "/imagens/psg.jpg"},
                new String[]{"R$119,99", "R$119,99", "R$119,99", "R$119,99"},
                "Camisas de Futebol Internacionais",
                carrinho
        );
    }
}
