package com.minhw.archives.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

/**
 * 剩余档案对象 remain_archives
 * 
 * @author iminhw
 * @date 2022-07-09
 */
public class RemainArchives extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 学年/学年 */
    @Excel(name = "学年")
    private String nf;

    /** 身份证号码 */
    @Excel(name = "身份证号")
    private String sfzhm;

    /** 班级 */
    @Excel(name = "班级")
    private String bj;

    /** 数据状态 */
    @Excel(name = "数据状态", dictType = "data_status")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setSfzhm(String sfzhm) 
    {
        this.sfzhm = sfzhm;
    }

    public String getSfzhm() 
    {
        return sfzhm;
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
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("xm", getXm())
            .append("nf", getNf())
            .append("sfzhm", getSfzhm())
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
