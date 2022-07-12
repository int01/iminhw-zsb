package com.minhw.archives.mapper;

import com.minhw.archives.domain.InArchivesClassTemp;

import java.util.List;

/**
 * 档案收录缓存Mapper接口
 *
 * @author iminhw
 * @date 2022-07-09
 */
public interface InArchivesClassTempMapper {
    /**
     * 查询档案收录缓存
     *
     * @param id 档案收录缓存主键
     * @return 档案收录缓存
     */
    public InArchivesClassTemp selectInArchivesClassTempById(Long id);

    /**
     * 查询档案收录缓存列表
     *
     * @param inArchivesClassTemp 档案收录缓存
     * @return 档案收录缓存集合
     */
    public List<InArchivesClassTemp> selectInArchivesClassTempList(InArchivesClassTemp inArchivesClassTemp);

    /**
     * 新增档案收录缓存
     *
     * @param inArchivesClassTemp 档案收录缓存
     * @return 结果
     */
    public int insertInArchivesClassTemp(InArchivesClassTemp inArchivesClassTemp);

    /**
     * 修改档案收录缓存
     *
     * @param inArchivesClassTemp 档案收录缓存
     * @return 结果
     */
    public int updateInArchivesClassTemp(InArchivesClassTemp inArchivesClassTemp);

    /**
     * 删除档案收录缓存
     *
     * @param id 档案收录缓存主键
     * @return 结果
     */
    public int deleteInArchivesClassTempById(Long id);

    /**
     * 批量删除档案收录缓存
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInArchivesClassTempByIds(Long[] ids);
}
