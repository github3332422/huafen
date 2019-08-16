package edu.javaee.ssmcrud.services;

import edu.javaee.ssmcrud.bean.Employer;
import edu.javaee.ssmcrud.bean.Message;

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

    /**
     * 通过邮箱校验员工
     * */
    public boolean cheakUser(String email);

    /**
     * 根据id查询数据
     * */
    public Employer getEmployer(Integer id);

    public void updataEmp(Employer employer);

    public void deleteBatch(List<Integer> ids);
}
