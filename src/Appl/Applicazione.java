package Appl;

import java.util.ArrayList;
import javax.swing.*;

public class Applicazione {
    public static void main(String[] args) {
        ArrayList<Persona> utenti = new ArrayList<>();
        utenti.add(new Persona("admin", "admin"));

        JFrame frame = new JFrame("Log in");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        frame.setLocation(200, 200);
        frame.setSize(600,300);


        JLabel label = new JLabel("Username: ", SwingConstants.RIGHT);
        label.setBounds(50, 50, 100, 30);
        JTextField username = new JTextField();
        username.setBounds(160, 50, 200, 30);
        JLabel label2 = new JLabel("Password: ", SwingConstants.RIGHT);
        label2.setBounds(50, 100, 100, 30);
        JPasswordField password = new JPasswordField();
        password.setBounds(160, 100, 200, 30);

        panel.add(label);
        panel.add(username);
        panel.add(label2);
        panel.add(password);


        JButton logIn = new JButton("Log in");
        logIn.setBounds(160, 150, 100, 30);
        JButton signIn = new JButton("Sign in");
        signIn.setBounds(270, 150, 100, 30);
        
        logIn.addActionListener(e -> {
            String user = username.getText();
            String pass = new String(password.getPassword());
            boolean found = false;
            for (Persona p : utenti) {
                if (p.getUser().equals(user) && p.checkPassword(pass)) {
                    found = true;
                    break;
                }
            }
            if (found)
                JOptionPane.showMessageDialog(frame, "Login successful!");
            else
                JOptionPane.showMessageDialog(frame, "Invalid username or password.");
        });

        signIn.addActionListener(e -> {
            String user = username.getText();
            String pass = new String(password.getPassword());
            boolean exists = false;
            for (Persona p : utenti) {
                if (p.getUser().equals(user)) {
                    exists = true;
                    break;
                }
            }
            if(exists) {
                JOptionPane.showMessageDialog(frame, "Username already exists.");
            } else {
                utenti.add(new Persona(user, pass));
                JOptionPane.showMessageDialog(frame, "User registered successfully!");
            }
        });

        panel.add(logIn);
        panel.add(signIn);

        frame.setVisible(true);
    }
}
