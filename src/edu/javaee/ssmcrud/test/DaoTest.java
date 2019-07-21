package edu.javaee.ssmcrud.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.javaee.ssmcrud.bean.Department;
import edu.javaee.ssmcrud.bean.Employer;
import edu.javaee.ssmcrud.dao.DepartmentMapper;
import edu.javaee.ssmcrud.dao.EmployerMapper;
import edu.javaee.ssmcrud.services.EmployerServices;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * @program: SSMCRUD
 * @description: 数据库操作类测试
 * @author: 张清
 * @create: 2019-07-19 13:51
 * 1:导入SpringTest模块
 * 2.@ContextConfiguration指定Spring配置文件的位置
 * 3.直接使用autowired的组件
 **/
//指定测试
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:applicatonContext.xml"))
public class DaoTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployerMapper employerMapper;
    @Autowired
    EmployerServices employerServices;
    @Autowired
    SqlSession sqlSession;
//    public static void main(String args[])
    //使用junit测试的时候需要加入junit-4.12.jar
    /**
     * 测试DepartmentMapper
     * */
    @Test
    public void testDepart(){
//        //创建Spring IOC容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicatonContext.xml");
//        //取的mapper
//        DepartmentMapper departmentMapper = applicationContext.getBean(DepartmentMapper.class);
//        System.out.println(departmentMapper);
//        //插入
//        departmentMapper.insertSelective(new Department(null,"开发部"));
//        departmentMapper.insertSelective(new Department(null,"测试部"));
//        //测试员工插入
//        employerMapper.insertSelective(new Employer(null,"张清","M","47666@qq.com",2));

        //批量插入
        EmployerMapper employerMapper = sqlSession.getMapper(EmployerMapper.class);
//        for(int i = 0 ; i < 1000 ; i ++){
//            String uid = UUID.randomUUID().toString().substring(0,5);
//            employerMapper.insertSelective(new Employer(null,uid+"","M",uid + "@qq.com",2));
//        }
//        List<Employer> employers = employerServices.getAllEmployer();
//        for(Employer employer:employers)
//        {
//            System.out.println(employer);
//        }

        PageHelper.startPage(1,5);
        List<Employer> employers = employerServices.getAllEmployer();
        for (Employer employer:employers){
            System.out.println(employer);
        }
        PageInfo pi = new PageInfo(employers,5);
//        PageInfo<Employer> pi = new PageInfo<>(employers);
        System.out.println(pi.getPageNum() + "\t" + pi.getPages() + "\t" + pi.getTotal());
    }
}
