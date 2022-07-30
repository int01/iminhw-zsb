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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 班级档案Controller
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
     * 查询班级档案列表
     */
    @PreAuthorize("@ss.hasPermi('archives:class:list')")
    @GetMapping("/list")
    public TableDataInfo list(InArchivesClass inArchivesClass) {
        startPage();
        List<InArchivesClass> list = inArchivesClassService.selectInArchivesClassList(inArchivesClass);
        return getDataTable(list);
    }

    /**
     * 导出班级档案列表
     */
    @PreAuthorize("@ss.hasPermi('archives:class:export')")
    @Log(title = "班级档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InArchivesClass inArchivesClass) {
        List<InArchivesClass> list = inArchivesClassService.selectInArchivesClassList(inArchivesClass);
        ExcelUtil<InArchivesClass> util = new ExcelUtil<InArchivesClass>(InArchivesClass.class);
        util.exportExcel(response, list, "班级档案数据");
    }

    /**
     * 获取班级档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('archives:class:query')")
    @GetMapping(value = "/{xuehao}")
    public AjaxResult getInfo(@PathVariable("xuehao") String xuehao) {
        return AjaxResult.success(inArchivesClassService.selectInArchivesClassByXuehao(xuehao));
    }

    @PreAuthorize("@ss.hasPermi('archives:class:print')")
    @GetMapping(value = "/bj")
    public AjaxResult getClassBybj(InArchivesClass inArchivesClass) {
        return AjaxResult.success(inArchivesClassService.selectInArchivesClassByBj(inArchivesClass));
    }

    /**
     * 新增班级档案
     */
    @PreAuthorize("@ss.hasPermi('archives:class:add')")
    @Log(title = "班级档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InArchivesClass inArchivesClass) {
        inArchivesClass.setCreateBy(getUsername());
        return toAjax(inArchivesClassService.insertInArchivesClass(inArchivesClass));
    }

    /**
     * 现场
     */
    @PreAuthorize("@ss.hasPermi('archives:class:collect')")
    @GetMapping(value = "/collect")
    public AjaxResult getinfoBy(InArchivesClass inArchivesClass) {
        return AjaxResult.success(inArchivesClassService.selectInArchivesClassByKshOrXueHOrSfzh(inArchivesClass));
    }

    /**
     * 修改班级档案
     */
    @PreAuthorize("@ss.hasPermi('archives:class:edit')")
    @Log(title = "班级档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InArchivesClass inArchivesClass) {
        inArchivesClass.setUpdateBy(getUsername());
        return toAjax(inArchivesClassService.updateInArchivesClass(inArchivesClass));
    }

    /**
     * 删除班级档案
     */
    @PreAuthorize("@ss.hasPermi('archives:class:remove')")
    @Log(title = "班级档案", businessType = BusinessType.DELETE)
    @DeleteMapping("/{xuehaos}")
    public AjaxResult remove(@PathVariable String[] xuehaos) {
        return toAjax(inArchivesClassService.deleteInArchivesClassByXuehaos(xuehaos));
    }

    @Log(title = "班级档案", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('archives:class:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<InArchivesClass> util = new ExcelUtil<>(InArchivesClass.class);
        List<InArchivesClass> inArchivesClassList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = inArchivesClassService.importInArchivesClass(inArchivesClassList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<InArchivesClass> util = new ExcelUtil<>(InArchivesClass.class);
        util.importTemplateExcel(response, "档案提交情况");
    }
}
