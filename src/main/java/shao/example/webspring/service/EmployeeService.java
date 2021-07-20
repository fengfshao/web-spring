package shao.example.webspring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shao.example.webspring.entity.Employee;
import shao.example.webspring.mapper.EmployeeMapper;

/**
 * Author: shaoff
 * Date: 2020/8/20 17:25
 * Package: shao.jsl.springbl.service
 * Description:
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> list(int count){
        return employeeMapper.listEmployee(count);
    }

    public void add(Employee e){
        employeeMapper.insertEmployee(e);
    }

    public Employee find(int empNo){
        return employeeMapper.selectEmployee(empNo);
    }
}
