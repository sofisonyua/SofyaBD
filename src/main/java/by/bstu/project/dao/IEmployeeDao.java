package by.bstu.project.dao;

import by.bstu.project.entity.Employee;

public interface IEmployeeDao extends IDao<Employee> {
    Employee getByFirstAndLastName(String firstName, String lastName) throws Exception;
}
