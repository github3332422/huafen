package edu.javaee.ssmcrud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.javaee.ssmcrud.bean.Department;
import edu.javaee.ssmcrud.bean.Employer;
import edu.javaee.ssmcrud.bean.Message;
import edu.javaee.ssmcrud.services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 返回部门
     * */
    @RequestMapping("/dept")
    public String getDepts(Model model){
        PageHelper.startPage(1,10);
        List<Department> list = departmentServices.getAllDepts();
        //PageInfo中包括有我们查询出来的数据
        PageInfo page = new PageInfo(list,10);
//        System.out.println(page);
        model.addAttribute("pageInfo",page);
        return "dept";
    }
//    @RequestMapping("/emps")
//    public String getemps(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
//                          Model model){
//        PageHelper.startPage(pn,5);
//        List<Employer> emps = employerServices.getAllEmployer();
////        for(Employer employer:emps){
////            System.out.println(employer);
////        }
//        //PageInfo中包括有我们查询出来的数据
//        PageInfo page = new PageInfo(emps,5);
////        System.out.println(page);
//        model.addAttribute("pageInfo",page);
//        return "lis";
//    }
}
