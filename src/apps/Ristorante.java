package apps;

import java.awt.GridLayout;
import javax.swing.*;

public class Ristorante {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));
        frame.add(panel);

        String[] piatti = {"Pizza", "Pasta", "Insalata", "Carne", "Pesce", "Dolce", "Bevanda"};

        String[] prezzi = {"10.00", "8.00", "5.00", "15.00", "12.00", "4.00", "2.00"};

        JCheckBox checkBox[] = new JCheckBox[7];
        JTextField textField[] = new JTextField[7];

        JLabel cibo = new JLabel("Cibo", SwingConstants.CENTER);
        JLabel prezzo = new JLabel("Quantità", SwingConstants.CENTER);
        panel.add(cibo);
        panel.add(prezzo);

        for(int i = 0; i < 7; i++) {
            checkBox[i] = new JCheckBox();
            checkBox[i].setText(piatti[i] + " - " + prezzi[i] + "€");
            panel.add(checkBox[i]);

            textField[i] = new JTextField(10);
            textField[i].setHorizontalAlignment(JTextField.CENTER);
            panel.add(textField[i]);
        }

        JTextField tf = new JTextField(" Totale ", 10);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setEditable(false);
        panel.add(tf);

        for(JCheckBox i : checkBox) {
            i.addActionListener(e -> {
                somma(textField, tf, checkBox, prezzi);
            });
        }

        frame.setVisible(true);
    }

    public static void somma(JTextField[] quatita, JTextField tf, JCheckBox[] checkBox, String[] prezzi) {
        double somma = 0;
        for (int i = 0; i < 7; i++) {
            if(checkBox[i].isSelected())
                somma += Double.parseDouble(prezzi[i]) * Integer.parseInt(quatita[i].getText());
        }
        tf.setText(String.valueOf(somma) + "€");
    }
}
