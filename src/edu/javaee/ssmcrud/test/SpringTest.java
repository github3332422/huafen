package edu.javaee.ssmcrud.test;

import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
/**
 * @program: SSMCRUD
 * @description: 使用Spring提供的单元测试看看我们写的是否好用
 * @author: 张清
 * @create: 2019-07-20 16:35
 **/
@RunWith(value = SpringJUnit4ClassRunner.class)
@WebAppConfiguration //不加这个的话无法获取到 WebApplicationContext 这个容器
@ContextConfiguration(locations = {"classpath:applicatonContext.xml","file:F:\\Java代码\\SSMCRUD\\conf\\springmvc-config.xml"})
public class SpringTest {
    //传入SpringMVC的IOC容器
    @Autowired
    WebApplicationContext webApplicationContext;
    //虚拟的MVC请求，获取到处理信息
    MockMvc mockMvc;
    @Before
    public void initMockMvc(){
        MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testPage()throws Exception{

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "2")).andReturn();
        //填写默认返回的快捷键是 ctrl + alt + v
        MockHttpServletRequest request = mvcResult.getRequest();
        PageInfo pageinfo = (PageInfo)request.getAttribute("pageInfo");
        System.out.println("总共页码" + pageinfo.getPageNum() + "当前页码" + pageinfo.getPages() + "总的记录数" +pageinfo.getTotal() +pageinfo);

    }
}

