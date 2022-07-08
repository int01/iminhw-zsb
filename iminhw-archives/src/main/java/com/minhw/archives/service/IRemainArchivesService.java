package com.minhw.archives.service;

import java.util.List;

import com.minhw.archives.domain.RemainArchives;

/**
 * 剩余档案Service接口
 *
 * @author iminhw
 * @date 2022-07-09
 */
public interface IRemainArchivesService {
    /**
     * 查询剩余档案
     *
     * @param id 剩余档案主键
     * @return 剩余档案
     */
    public RemainArchives selectRemainArchivesById(Long id);

    /**
     * 查询剩余档案列表
     *
     * @param remainArchives 剩余档案
     * @return 剩余档案集合
     */
    public List<RemainArchives> selectRemainArchivesList(RemainArchives remainArchives);

    /**
     * 新增剩余档案
     *
     * @param remainArchives 剩余档案
     * @return 结果
     */
    public int insertRemainArchives(RemainArchives remainArchives);

    /**
     * 修改剩余档案
     *
     * @param remainArchives 剩余档案
     * @return 结果
     */
    public int updateRemainArchives(RemainArchives remainArchives);

    /**
     * 批量删除剩余档案
     *
     * @param ids 需要删除的剩余档案主键集合
     * @return 结果
     */
    public int deleteRemainArchivesByIds(Long[] ids);

    /**
     * 删除剩余档案信息
     *
     * @param id 剩余档案主键
     * @return 结果
     */
    public int deleteRemainArchivesById(Long id);
}
