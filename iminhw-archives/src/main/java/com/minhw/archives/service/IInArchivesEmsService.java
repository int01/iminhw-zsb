package com.minhw.archives.service;

import java.util.List;
import com.minhw.archives.domain.InArchivesEms;

/**
 * 邮寄档案Service接口
 * 
 * @author iminhw
 * @date 2022-07-09
 */
public interface IInArchivesEmsService 
{
    /**
     * 查询邮寄档案
     * 
     * @param id 邮寄档案主键
     * @return 邮寄档案
     */
    public InArchivesEms selectInArchivesEmsById(Long id);

    /**
     * 查询邮寄档案列表
     * 
     * @param inArchivesEms 邮寄档案
     * @return 邮寄档案集合
     */
    public List<InArchivesEms> selectInArchivesEmsList(InArchivesEms inArchivesEms);

    /**
     * 新增邮寄档案
     * 
     * @param inArchivesEms 邮寄档案
     * @return 结果
     */
    public int insertInArchivesEms(InArchivesEms inArchivesEms);

    /**
     * 修改邮寄档案
     * 
     * @param inArchivesEms 邮寄档案
     * @return 结果
     */
    public int updateInArchivesEms(InArchivesEms inArchivesEms);

    /**
     * 批量删除邮寄档案
     * 
     * @param ids 需要删除的邮寄档案主键集合
     * @return 结果
     */
    public int deleteInArchivesEmsByIds(Long[] ids);

    /**
     * 删除邮寄档案信息
     * 
     * @param id 邮寄档案主键
     * @return 结果
     */
    public int deleteInArchivesEmsById(Long id);
}
