package by.bstu.project.dao;

import by.bstu.project.entity.RoomVO;

import java.util.List;

public interface IRoomVODao {
    RoomVO getFullInfoById(Integer id) throws Exception;
    List<RoomVO> getFullInfoList() throws Exception;
}
