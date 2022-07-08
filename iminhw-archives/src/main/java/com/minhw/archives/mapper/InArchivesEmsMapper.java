package com.minhw.archives.mapper;

import java.util.List;

import com.minhw.archives.domain.InArchivesEms;

/**
 * ems邮寄记录Mapper接口
 *
 * @author iminhw
 * @date 2022-07-09
 */
public interface InArchivesEmsMapper {
    /**
     * 查询ems邮寄记录
     *
     * @param id ems邮寄记录主键
     * @return ems邮寄记录
     */
    public InArchivesEms selectInArchivesEmsById(Long id);

    /**
     * 查询ems邮寄记录列表
     *
     * @param inArchivesEms ems邮寄记录
     * @return ems邮寄记录集合
     */
    public List<InArchivesEms> selectInArchivesEmsList(InArchivesEms inArchivesEms);

    /**
     * 新增ems邮寄记录
     *
     * @param inArchivesEms ems邮寄记录
     * @return 结果
     */
    public int insertInArchivesEms(InArchivesEms inArchivesEms);

    /**
     * 修改ems邮寄记录
     *
     * @param inArchivesEms ems邮寄记录
     * @return 结果
     */
    public int updateInArchivesEms(InArchivesEms inArchivesEms);

    /**
     * 删除ems邮寄记录
     *
     * @param id ems邮寄记录主键
     * @return 结果
     */
    public int deleteInArchivesEmsById(Long id);

    /**
     * 批量删除ems邮寄记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInArchivesEmsByIds(Long[] ids);
}
