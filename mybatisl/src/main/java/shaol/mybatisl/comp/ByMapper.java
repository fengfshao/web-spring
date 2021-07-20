package shaol.mybatisl.comp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import shaol.mybatisl.entity.Employee;
import shaol.mybatisl.mapper.EmployeeMapper;

import java.io.InputStream;

/**
 * Author: shaoff
 * Date: 2020/8/20 16:36
 * Package: shaol.mybatisl.comp
 * Description:
 */


public class ByMapper {
    private static EmployeeMapper em;
    static {
        try{
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession(true);
            em = session.getMapper(EmployeeMapper.class);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Employee findEmployee(int empNo) {
        return em.selectEmployee(empNo);
    }

    public static void addEmployee(Employee e) {
        em.insertEmployee(e);
    }
}
