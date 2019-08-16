package edu.javaee.ssmcrud.services.impl;

import edu.javaee.ssmcrud.bean.Employer;
import edu.javaee.ssmcrud.bean.EmployerExample;
import edu.javaee.ssmcrud.bean.Message;
import edu.javaee.ssmcrud.dao.EmployerMapper;
import edu.javaee.ssmcrud.services.EmployerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SSMCRUD
 * @description: 员工操作服务层
 * @author: 张清
 * @create: 2019-07-20 16:08
 **/
@Service
public class EmployerServicesImpl implements EmployerServices {

    @Autowired
    EmployerMapper employerMapper;
    @Override
    public List<Employer> getAllEmployer() {
        return employerMapper.selectByExampleWithDept(null);
    }

    @Override
    public void saveEmp(Employer employer) {
        employerMapper.insertSelective(employer);
    }


    @Override
    public boolean cheakUser(String email) {
        EmployerExample employerExample = new EmployerExample();
        EmployerExample.Criteria criteria = employerExample.createCriteria();
        criteria.andEmailEqualTo(email);
        long count = employerMapper.countByExample(employerExample);
        return count == 0;
    }

    @Override
    public Employer getEmployer(Integer id) {
        Employer employer = employerMapper.selectByPrimaryKey(id);
        return employer;
    }

    @Override
    public void updataEmp(Employer employer) {
        employerMapper.updateByPrimaryKeySelective(employer);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        EmployerExample employerExample = new EmployerExample();
        EmployerExample.Criteria criteria = employerExample.createCriteria();
        criteria.andEmp_idIn(ids);
        employerMapper.deleteByExample(employerExample);
    }

    @Override
    public void deleteEmp(Integer id) {
        employerMapper.deleteByPrimaryKey(id);
    }

}
