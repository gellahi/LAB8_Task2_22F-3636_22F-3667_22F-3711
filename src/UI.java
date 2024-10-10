import javax.swing.*;
import java.awt.*;

public class UI {

    private JTextField display;

    public void designUI() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel displayPanel = new JPanel();
        display = new JTextField(16);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        displayPanel.add(display);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(e -> handleButtonClick(label));
            buttonPanel.add(button);
        }

        JPanel newPanel = new JPanel(new GridLayout(2, 2));
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JLabel label = new JLabel("Enter Value:");
        JTextField textField = new JTextField(10);

        newPanel.add(label);
        newPanel.add(textField);
        newPanel.add(button1);
        newPanel.add(button2);

        frame.setLayout(new BorderLayout());
        frame.add(displayPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(newPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void handleButtonClick(String label) {
        if (label.equals("C")) {
            display.setText("");
        } else if (label.equals("=")) {
            display.setText("Result");
        } else {
            display.setText(display.getText() + label);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UI ui = new UI();
            ui.designUI();
        });
    }
}
