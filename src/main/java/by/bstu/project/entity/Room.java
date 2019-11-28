package by.bstu.project.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Room {
    private Integer id;
    private Integer doctorId;
    private Integer employeeId;
}
