package com.minhw.archives.mapper;

import com.minhw.archives.domain.InArchivesClass;
import com.minhw.archives.domain.InArchivesEms;

import java.util.List;

/**
 * 档案收集Mapper接口
 *
 * @author iminhw
 * @date 2022-07-09
 */
public interface InArchivesClassMapper {
    /**
     * 查询档案收集
     *
     * @param xuehao 档案收集主键
     * @return 档案收集
     */
    public InArchivesClass selectInArchivesClassByXuehao(String xuehao);

    InArchivesClass selectInArchivesClassByKsh(String ksh);

    /**
     * 查询档案收集列表
     *
     * @param inArchivesClass 档案收集
     * @return 档案收集集合
     */
    public List<InArchivesClass> selectInArchivesClassList(InArchivesClass inArchivesClass);

    /**
     * 新增档案收集
     *
     * @param inArchivesClass 档案收集
     * @return 结果
     */
    public int insertInArchivesClass(InArchivesClass inArchivesClass);

    /**
     * 修改档案收集
     *
     * @param inArchivesClass 档案收集
     * @return 结果
     */
    public int updateInArchivesClass(InArchivesClass inArchivesClass);

    /**
     * 删除档案收集
     *
     * @param xuehao 档案收集主键
     * @return 结果
     */
    public int deleteInArchivesClassByXuehao(String xuehao);

    /**
     * 批量删除档案收集
     *
     * @param xuehaos 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInArchivesClassByXuehaos(String[] xuehaos);

    int updateInArchivesClassByKsh(InArchivesClass inArchivesClass);
}
