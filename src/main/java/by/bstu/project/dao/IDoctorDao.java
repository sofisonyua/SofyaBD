package by.bstu.project.dao;

import by.bstu.project.entity.Doctor;

public interface IDoctorDao extends IDao<Doctor> {
    Doctor getByFirstAndLastName(String firstName, String lastName) throws Exception;
}
