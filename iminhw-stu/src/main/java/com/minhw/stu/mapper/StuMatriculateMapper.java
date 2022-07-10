package com.minhw.stu.mapper;

import java.util.List;
import com.minhw.stu.domain.StuMatriculate;

/**
 * 录取数据Mapper接口
 * 
 * @author iminhw
 * @date 2022-07-11
 */
public interface StuMatriculateMapper 
{
    /**
     * 查询录取数据
     * 
     * @param ksh 录取数据主键
     * @return 录取数据
     */
    public StuMatriculate selectStuMatriculateByKsh(String ksh);

    /**
     * 查询录取数据列表
     * 
     * @param stuMatriculate 录取数据
     * @return 录取数据集合
     */
    public List<StuMatriculate> selectStuMatriculateList(StuMatriculate stuMatriculate);

    /**
     * 新增录取数据
     * 
     * @param stuMatriculate 录取数据
     * @return 结果
     */
    public int insertStuMatriculate(StuMatriculate stuMatriculate);

    /**
     * 修改录取数据
     * 
     * @param stuMatriculate 录取数据
     * @return 结果
     */
    public int updateStuMatriculate(StuMatriculate stuMatriculate);

    /**
     * 删除录取数据
     * 
     * @param ksh 录取数据主键
     * @return 结果
     */
    public int deleteStuMatriculateByKsh(String ksh);

    /**
     * 批量删除录取数据
     * 
     * @param kshs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStuMatriculateByKshs(String[] kshs);
}
