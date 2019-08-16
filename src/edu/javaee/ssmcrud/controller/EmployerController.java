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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
//        System.out.println(page);
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

    /**
     * 执行员工的添加
     * JSR303校验
     * */
    @ResponseBody
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public Message getEmpsWithJson(Employer employer){
        employerServices.saveEmp(employer);
        return Message.success();
    }

    /**
     * 检验邮箱是否可用
     * */
    @ResponseBody
    @RequestMapping("/checkuser")
    public Message cheakUser(@RequestParam("email") String email){
        //对数据进行校验
        String regx = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
        if(!email.matches(regx)){
            return Message.fail().add("va_msg","输入的邮箱格式错误");
        }
        //从数据库中查询
        boolean b = employerServices.cheakUser(email);
        if(b == true){
            return Message.success();
        }else{
            return Message.fail().add("va_msg","邮箱不可用");
        }
    }


    /**
     * 根据id查询用户信息
     * */
    @ResponseBody
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public Message getEmp(@PathVariable("id") Integer id){
        Employer employer = employerServices.getEmployer(id);
        return Message.success().add("emp",employer);
    }

    /**
     * 保存用户
     * */
    @ResponseBody
    @RequestMapping(value = "/emp/{emp_id}",method = RequestMethod.PUT)
    public Message saveEmp(Employer employer){
        employerServices.updataEmp(employer);
        return Message.success();
    }

    /**
     * 删除用户
     * */
//    @ResponseBody
//    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
//    public Message deleteEmpById(@PathVariable("id")Integer id ){
//        employerServices.deleteEmp(id);
//        return Message.success();
//    }
    @ResponseBody
    @RequestMapping(value = "/emp/{ids}",method = RequestMethod.DELETE)
    public Message deleteEmpById(@PathVariable("ids")String ids ){
        if(ids.contains("-")){
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            for (String string:str_ids){
                del_ids.add(Integer.parseInt(string));
            }
            employerServices.deleteBatch(del_ids);
        }else{
            Integer id = Integer.parseInt(ids);
            employerServices.deleteEmp(id);
        }
        return Message.success();
    }


}












