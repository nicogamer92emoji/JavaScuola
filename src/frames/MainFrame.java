package frames;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame {
    public static void main(String[] args) {
        JFrame1 frame = new JFrame1("Frame1", "Testo", 800, 600);
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, 1));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame1.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("Label 1", JLabel.CENTER);
        panel.add(label1);


        JFrame1 frame2 = new JFrame1("Frame2", "Testo", 200, 500);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, 1));
        frame2.add(panel2);
        frame2.setDefaultCloseOperation(JFrame1.EXIT_ON_CLOSE);

        JLabel label2 = new JLabel("Label 2", JLabel.CENTER);
        panel2.add(label2);

        frame2.setLocation(900, 500);

        frame2.setVisible(true);
        frame.setVisible(true);
    }
}
