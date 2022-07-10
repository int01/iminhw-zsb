package com.minhw.archives.controller;

import com.minhw.archives.domain.InArchivesEms;
import com.minhw.archives.service.IInArchivesEmsService;
import com.minhw.common.annotation.Log;
import com.minhw.common.core.controller.BaseController;
import com.minhw.common.core.domain.AjaxResult;
import com.minhw.common.core.page.TableDataInfo;
import com.minhw.common.enums.BusinessType;
import com.minhw.common.utils.StringUtils;
import com.minhw.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 邮寄档案Controller
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
     * 查询邮寄档案列表
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:list')")
    @GetMapping("/list")
    public TableDataInfo list(InArchivesEms inArchivesEms) {
        startPage();
        List<InArchivesEms> list = inArchivesEmsService.selectInArchivesEmsList(inArchivesEms);
        return getDataTable(list);
    }

    /**
     * 导出邮寄档案列表
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:export')")
    @Log(title = "邮寄档案" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InArchivesEms inArchivesEms) {
        List<InArchivesEms> list = inArchivesEmsService.selectInArchivesEmsList(inArchivesEms);
        ExcelUtil<InArchivesEms> util = new ExcelUtil<InArchivesEms>(InArchivesEms.class);
        util.exportExcel(response, list, "邮寄档案数据");
    }

    /**
     * 获取邮寄档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(inArchivesEmsService.selectInArchivesEmsById(id));
    }

    /**
     * 新增邮寄档案
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:add')")
    @Log(title = "邮寄档案" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InArchivesEms inArchivesEms) {
        inArchivesEms.setCreateBy(getUserId() + ":" + getUsername());
        inArchivesEms.setCreateTime(new Date());
        return toAjax(inArchivesEmsService.insertInArchivesEms(inArchivesEms));
    }

    /**
     * 修改邮寄档案
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:edit')")
    @Log(title = "邮寄档案" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InArchivesEms inArchivesEms) {
        inArchivesEms.setUpdateBy(getUserId() + ":" + getUsername());
        return toAjax(inArchivesEmsService.updateInArchivesEms(inArchivesEms));
    }

    /**
     * 删除邮寄档案
     */
    @PreAuthorize("@ss.hasPermi('archives:ems:remove')")
    @Log(title = "邮寄档案" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(inArchivesEmsService.deleteInArchivesEmsByIds(ids));
    }

    @Log(title = "邮寄档案" , businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('archives:ems:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<InArchivesEms> util = new ExcelUtil<InArchivesEms>(InArchivesEms.class);
        List<InArchivesEms> inArchivesEmsList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = inArchivesEmsService.importArchivesEms(inArchivesEmsList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<InArchivesEms> util = new ExcelUtil<InArchivesEms>(InArchivesEms.class);
        util.importTemplateExcel(response, "快递单号数据");
    }

    @PreAuthorize("@ss.hasPermi('archives:ems:verify')")
    @Log(title = "邮寄档案" , businessType = BusinessType.UPDATE)
    @PutMapping("/verify")
    public AjaxResult verifyKddh(@RequestBody InArchivesEms inArchivesEms) {
        inArchivesEms.setUpdateBy(getUserId() + ":" + getUsername());
        InArchivesEms resObj = inArchivesEmsService.updateInArchivesEmsByKddh(inArchivesEms);
        return AjaxResult.success(resObj);
    }
}
