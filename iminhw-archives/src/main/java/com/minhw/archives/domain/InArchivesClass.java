package com.minhw.archives.domain;

import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 档案收集对象 in_archives_class
 *
 * @author iminhw
 * @date 2022-07-09
 */
public class InArchivesClass extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    @Excel(name = "学号", prompt = "必填项")
    private String xuehao;

    /**
     * 序号
     */
    @Excel(name = "档案序号")
    private Long xh;

    /**
     * 班级
     */
    @Excel(name = "班级")
    private String bj;

    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String xm;

    /**
     * 档案状态
     */
    @Excel(name = "档案状态", dictType = "archives_class_status")
    private Long dazt;

    /**
     * 考生号
     */
    @Excel(name = "考生号")
    private String ksh;

    /**
     * 身份证号
     */
    @Excel(name = "身份证号")
    private String sfzh;

    /** 档案袋情况 */
//    @Excel(name = "档案袋情况", dictType= "class_file_cover_status")
    private Long dadqk;

    /**
     * 数据状态
     */
    @Excel(name = "数据状态", dictType = "data_status")
    private Long status;

    public String getXuehao() {
        return xuehao;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public Long getDazt() {
        return dazt;
    }

    public void setDazt(Long dazt) {
        this.dazt = dazt;
    }

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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getDadqk() {
        return dadqk;
    }

    public void setDadqk(Long dadqk) {
        this.dadqk = dadqk;
    }

    //    @Override
//    public String toString() {
//        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
//                .append("xuehao", getXuehao())
//                .append("xh", getXh())
//                .append("bj", getBj())
//                .append("xm", getXm())
//                .append("dazt", getDazt())
//                .append("ksh", getKsh())
//                .append("sfzh", getSfzh())
//                .append("status", getStatus())
//                .append("createBy", getCreateBy())
//                .append("updateBy", getUpdateBy())
//                .append("remark", getRemark())
//                .append("updateTime", getUpdateTime())
//                .append("createTime", getCreateTime())
//                .toString();
//    }

    @Override
    public String toString() {
        return "class{" +
                "学号='" + xuehao + '\'' +
                ", 档案序号=" + xh +
                ", 班级='" + bj + '\'' +
                ", 姓名='" + xm + '\'' +
                ", 档案状态=" + dazt +
                ", 考生号='" + ksh + '\'' +
                ", 身份证号='" + sfzh + '\'' +
                ", 数据状态=" + status +
                '}';
    }
}
