package shaol.mybatisl.comp;

import junit.framework.TestCase;
import shaol.mybatisl.entity.Employee;
import shaol.mybatisl.entity.Gender;

import java.sql.Date;
import java.sql.SQLException;

/**
 * Author: shaoff
 * Date: 2020/8/20 15:52
 * Package: shaol.mybatisl.comp
 * Description:
 */
public class BySqlSessionTest extends TestCase {

    public void testFindEmployee() throws SQLException {
        Employee e=BySqlSession.findEmployee(10001);
        System.out.println(e);
        assertEquals(10001, e.getEmpNo());
    }

    public void testAddEmployee() throws SQLException {
        Employee e1 = new Employee(Integer.MAX_VALUE-2, Date.valueOf("1996-09-29"), "fengfeng", "shao", Gender.M, Date.valueOf("2019-07-03"));
        BySqlSession.addEmployee(e1);
        Employee e2=BySqlSession.findEmployee(e1.getEmpNo());
        System.out.println(e2);
        assertEquals(e1, e2);
    }
}