package edu.javaee.ssmcrud.services.impl;

import edu.javaee.ssmcrud.bean.Department;
import edu.javaee.ssmcrud.bean.Employer;
import edu.javaee.ssmcrud.dao.DepartmentMapper;
import edu.javaee.ssmcrud.dao.EmployerMapper;
import edu.javaee.ssmcrud.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SSMCRUD
 * @description: 部门服务层
 * @author: 张清
 * @create: 2019-07-21 16:43
 **/
@Service
public class DepartmentServicesImpl implements DepartmentServices {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> getAllDepts() {
        return departmentMapper.selectByExample(null);
    }
}
