package com.minhw.stu.controller;

import com.minhw.common.annotation.Log;
import com.minhw.common.core.controller.BaseController;
import com.minhw.common.core.domain.AjaxResult;
import com.minhw.common.core.page.TableDataInfo;
import com.minhw.common.enums.BusinessType;
import com.minhw.common.utils.poi.ExcelUtil;
import com.minhw.stu.domain.StuZyXy;
import com.minhw.stu.service.IStuZyXyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 专业学院配置Controller
 *
 * @author iminhw
 * @date 2022-07-17
 */
@RestController
@RequestMapping("/stu/stuxyzy")
public class StuZyXyController extends BaseController {
    @Autowired
    private IStuZyXyService stuZyXyService;

    /**
     * 查询专业学院配置列表
     */
    @PreAuthorize("@ss.hasPermi('stu:stuxyzy:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuZyXy stuZyXy) {
        startPage();
        List<StuZyXy> list = stuZyXyService.selectStuZyXyList(stuZyXy);
        return getDataTable(list);
    }

    /**
     * 导出专业学院配置列表
     */
    @PreAuthorize("@ss.hasPermi('stu:stuxyzy:export')")
    @Log(title = "专业学院配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuZyXy stuZyXy) {
        List<StuZyXy> list = stuZyXyService.selectStuZyXyList(stuZyXy);
        ExcelUtil<StuZyXy> util = new ExcelUtil<StuZyXy>(StuZyXy.class);
        util.exportExcel(response, list, "专业学院配置数据");
    }

    /**
     * 获取专业学院配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('stu:stuxyzy:query')")
    @GetMapping(value = "/{zy}")
    public AjaxResult getInfo(@PathVariable("zy") String zy) {
        return AjaxResult.success(stuZyXyService.selectStuZyXyByZy(zy));
    }

    /**
     * 新增专业学院配置
     */
    @PreAuthorize("@ss.hasPermi('stu:stuxyzy:add')")
    @Log(title = "专业学院配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuZyXy stuZyXy) {
        stuZyXy.setCreateBy(getUsername());
        return toAjax(stuZyXyService.insertStuZyXy(stuZyXy));
    }

    /**
     * 修改专业学院配置
     */
    @PreAuthorize("@ss.hasPermi('stu:stuxyzy:edit')")
    @Log(title = "专业学院配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuZyXy stuZyXy) {
        stuZyXy.setUpdateBy(getUsername());
        return toAjax(stuZyXyService.updateStuZyXy(stuZyXy));
    }

    /**
     * 删除专业学院配置
     */
    @PreAuthorize("@ss.hasPermi('stu:stuxyzy:remove')")
    @Log(title = "专业学院配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{zys}")
    public AjaxResult remove(@PathVariable String[] zys) {
        return toAjax(stuZyXyService.deleteStuZyXyByZys(zys));
    }
}
