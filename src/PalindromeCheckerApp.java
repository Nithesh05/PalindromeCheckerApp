import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeCheckerApp extends JFrame implements ActionListener {

    private JTextField inputField;
    private JButton checkButton;
    private JLabel resultLabel;

    public PalindromeCheckerApp() {
        setTitle("Palindrome Checker App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set layout
        setLayout(new FlowLayout());

        // Create components
        inputField = new JTextField(20);
        checkButton = new JButton("Check");
        resultLabel = new JLabel("Enter text and click Check");

        // Add components
        add(new JLabel("Enter Text:"));
        add(inputField);
        add(checkButton);
        add(resultLabel);

        // Add action listener
        checkButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String text = inputField.getText();

        // Remove spaces and convert to lowercase
        text = text.replaceAll("\\s+", "").toLowerCase();

        String reversed = new StringBuilder(text).reverse().toString();

        if (text.equals(reversed)) {
            resultLabel.setText("It is a Palindrome ✅");
        } else {
            resultLabel.setText("Not a Palindrome ❌");
        }
    }

    public static void main(String[] args) {
        new PalindromeCheckerApp().setVisible(true);
    }
}