package by.bstu.project.service;

import by.bstu.project.dao.IRoomVODao;
import by.bstu.project.dao.RoomVODaoImpl;
import by.bstu.project.entity.RoomVO;

import java.util.List;

public class RoomVOServiceImpl implements IRoomVOService {

    private IRoomVODao roomVODao = new RoomVODaoImpl();

    public RoomVO getFullInfoById(Integer id) throws Exception {
        return roomVODao.getFullInfoById(id);
    }

    public List<RoomVO> getFullInfoList() throws Exception {
        return roomVODao.getFullInfoList();
    }

    public List<RoomVO> getFreeRooms() throws Exception {
        return roomVODao.getFreeRooms();
    }

}
