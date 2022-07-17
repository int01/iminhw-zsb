package com.minhw.stu.controller;

import com.minhw.common.annotation.Log;
import com.minhw.common.core.controller.BaseController;
import com.minhw.common.core.domain.AjaxResult;
import com.minhw.common.core.page.TableDataInfo;
import com.minhw.common.enums.BusinessType;
import com.minhw.common.utils.poi.ExcelUtil;
import com.minhw.stu.domain.ExportNotificationView;
import com.minhw.stu.service.IExportNotificationViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 通知书数据Controller
 *
 * @author iminhw
 * @date 2022-07-17
 */
@RestController
@RequestMapping("/stu/matview")
public class ExportNotificationViewController extends BaseController {
    @Autowired
    private IExportNotificationViewService exportNotificationViewService;

    /**
     * 查询通知书数据列表
     */
    @PreAuthorize("@ss.hasPermi('stu:matview:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExportNotificationView exportNotificationView) {
        startPage();
        List<ExportNotificationView> list = exportNotificationViewService.selectExportNotificationViewList(exportNotificationView);
        return getDataTable(list);
    }

    /**
     * 导出通知书数据列表
     */
    @PreAuthorize("@ss.hasPermi('stu:matview:export')")
    @Log(title = "通知书数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExportNotificationView exportNotificationView) {
        List<ExportNotificationView> list = exportNotificationViewService.selectExportNotificationViewList(exportNotificationView);
        ExcelUtil<ExportNotificationView> util = new ExcelUtil<ExportNotificationView>(ExportNotificationView.class);
        util.exportExcel(response, list, "通知书打印数据");
    }

    /**
     * 获取通知书数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('stu:matview:query')")
    @GetMapping(value = "/{xh}")
    public AjaxResult getInfo(@PathVariable("xh") String xh) {
        return AjaxResult.success(exportNotificationViewService.selectExportNotificationViewByXh(xh));
    }

}
