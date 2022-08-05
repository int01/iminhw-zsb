package com.minhw.analysis.controller;

import com.minhw.analysis.domain.AnalysisMatriculate;
import com.minhw.analysis.service.IAnalysisMatriculateService;
import com.minhw.common.annotation.Log;
import com.minhw.common.core.controller.BaseController;
import com.minhw.common.core.page.TableDataInfo;
import com.minhw.common.enums.BusinessType;
import com.minhw.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: iminhw-zsb
 * @description:
 * @author: MinHw or mz
 * @create: 2022-08-04 14:18
 **/
@RestController
@RequestMapping("/analysis/matriculate")
public class AnalysisMatriculateController extends BaseController {

    @Autowired
    private IAnalysisMatriculateService analysisMatriculateService;


    @PreAuthorize("@ss.hasPermi('analysis:matriculate:list')")
    @GetMapping("/list")
    public TableDataInfo list(AnalysisMatriculate analysisMatriculate) {
        startPage();
        List<AnalysisMatriculate> list = analysisMatriculateService.selectAnalysisMatriculate(analysisMatriculate);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('analysis:matriculate:export')")
    @Log(title = "录取统计分析", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AnalysisMatriculate analysisMatriculate) {
        List<AnalysisMatriculate> list = analysisMatriculateService.selectAnalysisMatriculate(analysisMatriculate);
        ExcelUtil<AnalysisMatriculate> util = new ExcelUtil<>(AnalysisMatriculate.class);
        util.exportExcel(response, list, "录取数据统计");
    }
}
