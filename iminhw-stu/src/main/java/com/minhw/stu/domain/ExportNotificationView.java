package com.minhw.stu.domain;

import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 通知书数据对象 export_notification_view
 *
 * @author iminhw
 * @date 2022-07-17
 */
public class ExportNotificationView extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @Excel(name = "序号")
    private String xh;

    @Excel(name = "地区")
    private String dq;

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
     * 姓名
     */
    @Excel(name = "姓名")
    private String xm;

    /**
     * 录取专业
     */
    @Excel(name = "录取专业")
    private String zy;

    /**
     * 学院
     */
    @Excel(name = "学院")
    private String xy;

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getXh() {
        return xh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh;
    }

    public String getKsh() {
        return ksh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXm() {
        return xm;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getZy() {
        return zy;
    }

    public void setXy(String xy) {
        this.xy = xy;
    }

    public String getXy() {
        return xy;
    }

    public String getDq() {
        return dq;
    }

    public void setDq(String dq) {
        this.dq = dq;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("xh", getXh())
                .append("dq", getDq())
                .append("ksh", getKsh())
                .append("sfzh", getSfzh())
                .append("xm", getXm())
                .append("zy", getZy())
                .append("xy", getXy())
                .append("createTime", getCreateTime())
                .toString();
    }
}
