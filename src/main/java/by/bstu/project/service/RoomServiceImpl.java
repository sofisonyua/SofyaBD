package by.bstu.project.service;

import by.bstu.project.dao.IRoomDao;
import by.bstu.project.dao.RoomDaoImpl;
import by.bstu.project.entity.Room;

import java.util.List;

public class RoomServiceImpl implements IRoomService {

    private IRoomDao roomDao = new RoomDaoImpl();

    public Room insert(Room room) throws Exception {

        if (roomDao.getByEmployeeAndDoctorIds(room.getEmployeeId(), room.getDoctorId()) == null)
            return roomDao.insert(room);
        else return null;
    }

    public boolean delete(Room route) throws Exception {
        return roomDao.delete(route) == 1;
    }

    public Room getEntity(Integer id) throws Exception {
        return roomDao.getById(id);
    }

    public List<Room> getEntityList() throws Exception {
        return roomDao.getList();
    }

    public Integer getSize() throws Exception {
        return roomDao.getSize();
    }

    public int update(Room room) throws Exception {
        return roomDao.update(room);
    }
}
