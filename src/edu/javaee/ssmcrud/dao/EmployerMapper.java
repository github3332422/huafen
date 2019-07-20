package edu.javaee.ssmcrud.dao;

import edu.javaee.ssmcrud.bean.Employer;
import edu.javaee.ssmcrud.bean.EmployerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployerMapper {
    long countByExample(EmployerExample example);

    int deleteByExample(EmployerExample example);

    int deleteByPrimaryKey(Integer emp_id);

    int insert(Employer record);

    int insertSelective(Employer record);

    List<Employer> selectByExample(EmployerExample example);

    Employer selectByPrimaryKey(Integer emp_id);

    List<Employer> selectByExampleWithDept(EmployerExample example);

    Employer selectByPrimaryKeyWithDept(Integer emp_id);

    int updateByExampleSelective(@Param("record") Employer record, @Param("example") EmployerExample example);

    int updateByExample(@Param("record") Employer record, @Param("example") EmployerExample example);

    int updateByPrimaryKeySelective(Employer record);

    int updateByPrimaryKey(Employer record);
}