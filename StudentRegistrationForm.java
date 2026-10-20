
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends Frame
        implements ActionListener {

    TextField nameField, rollField, courseField;
    Button submit;

    StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(350, 250);
        setLayout(new FlowLayout());

        add(new Label("Name:"));
        nameField = new TextField(20);
        add(nameField);

        add(new Label("Roll No:"));
        rollField = new TextField(20);
        add(rollField);

        add(new Label("Course:"));
        courseField = new TextField(20);
        add(courseField);

        submit = new Button("Submit");
        add(submit);
        submit.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String details = "Registration Successful!\n"
                + "Name: " + nameField.getText() + "\n"
                + "Roll No: " + rollField.getText() + "\n"
                + "Course: " + courseField.getText();

        System.out.println(details);
        Dialog d = new Dialog(this, "Registration Details", true);
        d.setLayout(new FlowLayout());
        d.add(new Label(details.replace("\n", " | ")));
        Button ok = new Button("OK");
        ok.addActionListener(ev -> d.dispose());
        d.add(ok);
        d.setSize(400, 120);
        d.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}
