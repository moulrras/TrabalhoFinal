package Classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReclamacoesFeitas extends JFrame {

    public ReclamacoesFeitas() {
        setTitle("Reclamações Feitas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea txtAreaReclamacoes = new JTextArea();
        txtAreaReclamacoes.setEditable(false);
        txtAreaReclamacoes.setFont(new Font("Arial", Font.PLAIN, 14));

        // Retrieve complaints from Reclamacao class
        ArrayList<String> reclamacoes = Reclamacao.reclamacoes;
        for (String reclamacao : reclamacoes) {
            txtAreaReclamacoes.append(reclamacao + "\n\n");
        }

        JScrollPane scrollPane = new JScrollPane(txtAreaReclamacoes);
        add(scrollPane, BorderLayout.CENTER);
    }
}