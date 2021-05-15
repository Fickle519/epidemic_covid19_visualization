package org.exh.epidemic_covid19_analyse_system.controller;

import org.apache.ibatis.session.SqlSession;
import org.exh.epidemic_covid19_analyse_system.entity.CosmopolitanRecord;
import org.exh.epidemic_covid19_analyse_system.service.CosmopolitanRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.HashMap;
import java.util.List;
//控制层对象:用于控制国内疫情数据的请求处理
@Controller
public class CosmopolitanRecordController {

    @Autowired//Spring提供的注解来把service层中对象的自动注入
    private CosmopolitanRecordService service;
    DispatcherServlet


    @RequestMapping("allCosmopolitan.do")//请求的资源名
    @ResponseBody//代表返回的对象被SpringMVC通过Jackson解析成JSON格式并返回浏览器
    public List<CosmopolitanRecord> findAllCos(){
        return service.selectAll();
    }

    @RequestMapping("CosmopolitanByCname.do")//请求的资源名
    @ResponseBody//代表返回的对象被SpringMVC通过Jackson解析成JSON格式并返回浏览器
    public List<CosmopolitanRecord> findCosByCname(@RequestParam("cname") String cname){
        return service.selectListByCname(cname);
    }

    @RequestMapping("CosmopolitanByCnameAndDate.do")//请求的资源名
    @ResponseBody//代表返回的对象被SpringMVC通过Jackson解析成JSON格式并返回浏览器
    public CosmopolitanRecord findCosByCnameAndDate(@RequestParam("cname") String cname,
                                                    @RequestParam("exactDate") String exactDate){
        return service.selectOneByCnameAndDate(cname,exactDate);
    }

    @RequestMapping("cosmopolitanRetrieve.do")//请求的资源名
    @ResponseBody//代表返回的对象被SpringMVC通过Jackson解析成JSON格式并返回浏览器
    public List<CosmopolitanRecord> retrieve(@RequestParam("wd") String wd){
        System.out.println("receive succeeded:"+wd);
        List<CosmopolitanRecord> recordList = service.retrieve(wd);
        return recordList;
    }
}
