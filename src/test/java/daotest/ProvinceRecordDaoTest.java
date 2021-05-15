package daotest;

import org.exh.epidemic_covid19_analyse_system.dao.ProvinceRecordDao;
import org.exh.epidemic_covid19_analyse_system.entity.CosmopolitanRecord;
import org.exh.epidemic_covid19_analyse_system.entity.ProvinceRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class ProvinceRecordDaoTest {
    //    自动注入dao层对象
    @Autowired
    private ProvinceRecordDao dao;
//    测试方法
    @Test
    public void testSelectList(){
        List<ProvinceRecord> provinceRecordList = dao.selectList();
        System.out.println(provinceRecordList);
    }
    //    测试方法
    @Test
    public void testSelectListByPname(){
        List<ProvinceRecord> provinceRecordList = dao.selectListByPname("河北");
        System.out.println(provinceRecordList);
    }
//    测试方法
    @Test
    public void testSelectListByPnameAndDate(){
        ProvinceRecord record = new ProvinceRecord();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String str="20201201";
        try {
            Date date = sdf.parse(str);
            record.setPname("四川");
            record.setExactDate(date);
            ProvinceRecord provinceRecord = dao.selectOneByPnameAndDate(record);
            System.out.println(provinceRecord);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
