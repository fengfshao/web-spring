package shaol.mybatisl.comp;

import junit.framework.TestCase;
import shaol.mybatisl.entity.Employee;
import shaol.mybatisl.entity.Gender;

import java.nio.ByteBuffer;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

/**
 * Author: shaoff
 * Date: 2020/8/20 14:39
 * Package: shaol.mybatisl.comp
 * Description:
 */
public class ByJdbcTest extends TestCase {

    public void testList() throws Exception{
        List<Employee> someEmployees = ByJdbc.listEmployee(10);
        assertEquals(10, someEmployees.size());
    }

    public void testFind() throws Exception {
        List<Employee> someEmployees = ByJdbc.listEmployee(10);
        Employee e1=someEmployees.get(1);
        Employee e2 = ByJdbc.findEmployee(e1.getEmpNo());
        assertEquals(e1,e2);
    }

    public void testAddEmployee() throws SQLException {
        Employee e1 = new Employee(Integer.MAX_VALUE, Date.valueOf("1996-09-29"), "fengfeng", "shao", Gender.M, Date.valueOf("2019-07-03"));
        ByJdbc.addEmployee(e1);

        Employee e2 = ByJdbc.findEmployee(e1.getEmpNo());
        assertEquals(e1, e2);
    }

    public void testDeleteEmployee() throws SQLException {
        Employee e1 = new Employee(Integer.MAX_VALUE-1, Date.valueOf("1996-09-29"), "fengfeng", "shao", Gender.M, Date.valueOf("2019-07-03"));
        ByJdbc.addEmployee(e1);

        ByJdbc.deleteEmployee(e1.getEmpNo());
        Employee e2 = ByJdbc.findEmployee(e1.getEmpNo());
        assertNull(e2);
    }


}