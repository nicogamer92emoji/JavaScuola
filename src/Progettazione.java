import java.awt.*;
import javax.swing.*;

public class Progettazione {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Progettazione");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        frame.add(panel);

        JLabel nome = new JLabel("Inserisci il nome: ");
        panel.add(nome);
        JLabel programma = new JLabel("Programma 8.0");
        programma.setBackground(Color.YELLOW);
        programma.setForeground(Color.BLUE);
        panel.add(programma);
        JLabel scritta = new JLabel("1.234,5");
        panel.add(scritta);
        JButton ok = new JButton("OK");
        panel.add(ok);
        JButton annulla = new JButton("Annulla");
        annulla.setEnabled(false);
        panel.add(annulla);
        JTextField textField = new JTextField();
        textField.setSize(200, 30);
        panel.add(textField);
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        textArea.setText("Msg fisso");
        panel.add(textArea);


        frame.setVisible(true);

    }
}
