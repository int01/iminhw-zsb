package com.minhw.analysis.mapper;

import com.minhw.analysis.domain.AnalysisIndex;
import com.minhw.analysis.domain.AnalysisMatriculate;

import java.util.List;

/**
 * @program: iminhw-zsb
 * @description:
 * @author: MinHw
 * @create: 2022-08-10 22:40
 **/
public interface AnalysisIndexMapper {

    List<AnalysisIndex> selectSysHongPageVistCount();
}
