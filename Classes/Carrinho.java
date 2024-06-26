package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Carrinho {
    private ArrayList<CartItem> items;
    private String cupomAplicado;
    private JTextField cupomTextField; // Campo de texto para o cupom
    private JLabel totalLabel; // Label para exibir o valor total com desconto

    public Carrinho() {
        this.items = new ArrayList<>();
        this.cupomAplicado = "";
        this.cupomTextField = new JTextField(10);
        this.totalLabel = new JLabel("Valor Total: R$ 0.00");
    }

    public void addItem(String imagePath, String price) {
        for (CartItem item : items) {
            if (item.getImagePath().equals(imagePath)) {
                item.incrementQuantity();
                return;
            }
        }
        items.add(new CartItem(imagePath, price));
    }

    public double getTotalValue() {
        double total = 0.0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public double getTotalValueComDesconto() {
        double total = getTotalValue();
        if (cupomAplicado.equals("Camisa10")) {
            total *= 0.9; // Aplica 10% de desconto se o cupom "Camisa10" estiver aplicado
        }
        return total;
    }

    public void displayCart() {
        JFrame frame = new JFrame("Carrinho de Compras");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (CartItem item : items) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            ImageIcon icon = new ImageIcon(getClass().getResource(item.getImagePath()));
            JLabel label = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
            JLabel priceLabel = new JLabel("Preço: " + item.getPrice() + " x " + item.getQuantity());

            JButton removeButton = new JButton("Remover");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    items.remove(item);
                    frame.dispose();
                    displayCart();
                }
            });

            itemPanel.add(label);
            itemPanel.add(priceLabel);
            itemPanel.add(removeButton);
            panel.add(itemPanel);
        }

        totalLabel.setText("Valor Total: R$ " + String.format("%.2f", getTotalValueComDesconto()));
        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(totalLabel);

        // Adiciona campo de texto e botão para adicionar o cupom manualmente
        JPanel cupomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel cupomLabel = new JLabel("Cupom:");
        JButton aplicarCupomButton = new JButton("Aplicar Cupom");
        aplicarCupomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cupom = cupomTextField.getText().trim();
                aplicarCupom(cupom);
            }
        });
        cupomPanel.add(cupomLabel);
        cupomPanel.add(cupomTextField);
        cupomPanel.add(aplicarCupomButton);
        panel.add(cupomPanel);

        JButton addPaymentButton = new JButton("Adicionar Forma de Pagamento");
        addPaymentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormaDePag();
            }
        });
        panel.add(addPaymentButton);

        JButton confirmPurchaseButton = new JButton("Confirmar Compra");
        confirmPurchaseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmPurchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FormaDePag.isCartaoAdicionado()) {
                    JOptionPane.showMessageDialog(frame,
                            "Compra feita com sucesso!",
                            "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Primeiro o cartão deve ser adicionado!",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(confirmPurchaseButton);

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    public void aplicarCupom(String codigo) {
        if (codigo.equals("Camisa10")) {
            cupomAplicado = codigo;
            JOptionPane.showMessageDialog(null, "Cupom aplicado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cupom inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            cupomAplicado = "";
        }
        // Atualiza o valor total exibido com ou sem desconto
        totalLabel.setText("Valor Total: R$ " + String.format("%.2f", getTotalValueComDesconto()));
    }

    private static class CartItem {
        private String imagePath;
        private String price;
        private int quantity;

        public CartItem(String imagePath, String price) {
            this.imagePath = imagePath;
            this.price = price;
            this.quantity = 1;
        }

        public String getImagePath() {
            return imagePath;
        }

        public String getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void incrementQuantity() {
            this.quantity++;
        }

        public double getTotalPrice() {
            return quantity * Double.parseDouble(price.replace("R$", "").replace(",", "."));
        }
    }

    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();
        carrinho.addItem("/path/to/camisa1.jpg", "R$50,00");
        carrinho.addItem("/path/to/camisa2.jpg", "R$45,00");

        carrinho.displayCart();
    }
}
