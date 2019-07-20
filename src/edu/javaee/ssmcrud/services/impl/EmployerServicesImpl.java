package edu.javaee.ssmcrud.services.impl;

import edu.javaee.ssmcrud.bean.Employer;
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
}
