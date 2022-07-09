package com.minhw.archives.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * ems邮寄记录对象 in_archives_ems
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

    /**
     * ems单号
     */
    @Excel(name = "ems单号")
    private String kddh;

    /**
     * 袋内是否有档案
     */
    @Excel(name = "袋内是否有档案")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "更新时间" , width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间" , width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

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
