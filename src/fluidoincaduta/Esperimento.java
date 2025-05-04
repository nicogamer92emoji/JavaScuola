package fluidoincaduta;

public class Esperimento {
    double T_iniziale;
    double T_aria;
    double altezza;
    double raggio;
    double T_finale;

    public Esperimento(double T_iniziale, double T_aria, double altezza, double raggio, double T_finale) {
        this.T_iniziale = T_iniziale;
        this.T_aria = T_aria;
        this.altezza = altezza;
        this.raggio = raggio;
        this.T_finale = T_finale;
    }

    public double getT_iniziale() {
        return T_iniziale;
    }

    public double getT_aria() {
        return T_aria;
    }

    public double getAltezza() {
        return altezza;
    }

    public double getRaggio() {
        return raggio;
    }

    public double getT_finale() {
        return T_finale;
    }

}
