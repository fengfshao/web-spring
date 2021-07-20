package shaol.mybatisl.comp;

import junit.framework.TestCase;
import shaol.mybatisl.entity.Employee;
import shaol.mybatisl.entity.Gender;

import java.sql.Date;
import java.sql.SQLException;

/**
 * Author: shaoff
 * Date: 2020/8/20 16:46
 * Package: shaol.mybatisl.comp
 * Description:
 */
public class ByMapperTest extends TestCase {

    public void testFindEmployee() {
        Employee e=ByMapper.findEmployee(10001);
        System.out.println(e);
        assertEquals(10001, e.getEmpNo());
    }

    public void testAddEmployee() {
        Employee e1 = new Employee(Integer.MAX_VALUE-3, Date.valueOf("1996-09-29"), "fengfeng", "shao", Gender.M, Date.valueOf("2019-07-03"));
        ByMapper.addEmployee(e1);

        Employee e2=ByMapper.findEmployee(e1.getEmpNo());
        assertEquals(e1,e2);
    }

}