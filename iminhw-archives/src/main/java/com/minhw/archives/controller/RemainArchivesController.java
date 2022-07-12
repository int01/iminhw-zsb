package com.minhw.archives.controller;

import com.minhw.archives.domain.RemainArchives;
import com.minhw.archives.service.IRemainArchivesService;
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
 * 剩余档案Controller
 *
 * @author iminhw
 * @date 2022-07-11
 */
@RestController
@RequestMapping("/archives/remain")
public class RemainArchivesController extends BaseController {
    @Autowired
    private IRemainArchivesService remainArchivesService;

    /**
     * 查询剩余档案列表
     */
    @PreAuthorize("@ss.hasPermi('archives:remain:list')")
    @GetMapping("/list")
    public TableDataInfo list(RemainArchives remainArchives) {
        startPage();
        List<RemainArchives> list = remainArchivesService.selectRemainArchivesList(remainArchives);
        return getDataTable(list);
    }

    /**
     * 导出剩余档案列表
     */
    @PreAuthorize("@ss.hasPermi('archives:remain:export')")
    @Log(title = "剩余档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RemainArchives remainArchives) {
        List<RemainArchives> list = remainArchivesService.selectRemainArchivesList(remainArchives);
        ExcelUtil<RemainArchives> util = new ExcelUtil<RemainArchives>(RemainArchives.class);
        util.exportExcel(response, list, "剩余档案数据");
    }

    /**
     * 获取剩余档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('archives:remain:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(remainArchivesService.selectRemainArchivesById(id));
    }

    /**
     * 新增剩余档案
     */
    @PreAuthorize("@ss.hasPermi('archives:remain:add')")
    @Log(title = "剩余档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RemainArchives remainArchives) {
        remainArchives.setCreateBy(getUsername());
        return toAjax(remainArchivesService.insertRemainArchives(remainArchives));
    }

    /**
     * 修改剩余档案
     */
    @PreAuthorize("@ss.hasPermi('archives:remain:edit')")
    @Log(title = "剩余档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RemainArchives remainArchives) {
        remainArchives.setUpdateBy(getUsername());
        return toAjax(remainArchivesService.updateRemainArchives(remainArchives));
    }

    /**
     * 删除剩余档案
     */
    @PreAuthorize("@ss.hasPermi('archives:remain:remove')")
    @Log(title = "剩余档案", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(remainArchivesService.deleteRemainArchivesByIds(ids));
    }

    @Log(title = "邮寄档案", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('archives:remain:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<RemainArchives> util = new ExcelUtil<>(RemainArchives.class);
        List<RemainArchives> remainArchivesList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = remainArchivesService.importRemainArchives(remainArchivesList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<RemainArchives> util = new ExcelUtil<>(RemainArchives.class);
        util.importTemplateExcel(response, "剩余档案数据");
    }
}
