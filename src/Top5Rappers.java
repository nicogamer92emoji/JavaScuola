import java.util.ArrayList;
import javax.swing.*;

public class Top5Rappers {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();

        JFrame frame = new JFrame("Lista di cose da fare");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 500);
        frame.add(panel);

        JLabel label = new JLabel("Aggiungi un elemento alla tua lista: ");
        label.setBounds(10, 10, 300, 25);
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(210, 10, 320, 25);
        panel.add(textField);

        JButton aggiungi = new JButton("Aggiungi");
        aggiungi.setBounds(210, 40, 100, 25);
        panel.add(aggiungi);

        JButton elimina = new JButton("Elimina");
        elimina.setBounds(320, 40, 100, 25);
        panel.add(elimina);

        JButton completa = new JButton("Completa");
        completa.setBounds(430, 40, 100, 25);
        panel.add(completa);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 80, 580, 350);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);
        scrollPane.setBounds(10, 80, 570, 350);

        aggiungi.addActionListener(e -> {
            String text = textField.getText();
            if(!text.isEmpty()) {
                lista.add(text);
                textField.setText("");
                textArea.setText(textArea.getText() + "- " + lista.get(lista.size() - 1) + "\n");
            } else {
                JOptionPane.showMessageDialog(frame, "Inserisci un elemento valido.");
            }
        });

        elimina.addActionListener(e -> {
            String text = textField.getText();
            boolean trovato = false;
            for(int i = 0; i< lista.size(); i++) {
                if(lista.get(i).equals(text)) {
                    lista.remove(i);
                    textField.setText("");
                    trovato = true;
                }
            }

            if(!trovato) {
                JOptionPane.showMessageDialog(frame, "Elemento non trovato.");
            } else {
                textArea.setText("");
                for(String i : lista) {
                    textArea.setText(textArea.getText() + "- " + i + "\n");
                }
            }
        });

        completa.addActionListener(e -> {
            String text = textField.getText();
            boolean trovato = false;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).equals(text)) {
                    lista.set(i, text + " (completato)");
                    textField.setText("");
                    trovato = true;
                }
            }

            if (!trovato) {
                JOptionPane.showMessageDialog(frame, "Elemento non trovato.");
            } else {
                textArea.setText("");
                for (String i : lista) {
                    textArea.setText(textArea.getText() + "- " + i + "\n");
                }
            }
        });

        frame.setVisible(true);
    }
}