package com.minhw.analysis.service;

import com.minhw.analysis.domain.AnalysisIndex;

import java.util.List;

/**
 * @program: iminhw-zsb
 * @description:
 * @author: MinHw
 * @create: 2022-08-11 14:33
 **/
public interface IAnalysisIndexService {

    List<AnalysisIndex> selectSysHongPageVistCount();
}
