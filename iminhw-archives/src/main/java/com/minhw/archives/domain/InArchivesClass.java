package com.minhw.archives.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 档案收集情况对象 in_archives_class
 *
 * @author iminhw
 * @date 2022-07-09
 */
public class InArchivesClass extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    @Excel(name = "学号")
    private String xuehao;

    /**
     * 序号
     */
    @Excel(name = "序号")
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
    @Excel(name = "档案状态")
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

    /**
     * 数据状态
     */
    @Excel(name = "数据状态")
    private Long status;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remarks;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间" , width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间" , width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
