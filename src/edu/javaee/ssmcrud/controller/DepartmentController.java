package edu.javaee.ssmcrud.controller;

import edu.javaee.ssmcrud.bean.Department;
import edu.javaee.ssmcrud.bean.Message;
import edu.javaee.ssmcrud.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: SSMCRUD
 * @description: 处理和部门有关的请求
 * @author: 张清
 * @create: 2019-07-21 16:41
 **/
@Controller
public class DepartmentController {
    @Autowired
    DepartmentServices departmentServices;

    /**
     * 返回所有的部门
     * */
    @ResponseBody
    @RequestMapping("/depts")
    public Message getAllDepts(){
        List<Department> list = departmentServices.getAllDepts();
        return Message.success().add("depts",list);
    }
}
