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
import com.minhw.archives.domain.InArchivesEms;
import com.minhw.archives.service.IInArchivesEmsService;
import com.minhw.common.utils.poi.ExcelUtil;
import com.minhw.common.core.page.TableDataInfo;

/**
 * 邮寄档案Controller
 * 
 * @author iminhw
 * @date 2022-07-09
 */
@RestController
@RequestMapping("/archives/ems")
public class InArchivesEmsController extends BaseController
{
    @Autowired
    private IInArchivesEmsService inArchivesEmsService;

    /**
     * 查询邮寄档案列表
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:list')")
    @GetMapping("/list")
    public TableDataInfo list(InArchivesEms inArchivesEms)
    {
        startPage();
        List<InArchivesEms> list = inArchivesEmsService.selectInArchivesEmsList(inArchivesEms);
        return getDataTable(list);
    }

    /**
     * 导出邮寄档案列表
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:export')")
    @Log(title = "邮寄档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InArchivesEms inArchivesEms)
    {
        List<InArchivesEms> list = inArchivesEmsService.selectInArchivesEmsList(inArchivesEms);
        ExcelUtil<InArchivesEms> util = new ExcelUtil<InArchivesEms>(InArchivesEms.class);
        util.exportExcel(response, list, "邮寄档案数据");
    }

    /**
     * 获取邮寄档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(inArchivesEmsService.selectInArchivesEmsById(id));
    }

    /**
     * 新增邮寄档案
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:add')")
    @Log(title = "邮寄档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InArchivesEms inArchivesEms)
    {
        inArchivesEms.setCreateBy(getUserId()+":"+getUsername());
        inArchivesEms.setCreateTime(new Date());
        return toAjax(inArchivesEmsService.insertInArchivesEms(inArchivesEms));
    }

    /**
     * 修改邮寄档案
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:edit')")
    @Log(title = "邮寄档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InArchivesEms inArchivesEms) {
        inArchivesEms.setUpdateBy(getUserId()+":"+getUsername());
        return toAjax(inArchivesEmsService.updateInArchivesEms(inArchivesEms));
    }

    /**
     * 删除邮寄档案
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:remove')")
    @Log(title = "邮寄档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(inArchivesEmsService.deleteInArchivesEmsByIds(ids));
    }
}
