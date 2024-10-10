import javax.swing.*;
import java.awt.*;

public class UI {

    private JTextField display;

    public void designUI() {

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel displayPanel = new JPanel();
        display = new JTextField(16); // Text field for display
        display.setEditable(false); // Make it non-editable
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
        frame.setLayout(new BorderLayout());
        frame.add(displayPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
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
        // Run UI in the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            UI ui = new UI();
            ui.designUI();
        });
    }
}
