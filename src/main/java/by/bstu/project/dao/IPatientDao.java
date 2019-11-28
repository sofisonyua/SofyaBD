package by.bstu.project.dao;

import by.bstu.project.entity.Patient;

public interface IPatientDao extends IDao<Patient> {
    Patient getByFirstAndLastName(String firstName, String lastName) throws Exception;
}
