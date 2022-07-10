package com.minhw.stu.controller;

import com.minhw.common.annotation.Log;
import com.minhw.common.core.controller.BaseController;
import com.minhw.common.core.domain.AjaxResult;
import com.minhw.common.core.page.TableDataInfo;
import com.minhw.common.enums.BusinessType;
import com.minhw.common.utils.poi.ExcelUtil;
import com.minhw.stu.domain.StuMatriculate;
import com.minhw.stu.service.IStuMatriculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 录取数据Controller
 *
 * @author iminhw
 * @date 2022-07-11
 */
@RestController
@RequestMapping("/stu/matriculate")
public class StuMatriculateController extends BaseController {
    @Autowired
    private IStuMatriculateService stuMatriculateService;

    /**
     * 查询录取数据列表
     */
    @PreAuthorize("@ss.hasPermi('stu:matriculate:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuMatriculate stuMatriculate) {
        startPage();
        List<StuMatriculate> list = stuMatriculateService.selectStuMatriculateList(stuMatriculate);
        return getDataTable(list);
    }

    /**
     * 导出录取数据列表
     */
    @PreAuthorize("@ss.hasPermi('stu:matriculate:export')")
    @Log(title = "录取数据" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuMatriculate stuMatriculate) {
        List<StuMatriculate> list = stuMatriculateService.selectStuMatriculateList(stuMatriculate);
        ExcelUtil<StuMatriculate> util = new ExcelUtil<StuMatriculate>(StuMatriculate.class);
        util.exportExcel(response, list, "录取数据数据");
    }

    /**
     * 获取录取数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('stu:matriculate:query')")
    @GetMapping(value = "/{ksh}")
    public AjaxResult getInfo(@PathVariable("ksh") String ksh) {
        return AjaxResult.success(stuMatriculateService.selectStuMatriculateByKsh(ksh));
    }

    /**
     * 新增录取数据
     */
    @PreAuthorize("@ss.hasPermi('stu:matriculate:add')")
    @Log(title = "录取数据" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuMatriculate stuMatriculate) {
        stuMatriculate.setCreateBy(getUsername());
        return toAjax(stuMatriculateService.insertStuMatriculate(stuMatriculate));
    }

    /**
     * 修改录取数据
     */
    @PreAuthorize("@ss.hasPermi('stu:matriculate:edit')")
    @Log(title = "录取数据" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuMatriculate stuMatriculate) {
        stuMatriculate.setUpdateBy(getUsername());
        return toAjax(stuMatriculateService.updateStuMatriculate(stuMatriculate));
    }

    /**
     * 删除录取数据
     */
    @PreAuthorize("@ss.hasPermi('stu:matriculate:remove')")
    @Log(title = "录取数据" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{kshs}")
    public AjaxResult remove(@PathVariable String[] kshs) {
        return toAjax(stuMatriculateService.deleteStuMatriculateByKshs(kshs));
    }
}
