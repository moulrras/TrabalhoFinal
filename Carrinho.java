package Classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Carrinho {
    private ArrayList<String> items;
    private ArrayList<String> prices;

    public Carrinho() {
        items = new ArrayList<>();
        prices = new ArrayList<>();
    }

    public void addItem(String item, String price) {
        items.add(item);
        prices.add(price);
        System.out.println("Item adicionado ao carrinho: " + item + " - " + price);
    }

    public void displayCart() {
        JFrame frame = new JFrame("Carrinho de Compras");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            String price = prices.get(i);
            JLabel label = new JLabel(new ImageIcon(getClass().getResource(item)));
            JLabel priceLabel = new JLabel(price);
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BorderLayout());
            itemPanel.add(label, BorderLayout.CENTER);
            itemPanel.add(priceLabel, BorderLayout.SOUTH);
            panel.add(itemPanel);
        }

        frame.add(new JScrollPane(panel));
        frame.setVisible(true);
    }
}
