import javax.swing.*;

public class CalcInterfaccia {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calcolatrice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 400, 300);
        frame.add(panel);
        
        JLabel label = new JLabel("N.1");
        label.setBounds(10, 10, 50, 25);
        panel.add(label);

        JTextField textField1 = new JTextField(10);
        textField1.setBounds(10, 30, 50, 25);
        panel.add(textField1);
        
        JLabel label2 = new JLabel("Operatore");
        label2.setBounds(70, 10, 100, 25);
        panel.add(label2);
        
        String[] operatoriArray = {"+", "-", "*", "/"};
        JComboBox<String> operatori = new JComboBox<>(operatoriArray);
        operatori.setBounds(75, 30, 50, 25);
        panel.add(operatori);

        JLabel label3 = new JLabel("N.2");
        label3.setBounds(150, 10, 50, 25);
        panel.add(label3);
        
        JTextField textField2 = new JTextField(10);
        textField2.setBounds(150, 30, 50, 25);
        panel.add(textField2);

        JTextField uguale = new JTextField("=");
        uguale.setBounds(220, 30, 50, 25);
        uguale.setEditable(false);
        panel.add(uguale);

        JButton calcolaButton = new JButton("Calcola");
        calcolaButton.setBounds(280, 30, 100, 25);
        panel.add(calcolaButton);

        JButton azzera = new JButton("Azzera");
        azzera.setBounds(280, 70, 100, 25);
        panel.add(azzera);

        azzera.addActionListener(e -> {
            textField1.setText("");
            textField2.setText("");
            uguale.setText("=");
        });

        calcolaButton.addActionListener(e -> {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                char operatore = operatori.getSelectedItem().toString().charAt(0);
                double risultato;
                
                switch (operatore) {
                    case '+' -> risultato = num1 + num2;
                    case '-' -> risultato = num1 - num2;
                    case '*' -> risultato = num1 * num2;
                    case '/' -> risultato = num1 / num2;
                    default -> {
                        JOptionPane.showMessageDialog(frame, "Operatore non valido", "Errore", JOptionPane.ERROR_MESSAGE); return;
                    }
                }
                
                uguale.setText(String.valueOf("= " + risultato));
        });

        frame.setVisible(true);
    }
}
