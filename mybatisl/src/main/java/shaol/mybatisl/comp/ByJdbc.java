package shaol.mybatisl.comp;

import shaol.mybatisl.entity.Employee;
import shaol.mybatisl.entity.Gender;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: shaoff
 * Date: 2020/8/20 11:48
 * Package: shaol.mybatisl.comp
 * Description:
 * 通过jdbc 完成数据库的CRUD操作
 * 使用本地mysql进行测试
 *
 * 参考  https://www.javatpoint.com/PreparedStatement-interface
 */
public class ByJdbc {
    static Connection conn;

    static {
        try {
            //加载driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai", "sakura", "test");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    static Employee extractFromResultSet(ResultSet rs) {
        try {
            int empNo = rs.getInt(1);
            Date birthDate = rs.getDate(2);
            String firstName = rs.getString(3);
            String lastName = rs.getString(4);
            Gender gender = Gender.valueOf(rs.getString(5));
            Date hireDate = rs.getDate(6);
            return new Employee(empNo, birthDate, firstName, lastName, gender, hireDate);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static List<Employee> listEmployee(int n) throws Exception {
        List<Employee> res = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select emp_no,birth_date,first_name,last_name,gender,hire_date from employees limit "+n);
        while (rs.next()) {

            res.add(extractFromResultSet(rs));
        }
        return res;
    }

    public static Employee findEmployee(int empNo) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("select * from employees where emp_no=?");
        stmt.setInt(1, empNo);
        ResultSet rs=stmt.executeQuery();
        rs.next();
        return extractFromResultSet(rs);
    }

    public static void addEmployee(Employee e) throws SQLException{
        String sql="insert into employees(emp_no,birth_date,first_name,last_name,gender,hire_date) values (?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,e.getEmpNo());
        stmt.setDate(2,e.getBirthDate());
        stmt.setString(3, e.getFirstName());
        stmt.setString(4, e.getLastName());
        stmt.setString(5,e.getGender().name());
        stmt.setDate(6, e.getHireDate());

        int res=stmt.executeUpdate();
        assert res==1;
    }

    public static void deleteEmployee(int empNo) throws SQLException{
        String sql="delete from employees where emp_no=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,empNo);

        int res=stmt.executeUpdate();
        assert res==1;
    }

    public static void main(String[] args) throws Exception {
        List<Employee> someEmployees = listEmployee(10);
        Employee e1=someEmployees.get(1);
        Employee e2=findEmployee(e1.getEmpNo());
    }
}
