package com.minhw.analysis.domain;

import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

/**
 * 录取数据对象 stu_matriculate 统计
 *
 * @author iminhw
 * @date 2022-08-04
 */
public class AnalysisMatriculate extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 年度
     */
    @Excel(name = "年度")
    private String nd;

    /**
     * 省份
     */
    @Excel(name = "省份")
    private String dq;

    /**
     * 批次
     */
    @Excel(name = "批次", dictType = "matriculate_pc")
    private Long pc;
    /**
     * 科类
     */
    @Excel(name = "科类", dictType = "matriculate_kl")
    private Long kl;

    /**
     * 录取专业
     */
    @Excel(name = "录取专业")
    private String zy;

    /**
     * 中学名称
     */
    @Excel(name = "中学名称")
    private String zxmc;

    /**
     * 投档成绩
     */
    @Excel(name = "最高分")
    private Double maxtdcj;
    @Excel(name = "最低分")
    private Double mintdcj;
    @Excel(name = "平均分")
    private Double avgtdcj;

    /**
     * 人数
     */
    @Excel(name = "录取人数")
    private Long countnum;

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getDq() {
        return dq;
    }

    public void setDq(String dq) {
        this.dq = dq;
    }

    public Long getPc() {
        return pc;
    }

    public void setPc(Long pc) {
        this.pc = pc;
    }

    public Long getKl() {
        return kl;
    }

    public void setKl(Long kl) {
        this.kl = kl;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getZxmc() {
        return zxmc;
    }

    public void setZxmc(String zxmc) {
        this.zxmc = zxmc;
    }

    public Double getMaxtdcj() {
        return maxtdcj;
    }

    public void setMaxtdcj(Double maxtdcj) {
        this.maxtdcj = maxtdcj;
    }

    public Double getMintdcj() {
        return mintdcj;
    }

    public void setMintdcj(Double mintdcj) {
        this.mintdcj = mintdcj;
    }

    public Double getAvgtdcj() {
        return avgtdcj;
    }

    public void setAvgtdcj(Double avgtdcj) {
        this.avgtdcj = avgtdcj;
    }

    public Long getCountnum() {
        return countnum;
    }

    public void setCountnum(Long countnum) {
        this.countnum = countnum;
    }

    @Override
    public String toString() {
        return "AnalysisMatriculate{" +
                "nd='" + nd + '\'' +
                ", dq='" + dq + '\'' +
                ", pc=" + pc +
                ", kl=" + kl +
                ", zy='" + zy + '\'' +
                ", zxmc='" + zxmc + '\'' +
                ", maxtdcj=" + maxtdcj +
                ", mintdcj=" + mintdcj +
                ", avgtdcj=" + avgtdcj +
                ", countnum=" + countnum +
                '}';
    }
}
