package org.exh.epidemic_covid19_analyse_system.controller;

import org.exh.epidemic_covid19_analyse_system.entity.ProvinceRecord;
import org.exh.epidemic_covid19_analyse_system.service.ProvinceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
//控制层对象:用于控制国内疫情数据的请求处理
@Controller
public class ProvinceRecordController {

    @Autowired//Spring提供的注解来把service层中对象的自动注入
    private ProvinceRecordService service;

    @RequestMapping("allPro.do")//请求的资源名
    @ResponseBody//代表返回的对象被SpringMVC通过Jackson解析成JSON格式并返回浏览器
    public List<ProvinceRecord> findAllPro(){
        List<ProvinceRecord> records = service.selectAll();
        System.out.println(records);
        return records;
    }

    @RequestMapping("proByPname.do")//请求的资源名
    @ResponseBody//代表返回的对象被SpringMVC通过Jackson解析成JSON格式并返回浏览器
    public List<ProvinceRecord> findProByPname(@RequestParam("pname") String pname){
//        System.out.println(pname);
        List<ProvinceRecord> recordList = service.selectListByPname(pname);
        System.out.println(recordList);
        return recordList;
    }

    @RequestMapping("proByPnameAndDate.do")//请求的资源名
    @ResponseBody//代表返回的对象被SpringMVC通过Jackson解析成JSON格式并返回浏览器
    public ProvinceRecord findProByPnameAndDate(@RequestParam("pname") String pname,
                                                @RequestParam("exactDate") String exactDate){
        return service.selectOneByPnameAndDate(pname,exactDate);
    }

    @RequestMapping("demosticRetrieve.do")//请求的资源名
    @ResponseBody//代表返回的对象被SpringMVC通过Jackson解析成JSON格式并返回浏览器
    public List<ProvinceRecord> retrieve(@RequestParam("wd") String wd){
        System.out.println(wd);
        return service.retrieve(wd);
    }


}
