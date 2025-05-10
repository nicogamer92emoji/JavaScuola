// acqua al litro $0,0024

import java.awt.*;
import javax.swing.*;

public class CalcolaBolletta {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        final double acqua = 0.0024;
        final double energia = 0.0905;
        final double gas = 0.402365;

        JFrame[] frames = new JFrame[4];
        for(int i = 0; i<3; i++) {
            frames[i] = new JFrame();
            frames[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frames[i].setSize(300, 200);
            frames[i].setLocation(i==0 ? 300 : (i+1)*300, 350);
            frames[i].setResizable(false);
        }
        frames[3] = new JFrame("Pulsante");
        frames[3].setLocation(700, 600);
        frames[3].setSize(170, 110);
        frames[3].setLayout(new FlowLayout(FlowLayout.CENTER));
        frames[3].setResizable(false);

        JButton prossimo = new JButton("Prossimo");
        frames[3].add(prossimo);
        JButton calcola = new JButton("Calcola");
        frames[3].add(calcola);

        frames[0].setTitle("Consumi");
        frames[1].setTitle("Input");
        frames[2].setTitle("Bolletta");

        frames[0].setLayout(new GridLayout(4, 2));
        frames[0].add(new JLabel("Oggetto", JLabel.CENTER));
        frames[0].add(new JLabel("Consumo", JLabel.CENTER));
        frames[0].add(new JLabel("Rubinetto", JLabel.CENTER));
        frames[0].add(new JLabel("6 L/m", JLabel.CENTER));
        frames[0].add(new JLabel("Doccia", JLabel.CENTER));
        frames[0].add(new JLabel("12 L/m", JLabel.CENTER));
        frames[0].add(new JLabel("Sciacquone", JLabel.CENTER));
        frames[0].add(new JLabel("24 L", JLabel.CENTER));

        frames[1].setLayout(new GridLayout(4, 2));
        frames[1].add(new JLabel("Oggetto", JLabel.CENTER));
        frames[1].add(new JLabel("Tempo usato in minuti", JLabel.CENTER));
        frames[1].add(new JLabel("Rubinetto", JLabel.CENTER));
        JTextField rubinetto = new JTextField();
        frames[1].add(rubinetto);
        frames[1].add(new JLabel("Doccia", JLabel.CENTER));
        JTextField doccia = new JTextField();
        frames[1].add(doccia);
        frames[1].add(new JLabel("num sciacquoni usati", JLabel.CENTER));
        JTextField sciacquioni = new JTextField();
        frames[1].add(sciacquioni);

        java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);

        prossimo.addActionListener(e -> {
            try {
                switch (a.get()) {
                    case 1 -> {
                        frames[0].getContentPane().removeAll();
                        frames[0].setLayout(new GridLayout(5, 2));
                        frames[0].add(new JLabel("Oggetto", JLabel.CENTER));
                        frames[0].add(new JLabel("Consumo", JLabel.CENTER));
                        frames[0].add(new JLabel("Phon", JLabel.CENTER));
                        frames[0].add(new JLabel("2000 W", JLabel.CENTER));
                        frames[0].add(new JLabel("Frigo", JLabel.CENTER));
                        frames[0].add(new JLabel("40 W", JLabel.CENTER));
                        frames[0].add(new JLabel("Condizionatore", JLabel.CENTER));
                        frames[0].add(new JLabel("3000 W", JLabel.CENTER));
                        frames[0].add(new JLabel("Microonde", JLabel.CENTER));
                        frames[0].add(new JLabel("100 W", JLabel.CENTER));
                        frames[0].getContentPane().revalidate();
                        frames[0].getContentPane().repaint();
                        frames[1].getContentPane().removeAll();
                        frames[1].setLayout(new GridLayout(5, 2));
                        frames[1].add(new JLabel("Oggetto", JLabel.CENTER));
                        frames[1].add(new JLabel("Tempo usato in minuti", JLabel.CENTER));
                        frames[1].add(new JLabel("Phon", JLabel.CENTER));
                        JTextField phon = new JTextField();
                        frames[1].add(phon);
                        frames[1].add(new JLabel("Frigo", JLabel.CENTER));
                        JTextField frigo = new JTextField();
                        frames[1].add(frigo);
                        frames[1].add(new JLabel("Condizionatore", JLabel.CENTER));
                        JTextField condizionatore = new JTextField();
                        frames[1].add(condizionatore);
                        frames[1].add(new JLabel("Microonde", JLabel.CENTER));
                        JTextField microonde = new JTextField();
                        frames[1].add(microonde);
                        frames[1].getContentPane().revalidate();
                        frames[1].getContentPane().repaint();
                        a.incrementAndGet();
                    }
                    case 2 -> {
                        frames[0].getContentPane().removeAll();
                        frames[0].setLayout(new GridLayout(4, 2));
                        frames[0].add(new JLabel("Oggetto", JLabel.CENTER));
                        frames[0].add(new JLabel("Consumo", JLabel.CENTER));
                        frames[0].add(new JLabel("Gas", JLabel.CENTER));
                        frames[0].add(new JLabel("1 smc", JLabel.CENTER));
                        frames[0].getContentPane().revalidate();
                        frames[0].getContentPane().repaint();
                        frames[1].getContentPane().removeAll();
                        frames[1].setLayout(new GridLayout(4, 2));
                        frames[1].add(new JLabel("Oggetto", JLabel.CENTER));
                        frames[1].add(new JLabel("Tempo usato in minuti", JLabel.CENTER));
                        JTextField usoGas = new JTextField();
                        frames[1].add(usoGas);
                        frames[1].getContentPane().revalidate();
                        frames[1].getContentPane().repaint();
                        a.incrementAndGet();
                    }
                    default -> System.out.println("Non ci sono più oggetti da calcolare");
                }
            } catch (Exception er) {
                System.out.println(er);
            }
        });


        for(JFrame f : frames) {
            f.setVisible(true);
        }
    }
}