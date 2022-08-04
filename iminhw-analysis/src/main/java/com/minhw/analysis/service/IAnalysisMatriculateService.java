package com.minhw.analysis.service;

import com.minhw.analysis.domain.AnalysisMatriculate;

import java.util.List;

/**
 * @program: iminhw-zsb
 * @description:
 * @author: MinHw
 * @create: 2022-08-04 14:16
 **/
public interface IAnalysisMatriculateService {


    /**
     * 获取统计信息
     * @param analysisMatriculate
     * @return
     */
    List<AnalysisMatriculate> selectAnalysisMatriculate(AnalysisMatriculate analysisMatriculate);
}
