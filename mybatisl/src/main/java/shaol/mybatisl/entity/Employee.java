package shaol.mybatisl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * Author: shaoff
 * Date: 2020/8/19 19:42
 * Package: shao.jsl.springbl.entity
 * Description:
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int empNo;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date hireDate;
}

