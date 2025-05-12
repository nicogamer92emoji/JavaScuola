package fluidoincaduta;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class FluidoCalc {
    @SuppressWarnings({ "UseSpecificCatch", "unused" })
    public static void main(String[] args) {
        ArrayList<Esperimento> esperimenti = new ArrayList<>();

        JFrame frame = new JFrame("Versare un fluido per raffreddarlo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JTable acqua = new JTable(4, 2);
        acqua.setValueAt("Specifiche dell'acqua", 0, 0);
        acqua.setValueAt("Densità:", 1, 0);
        acqua.setValueAt("1000 kg/m³", 1, 1);
        acqua.setValueAt("Calore specifico:", 2, 0);
        acqua.setValueAt("4186 J/(kg·K)", 2, 1);
        acqua.setValueAt("Coefficiente di scambio termico superficiale: ", 3, 0);
        acqua.setValueAt("10 W/(m²·K)", 3, 1);
        acqua.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(acqua);
        scrollPane.setBounds(0, 0, 350, 100);
        frame.add(scrollPane);

        JTable valori = new JTable(4, 2);
        valori.setValueAt("Temperatura iniziale (°C):", 0, 0);
        valori.setValueAt("Temperatura aria (°C):", 1, 0);
        valori.setValueAt("Altezza di caduta (m):", 2, 0);
        valori.setValueAt("Raggio del filo d'acqua (m):", 3, 0);

        JScrollPane valoriScrollPane = new JScrollPane(valori);
        valoriScrollPane.setBounds(0, 120, 350, 100);
        frame.add(valoriScrollPane);

        JButton calcola = new JButton("Calcola");
        calcola.setBounds(360, 50, 200, 30);

        calcola.addActionListener(e -> {
            try {
                double T_iniziale = Double.parseDouble(valori.getValueAt(0, 1).toString());
                double T_aria = Double.parseDouble(valori.getValueAt(1, 1).toString());
                double altezza = Double.parseDouble(valori.getValueAt(2, 1).toString());
                double raggio = Double.parseDouble(valori.getValueAt(3, 1).toString());
        
                // Costanti
                double rho = 1000;          // densità dell'acqua (kg/m^3)
                double c = 4186;            // calore specifico (J/kg·K)
                double wc = 10;             // coefficiente di scambio termico (W/m^2·K)
                double g = 9.81;            // accelerazione gravitazionale (m/s^2)
                double angolo_deg = raggio; // angolo con cui si versa l'acqua (°)
                double angolo_rad = Math.toRadians(angolo_deg);
        
                double radice = Math.sqrt((2 * altezza) / (g * Math.cos(angolo_rad)));
        
                double delta_T = (wc / (rho * c)) * (1 / raggio) * radice * (T_iniziale - T_aria);
                double T_finale = T_iniziale - delta_T;
        
                JOptionPane.showMessageDialog(null, 
                    String.format("Temperatura finale stimata dell'acqua: %.2f °C", T_finale), 
                    "Risultato", JOptionPane.INFORMATION_MESSAGE);
                
                esperimenti.add(new Esperimento(T_iniziale, T_aria, altezza, raggio, T_finale));
        
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                    "Errore nei valori inseriti. Assicurati di compilare tutti i campi con numeri validi.",
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        frame.add(calcola);

        JButton mostra = new JButton("Mostra Esperimenti");
        mostra.setBounds(360, 100, 200, 30);

        mostra.addActionListener(e -> {
            JFrame frame2 = new JFrame("Esperimenti");
            frame2.setLocation(1100, 540);
            frame2.setSize(500,300);
            frame2.setLayout(new GridLayout(esperimenti.size(), 1));
            
            for (Esperimento esperimento : esperimenti) {
                JLabel label = new JLabel(String.format("T_iniziale: %.2f, T_aria: %.2f, Altezza: %.2f, Raggio: %.2f, T_finale: %.2f",
                    esperimento.getT_iniziale(), esperimento.getT_aria(), esperimento.getAltezza(), esperimento.getRaggio(), esperimento.getT_finale()));
                frame2.add(label);
            }
            
            frame2.setVisible(true);
        });
        frame.add(mostra);

        frame.setVisible(true);
    }
}
