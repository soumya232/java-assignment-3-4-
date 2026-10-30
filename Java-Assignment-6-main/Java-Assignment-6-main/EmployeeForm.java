
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class EmployeeForm extends JFrame {

    private JTextField idField;
    private JTextField nameField;
    private JTextField departmentField;
    private JTextField salaryField;

    private JTable employeeTable;
    private DefaultTableModel tableModel;

    private final EmployeeDAO dao = new EmployeeDAO();

    public EmployeeForm() {

        setTitle("Employee Management System");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Heading
        JLabel heading = new JLabel(
                "Employee Management System",
                SwingConstants.CENTER
        );
        heading.setFont(new Font("Arial", Font.BOLD, 22));

        // Employee form
        JPanel formPanel = new JPanel(
                new GridLayout(4, 2, 10, 10)
        );
        formPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        idField = new JTextField();
        nameField = new JTextField();
        departmentField = new JTextField();
        salaryField = new JTextField();

        formPanel.add(new JLabel("Employee ID:"));
        formPanel.add(idField);

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Department:"));
        formPanel.add(departmentField);

        formPanel.add(new JLabel("Salary:"));
        formPanel.add(salaryField);

        // Buttons
        JButton submitButton = new JButton("Submit");
        JButton viewButton = new JButton("View All Employees");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(viewButton);

        // Employee table
        tableModel = new DefaultTableModel(
                new String[]{
                        "Employee ID",
                        "Name",
                        "Department",
                        "Salary"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);

        // Arrange components
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.add(heading, BorderLayout.NORTH);
        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        setLayout(new BorderLayout(10, 10));
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Button actions
        submitButton.addActionListener(e -> addEmployee());
        viewButton.addActionListener(e -> viewEmployees());
    }

    // Add employee to database
    private void addEmployee() {

        String idText = idField.getText().trim();
        String name = nameField.getText().trim();
        String department = departmentField.getText().trim();
        String salaryText = salaryField.getText().trim();

        if (idText.isEmpty() || name.isEmpty()
                || department.isEmpty() || salaryText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this, "Please fill in all fields."
            );
            return;
        }

        try {
            int id = Integer.parseInt(idText);
            BigDecimal salary = new BigDecimal(salaryText);

            if (id <= 0 || !Double.isFinite(salary.doubleValue())
                    || salary.compareTo(BigDecimal.ZERO) < 0
                    || salary.scale() > 2
                    || salary.precision() - salary.scale() > 8) {

                JOptionPane.showMessageDialog(
                        this, "Enter a valid employee ID and salary."
                );
                return;
            }

            dao.addEmployee(
                    id, name, department, salary.doubleValue()
            );

            JOptionPane.showMessageDialog(
                    this, "Employee added successfully!"
            );

            clearFields();
            viewEmployees();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Employee ID must be an integer and salary must be numeric."
            );

        } catch (SQLException ex) {

            if (ex.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(
                        this, "Employee ID already exists."
                );
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Database error: " + ex.getMessage()
                );
            }
        }
    }

    // Display all employee records
    private void viewEmployees() {

        try {
            List<Object[]> employees = dao.getAllEmployees();

            tableModel.setRowCount(0);

            for (Object[] employee : employees) {
                tableModel.addRow(employee);
            }

            if (employees.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, "No employee records found."
                );
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to retrieve employees: "
                            + ex.getMessage()
            );
        }
    }

    // Clear form fields
    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        departmentField.setText("");
        salaryField.setText("");
    }

    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            EmployeeForm form = new EmployeeForm();
            form.setVisible(true);
        });
    }
}
