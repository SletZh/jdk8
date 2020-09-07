package pojo;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Student {
    private String name;
    private String gender;
    private Double score;
    private String className;
}
