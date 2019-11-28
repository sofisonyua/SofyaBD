package by.bstu.project.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Patient {
    private Integer id;
    private String firstName;
    private String lastName;
    private String diagnosis;
    private String therapy;
    private Integer doctorId;
}
