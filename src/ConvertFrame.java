import javax.swing.*;

public class ConvertFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Convertitore");

        JPanel celsius = new JPanel();
        JPanel kelvin = new JPanel();

        JTextField txtCelsius = new JTextField(15);
        JTextField txtKelvin = new JTextField(15);

        JLabel kelvinLabel = new JLabel("Kelvin");
        JLabel celsiusLabel = new JLabel("Celsius");

        JButton convertToKelvin = new JButton("Converti C -> K");
        convertToKelvin.addActionListener(e -> {
            try {
                double celsiusValue = Double.parseDouble(txtCelsius.getText());
                kelvinLabel.setText("Kelvin: " + (celsiusValue + 273.15));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Inserisci un numero valido per i Celsius.");
            }
        });

        JButton convertToCelsius = new JButton("Converti K -> C");
        convertToCelsius.addActionListener(e -> {
            try {
                double kelvinValue = Double.parseDouble(txtKelvin.getText());
                celsiusLabel.setText("Celsius: " + (kelvinValue - 273.15));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Inserisci un numero valido per i Kelvin.");
            }
        });

        celsius.add(new JLabel("Gradi Celsius: "));
        celsius.add(txtCelsius);
        celsius.add(convertToKelvin);
        celsius.add(kelvinLabel);

        kelvin.add(new JLabel("Gradi Kelvin: "));
        kelvin.add(txtKelvin);
        kelvin.add(convertToCelsius);
        kelvin.add(celsiusLabel);

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add(celsius);
        frame.getContentPane().add(kelvin);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
