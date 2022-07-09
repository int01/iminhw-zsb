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
import com.minhw.archives.domain.InArchivesClassTemp;
import com.minhw.archives.service.IInArchivesClassTempService;
import com.minhw.common.utils.poi.ExcelUtil;
import com.minhw.common.core.page.TableDataInfo;

/**
 * 档案收录缓存Controller
 * 
 * @author iminhw
 * @date 2022-07-09
 */
@RestController
@RequestMapping("/archives/classtemp")
public class InArchivesClassTempController extends BaseController
{
    @Autowired
    private IInArchivesClassTempService inArchivesClassTempService;

    /**
     * 查询档案收录缓存列表
     */
    @PreAuthorize("@ss.hasPermi('archives:classtemp:list')")
    @GetMapping("/list")
    public TableDataInfo list(InArchivesClassTemp inArchivesClassTemp)
    {
        startPage();
        List<InArchivesClassTemp> list = inArchivesClassTempService.selectInArchivesClassTempList(inArchivesClassTemp);
        return getDataTable(list);
    }

    /**
     * 导出档案收录缓存列表
     */
    @PreAuthorize("@ss.hasPermi('archives:classtemp:export')")
    @Log(title = "档案收录缓存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InArchivesClassTemp inArchivesClassTemp)
    {
        List<InArchivesClassTemp> list = inArchivesClassTempService.selectInArchivesClassTempList(inArchivesClassTemp);
        ExcelUtil<InArchivesClassTemp> util = new ExcelUtil<InArchivesClassTemp>(InArchivesClassTemp.class);
        util.exportExcel(response, list, "档案收录缓存数据");
    }

    /**
     * 获取档案收录缓存详细信息
     */
    @PreAuthorize("@ss.hasPermi('archives:classtemp:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(inArchivesClassTempService.selectInArchivesClassTempById(id));
    }

    /**
     * 新增档案收录缓存
     */
    @PreAuthorize("@ss.hasPermi('archives:classtemp:add')")
    @Log(title = "档案收录缓存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InArchivesClassTemp inArchivesClassTemp)
    {
        inArchivesClassTemp.setCreateBy(getUserId()+":"+getUsername());
        inArchivesClassTemp.setCreateTime(new Date());
        return toAjax(inArchivesClassTempService.insertInArchivesClassTemp(inArchivesClassTemp));
    }

    /**
     * 修改档案收录缓存
     */
    @PreAuthorize("@ss.hasPermi('archives:classtemp:edit')")
    @Log(title = "档案收录缓存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InArchivesClassTemp inArchivesClassTemp) {
        inArchivesClassTemp.setUpdateBy(getUserId()+":"+getUsername());
        return toAjax(inArchivesClassTempService.updateInArchivesClassTemp(inArchivesClassTemp));
    }

    /**
     * 删除档案收录缓存
     */
    @PreAuthorize("@ss.hasPermi('archives:classtemp:remove')")
    @Log(title = "档案收录缓存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(inArchivesClassTempService.deleteInArchivesClassTempByIds(ids));
    }
}
