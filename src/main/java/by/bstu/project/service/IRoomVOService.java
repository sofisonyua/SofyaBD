package by.bstu.project.service;

import by.bstu.project.entity.RoomVO;

import java.util.List;

public interface IRoomVOService {
    RoomVO getFullInfoById(Integer id) throws Exception;
    List<RoomVO> getFullInfoList() throws Exception;
    List<RoomVO> getFreeRooms() throws Exception;
}
