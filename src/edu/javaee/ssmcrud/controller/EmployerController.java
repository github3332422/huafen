package edu.javaee.ssmcrud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.javaee.ssmcrud.bean.Employer;
import edu.javaee.ssmcrud.bean.Message;
import edu.javaee.ssmcrud.dao.EmployerMapper;
import edu.javaee.ssmcrud.services.EmployerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: SSMCRUD
 * @description: 员工操作
 * @author: 张清
 * @create: 2019-07-20 16:04
 **/
@Controller
public class EmployerController {

    @Autowired
    private EmployerServices employerServices;
    /**
     * 查询员工数据
     * RequestParam:接收传入的pn值
     * */
    @RequestMapping("/emps")
    public String getemps(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
        Model model){
        PageHelper.startPage(pn,5);
        List<Employer> emps = employerServices.getAllEmployer();
//        for(Employer employer:emps){
//            System.out.println(employer);
//        }
        //PageInfo中包括有我们查询出来的数据
        PageInfo page = new PageInfo(emps,5);
        System.out.println(page);
        model.addAttribute("pageInfo",page);
        return "lis";
    }
    /**
     * 查询员工数据并且以json的格式返回
     * @return 查询到的数据以json格式返回
     * */
    @ResponseBody
    @RequestMapping("/empsJson")
    public Message getEmpsJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,8);
        List<Employer> emps = employerServices.getAllEmployer();
        PageInfo page = new PageInfo(emps,5);
        return Message.success().add("pageInfo",page);
    }
}
