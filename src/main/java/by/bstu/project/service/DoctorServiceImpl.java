package by.bstu.project.service;

import by.bstu.project.dao.DoctorDaoImpl;
import by.bstu.project.dao.IDoctorDao;
import by.bstu.project.entity.Doctor;

import java.util.List;

public class DoctorServiceImpl implements IDoctorService {

    private IDoctorDao doctorDao = new DoctorDaoImpl();

    public Doctor insert(Doctor doctor) throws Exception {
        if (doctorDao.getByFirstAndLastName(doctor.getFirstName(), doctor.getFirstName()) == null)
            return doctorDao.insert(doctor);
        else
            return null;
    }

    public boolean delete(Doctor doctor) throws Exception {
        return doctorDao.delete(doctor) == 1;
    }

    public Doctor getEntity(Integer id) throws Exception {
        return doctorDao.getById(id);
    }

    public List<Doctor> getEntityList() throws Exception {
        return doctorDao.getList();
    }

    public Integer getSize() throws Exception {
        return doctorDao.getSize();
    }
}
