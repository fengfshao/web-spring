package shaol.mybatisl.comp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import shaol.mybatisl.entity.Employee;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: shaoff
 * Date: 2020/8/20 15:40
 * Package: shaol.mybatisl.comp
 * Description:
 */
public class BySqlSession {
    private static SqlSession session;
    static {
        try{
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Employee findEmployee(int empNo) throws SQLException {
        // shaol.mybatisl.mapper.EmployeeMapper.selectEmployee 见xml
        Employee employee = (Employee) session.selectOne("shaol.mybatisl.mapper.EmployeeMapper.selectEmployee", empNo);
        return employee;
    }

    public static void addEmployee(Employee e) throws SQLException {
        // shaol.mybatisl.mapper.EmployeeMapper.selectEmployee 见xml
        int res= session.insert("shaol.mybatisl.mapper.EmployeeMapper.insertEmployee", e);
        assert res==1;
        session.commit();
    }

}
