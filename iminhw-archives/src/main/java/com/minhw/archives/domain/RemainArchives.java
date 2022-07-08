package com.minhw.archives.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
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
private static final long serialVersionUID=1L;

    /** id */
    private Long id;

    /** 姓名 */
            @Excel(name = "姓名")
    private String xm;

    /** 学年/学年 */
            @Excel(name = "学年/学年")
    private String nf;

    /** 身份证号码 */
            @Excel(name = "身份证号码")
    private String sfzhm;

    /** 班级 */
            @Excel(name = "班级")
    private String bj;

    /** 数据状态 */
            @Excel(name = "数据状态")
    private Long state;

    /** 备注 */
            @Excel(name = "备注")
    private String remarks;

    /** 更新时间 */
            @JsonFormat(pattern = "yyyy-MM-dd")
            @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 创建时间 */
            @JsonFormat(pattern = "yyyy-MM-dd")
            @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

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
    public void setState(Long state)
            {
            this.state = state;
            }

    public Long getState()
            {
            return state;
            }
    public void setRemarks(String remarks)
            {
            this.remarks = remarks;
            }

    public String getRemarks()
            {
            return remarks;
            }
    public void setUpdateDate(Date updateDate)
            {
            this.updateDate = updateDate;
            }

    public Date getUpdateDate()
            {
            return updateDate;
            }
    public void setCreateDate(Date createDate)
            {
            this.createDate = createDate;
            }

    public Date getCreateDate()
            {
            return createDate;
            }

@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id",getId())
            .append("xm",getXm())
            .append("nf",getNf())
            .append("sfzhm",getSfzhm())
            .append("bj",getBj())
            .append("state",getState())
            .append("createBy",getCreateBy())
            .append("updateBy",getUpdateBy())
            .append("remarks",getRemarks())
            .append("updateDate",getUpdateDate())
            .append("createDate",getCreateDate())
        .toString();
        }
        }
