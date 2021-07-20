package shaol.mybatisl.mapper;

import shaol.mybatisl.entity.Employee;

/**
 * Author: shaoff
 * Date: 2020/8/20 16:36
 * Package: shaol.mybatisl.comp
 * Description:
 * Mapper接口的引用路径应该和mapper xml的namespace一致，方法名对应到id上
 */

public interface EmployeeMapper {
    Employee selectEmployee(int empNo);
    void insertEmployee(Employee e);
}
