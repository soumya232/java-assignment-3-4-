
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/company_db";
    private static final String USER = "root";
    private static final String PASSWORD = "mahak";

    // Establish database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Insert a new employee
    public void addEmployee(int id, String name,
                            String department, double salary)
            throws SQLException {

        String sql = "INSERT INTO employees "
                + "(emp_id, name, department, salary) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.setDouble(4, salary);

            ps.executeUpdate();
        }
    }

    // Retrieve all employees
    public List<Object[]> getAllEmployees() throws SQLException {

        List<Object[]> employees = new ArrayList<>();

        String sql = "SELECT emp_id, name, department, salary "
                + "FROM employees ORDER BY emp_id";

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                employees.add(new Object[]{
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getBigDecimal("salary")
                });
            }
        }

        return employees;
    }
}
