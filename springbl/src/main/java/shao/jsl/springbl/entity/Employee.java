package shao.jsl.springbl.entity;

import lombok.Data;

import java.sql.Date;

/**
 * Author: shaoff
 * Date: 2020/8/19 19:42
 * Package: shao.jsl.springbl.entity
 * Description:
 */


@Data
public class Employee {
    private long empNo;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date hireDate;
}

