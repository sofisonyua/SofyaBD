package by.bstu.project.dao;

import by.bstu.project.entity.Patient;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoImpl extends AbstractDao implements IPatientDao {

    public PatientDaoImpl() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Patient insert(Patient patient) throws Exception {
        PreparedStatement statement = getCreateStatement("INSERT INTO patient(first_name, last_name, diagnosis, therapy, doctor_id) VALUES(?, ?, ?, ?, ?)", "id");
        statement.setString(1, patient.getFirstName());
        statement.setString(2, patient.getLastName());
        statement.setString(3, patient.getDiagnosis());
        statement.setString(4, patient.getTherapy());
        statement.setInt(5, patient.getDoctorId());
        if (statement.executeUpdate() > 0) {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            boolean next = generatedKeys.next();
            int patientId = next ? generatedKeys.getInt(1) : -1;
            if (patientId != -1) {
                patient.setId(patientId);
                return patient;
            }
        }
        throw new RuntimeException("Patient was not created");
    }

    public Integer delete(Patient patient) throws Exception {
        PreparedStatement statement = createStatement("DELETE FROM patient WHERE id = ?");
        statement.setInt(1, patient.getId());
        int rows = statement.executeUpdate();
        return rows;
    }

    public Patient getById(Integer id) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM patient WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next())
            return null;
        Patient patient = new Patient();
        patient.setId(id);
        patient.setFirstName(resultSet.getString("first_name"));
        patient.setLastName(resultSet.getString("last_name"));
        patient.setDiagnosis(resultSet.getString("diagnosis"));
        patient.setTherapy(resultSet.getString("therapy"));
        patient.setDoctorId(resultSet.getInt("doctor_id"));
        return patient;
    }

    public List<Patient> getList() throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM patient");
        ResultSet resultSet = statement.executeQuery();
        List<Patient> patientList = new ArrayList<Patient>();
        while (resultSet.next()) {
            Patient patient = new Patient();
            patient.setId(resultSet.getInt("id"));
            patient.setFirstName(resultSet.getString("first_name"));
            patient.setLastName(resultSet.getString("last_name"));
            patient.setDiagnosis(resultSet.getString("diagnosis"));
            patient.setTherapy(resultSet.getString("therapy"));
            patient.setDoctorId(resultSet.getInt("doctor_id"));
            patientList.add(patient);
        }
        return patientList;
    }

    public Integer getSize() throws Exception {
        Integer size;
        PreparedStatement statement = createStatement("SELECT count(*) FROM patient");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return size = resultSet.getInt(1);
    }

    public Patient getByFirstAndLastName(String firstName, String lastName) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM patient WHERE first_name = ? and last_name = ?");
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next())
            return null;
        Patient patient = new Patient();
        patient.setId(resultSet.getInt("id"));
        patient.setFirstName(resultSet.getString("first_name"));
        patient.setLastName(resultSet.getString("last_name"));
        patient.setDiagnosis(resultSet.getString("diagnosis"));
        patient.setTherapy(resultSet.getString("therapy"));
        patient.setDoctorId(resultSet.getInt("doctor_id"));
        return patient;
    }
}
