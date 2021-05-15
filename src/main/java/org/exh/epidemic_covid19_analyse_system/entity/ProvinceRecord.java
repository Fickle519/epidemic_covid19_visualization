package org.exh.epidemic_covid19_analyse_system.entity;


import java.util.Date;
//entity(domain)实体对象，用于省份疫情对象的存储
public class ProvinceRecord {

    private String pname;//国家名
    private Date exactDate;//日期
    private int totalNum;//累计确诊
    private int healedNum;//累计治愈
    private int deadNum;//累计死亡
    private int increasedNum;//当日新增
    //无参数构造方法
    public ProvinceRecord() {
    }
    //有参数构造方法
    public ProvinceRecord(String pname, Date exactDate, int totalNum, int healedNum, int deadNum, int increasedNum) {
        this.pname = pname;
        this.exactDate = exactDate;
        this.totalNum = totalNum;
        this.healedNum = healedNum;
        this.deadNum = deadNum;
        this.increasedNum = increasedNum;
    }

    //对象toString方法
    @Override
    public String toString() {
        return "ProvinceRecord{" +
                "pname='" + pname + '\'' +
                ", exactDate=" + exactDate +
                ", totalNum=" + totalNum +
                ", healedNum=" + healedNum +
                ", deadNum=" + deadNum +
                ", increasedNum=" + increasedNum +
                '}';
    }

    //属性对应的get/set方法（名字不可以修改因为框架底层通过反射获取属性对应的get/set方法）
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Date getExactDate() {
        return exactDate;
    }

    public void setExactDate(Date exactDate) {
        this.exactDate = exactDate;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getHealedNum() {
        return healedNum;
    }

    public void setHealedNum(int healedNum) {
        this.healedNum = healedNum;
    }

    public int getDeadNum() {
        return deadNum;
    }

    public void setDeadNum(int deadNum) {
        this.deadNum = deadNum;
    }

    public int getIncreasedNum() {
        return increasedNum;
    }

    public void setIncreasedNum(int increasedNum) {
        this.increasedNum = increasedNum;
    }
}
