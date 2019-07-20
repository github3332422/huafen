package edu.javaee.ssmcrud.test;

import java.util.List;

import edu.javaee.ssmcrud.bean.Employer;
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
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicatonContext.xml","classpath:springmvc-config.xml"})

public class MVCTest {
	@Autowired
	WebApplicationContext context;
	MockMvc mockMvc;
	@Before
	public void initMockMvc() {
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void testPage() throws Exception {
		MvcResult result=  mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
		MockHttpServletRequest request= result.getRequest();
		PageInfo p=(PageInfo) request.getAttribute("pageInfo");
		int []nums=p.getNavigatepageNums();
		for(int i:nums) {
			System.out.print(" --"+i);
		}
		List<Employer> list=p.getList();
		for(Employer employee :list) {
			System.out.println("ID:"+employee.getEmp_id()+"  Name"+employee.getEmp_name());;
			
		}
		
	}
}
