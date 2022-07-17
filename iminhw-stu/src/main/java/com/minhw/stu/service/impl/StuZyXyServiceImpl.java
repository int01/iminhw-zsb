package com.minhw.stu.service.impl;

import com.minhw.common.utils.DateUtils;
import com.minhw.stu.domain.StuZyXy;
import com.minhw.stu.mapper.StuZyXyMapper;
import com.minhw.stu.service.IStuZyXyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专业学院配置Service业务层处理
 *
 * @author iminhw
 * @date 2022-07-17
 */
@Service
public class StuZyXyServiceImpl implements IStuZyXyService {
    @Autowired
    private StuZyXyMapper stuZyXyMapper;

    /**
     * 查询专业学院配置
     *
     * @param zy 专业学院配置主键
     * @return 专业学院配置
     */
    @Override
    public StuZyXy selectStuZyXyByZy(String zy) {
        return stuZyXyMapper.selectStuZyXyByZy(zy);
    }

    /**
     * 查询专业学院配置列表
     *
     * @param stuZyXy 专业学院配置
     * @return 专业学院配置
     */
    @Override
    public List<StuZyXy> selectStuZyXyList(StuZyXy stuZyXy) {
        return stuZyXyMapper.selectStuZyXyList(stuZyXy);
    }

    /**
     * 新增专业学院配置
     *
     * @param stuZyXy 专业学院配置
     * @return 结果
     */
    @Override
    public int insertStuZyXy(StuZyXy stuZyXy) {
        stuZyXy.setCreateTime(DateUtils.getNowDate());
        return stuZyXyMapper.insertStuZyXy(stuZyXy);
    }

    /**
     * 修改专业学院配置
     *
     * @param stuZyXy 专业学院配置
     * @return 结果
     */
    @Override
    public int updateStuZyXy(StuZyXy stuZyXy) {
        stuZyXy.setUpdateTime(DateUtils.getNowDate());
        return stuZyXyMapper.updateStuZyXy(stuZyXy);
    }

    /**
     * 批量删除专业学院配置
     *
     * @param zys 需要删除的专业学院配置主键
     * @return 结果
     */
    @Override
    public int deleteStuZyXyByZys(String[] zys) {
        return stuZyXyMapper.deleteStuZyXyByZys(zys);
    }

    /**
     * 删除专业学院配置信息
     *
     * @param zy 专业学院配置主键
     * @return 结果
     */
    @Override
    public int deleteStuZyXyByZy(String zy) {
        return stuZyXyMapper.deleteStuZyXyByZy(zy);
    }
}
