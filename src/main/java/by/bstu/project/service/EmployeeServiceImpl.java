package by.bstu.project.service;

import by.bstu.project.dao.EmployeeDaoImpl;
import by.bstu.project.dao.IEmployeeDao;
import by.bstu.project.entity.Employee;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDao employeeDao = new EmployeeDaoImpl();

    public Employee insert(Employee employee) throws Exception {
        if (employeeDao.getByFirstAndLastName(employee.getFirstName(), employee.getFirstName()) == null)
            return employeeDao.insert(employee);
        else
            return null;
    }

    public boolean delete(Employee employee) throws Exception {
        return employeeDao.delete(employee) == 1;
    }

    public Employee getEntity(Integer id) throws Exception {
        return employeeDao.getById(id);
    }

    public List<Employee> getEntityList() throws Exception {
        return employeeDao.getList();
    }

    public Integer getSize() throws Exception {
        return employeeDao.getSize();
    }

    public int update(Employee employee) throws Exception {
        return employeeDao.update(employee);
    }
}
