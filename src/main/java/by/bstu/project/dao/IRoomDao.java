package by.bstu.project.dao;

import by.bstu.project.entity.Room;

public interface IRoomDao extends IDao<Room> {
    Room getByEmployeeAndDoctorIds(Integer employeeId, Integer doctorId) throws Exception;
}
