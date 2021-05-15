package org.exh.epidemic_covid19_analyse_system.service;

import org.exh.epidemic_covid19_analyse_system.dao.ProvinceRecordDao;
import org.exh.epidemic_covid19_analyse_system.entity.ProvinceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service//Service层用于控制业务逻辑
public class ProvinceRecordService {

    @Autowired
    private ProvinceRecordDao dao;

    //查询所有省份疫情数据
    public List<ProvinceRecord> selectAll(){
        return dao.selectList();
    }
    //按照省份名搜索疫情数据
    public List<ProvinceRecord> selectListByPname(String pname){
        List<ProvinceRecord> recordList = dao.selectListByPname(pname);
//        System.out.println(recordList);
        return recordList;
    }
    //按照省份名和日期进行疫情数据的搜索
    public ProvinceRecord selectOneByPnameAndDate(String pname,String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date exactDate = sdf.parse(date);
            ProvinceRecord record = new ProvinceRecord();
            record.setPname(pname);
            record.setExactDate(exactDate);
            return dao.selectOneByPnameAndDate(record);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    //此方法用于控制前端输入的搜索词wd的业务逻辑判断 （包括控制布尔检索）
    public List<ProvinceRecord> retrieve(String wd){
        if(wd==null){
            return null;
        }
        wd = wd.trim();//去掉前后空格
        List<ProvinceRecord> recordList;
        if(wd.equals("")){//如果是空字符串则返回全部国外疫情记录
            return this.selectAll();
        }
        //如果包含AND 或者 OR 则进行布尔的检索
        if(wd.contains("or") || wd.contains("OR")
                || wd.contains("and") || wd.contains("AND")){
            String[] splitWd = wd.split(" ");
//            System.out.println(splitWd[0]+"\n"+splitWd[1]+"\n"+splitWd[2]);
            String keyWord1 = splitWd[0].trim();//获取第一个地点
            String keyWord2 = splitWd[2].trim();//获取第二个地点
            recordList = this.selectListByPname(keyWord1);
            System.out.println(recordList);
            recordList.addAll(this.selectListByPname(keyWord2));
            System.out.println(recordList);
        }else {//否则按照单独关键词进行搜索
            recordList = this.selectListByPname(wd);
        }

        return recordList;

    }
}
