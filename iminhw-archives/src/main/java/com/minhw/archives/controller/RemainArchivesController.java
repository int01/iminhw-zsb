package com.minhw.archives.controller;

import java.util.Date;
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
import com.minhw.archives.domain.RemainArchives;
import com.minhw.archives.service.IRemainArchivesService;
import com.minhw.common.utils.poi.ExcelUtil;
import com.minhw.common.core.page.TableDataInfo;

/**
 * 剩余档案Controller
 * 
 * @author iminhw
 * @date 2022-07-09
 */
@RestController
@RequestMapping("/archives/remain")
public class RemainArchivesController extends BaseController
{
    @Autowired
    private IRemainArchivesService remainArchivesService;

    /**
     * 查询剩余档案列表
     */
    @PreAuthorize("@ss.hasPermi('archives:remain:list')")
    @GetMapping("/list")
    public TableDataInfo list(RemainArchives remainArchives)
    {
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
    public void export(HttpServletResponse response, RemainArchives remainArchives)
    {
        List<RemainArchives> list = remainArchivesService.selectRemainArchivesList(remainArchives);
        ExcelUtil<RemainArchives> util = new ExcelUtil<RemainArchives>(RemainArchives.class);
        util.exportExcel(response, list, "剩余档案数据");
    }

    /**
     * 获取剩余档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('archives:remain:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(remainArchivesService.selectRemainArchivesById(id));
    }

    /**
     * 新增剩余档案
     */
    @PreAuthorize("@ss.hasPermi('archives:remain:add')")
    @Log(title = "剩余档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RemainArchives remainArchives)
    {
        remainArchives.setCreateBy(getUserId()+":"+getUsername());
        remainArchives.setCreateTime(new Date());
        return toAjax(remainArchivesService.insertRemainArchives(remainArchives));
    }

    /**
     * 修改剩余档案
     */
    @PreAuthorize("@ss.hasPermi('archives:remain:edit')")
    @Log(title = "剩余档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RemainArchives remainArchives) {
        remainArchives.setUpdateBy(getUserId()+":"+getUsername());
        return toAjax(remainArchivesService.updateRemainArchives(remainArchives));
    }

    /**
     * 删除剩余档案
     */
    @PreAuthorize("@ss.hasPermi('archives:remain:remove')")
    @Log(title = "剩余档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(remainArchivesService.deleteRemainArchivesByIds(ids));
    }
}
