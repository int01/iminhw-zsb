package com.minhw.archives.service.impl;

import java.util.List;
import com.minhw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minhw.archives.mapper.InArchivesEmsMapper;
import com.minhw.archives.domain.InArchivesEms;
import com.minhw.archives.service.IInArchivesEmsService;

/**
 * 邮寄档案Service业务层处理
 * 
 * @author iminhw
 * @date 2022-07-09
 */
@Service
public class InArchivesEmsServiceImpl implements IInArchivesEmsService 
{
    @Autowired
    private InArchivesEmsMapper inArchivesEmsMapper;

    /**
     * 查询邮寄档案
     * 
     * @param id 邮寄档案主键
     * @return 邮寄档案
     */
    @Override
    public InArchivesEms selectInArchivesEmsById(Long id)
    {
        return inArchivesEmsMapper.selectInArchivesEmsById(id);
    }

    /**
     * 查询邮寄档案列表
     * 
     * @param inArchivesEms 邮寄档案
     * @return 邮寄档案
     */
    @Override
    public List<InArchivesEms> selectInArchivesEmsList(InArchivesEms inArchivesEms)
    {
        return inArchivesEmsMapper.selectInArchivesEmsList(inArchivesEms);
    }

    /**
     * 新增邮寄档案
     * 
     * @param inArchivesEms 邮寄档案
     * @return 结果
     */
    @Override
    public int insertInArchivesEms(InArchivesEms inArchivesEms)
    {
        inArchivesEms.setCreateTime(DateUtils.getNowDate());
        return inArchivesEmsMapper.insertInArchivesEms(inArchivesEms);
    }

    /**
     * 修改邮寄档案
     * 
     * @param inArchivesEms 邮寄档案
     * @return 结果
     */
    @Override
    public int updateInArchivesEms(InArchivesEms inArchivesEms)
    {
        inArchivesEms.setUpdateTime(DateUtils.getNowDate());
        return inArchivesEmsMapper.updateInArchivesEms(inArchivesEms);
    }

    /**
     * 批量删除邮寄档案
     * 
     * @param ids 需要删除的邮寄档案主键
     * @return 结果
     */
    @Override
    public int deleteInArchivesEmsByIds(Long[] ids)
    {
        return inArchivesEmsMapper.deleteInArchivesEmsByIds(ids);
    }

    /**
     * 删除邮寄档案信息
     * 
     * @param id 邮寄档案主键
     * @return 结果
     */
    @Override
    public int deleteInArchivesEmsById(Long id)
    {
        return inArchivesEmsMapper.deleteInArchivesEmsById(id);
    }
}
