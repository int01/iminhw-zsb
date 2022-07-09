package com.minhw.archives.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 剩余档案对象 remain_archives
 *
 * @author iminhw
 * @date 2022-07-09
 */
public class RemainArchives extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String xm;

    /**
     * 学年/学年
     */
    @Excel(name = "学年/学年")
    private String nf;

    /**
     * 身份证号码
     */
    @Excel(name = "身份证号码")
    private String sfzhm;

    /**
     * 班级
     */
    @Excel(name = "班级")
    private String bj;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getNf() {
        return nf;
    }

    public void setNf(String nf) {
        this.nf = nf;
    }

    public String getSfzhm() {
        return sfzhm;
    }

    public void setSfzhm(String sfzhm) {
        this.sfzhm = sfzhm;
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj;
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
