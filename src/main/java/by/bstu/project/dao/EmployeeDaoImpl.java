package by.bstu.project.dao;

import by.bstu.project.entity.Employee;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl extends AbstractDao implements IEmployeeDao {

    public EmployeeDaoImpl() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee insert(Employee employee) throws Exception {
        PreparedStatement statement = getCreateStatement("INSERT INTO employee(first_name, last_name, position, age) VALUES(?, ?, ?, ?)", "id");
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getLastName());
        statement.setString(3, employee.getPosition());
        statement.setInt(4, employee.getAge());
        if (statement.executeUpdate() > 0) {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            boolean next = generatedKeys.next();
            int employeeId = next ? generatedKeys.getInt(1) : -1;
            if (employeeId != -1) {
                employee.setId(employeeId);
                return employee;
            }
        }
        throw new RuntimeException("Employee was not created");
    }

    public Integer delete(Employee employee) throws Exception {
        PreparedStatement statement = createStatement("DELETE FROM employee WHERE id = ?");
        statement.setInt(1, employee.getId());
        int rows = statement.executeUpdate();
        return rows;
    }

    public Employee getById(Integer id) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM employee WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next())
            return null;
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setPosition(resultSet.getString("position"));
        employee.setAge(resultSet.getInt("age"));
        return employee;
    }

    public List<Employee> getList() throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM employee");
        ResultSet resultSet = statement.executeQuery();
        List<Employee> listEmployee = new ArrayList<Employee>();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setPosition(resultSet.getString("position"));
            employee.setAge(resultSet.getInt("age"));
            listEmployee.add(employee);
        }
        return listEmployee;
    }

    public Integer getSize() throws Exception {
        Integer size;
        PreparedStatement statement = createStatement("SELECT count(*) FROM employee");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return size = resultSet.getInt(1);
    }

    public Employee getByFirstAndLastName(String firstName, String lastName) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM employee WHERE first_name = ? and last_name = ?");
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next())
            return null;
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setPosition(resultSet.getString("position"));
        employee.setAge(resultSet.getInt("age"));
        return employee;
    }

    public int update(Employee employee) throws Exception {
        PreparedStatement statement = createStatement("UPDATE employee set employee.first_name = ?, employee.last_name = ?, employee.position = ?, employee.age = ? where id = ?");
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getLastName());
        statement.setString(3, employee.getPosition());
        statement.setInt(4, employee.getAge());
        statement.setInt(5, employee.getId());
        return statement.executeUpdate();
    }
}
