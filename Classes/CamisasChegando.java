package Classes;

import javax.swing.*;
import java.awt.*;

public class CamisasChegando extends Camisa {
    public CamisasChegando(Carrinho carrinho) {
        super(
                new String[]{"/imagens/cruzeiro2.jpg", "/imagens/santos.jpg", "/imagens/chelsea.jpg", "/imagens/city.jpg"},
                new String[]{"R$99,99", "R$99,99", "R$119,99", "R$119,99"},
                "Camisas para Chegar",
                carrinho
        );
    }

    @Override
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
                addToCartButton.addActionListener(e -> {
                    JOptionPane.showMessageDialog(frame, "Produto em Falta", "Aviso", JOptionPane.WARNING_MESSAGE);
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
