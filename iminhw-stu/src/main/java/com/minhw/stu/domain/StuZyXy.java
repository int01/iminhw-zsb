package com.minhw.stu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

/**
 * 专业学院配置对象 stu_zy_xy
 *
 * @author iminhw
 * @date 2022-07-17
 */
public class StuZyXy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专业 */
    @Excel(name = "专业")
    private String zy;

    /** 学院 */
    @Excel(name = "学院")
    private String xy;

    /** 数据状态 */
    @Excel(name = "数据状态")
    private Long status;

    public void setZy(String zy)
    {
        this.zy = zy;
    }

    public String getZy()
    {
        return zy;
    }
    public void setXy(String xy)
    {
        this.xy = xy;
    }

    public String getXy()
    {
        return xy;
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
                .append("zy", getZy())
                .append("xy", getXy())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("remark", getRemark())
                .append("updateTime", getUpdateTime())
                .append("createTime", getCreateTime())
                .toString();
    }
}
