import javax.swing.*;
import java.awt.*;

public class UI {

    public void designUI() {
        JFrame frame = new JFrame("Calculator");

        JPanel panel = new JPanel(new GridLayout(2, 2));
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JLabel label = new JLabel("Enter Value:");
        JTextField textField = new JTextField(10);

        panel.add(label);
        panel.add(textField);
        panel.add(button1);
        panel.add(button2);

        frame.add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.designUI();
    }
}
