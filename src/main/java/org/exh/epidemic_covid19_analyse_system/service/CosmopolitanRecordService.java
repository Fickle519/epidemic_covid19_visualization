package org.exh.epidemic_covid19_analyse_system.service;

import org.exh.epidemic_covid19_analyse_system.dao.CosmopolitanRecordDao;
import org.exh.epidemic_covid19_analyse_system.entity.CosmopolitanRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service//Service层用于控制业务逻辑
public class CosmopolitanRecordService {

    @Autowired
    private CosmopolitanRecordDao dao;
    //查询所有国际疫情数据
    public List<CosmopolitanRecord> selectAll(){
        return dao.selectList();
    }
    //按照国家名搜索疫情数据
    public List<CosmopolitanRecord> selectListByCname(String cname){
        return dao.selectListByCname(cname);
    }
    //按照国家名和日期进行疫情数据的搜索
    public CosmopolitanRecord selectOneByCnameAndDate(String cname,String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//格式化日期对象
        try {
            Date exactDate = sdf.parse(date);
            CosmopolitanRecord record = new CosmopolitanRecord();
            record.setCname(cname);
            record.setExactDate(exactDate);
            return dao.selectOneByCnameAndDate(record);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    //此方法用于控制前端输入的搜索词wd的业务逻辑判断 （包括控制布尔检索）
    public List<CosmopolitanRecord> retrieve(String wd){
        if(wd==null){
            return null;
        }
        wd = wd.trim();//去掉前后空格
        List<CosmopolitanRecord> recordList;
        if(wd.equals("")){//如果是空字符串则返回全部国外疫情记录
            return this.selectAll();
        }
        //如果包含AND 或者 OR 则进行布尔的检索
        if(wd.contains("or") || wd.contains("OR")
        || wd.contains("and") || wd.contains("AND")){
            String[] splitWd = wd.split(" ");//分割字符串
//            System.out.println(splitWd[0]+"\n"+splitWd[1]+"\n"+splitWd[2]);
            String keyWord1 = splitWd[0].trim();//获取第一个地点
            String keyWord2 = splitWd[2].trim();//获取第二个地点
            recordList = this.selectListByCname(keyWord1);
            System.out.println(recordList);
            recordList.addAll(this.selectListByCname(keyWord2));
            System.out.println(recordList);
        }else {//否则按照单独关键词进行搜索
            recordList = this.selectListByCname(wd);
        }
        return recordList;

    }
}

