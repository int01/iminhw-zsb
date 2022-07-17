package com.minhw.stu.domain;

import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

/**
 * 录取数据对象 stu_matriculate
 *
 * @author iminhw
 * @date 2022-07-11
 */
public class StuMatriculate extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 考生号
     */
    @Excel(name = "考生号", prompt = "必填项")
    private String ksh;

    /**
     * 身份证号
     */
    @Excel(name = "身份证号")
    private String sfzh;

    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String xm;

    /**
     * 录取专业
     */
    @Excel(name = "录取专业")
    private String zy;

    @Excel(name= "序号")
    private String xh;

    /**
     * 联系电话
     */
    @Excel(name = "联系电话")
    private String lxdh;

    /**
     * 邮件地址
     */
    @Excel(name = "地址")
    private String dz;

    /**
     * 数据状态
     */
    @Excel(name = "数据状态", dictType = "data_status")
    private Long status;

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    //    @Override
//    public String toString() {
//        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
//            .append("ksh", getKsh())
//            .append("sfzh", getSfzh())
//            .append("xm", getXm())
//            .append("zy", getZy())
//            .append("lxdh", getLxdh())
//            .append("dz", getDz())
//            .append("status", getStatus())
//            .append("createBy", getCreateBy())
//            .append("updateBy", getUpdateBy())
//            .append("remark", getRemark())
//            .append("updateTime", getUpdateTime())
//            .append("createTime", getCreateTime())
//            .toString();
//    }

    @Override
    public String toString() {
        return "录取数据{" +
                "考生号='" + ksh + '\'' +
                ", 身份证号='" + sfzh + '\'' +
                ", 姓名='" + xm + '\'' +
                ", 专业='" + zy + '\'' +
                "，序号='" + xh + '\'' +
                ", 联系电话='" + lxdh + '\'' +
                ", 地址='" + dz + '\''
                ;
    }
}
