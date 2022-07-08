package com.minhw.archives.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.minhw.common.annotation.Log;
import com.minhw.common.core.controller.BaseController;
import com.minhw.common.core.domain.AjaxResult;
import com.minhw.common.enums.BusinessType;
import com.minhw.archives.domain.InArchivesEms;
import com.minhw.archives.service.IInArchivesEmsService;
import com.minhw.common.utils.poi.ExcelUtil;
import com.minhw.common.core.page.TableDataInfo;

/**
 * ems邮寄记录Controller
 *
 * @author iminhw
 * @date 2022-07-09
 */
@RestController
@RequestMapping("/archives/ems")
public class InArchivesEmsController extends BaseController {
    @Autowired
    private IInArchivesEmsService inArchivesEmsService;

/**
 * 查询ems邮寄记录列表
 */
@PreAuthorize("@ss.hasPermi('archives:ems:list')")
@GetMapping("/list")
    public TableDataInfo list(InArchivesEms inArchivesEms) {
        startPage();
        List<InArchivesEms> list = inArchivesEmsService.selectInArchivesEmsList(inArchivesEms);
        return getDataTable(list);
    }

    /**
     * 导出ems邮寄记录列表
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:export')")
    @Log(title = "ems邮寄记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InArchivesEms inArchivesEms) {
        List<InArchivesEms> list = inArchivesEmsService.selectInArchivesEmsList(inArchivesEms);
        ExcelUtil<InArchivesEms> util = new ExcelUtil<InArchivesEms>(InArchivesEms. class);
        util.exportExcel(response, list, "ems邮寄记录数据");
    }

    /**
     * 获取ems邮寄记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(inArchivesEmsService.selectInArchivesEmsById(id));
    }

    /**
     * 新增ems邮寄记录
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:add')")
    @Log(title = "ems邮寄记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InArchivesEms inArchivesEms) {
        return toAjax(inArchivesEmsService.insertInArchivesEms(inArchivesEms));
    }

    /**
     * 修改ems邮寄记录
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:edit')")
    @Log(title = "ems邮寄记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InArchivesEms inArchivesEms) {
        return toAjax(inArchivesEmsService.updateInArchivesEms(inArchivesEms));
    }

    /**
     * 删除ems邮寄记录
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:remove')")
    @Log(title = "ems邮寄记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(inArchivesEmsService.deleteInArchivesEmsByIds(ids));
    }
}
