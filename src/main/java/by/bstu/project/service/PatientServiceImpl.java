package by.bstu.project.service;

import by.bstu.project.dao.IPatientDao;
import by.bstu.project.dao.PatientDaoImpl;
import by.bstu.project.entity.Patient;

import java.util.List;

public class PatientServiceImpl implements IPatientService {

    private IPatientDao patientDao = new PatientDaoImpl();

    public Patient insert(Patient patient) throws Exception {
        if (patientDao.getByFirstAndLastName(patient.getFirstName(), patient.getFirstName()) == null)
            return patientDao.insert(patient);
        else
            return null;
    }

    public boolean delete(Patient patient) throws Exception {
        return patientDao.delete(patient) == 1;
    }

    public Patient getEntity(Integer id) throws Exception {
        return patientDao.getById(id);
    }

    public List<Patient> getEntityList() throws Exception {
        return patientDao.getList();
    }

    public Integer getSize() throws Exception {
        return patientDao.getSize();
    }

    public int update(Patient patient) throws Exception {
        return patientDao.update(patient);
    }
}
