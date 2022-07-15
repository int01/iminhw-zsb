package com.minhw.stu.controller;

import com.minhw.common.annotation.Log;
import com.minhw.common.core.controller.BaseController;
import com.minhw.common.core.domain.AjaxResult;
import com.minhw.common.core.page.TableDataInfo;
import com.minhw.common.enums.BusinessType;
import com.minhw.common.utils.poi.ExcelUtil;
import com.minhw.stu.domain.StuOutNotification;
import com.minhw.stu.domain.StuOutNotificationStylusPrinting;
import com.minhw.stu.service.IStuOutNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 通知书邮寄记录Controller
 *
 * @author iminhw
 * @date 2022-07-12
 */
@RestController
@RequestMapping("/stu/notification")
public class StuOutNotificationController extends BaseController {
    @Autowired
    private IStuOutNotificationService stuOutNotificationService;

    /**
     * 查询通知书邮寄记录列表
     */
    @PreAuthorize("@ss.hasPermi('stu:notification:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuOutNotification stuOutNotification) {
        startPage();
        List<StuOutNotification> list = stuOutNotificationService.selectStuOutNotificationList(stuOutNotification);
        return getDataTable(list);
    }

    /**
     * 导出通知书邮寄记录列表
     */
    @PreAuthorize("@ss.hasPermi('stu:notification:export')")
    @Log(title = "通知书邮寄记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuOutNotification stuOutNotification) {
        List<StuOutNotification> list = stuOutNotificationService.selectStuOutNotificationList(stuOutNotification);
        ExcelUtil<StuOutNotification> util = new ExcelUtil<StuOutNotification>(StuOutNotification.class);
        util.exportExcel(response, list, "通知书邮寄记录数据");
    }

    /**
     * 获取通知书邮寄记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('stu:notification:query')")
    @GetMapping(value = "/{ksh}")
    public AjaxResult getInfo(@PathVariable("ksh") String ksh) {
        return AjaxResult.success(stuOutNotificationService.selectStuOutNotificationByKsh(ksh));
    }

    /**
     * 新增通知书邮寄记录
     */
    @PreAuthorize("@ss.hasPermi('stu:notification:add')")
    @Log(title = "通知书邮寄记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuOutNotification stuOutNotification) {
        stuOutNotification.setCreateBy(getUsername());
        return toAjax(stuOutNotificationService.insertStuOutNotification(stuOutNotification));
    }

    /**
     * 修改通知书邮寄记录
     */
    @PreAuthorize("@ss.hasPermi('stu:notification:edit')")
    @Log(title = "通知书邮寄记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuOutNotification stuOutNotification) {
        stuOutNotification.setUpdateBy(getUsername());
        return toAjax(stuOutNotificationService.updateStuOutNotification(stuOutNotification));
    }

    /**
     * 删除通知书邮寄记录
     */
    @PreAuthorize("@ss.hasPermi('stu:notification:remove')")
    @Log(title = "通知书邮寄记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{kshs}")
    public AjaxResult remove(@PathVariable String[] kshs) {
        return toAjax(stuOutNotificationService.deleteStuOutNotificationByKshs(kshs));
    }


    /**
     * 热敏
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "通知书邮寄记录", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('stu:notification:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<StuOutNotification> util = new ExcelUtil<>(StuOutNotification.class);
        List<StuOutNotification> stuOutNotificationList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = stuOutNotificationService.importStuOutNotification(stuOutNotificationList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 热敏模版
     * @param response
     */
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<StuOutNotification> util = new ExcelUtil<>(StuOutNotification.class);
        util.importTemplateExcel(response, "通知书邮寄记录");
    }

    @Log(title = "通知书邮寄记录", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('stu:notification:import')")
    @PostMapping("/importStylusPrintingData")
    public AjaxResult imporStylusPrintingtData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<StuOutNotificationStylusPrinting> util = new ExcelUtil<>(StuOutNotificationStylusPrinting.class);
        List<StuOutNotificationStylusPrinting> stuOutNotificationStylusPrintingList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = stuOutNotificationService.importStuOutNotificationStylusPrinting(stuOutNotificationStylusPrintingList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 针
     * @param response
     */
    @PostMapping("/importStylusPrintingTemplate")
    public void importStylusPrintingTemplate(HttpServletResponse response) {
        ExcelUtil<StuOutNotificationStylusPrinting> util = new ExcelUtil<>(StuOutNotificationStylusPrinting.class);
        util.importTemplateExcel(response, "通知书邮寄记录");
    }
}
