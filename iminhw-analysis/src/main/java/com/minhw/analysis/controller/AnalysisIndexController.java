package com.minhw.analysis.controller;

import com.minhw.analysis.service.IAnalysisIndexService;
import com.minhw.common.core.controller.BaseController;
import com.minhw.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: iminhw-zsb
 * @description:
 * @author: MinHw or mz
 * @create: 2022-08-11 14:21
 **/
@RestController
@RequestMapping("/analysis/index")
public class AnalysisIndexController extends BaseController {

    @Autowired
    private IAnalysisIndexService analysisIndexService;

    @GetMapping("/hpcount")
    @PreAuthorize("@ss.hasPermi('analysis:index:hpv')")
    public AjaxResult getHongPageCount() {
        return AjaxResult.success(analysisIndexService.selectSysHongPageVistCount());
    }

}
