package org.exh.epidemic_covid19_analyse_system.dao;

import org.exh.epidemic_covid19_analyse_system.entity.ProvinceRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
//Data access Object(DAO)层 用于底层数据的读取

@Repository
public interface ProvinceRecordDao {
    //查询所有国内疫情数据
    List<ProvinceRecord> selectList();
    //按照省份名查询所有国际疫情数据
    List<ProvinceRecord> selectListByPname(String pname);
    //按照省份名和时间查询所有疫情数据(此方法暂未使用)
    ProvinceRecord selectOneByPnameAndDate(ProvinceRecord provinceRecord);
}
