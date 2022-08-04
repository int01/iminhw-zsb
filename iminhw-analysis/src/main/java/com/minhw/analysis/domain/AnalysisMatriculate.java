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

}
