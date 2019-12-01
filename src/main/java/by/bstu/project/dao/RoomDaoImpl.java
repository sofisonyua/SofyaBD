package by.bstu.project.dao;

import by.bstu.project.entity.Room;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl extends AbstractDao implements IRoomDao {

    public RoomDaoImpl() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Room insert(Room room) throws Exception {
        PreparedStatement statement = getCreateStatement("INSERT INTO room(doctor_id, employee_id, isFree) VALUES(?, ?, ?)", "id");
        statement.setInt(1, room.getDoctorId());
        statement.setInt(2, room.getEmployeeId());
        statement.setBoolean(3, room.isFree());
        if (statement.executeUpdate() > 0) {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            boolean next = generatedKeys.next();
            int roomId = next ? generatedKeys.getInt(1) : -1;
            if (roomId != -1) {
                room.setId(roomId);
                return room;
            }
        }
        throw new RuntimeException("Room was not created");
    }

    public Integer delete(Room room) throws Exception {
        PreparedStatement statement = createStatement("DELETE FROM room WHERE id = ?");
        statement.setInt(1, room.getId());
        int rows = statement.executeUpdate();
        return rows;
    }

    public Room getById(Integer id) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM room WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next())
            return null;
        Room room = new Room();
        room.setId(id);
        room.setDoctorId(resultSet.getInt("doctor_id"));
        room.setEmployeeId(resultSet.getInt("employee_id"));
        room.setFree(resultSet.getBoolean("isFree"));
        return room;
    }

    public List<Room> getList() throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM room");
        ResultSet resultSet = statement.executeQuery();
        List<Room> rooms = new ArrayList<Room>();
        while (resultSet.next()) {
            Room room = new Room();
            room.setId(resultSet.getInt("id"));
            room.setDoctorId(resultSet.getInt("doctor_id"));
            room.setEmployeeId(resultSet.getInt("employee_id"));
            room.setFree(resultSet.getBoolean("isFree"));
            rooms.add(room);
        }
        return rooms;
    }

    public Integer getSize() throws Exception {
        Integer size;

        PreparedStatement statement = createStatement("SELECT count(*) FROM room");

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();

        return size = resultSet.getInt(1);
    }

    public Room getByEmployeeAndDoctorIds(Integer employeeId, Integer doctorId) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM room WHERE employee_id = ? and doctor_id = ?");
        statement.setInt(1, employeeId);
        statement.setInt(2, doctorId);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next())
            return null;
        Room room = new Room();
        room.setId(resultSet.getInt("id"));
        room.setEmployeeId(employeeId);
        room.setDoctorId(doctorId);
        room.setFree(resultSet.getBoolean("isFree"));
        return room;
    }

    public int update(Room room) throws Exception {
        PreparedStatement statement = createStatement("UPDATE room set room.doctor_id = ?, room.employee_id = ?, room.isFree = ? where id = ?");
        statement.setInt(1, room.getDoctorId());
        statement.setInt(2, room.getEmployeeId());
        statement.setBoolean(3, room.isFree());
        statement.setInt(4, room.getId());
        return statement.executeUpdate();
    }
}
