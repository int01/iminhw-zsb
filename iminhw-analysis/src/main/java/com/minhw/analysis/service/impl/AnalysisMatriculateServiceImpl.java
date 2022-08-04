package com.minhw.analysis.service.impl;

import com.minhw.analysis.domain.AnalysisMatriculate;
import com.minhw.analysis.mapper.AnalysisMatriculateMapper;
import com.minhw.analysis.service.IAnalysisMatriculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: iminhw-zsb
 * @description:
 * @author: MinHw or mz
 * @create: 2022-08-04 14:16
 **/
@Service
public class AnalysisMatriculateServiceImpl implements IAnalysisMatriculateService {

    @Autowired
    private AnalysisMatriculateMapper analysisMatriculateMapper;

    @Override
    public List<AnalysisMatriculate> selectAnalysisMatriculate(AnalysisMatriculate analysisMatriculate) {
        return analysisMatriculateMapper.selectAnalysisMatriculate(analysisMatriculate);
    }
}
