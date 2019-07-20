package edu.javaee.ssmcrud.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: SSMCRUD
 * @description: 逆向生成实体类和Mapper文件
 * @author: 张清
 * @create: 2019-07-19 10:25
 **/
public class MBGTest {
    public static void main(String args[])throws Exception{
        /**
         * 生成带注释的
         * */
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("F:\\Java代码\\SSMCRUD\\conf\\mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        /**
         * 生成不带注释的
         * http://www.mybatis.org/generator/configreference/commentGenerator.html
         * 在配置文件中加入如下代码
         * <commentGenerator>
         *   <property name="suppressDate" value="true" />
         * </commentGenerator>
         * */

    }
}
