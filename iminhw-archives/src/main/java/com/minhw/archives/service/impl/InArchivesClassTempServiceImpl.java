package com.minhw.archives.service.impl;

import com.minhw.archives.domain.InArchivesClassTemp;
import com.minhw.archives.mapper.InArchivesClassTempMapper;
import com.minhw.archives.service.IInArchivesClassTempService;
import com.minhw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 档案收录缓存Service业务层处理
 *
 * @author iminhw
 * @date 2022-07-09
 */
@Service
public class InArchivesClassTempServiceImpl implements IInArchivesClassTempService {
    @Autowired
    private InArchivesClassTempMapper inArchivesClassTempMapper;

    /**
     * 查询档案收录缓存
     *
     * @param id 档案收录缓存主键
     * @return 档案收录缓存
     */
    @Override
    public InArchivesClassTemp selectInArchivesClassTempById(Long id) {
        return inArchivesClassTempMapper.selectInArchivesClassTempById(id);
    }

    /**
     * 查询档案收录缓存列表
     *
     * @param inArchivesClassTemp 档案收录缓存
     * @return 档案收录缓存
     */
    @Override
    public List<InArchivesClassTemp> selectInArchivesClassTempList(InArchivesClassTemp inArchivesClassTemp) {
        return inArchivesClassTempMapper.selectInArchivesClassTempList(inArchivesClassTemp);
    }

    /**
     * 新增档案收录缓存
     *
     * @param inArchivesClassTemp 档案收录缓存
     * @return 结果
     */
    @Override
    public int insertInArchivesClassTemp(InArchivesClassTemp inArchivesClassTemp) {
        inArchivesClassTemp.setCreateTime(DateUtils.getNowDate());
        return inArchivesClassTempMapper.insertInArchivesClassTemp(inArchivesClassTemp);
    }

    /**
     * 修改档案收录缓存
     *
     * @param inArchivesClassTemp 档案收录缓存
     * @return 结果
     */
    @Override
    public int updateInArchivesClassTemp(InArchivesClassTemp inArchivesClassTemp) {
        inArchivesClassTemp.setUpdateTime(DateUtils.getNowDate());
        return inArchivesClassTempMapper.updateInArchivesClassTemp(inArchivesClassTemp);
    }

    /**
     * 批量删除档案收录缓存
     *
     * @param ids 需要删除的档案收录缓存主键
     * @return 结果
     */
    @Override
    public int deleteInArchivesClassTempByIds(Long[] ids) {
        return inArchivesClassTempMapper.deleteInArchivesClassTempByIds(ids);
    }

    /**
     * 删除档案收录缓存信息
     *
     * @param id 档案收录缓存主键
     * @return 结果
     */
    @Override
    public int deleteInArchivesClassTempById(Long id) {
        return inArchivesClassTempMapper.deleteInArchivesClassTempById(id);
    }
}
