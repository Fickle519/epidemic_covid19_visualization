package org.exh.epidemic_covid19_analyse_system.dao;

import org.exh.epidemic_covid19_analyse_system.entity.CosmopolitanRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
//Data access Object(DAO)层 用于底层数据的读取
@Repository
public interface CosmopolitanRecordDao {
    //查询所有国际疫情数据
    List<CosmopolitanRecord> selectList();
    //按照国家名查询所有国际疫情数据
    List<CosmopolitanRecord> selectListByCname(String cname);
    //按照国家名和时间查询所有疫情数据(此方法暂未使用)
    CosmopolitanRecord selectOneByCnameAndDate(CosmopolitanRecord cosmopolitanRecord);


}



