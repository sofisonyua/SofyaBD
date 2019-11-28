package by.bstu.project.dao;

import by.bstu.project.entity.Doctor;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl extends AbstractDao implements IDoctorDao {

    public DoctorDaoImpl() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Doctor insert(Doctor doctor) throws Exception {
        PreparedStatement statement = getCreateStatement("INSERT INTO doctors(first_name, last_name, specialization, age) VALUES(?, ?, ?, ?)", "id");
        statement.setString(1, doctor.getFirstName());
        statement.setString(2, doctor.getLastName());
        statement.setString(3, doctor.getSpecialization());
        statement.setInt(4, doctor.getAge());
        if (statement.executeUpdate() > 0) {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            boolean next = generatedKeys.next();
            int doctorId = next ? generatedKeys.getInt(1) : -1;
            if (doctorId != -1) {
                doctor.setId(doctorId);
                return doctor;
            }
        }
        throw new RuntimeException("Doctors was not created");
    }

    public Integer delete(Doctor doctor) throws Exception {
        PreparedStatement statement = createStatement("DELETE FROM doctors WHERE id = ?");
        statement.setInt(1, doctor.getId());
        int rows = statement.executeUpdate();
        return rows;
    }

    public Doctor getById(Integer id) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM doctors WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next())
            return null;
        Doctor doctor = new Doctor();
        doctor.setId(id);
        doctor.setFirstName(resultSet.getString("first_name"));
        doctor.setLastName(resultSet.getString("last_name"));
        doctor.setSpecialization(resultSet.getString("specialization"));
        doctor.setAge(resultSet.getInt("age"));
        return doctor;
    }

    public List<Doctor> getList() throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM doctors");
        ResultSet resultSet = statement.executeQuery();
        List<Doctor> listDoctors = new ArrayList<Doctor>();
        while (resultSet.next()) {
            Doctor doctor = new Doctor();
            doctor.setId(resultSet.getInt("id"));
            doctor.setFirstName(resultSet.getString("first_name"));
            doctor.setLastName(resultSet.getString("last_name"));
            doctor.setSpecialization(resultSet.getString("specialization"));
            doctor.setAge(resultSet.getInt("age"));
            listDoctors.add(doctor);
        }
        return listDoctors;
    }

    public Integer getSize() throws Exception {
        Integer size;
        PreparedStatement statement = createStatement("SELECT count(*) FROM doctors");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return size = resultSet.getInt(1);
    }

    public Doctor getByFirstAndLastName(String firstName, String lastName) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM doctors WHERE first_name = ? and last_name = ?");
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next())
            return null;
        Doctor doctor = new Doctor();
        doctor.setId(resultSet.getInt("id"));
        doctor.setFirstName(resultSet.getString("first_name"));
        doctor.setLastName(resultSet.getString("last_name"));
        doctor.setSpecialization(resultSet.getString("specialization"));
        doctor.setAge(resultSet.getInt("age"));
        return doctor;
    }
}
