import javax.swing.*;

public class InterfacciaRandom {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Spammer");
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(panel);

        JButton button = new JButton("Premi");

        button.addActionListener(e -> {
            Timer timer = new Timer(10, er -> {
                JLabel l = new JLabel("a");
                panel.add(l);
                panel.revalidate();
                panel.repaint();
            });
            timer.start();
        });

        panel.add(button);
        frame.setVisible(true);
    }
}
