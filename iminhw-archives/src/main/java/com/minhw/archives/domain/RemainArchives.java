package com.minhw.archives.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

/**
 * 剩余档案对象 remain_archives
 * 
 * @author iminhw
 * @date 2022-07-11
 */
public class RemainArchives extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 序号 */
    @Excel(name = "序号")
    private Long xh;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 学年 */
    @Excel(name = "学年")
    private String nf;

    /** 考生号 */
    private String ksh;

    /** 身份证号 */
    private String sfzh;

    /** 班级 */
    private String bj;

    /** 数据状态 */
    @Excel(name = "数据状态", dictType = "data_status")
    private Long status;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remark;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setXh(Long xh) 
    {
        this.xh = xh;
    }

    public Long getXh() 
    {
        return xh;
    }
    public void setXm(String xm) 
    {
        this.xm = xm;
    }

    public String getXm() 
    {
        return xm;
    }
    public void setNf(String nf) 
    {
        this.nf = nf;
    }

    public String getNf() 
    {
        return nf;
    }
    public void setKsh(String ksh) 
    {
        this.ksh = ksh;
    }

    public String getKsh() 
    {
        return ksh;
    }
    public void setSfzh(String sfzh) 
    {
        this.sfzh = sfzh;
    }

    public String getSfzh() 
    {
        return sfzh;
    }
    public void setBj(String bj) 
    {
        this.bj = bj;
    }

    public String getBj() 
    {
        return bj;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("xh", getXh())
            .append("xm", getXm())
            .append("nf", getNf())
            .append("ksh", getKsh())
            .append("sfzh", getSfzh())
            .append("bj", getBj())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
