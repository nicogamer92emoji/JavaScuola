package apps;

import java.awt.GridLayout;
import java.util.Random;
import javax.swing.*;

public class Ristorante extends Thread {
    static JTextField[] textFields = new JTextField[10];
    int somma = 0;
    static JTextField totale;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 3));
        frame.add(panel);

        String[] cibo = {"Pizza", "Pasta", "Insalata", "Carne", "Pesce", "Dolce", "Bevanda", "Antipasto", "Contorno", "Frutta"};

        for (int i = 0; i < cibo.length; i++) {
            JLabel label = new JLabel(cibo[i]);
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            panel.add(label);

            Random random = new Random();
            JLabel prezzo = new JLabel(random.nextInt(10) + " €");
            prezzo.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(prezzo);

            JTextField textField = new JTextField("Quantità", 2);
            textField.setHorizontalAlignment(JTextField.CENTER);
            textFields[i] = textField;
            panel.add(textField);
        }

        JLabel label = new JLabel("Totale");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(label);

        JLabel vuota = new JLabel(" ");
        panel.add(vuota);
        
        totale = new JTextField("0", 2);
        totale.setEditable(false);
        totale.setHorizontalAlignment(JTextField.CENTER);
        panel.add(totale);

        Ristorante ristorante = new Ristorante();
        ristorante.start();

        

        frame.setVisible(true);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++){
                switch (textFields[i].getText()) {
                    case "1" -> somma += Integer.parseInt(textFields[i].getText());
                    case "2" -> somma += Integer.parseInt(textFields[i].getText()) * 2;
                    case "3" -> somma += Integer.parseInt(textFields[i].getText()) * 3;
                    case "4" -> somma += Integer.parseInt(textFields[i].getText()) * 4;
                    case "5" -> somma += Integer.parseInt(textFields[i].getText()) * 5;
                    default -> somma += 0;

                }
            }

        totale.setText(String.valueOf(somma));

        Thread.sleep(1000);
        } catch (NumberFormatException e) {
            System.out.println("Errore nella conversione del numero");
        } catch (InterruptedException e) {
            System.out.println("Thread interrotto");
        } finally {
            System.out.println("Somma totale: " + somma);
        }
    }

    
}
