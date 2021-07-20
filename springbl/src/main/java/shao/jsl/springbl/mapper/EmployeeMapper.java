package shao.jsl.springbl.mapper;

import org.springframework.stereotype.Repository;
import shao.jsl.springbl.entity.Employee;

import java.util.List;

/**
 * Author: shaoff
 * Date: 2020/8/19 20:18
 * Package: shao.jsl.springbl.mapper
 * Description:
 */

@Repository
public interface EmployeeMapper {

    void updateEmployee(Employee employee);
    void deleteEmployee(int empNo);
    List<Employee> listEmployee(int n);
    Employee selectEmployee(int empNo);
    void insertEmployee(Employee e);
}
