package servicetest;

import org.exh.epidemic_covid19_analyse_system.entity.CosmopolitanRecord;
import org.exh.epidemic_covid19_analyse_system.service.CosmopolitanRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
/*
 * 此类用于进行测试Service层检索的方式是否可以使用的测试类
 * 第一个@RunWith注解是让Spring加载单元测试工具类
 * 第二个@ContextConfiguration是告知读取Spring的配置文件并获取其中的bean对象(因为Dao层依赖Mybatis框架
 * 而MyBatis的使用由Spring进行管控)*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
public class CosmopolitanServiceTest {
    @Autowired
    private CosmopolitanRecordService service;

    @Test
    public void testRetrieve(){
        List<CosmopolitanRecord> recordList = service.retrieve("美国 or 英国");
        System.out.println(recordList);
    }
}
