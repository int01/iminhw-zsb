package com.minhw.analysis.service.impl;

import com.minhw.analysis.domain.AnalysisIndex;
import com.minhw.analysis.mapper.AnalysisIndexMapper;
import com.minhw.analysis.service.IAnalysisIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: iminhw-zsb
 * @description:
 * @author: MinHw or mz
 * @create: 2022-08-11 14:33
 **/
@Service
public class AnalysisIndexServiceImp implements IAnalysisIndexService {

    @Autowired
    private AnalysisIndexMapper analysisIndexMapper;

    @Override
    public List<AnalysisIndex> selectSysHongPageVistCount() {
        return analysisIndexMapper.selectSysHongPageVistCount();
    }
}
