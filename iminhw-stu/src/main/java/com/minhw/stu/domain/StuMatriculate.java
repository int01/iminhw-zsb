package com.minhw.stu.domain;

import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 录取数据对象 stu_matriculate
 *
 * @author iminhw
 * @date 2022-08-01
 */
public class StuMatriculate extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 考生号
     */
    @Excel(name = "考生号", prompt = "必填项")
    private String ksh;

    /**
     * 身份证号
     */
    @Excel(name = "身份证号")
    private String sfzh;

    @Excel(name = "序号")
    private String xh;

    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String xm;

    /**
     * 性别
     */
    @Excel(name = "性别", dictType = "sys_user_sex")
    private Long xb;

    /**
     * 录取专业
     */
    @Excel(name = "录取专业")
    private String zy;

    /**
     * 录取电话
     */
    @Excel(name = "录取电话")
    private String lxdh;

    /**
     * 省份
     */
    @Excel(name = "省份")
    private String dq;


    /**
     * 邮寄地址
     */
    @Excel(name = "邮寄地址")
    private String dz;
    /**
     * 批次
     */
    @Excel(name = "批次", dictType="matriculate_pc")
    private Long pc;
    /**
     * 科类
     */
    @Excel(name = "科类", dictType="matriculate_kl")
    private Long kl;

    /**
     * 中学名称
     */
    @Excel(name = "中学名称")
    private String zxmc;

    /**
     * 投档成绩
     */
    @Excel(name = "投档成绩")
    private Long tdcj;

    /**
     * 数据状态
     */
    @Excel(name = "数据状态", dictType = "data_status")
    private Long status;

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

    public void setXb(Long xb) {
        this.xb = xb;
    }

    public Long getXb() {
        return xb;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getZy() {
        return zy;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getDz() {
        return dz;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getXh() {
        return xh;
    }

    public void setDq(String dq) {
        this.dq = dq;
    }

    public String getDq() {
        return dq;
    }

    public void setPc(Long pc) {
        this.pc = pc;
    }

    public Long getPc() {
        return pc;
    }

    public void setKl(Long kl) {
        this.kl = kl;
    }

    public Long getKl() {
        return kl;
    }

    public void setZxmc(String zxmc) {
        this.zxmc = zxmc;
    }

    public String getZxmc() {
        return zxmc;
    }

    public void setTdcj(Long tdcj) {
        this.tdcj = tdcj;
    }

    public Long getTdcj() {
        return tdcj;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("ksh", getKsh())
                .append("sfzh", getSfzh())
                .append("xm", getXm())
                .append("xb", getXb())
                .append("zy", getZy())
                .append("lxdh", getLxdh())
                .append("dz", getDz())
                .append("xh", getXh())
                .append("dq", getDq())
                .append("pc", getPc())
                .append("kl", getKl())
                .append("zxmc", getZxmc())
                .append("tdcj", getTdcj())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("remark", getRemark())
                .append("updateTime", getUpdateTime())
                .append("createTime", getCreateTime())
                .toString();
    }
}
