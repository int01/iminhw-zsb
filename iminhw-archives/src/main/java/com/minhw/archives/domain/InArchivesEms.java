package com.minhw.archives.domain;

import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 邮寄档案对象 in_archives_ems
 *
 * @author iminhw
 * @date 2022-07-09
 */
public class InArchivesEms extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    @Excel(name = "快递序号")
    private Long xh;

    /**
     * 快递单号
     */
    @Excel(name = "快递单号")
    private String kddh;

    /**
     * 签收验证
     */
    @Excel(name = "签收验证", dictType = "ems_validated")
    private Long qsyz;

    /**
     * 是否档案
     */
    @Excel(name = "是否档案", dictType = "in_archives_ems_danan")
    private Long sfda;

    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String xm;

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
//    @Excel(name = "档案袋情况")
    private Integer dadqk;

    /**
     * 数据状态
     */
    @Excel(name = "数据状态", dictType = "data_status")
    private Long status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKddh() {
        return kddh;
    }

    public void setKddh(String kddh) {
        this.kddh = kddh;
    }

    public Long getQsyz() {
        return qsyz;
    }

    public void setQsyz(Long qsyz) {
        this.qsyz = qsyz;
    }

    public Long getSfda() {
        return sfda;
    }

    public void setSfda(Long sfda) {
        this.sfda = sfda;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
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

    public Long getXh() {
        return xh;
    }

    public void setXh(Long xh) {
        this.xh = xh;
    }

    public Integer getDadqk() {
        return dadqk;
    }

    public void setDadqk(Integer dadqk) {
        this.dadqk = dadqk;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("xh", getXh())
                .append("kddh", getKddh())
                .append("qsyz", getQsyz())
                .append("sfda", getSfda())
                .append("xm", getXm())
                .append("ksh", getKsh())
                .append("sfzh", getSfzh())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("remark", getRemark())
                .append("updateTime", getUpdateTime())
                .append("createTime", getCreateTime())
                .toString();
    }
}
