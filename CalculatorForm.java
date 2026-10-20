
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorForm extends JFrame
        implements ActionListener {

    JTextField num1, num2, result;
    JButton add, sub, mul, div;

    CalculatorForm() {
        setTitle("Calculator");
        setSize(350, 250);
        setLayout(new FlowLayout());

        add(new JLabel("First Number:"));
        num1 = new JTextField(10);
        add(num1);

        add(new JLabel("Second Number:"));
        num2 = new JTextField(10);
        add(num2);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");

        add(add);
        add(sub);
        add(mul);
        add(div);

        add(new JLabel("Result:"));
        result = new JTextField(15);
        result.setEditable(false);
        add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(num1.getText());
            double b = Double.parseDouble(num2.getText());
            double r = 0;

            if (e.getSource() == add)
                r = a + b;
            else if (e.getSource() == sub)
                r = a - b;
            else if (e.getSource() == mul)
                r = a * b;
            else if (e.getSource() == div) {
                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                r = a / b;
            }

            result.setText(String.valueOf(r));
        } catch (NumberFormatException ex) {
            result.setText("Enter valid numbers");
        }
    }

    public static void main(String[] args) {
        new CalculatorForm();
    }
}