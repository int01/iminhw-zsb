package com.minhw.stu.service.impl;

import java.util.List;
import com.minhw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minhw.stu.mapper.StuMatriculateMapper;
import com.minhw.stu.domain.StuMatriculate;
import com.minhw.stu.service.IStuMatriculateService;

/**
 * 录取数据Service业务层处理
 * 
 * @author iminhw
 * @date 2022-07-11
 */
@Service
public class StuMatriculateServiceImpl implements IStuMatriculateService 
{
    @Autowired
    private StuMatriculateMapper stuMatriculateMapper;

    /**
     * 查询录取数据
     * 
     * @param ksh 录取数据主键
     * @return 录取数据
     */
    @Override
    public StuMatriculate selectStuMatriculateByKsh(String ksh)
    {
        return stuMatriculateMapper.selectStuMatriculateByKsh(ksh);
    }

    /**
     * 查询录取数据列表
     * 
     * @param stuMatriculate 录取数据
     * @return 录取数据
     */
    @Override
    public List<StuMatriculate> selectStuMatriculateList(StuMatriculate stuMatriculate)
    {
        return stuMatriculateMapper.selectStuMatriculateList(stuMatriculate);
    }

    /**
     * 新增录取数据
     * 
     * @param stuMatriculate 录取数据
     * @return 结果
     */
    @Override
    public int insertStuMatriculate(StuMatriculate stuMatriculate)
    {
        stuMatriculate.setCreateTime(DateUtils.getNowDate());
        return stuMatriculateMapper.insertStuMatriculate(stuMatriculate);
    }

    /**
     * 修改录取数据
     * 
     * @param stuMatriculate 录取数据
     * @return 结果
     */
    @Override
    public int updateStuMatriculate(StuMatriculate stuMatriculate)
    {
        stuMatriculate.setUpdateTime(DateUtils.getNowDate());
        return stuMatriculateMapper.updateStuMatriculate(stuMatriculate);
    }

    /**
     * 批量删除录取数据
     * 
     * @param kshs 需要删除的录取数据主键
     * @return 结果
     */
    @Override
    public int deleteStuMatriculateByKshs(String[] kshs)
    {
        return stuMatriculateMapper.deleteStuMatriculateByKshs(kshs);
    }

    /**
     * 删除录取数据信息
     * 
     * @param ksh 录取数据主键
     * @return 结果
     */
    @Override
    public int deleteStuMatriculateByKsh(String ksh)
    {
        return stuMatriculateMapper.deleteStuMatriculateByKsh(ksh);
    }
}
