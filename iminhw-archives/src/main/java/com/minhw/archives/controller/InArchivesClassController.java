package com.minhw.archives.controller;

import com.minhw.archives.domain.InArchivesClass;
import com.minhw.archives.service.IInArchivesClassService;
import com.minhw.common.annotation.Log;
import com.minhw.common.core.controller.BaseController;
import com.minhw.common.core.domain.AjaxResult;
import com.minhw.common.core.page.TableDataInfo;
import com.minhw.common.enums.BusinessType;
import com.minhw.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 档案收集Controller
 *
 * @author iminhw
 * @date 2022-07-09
 */
@RestController
@RequestMapping("/archives/class")
public class InArchivesClassController extends BaseController {
    @Autowired
    private IInArchivesClassService inArchivesClassService;

    /**
     * 查询档案收集列表
     */
    @PreAuthorize("@ss.hasPermi('archives:class:list')")
    @GetMapping("/list")
    public TableDataInfo list(InArchivesClass inArchivesClass) {
        startPage();
        List<InArchivesClass> list = inArchivesClassService.selectInArchivesClassList(inArchivesClass);
        return getDataTable(list);
    }

    /**
     * 导出档案收集列表
     */
    @PreAuthorize("@ss.hasPermi('archives:class:export')")
    @Log(title = "档案收集", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InArchivesClass inArchivesClass) {
        List<InArchivesClass> list = inArchivesClassService.selectInArchivesClassList(inArchivesClass);
        ExcelUtil<InArchivesClass> util = new ExcelUtil<InArchivesClass>(InArchivesClass.class);
        util.exportExcel(response, list, "档案收集数据");
    }

    /**
     * 获取档案收集详细信息
     */
    @PreAuthorize("@ss.hasPermi('archives:class:query')")
    @GetMapping(value = "/{xuehao}")
    public AjaxResult getInfo(@PathVariable("xuehao") String xuehao) {
        return AjaxResult.success(inArchivesClassService.selectInArchivesClassByXuehao(xuehao));
    }

    /**
     * 新增档案收集
     */
    @PreAuthorize("@ss.hasPermi('archives:class:add')")
    @Log(title = "档案收集", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InArchivesClass inArchivesClass) {
        inArchivesClass.setCreateBy(getUsername());
        return toAjax(inArchivesClassService.insertInArchivesClass(inArchivesClass));
    }

    /**
     * 修改档案收集
     */
    @PreAuthorize("@ss.hasPermi('archives:class:edit')")
    @Log(title = "档案收集", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InArchivesClass inArchivesClass) {
        inArchivesClass.setUpdateBy(getUsername());
        return toAjax(inArchivesClassService.updateInArchivesClass(inArchivesClass));
    }

    /**
     * 删除档案收集
     */
    @PreAuthorize("@ss.hasPermi('archives:class:remove')")
    @Log(title = "档案收集", businessType = BusinessType.DELETE)
    @DeleteMapping("/{xuehaos}")
    public AjaxResult remove(@PathVariable String[] xuehaos) {
        return toAjax(inArchivesClassService.deleteInArchivesClassByXuehaos(xuehaos));
    }
}
