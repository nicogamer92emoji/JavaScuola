package Appl;

public class Persona {
    private final String user;
    private final String password;

    public Persona(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
