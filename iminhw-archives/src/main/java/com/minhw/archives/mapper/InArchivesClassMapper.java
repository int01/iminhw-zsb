package com.minhw.archives.mapper;

import java.util.List;

import com.minhw.archives.domain.InArchivesClass;

/**
 * 档案收集情况Mapper接口
 *
 * @author iminhw
 * @date 2022-07-09
 */
public interface InArchivesClassMapper {
    /**
     * 查询档案收集情况
     *
     * @param xuehao 档案收集情况主键
     * @return 档案收集情况
     */
    public InArchivesClass selectInArchivesClassByXuehao(String xuehao);

    /**
     * 查询档案收集情况列表
     *
     * @param inArchivesClass 档案收集情况
     * @return 档案收集情况集合
     */
    public List<InArchivesClass> selectInArchivesClassList(InArchivesClass inArchivesClass);

    /**
     * 新增档案收集情况
     *
     * @param inArchivesClass 档案收集情况
     * @return 结果
     */
    public int insertInArchivesClass(InArchivesClass inArchivesClass);

    /**
     * 修改档案收集情况
     *
     * @param inArchivesClass 档案收集情况
     * @return 结果
     */
    public int updateInArchivesClass(InArchivesClass inArchivesClass);

    /**
     * 删除档案收集情况
     *
     * @param xuehao 档案收集情况主键
     * @return 结果
     */
    public int deleteInArchivesClassByXuehao(String xuehao);

    /**
     * 批量删除档案收集情况
     *
     * @param xuehaos 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInArchivesClassByXuehaos(String[] xuehaos);
}
