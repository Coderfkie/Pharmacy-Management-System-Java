package pharmacy.gui;
import javax.swing.*;

/**
 * LoginFrame provides a simple login interface
 * for the Pharmacy Management System.
 */
public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Pharmacy Login");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(120, 30, 160, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 80, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 70, 160, 25);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(120, 110, 80, 30);
        add(loginButton);

        // Login logic
        loginButton.addActionListener(e -> login());

        setVisible(true);
           
    }

    /**
     * Validates login credentials
     */
    private void login() {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        // Simple hardcoded login 
        if (user.equals("coderfkie") && pass.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login Successful");
            new PharmacyFrame();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Login");
        }
    }

}

