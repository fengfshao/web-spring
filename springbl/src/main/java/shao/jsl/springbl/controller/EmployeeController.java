package shao.jsl.springbl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shao.jsl.springbl.entity.Employee;
import shao.jsl.springbl.service.EmployeeService;

import java.util.List;

/**
 * Author: shaoff
 * Date: 2020/8/19 19:37
 * Package: shao.jsl.springbl.controller
 * Description:
 */

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> listEmployees(@RequestParam(value = "count", defaultValue = "10") int count) {
        List<Employee> res = employeeService.list(count);
        return res;
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee e) {
        employeeService.add(e);
    }


    @GetMapping("/find")
    public Employee findEmployee(@RequestParam int empNo) {
        Employee res = employeeService.find(empNo);
        return res;
    }


}
