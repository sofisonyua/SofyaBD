package by.bstu.project.entity;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String position;
    private Integer age;
}
