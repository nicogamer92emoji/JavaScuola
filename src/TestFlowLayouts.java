import java.awt.FlowLayout;
import javax.swing.*;

public class TestFlowLayouts {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel label = new JLabel("Tanti pulsanti nella stessa linea: ");
        frame.add(label);

        JButton[] buttons = new JButton[10];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Button " + (i + 1));
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
    }
}