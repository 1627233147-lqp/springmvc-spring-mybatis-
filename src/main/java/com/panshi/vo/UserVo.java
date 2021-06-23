package com.panshi.vo;

import java.io.Serializable;
/**
 * @author lqp
 * @date 2021 6-20
 * @version 1.0
 */
public class UserVo implements Serializable {
    private int stuId;
    private String stuName;
    private String stuAge;
    private String stuSex;
    private  String stuFamily;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuFamily() {
        return stuFamily;
    }

    public void setStuFamily(String stuFamily) {
        this.stuFamily = stuFamily;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAge='" + stuAge + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuFamily='" + stuFamily + '\'' +
                '}';
    }
}
