package frames;

import javax.swing.JFrame;

public class JFrame1 extends JFrame{
    private final String titolo;
    private final String testo;
    private final int larghezza;
    private final int altezza;

    public JFrame1(String titolo, String testo, int larghezza, int altezza) {
        this.setTitle(titolo);
        this.titolo = titolo;
        this.testo = testo;
        this.setSize(larghezza, altezza);
        this.larghezza = larghezza;
        this.altezza = altezza;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getTesto() {
        return testo;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public int getAltezza() {
        return altezza;
    }
}