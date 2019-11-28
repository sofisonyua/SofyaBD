package by.bstu.project.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Doctor {
    private Integer id;
    private String firstName;
    private String lastName;
    private String specialization;
    private Integer age;
}
