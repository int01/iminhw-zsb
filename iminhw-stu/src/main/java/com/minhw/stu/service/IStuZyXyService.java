package com.minhw.stu.service;

import com.minhw.stu.domain.StuZyXy;

import java.util.List;

/**
 * 专业学院配置Service接口
 *
 * @author iminhw
 * @date 2022-07-17
 */
public interface IStuZyXyService {
    /**
     * 查询专业学院配置
     *
     * @param zy 专业学院配置主键
     * @return 专业学院配置
     */
    public StuZyXy selectStuZyXyByZy(String zy);

    /**
     * 查询专业学院配置列表
     *
     * @param stuZyXy 专业学院配置
     * @return 专业学院配置集合
     */
    public List<StuZyXy> selectStuZyXyList(StuZyXy stuZyXy);

    /**
     * 新增专业学院配置
     *
     * @param stuZyXy 专业学院配置
     * @return 结果
     */
    public int insertStuZyXy(StuZyXy stuZyXy);

    /**
     * 修改专业学院配置
     *
     * @param stuZyXy 专业学院配置
     * @return 结果
     */
    public int updateStuZyXy(StuZyXy stuZyXy);

    /**
     * 批量删除专业学院配置
     *
     * @param zys 需要删除的专业学院配置主键集合
     * @return 结果
     */
    public int deleteStuZyXyByZys(String[] zys);

    /**
     * 删除专业学院配置信息
     *
     * @param zy 专业学院配置主键
     * @return 结果
     */
    public int deleteStuZyXyByZy(String zy);
}
