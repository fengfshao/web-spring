package shao.example.webspring.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import shao.example.webspring.entity.Employee;

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
