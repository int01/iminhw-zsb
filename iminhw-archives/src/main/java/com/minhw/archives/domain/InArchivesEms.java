package com.minhw.archives.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

/**
 * ems邮寄记录对象 in_archives_ems
 *
 * @author iminhw
 * @date 2022-07-09
 */
public class InArchivesEms extends BaseEntity
        {
private static final long serialVersionUID=1L;

    /** 主键 */
    private Long id;

    /** ems单号 */
            @Excel(name = "ems单号")
    private String kddh;

    /** 袋内是否有档案 */
            @Excel(name = "袋内是否有档案")
    private Long sfda;

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
    public void setKddh(String kddh)
            {
            this.kddh = kddh;
            }

    public String getKddh()
            {
            return kddh;
            }
    public void setSfda(Long sfda)
            {
            this.sfda = sfda;
            }

    public Long getSfda()
            {
            return sfda;
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
            .append("kddh",getKddh())
            .append("sfda",getSfda())
            .append("xm",getXm())
            .append("ksh",getKsh())
            .append("sfzh",getSfzh())
            .append("state",getState())
            .append("createBy",getCreateBy())
            .append("updateBy",getUpdateBy())
            .append("remarks",getRemarks())
            .append("updateDate",getUpdateDate())
            .append("createDate",getCreateDate())
        .toString();
        }
        }
