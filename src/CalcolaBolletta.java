import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.*;

public class CalcolaBolletta {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        final double COSTO_ACQUA = 1.5;
        final double COSTO_ENERGIA = 0.25;
        final double COSTO_GAS = 0.95;

        AtomicInteger step = new AtomicInteger(0);
        JFrame frame = new JFrame("Calcola Bolletta - 30 giorni");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel centerPanel = new JPanel(new GridLayout(0, 2));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton prossimo = new JButton("Prossimo");
        JButton calcola = new JButton("Calcola");
        JButton salvaCommento = new JButton("Salva commento");

        buttonPanel.add(prossimo);
        buttonPanel.add(calcola);
        buttonPanel.add(salvaCommento);

        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // TextArea per il commento
        JTextArea commentoArea = new JTextArea(5, 40);
        JScrollPane scrollPane = new JScrollPane(commentoArea);
        frame.add(scrollPane, BorderLayout.NORTH);
        commentoArea.setBorder(BorderFactory.createTitledBorder("Scrivi un commento su come migliorare il consumo"));

        // Campi input
        JTextField rubinetto = new JTextField();
        JTextField doccia = new JTextField();
        JTextField sciacquoni = new JTextField();
        JTextField phon = new JTextField();
        JTextField forno = new JTextField();
        JTextField frigo = new JTextField();
        JTextField condizionatore = new JTextField();
        JTextField microonde = new JTextField();
        JTextField caldaiaGas = new JTextField();

        Runnable aggiornaSchermata = () -> {
            centerPanel.removeAll();
            switch (step.get()) {
                case 0 -> {
                    centerPanel.add(new JLabel("Rubinetto (minuti totali al mese):"));
                    centerPanel.add(rubinetto);
                    centerPanel.add(new JLabel("Doccia (minuti totali al mese):"));
                    centerPanel.add(doccia);
                    centerPanel.add(new JLabel("Sciacquoni usati (n°):"));
                    centerPanel.add(sciacquoni);
                }
                case 1 -> {
                    centerPanel.add(new JLabel("Phon (minuti totali al mese):"));
                    centerPanel.add(phon);
                    centerPanel.add(new JLabel("Frigo (1 se usato, 0 se no):"));
                    centerPanel.add(frigo);
                    centerPanel.add(new JLabel("Condizionatore (minuti totali al mese):"));
                    centerPanel.add(condizionatore);
                    centerPanel.add(new JLabel("Forno (minuti totali al mese):"));
                    centerPanel.add(forno);
                    centerPanel.add(new JLabel("Microonde (minuti totali al mese):"));
                    centerPanel.add(microonde);
                }
                case 2 -> {
                    centerPanel.add(new JLabel("Gas consumato (smc):"));
                    centerPanel.add(caldaiaGas);
                }
                default -> {
                    centerPanel.add(new JLabel("Tutti i dati sono stati inseriti."));
                }
            }
            centerPanel.revalidate();
            centerPanel.repaint();
        };

        calcola.addActionListener(e -> {
            try {
                switch (step.get()) {
                    case 0 -> {
                        double minRub = Double.parseDouble(rubinetto.getText());
                        double minDoccia = Double.parseDouble(doccia.getText());
                        double nSciacquoni = Double.parseDouble(sciacquoni.getText());

                        double litriTotali = (minRub * 6) + (minDoccia * 12) + (nSciacquoni * 18);
                        double metriCubici = litriTotali / 1000.0;
                        double costoAcqua = metriCubici * COSTO_ACQUA;

                        JOptionPane.showMessageDialog(frame, String.format("Costo acqua: %.2f € (%.2f m³)", costoAcqua, metriCubici));
                    }
                    case 1 -> {
                        double minPhon = Double.parseDouble(phon.getText()) / 60.0;
                        double usaFrigo = Double.parseDouble(frigo.getText());
                        double minCond = Double.parseDouble(condizionatore.getText()) / 60.0;
                        double minForno = Double.parseDouble(forno.getText()) / 60.0;
                        double minMicr = Double.parseDouble(microonde.getText()) / 60.0;

                        double kWhTot = (2 * minPhon) +
                                (usaFrigo == 1 ? 30 : 0) +
                                (3 * minCond) +
                                (1.2 * minForno) +
                                (0.1 * minMicr);

                        double costoEnergia = kWhTot * COSTO_ENERGIA;

                        JOptionPane.showMessageDialog(frame, String.format("Consumo: %.2f kWh\nCosto energia: %.2f €", kWhTot, costoEnergia));
                    }
                    case 2 -> {
                        double smc = Double.parseDouble(caldaiaGas.getText());
                        double costoGas = smc * COSTO_GAS;

                        JOptionPane.showMessageDialog(frame, String.format("Gas usato: %.2f smc\nCosto gas: %.2f €", smc, costoGas));
                    }
                    default -> JOptionPane.showMessageDialog(frame, "Tutti i calcoli sono stati completati.");
                }
            } catch (HeadlessException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Errore: " + ex.getMessage());
            }
        });

        prossimo.addActionListener(e -> {
            if (step.get() < 3) {
                step.incrementAndGet();
                aggiornaSchermata.run();
            } else {
                JOptionPane.showMessageDialog(frame, "Non ci sono altri passaggi.");
            }
        });

        salvaCommento.addActionListener(e -> {
            String commento = commentoArea.getText();
            try (FileWriter fw = new FileWriter("commento_consumi.txt")) {
                fw.write(commento);
                JOptionPane.showMessageDialog(frame, "Commento salvato con successo!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Errore durante il salvataggio: " + ex.getMessage());
            }
        });

        aggiornaSchermata.run();
        frame.setVisible(true);
    }
}
