import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeCheckerApp extends JFrame implements ActionListener {

    private JTextField inputField;
    private JButton checkButton;
    private JButton clearButton;
    private JLabel resultLabel;

    public PalindromeCheckerApp() {
        setTitle("Palindrome Checker App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        inputField = new JTextField(20);
        checkButton = new JButton("Check");
        clearButton = new JButton("Clear");
        resultLabel = new JLabel("Enter text and click Check");

        add(new JLabel("Enter Text:"));
        add(inputField);
        add(checkButton);
        add(clearButton);
        add(resultLabel);

        checkButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == checkButton) {

            String text = inputField.getText();

            if (text.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter some text!",
                        "Input Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            String reversed = new StringBuilder(text).reverse().toString();

            if (text.equals(reversed)) {
                resultLabel.setText("It is a Palindrome ✅");
            } else {
                resultLabel.setText("Not a Palindrome ❌");
            }
        }

        if (e.getSource() == clearButton) {
            inputField.setText("");
            resultLabel.setText("Enter text and click Check");
        }
    }

    public static void main(String[] args) {
        new PalindromeCheckerApp().setVisible(true);
    }
}