package daotest;


import org.exh.epidemic_covid19_analyse_system.dao.CosmopolitanRecordDao;
import org.exh.epidemic_covid19_analyse_system.entity.CosmopolitanRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
* 此类用于进行测试底层Dao的方式是否可以使用的测试类
* 第一个@RunWith注解是让Spring加载单元测试工具类
* 第二个@ContextConfiguration是告知读取Spring的配置文件并获取其中的bean对象(因为Dao层依赖Mybatis框架
* 而MyBatis的使用由Spring进行管控)*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
public class CosmopolitanRecordDaoTest {

//    自动注入dao层对象
    @Autowired
    private CosmopolitanRecordDao dao;
//    测试方法
    @Test
    public void testSelectList(){
        List<CosmopolitanRecord> cosmopolitanRecordList = dao.selectList();
        System.out.println(cosmopolitanRecordList);
    }
//    测试方法

    @Test
    public void testSelectListByCname(){
        List<CosmopolitanRecord> cosmopolitanRecordList = dao.selectListByCname("美国");
        System.out.println(cosmopolitanRecordList);
    }
//    测试方法
    @Test
    public void testSelectOneByCnameAndDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String str="20201201";
        try {
            Date date = sdf.parse(str);
            CosmopolitanRecord record = new CosmopolitanRecord();
            record.setCname("美国");
            record.setExactDate(date);
            CosmopolitanRecord cosmopolitanRecord = dao.selectOneByCnameAndDate(record);
            System.out.println(cosmopolitanRecord);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
