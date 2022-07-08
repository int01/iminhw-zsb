package com.minhw.archives.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minhw.archives.mapper.InArchivesEmsMapper;
import com.minhw.archives.domain.InArchivesEms;
import com.minhw.archives.service.IInArchivesEmsService;

/**
 * ems邮寄记录Service业务层处理
 *
 * @author iminhw
 * @date 2022-07-09
 */
@Service
public class InArchivesEmsServiceImpl implements IInArchivesEmsService {
    @Autowired
    private InArchivesEmsMapper inArchivesEmsMapper;

    /**
     * 查询ems邮寄记录
     *
     * @param id ems邮寄记录主键
     * @return ems邮寄记录
     */
    @Override
    public InArchivesEms selectInArchivesEmsById(Long id) {
        return inArchivesEmsMapper.selectInArchivesEmsById(id);
    }

    /**
     * 查询ems邮寄记录列表
     *
     * @param inArchivesEms ems邮寄记录
     * @return ems邮寄记录
     */
    @Override
    public List<InArchivesEms> selectInArchivesEmsList(InArchivesEms inArchivesEms) {
        return inArchivesEmsMapper.selectInArchivesEmsList(inArchivesEms);
    }

    /**
     * 新增ems邮寄记录
     *
     * @param inArchivesEms ems邮寄记录
     * @return 结果
     */
    @Override
    public int insertInArchivesEms(InArchivesEms inArchivesEms) {
            return inArchivesEmsMapper.insertInArchivesEms(inArchivesEms);
    }

    /**
     * 修改ems邮寄记录
     *
     * @param inArchivesEms ems邮寄记录
     * @return 结果
     */
    @Override
    public int updateInArchivesEms(InArchivesEms inArchivesEms) {
        return inArchivesEmsMapper.updateInArchivesEms(inArchivesEms);
    }

    /**
     * 批量删除ems邮寄记录
     *
     * @param ids 需要删除的ems邮寄记录主键
     * @return 结果
     */
    @Override
    public int deleteInArchivesEmsByIds(Long[] ids) {
        return inArchivesEmsMapper.deleteInArchivesEmsByIds(ids);
    }

    /**
     * 删除ems邮寄记录信息
     *
     * @param id ems邮寄记录主键
     * @return 结果
     */
    @Override
    public int deleteInArchivesEmsById(Long id) {
        return inArchivesEmsMapper.deleteInArchivesEmsById(id);
    }
}
