package edu.javaee.ssmcrud.services;

import edu.javaee.ssmcrud.bean.Employer;

import java.util.List;

public interface EmployerServices {
    /**
     * 查询所有的用户
     * */
    public List<Employer> getAllEmployer();

    /**
     * 保存用户
     * */
    public void saveEmp(Employer employer);

    /**
     * 删除员工
     * */
    public void deleteEmp(Integer id);
}
