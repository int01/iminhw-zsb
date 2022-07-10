package com.minhw.stu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

/**
 * 录取数据对象 stu_matriculate
 * 
 * @author iminhw
 * @date 2022-07-11
 */
public class StuMatriculate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 考生号 */
    @Excel(name = "考生号")
    private String ksh;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String sfzh;

    /** 姓名 */
    @Excel(name = "姓名")
    private String xm;

    /** 录取专业 */
    @Excel(name = "录取专业")
    private String zy;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String lxdh;

    /** 邮件地址 */
    @Excel(name = "邮件地址")
    private String dz;

    /** 数据状态 */
    @Excel(name = "数据状态")
    private Long status;

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
    public void setXm(String xm) 
    {
        this.xm = xm;
    }

    public String getXm() 
    {
        return xm;
    }
    public void setZy(String zy) 
    {
        this.zy = zy;
    }

    public String getZy() 
    {
        return zy;
    }
    public void setLxdh(String lxdh) 
    {
        this.lxdh = lxdh;
    }

    public String getLxdh() 
    {
        return lxdh;
    }
    public void setDz(String dz) 
    {
        this.dz = dz;
    }

    public String getDz() 
    {
        return dz;
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
            .append("ksh", getKsh())
            .append("sfzh", getSfzh())
            .append("xm", getXm())
            .append("zy", getZy())
            .append("lxdh", getLxdh())
            .append("dz", getDz())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
