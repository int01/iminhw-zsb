package com.minhw.web.controller.monitor;

import com.minhw.common.annotation.Log;
import com.minhw.common.core.controller.BaseController;
import com.minhw.common.core.domain.AjaxResult;
import com.minhw.common.core.page.TableDataInfo;
import com.minhw.common.enums.BusinessType;
import com.minhw.common.utils.poi.ExcelUtil;
import com.minhw.system.domain.SysHomeVisitLog;
import com.minhw.system.service.ISysHomeVisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: iminhw-zsb
 * @description:
 * @author: MinHw or mz
 * @create: 2022-07-15 20:14
 **/
@RestController
@RequestMapping("/monitor/homevisitlog")
public class SysHomeVisitLogController extends BaseController {
    @Autowired
    private ISysHomeVisitLogService homeVisitLogService;

    @PreAuthorize("@ss.hasPermi('monitor:homevisitlog:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysHomeVisitLog homeVisitLog) {
        startPage();
        List<SysHomeVisitLog> list = homeVisitLogService.selectHomeVisitLogList(homeVisitLog);
        return getDataTable(list);
    }

    @Log(title = "前台日志", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('monitor:homevisitlog:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysHomeVisitLog homeVisitLog) {
        List<SysHomeVisitLog> list = homeVisitLogService.selectHomeVisitLogList(homeVisitLog);
        ExcelUtil<SysHomeVisitLog> util = new ExcelUtil<>(SysHomeVisitLog.class);
        util.exportExcel(response, list, "前台日志");
    }

    @Log(title = "前台日志", businessType = BusinessType.DELETE)
    @PreAuthorize("@ss.hasPermi('monitor:homevisitlog:remove')")
    @DeleteMapping("/{visitIds}")
    public AjaxResult remove(@PathVariable Long[] visitIds) {
        return toAjax(homeVisitLogService.deleteHomeVisitLogByIds(visitIds));
    }

    @Log(title = "前台日志", businessType = BusinessType.CLEAN)
    @PreAuthorize("@ss.hasPermi('monitor:homevisitlog:remove')")
    @DeleteMapping("/clean")
    public AjaxResult clean() {
        homeVisitLogService.cleanHomeVisitLog();
        return AjaxResult.success();
    }
}
