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
    private Double maxTdcj;
    @Excel(name = "最低分")
    private Double minTdcj;
    @Excel(name = "平均分")
    private Double avgTdcj;

    /**
     * 人数
     */
    @Excel(name = "录取人数")
    private Long countNum;

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

    public Double getMaxTdcj() {
        return maxTdcj;
    }

    public void setMaxTdcj(Double maxTdcj) {
        this.maxTdcj = maxTdcj;
    }

    public Double getMinTdcj() {
        return minTdcj;
    }

    public void setMinTdcj(Double minTdcj) {
        this.minTdcj = minTdcj;
    }

    public Double getAvgTdcj() {
        return avgTdcj;
    }

    public void setAvgTdcj(Double avgTdcj) {
        this.avgTdcj = avgTdcj;
    }

    public Long getCountNum() {
        return countNum;
    }

    public void setCountNum(Long countNum) {
        this.countNum = countNum;
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
                ", maxTdcj=" + maxTdcj +
                ", minTdcj=" + minTdcj +
                ", avgTdcj=" + avgTdcj +
                ", countNum=" + countNum +
                '}';
    }
}
