package com.minhw.archives.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

/**
 * 档案收录缓存对象 in_archives_class_temp
 * 
 * @author iminhw
 * @date 2022-07-09
 */
public class InArchivesClassTemp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 学号 */
    @Excel(name = "学号")
    private String xuehao;

    /** 序号 */
    @Excel(name = "序号")
    private Long xh;

    /** 班级 */
    @Excel(name = "班级")
    private String bj;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 考生号 */
    @Excel(name = "考生号")
    private String ksh;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String sfzh;

    /** 数据状态 */
    @Excel(name = "数据状态")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setXuehao(String xuehao) 
    {
        this.xuehao = xuehao;
    }

    public String getXuehao() 
    {
        return xuehao;
    }
    public void setXh(Long xh) 
    {
        this.xh = xh;
    }

    public Long getXh() 
    {
        return xh;
    }
    public void setBj(String bj) 
    {
        this.bj = bj;
    }

    public String getBj() 
    {
        return bj;
    }
    public void setXm(String xm) 
    {
        this.xm = xm;
    }

    public String getXm() 
    {
        return xm;
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
            .append("xuehao", getXuehao())
            .append("xh", getXh())
            .append("bj", getBj())
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
