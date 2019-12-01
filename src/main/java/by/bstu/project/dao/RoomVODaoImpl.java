package by.bstu.project.dao;

import by.bstu.project.entity.RoomVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomVODaoImpl extends AbstractDao implements IRoomVODao {

    private static final String SELECT_SQL = "SELECT room.id, " +
            "room.isFree, " +
            "doctor.first_name, " +
            "doctor.last_name, " +
            "doctor.specialization, " +
            "doctor.age, " +
            "empl.first_name, " +
            "empl.last_name, " +
            "empl.position, " +
            "empl.age " +
            "FROM room " +
            "INNER JOIN doctors AS doctor ON room.doctor_id = doctor.id " +
            "INNER JOIN employee AS empl ON room.employee_id = empl.id " +
            "WHERE room.id = ?";

    private static final String SELECT_ALL_SQL = "SELECT room.id, " +
            "room.isFree, " +
            "doctor.first_name, " +
            "doctor.last_name, " +
            "doctor.specialization, " +
            "doctor.age, " +
            "empl.first_name, " +
            "empl.last_name, " +
            "empl.position, " +
            "empl.age " +
            "FROM room " +
            "INNER JOIN doctors AS doctor ON room.doctor_id = doctor.id " +
            "INNER JOIN employee AS empl ON room.employee_id = empl.id";

    private static final String SELECT_ALL_FREE_ROOMS_SQL = "SELECT room.id, " +
            "room.isFree, " +
            "doctor.first_name, " +
            "doctor.last_name, " +
            "doctor.specialization, " +
            "doctor.age, " +
            "empl.first_name, " +
            "empl.last_name, " +
            "empl.position, " +
            "empl.age " +
            "FROM room " +
            "INNER JOIN doctors AS doctor ON room.doctor_id = doctor.id " +
            "INNER JOIN employee AS empl ON room.employee_id = empl.id "+
            "WHERE room.isFree = true;";

    public RoomVO getFullInfoById(Integer id) throws Exception {
        PreparedStatement statement = createStatement(SELECT_SQL);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next())
            return null;
        RoomVO roomVO = new RoomVO();
        roomVO.setId(id);
        roomVO.setFree(resultSet.getBoolean("room.isFree"));
        roomVO.setDoctorFirstName(resultSet.getString("doctor.first_name"));
        roomVO.setDoctorLastName(resultSet.getString("doctor.last_name"));
        roomVO.setDoctorAge(resultSet.getInt("doctor.age"));
        roomVO.setDoctorSpecialization(resultSet.getString("doctor.specialization"));
        roomVO.setEmployeeFirstName(resultSet.getString("empl.first_name"));
        roomVO.setEmployeeLastName(resultSet.getString("empl.last_name"));
        roomVO.setEmployeePosition(resultSet.getString("empl.position"));
        roomVO.setEmployeeAge(resultSet.getInt("empl.age"));
        return roomVO;
    }


    public List<RoomVO> getFullInfoList() throws Exception {
        PreparedStatement statement = createStatement(SELECT_ALL_SQL);
        ResultSet resultSet = statement.executeQuery();
        List<RoomVO> roomVOList = new ArrayList<RoomVO>();
        while (resultSet.next()) {
            RoomVO roomVO = new RoomVO();
            roomVO.setId(resultSet.getInt("room.id"));
            roomVO.setFree(resultSet.getBoolean("room.isFree"));
            roomVO.setDoctorFirstName(resultSet.getString("doctor.first_name"));
            roomVO.setDoctorLastName(resultSet.getString("doctor.last_name"));
            roomVO.setDoctorAge(resultSet.getInt("doctor.age"));
            roomVO.setDoctorSpecialization(resultSet.getString("doctor.specialization"));
            roomVO.setEmployeeFirstName(resultSet.getString("empl.first_name"));
            roomVO.setEmployeeLastName(resultSet.getString("empl.last_name"));
            roomVO.setEmployeePosition(resultSet.getString("empl.position"));
            roomVO.setEmployeeAge(resultSet.getInt("empl.age"));
            roomVOList.add(roomVO);
        }
        return roomVOList;
    }

    public List<RoomVO> getFreeRooms() throws Exception {
        PreparedStatement statement = createStatement(SELECT_ALL_FREE_ROOMS_SQL);
        ResultSet resultSet = statement.executeQuery();
        List<RoomVO> roomVOList = new ArrayList<RoomVO>();
        while (resultSet.next()) {
            RoomVO roomVO = new RoomVO();
            roomVO.setId(resultSet.getInt("room.id"));
            roomVO.setFree(resultSet.getBoolean("room.isFree"));
            roomVO.setDoctorFirstName(resultSet.getString("doctor.first_name"));
            roomVO.setDoctorLastName(resultSet.getString("doctor.last_name"));
            roomVO.setDoctorAge(resultSet.getInt("doctor.age"));
            roomVO.setDoctorSpecialization(resultSet.getString("doctor.specialization"));
            roomVO.setEmployeeFirstName(resultSet.getString("empl.first_name"));
            roomVO.setEmployeeLastName(resultSet.getString("empl.last_name"));
            roomVO.setEmployeePosition(resultSet.getString("empl.position"));
            roomVO.setEmployeeAge(resultSet.getInt("empl.age"));
            roomVOList.add(roomVO);
        }
        return roomVOList;
    }
}
