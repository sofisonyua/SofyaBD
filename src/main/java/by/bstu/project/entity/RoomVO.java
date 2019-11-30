package by.bstu.project.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RoomVO {
    Integer id;
    String doctorFirstName;
    String doctorLastName;
    String doctorSpecialization;
    Integer doctorAge;
    String employeeFirstName;
    String employeeLastName;
    String employeePosition;
    Integer employeeAge;
    boolean isFree;
}
