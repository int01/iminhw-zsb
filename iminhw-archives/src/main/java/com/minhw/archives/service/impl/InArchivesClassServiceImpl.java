package com.minhw.archives.service.impl;

import com.minhw.archives.domain.InArchivesClass;
import com.minhw.archives.mapper.InArchivesClassMapper;
import com.minhw.archives.service.IInArchivesClassService;
import com.minhw.common.exception.ServiceException;
import com.minhw.common.utils.DateUtils;
import com.minhw.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 档案收集Service业务层处理
 *
 * @author iminhw
 * @date 2022-07-09
 */
@Service
public class InArchivesClassServiceImpl implements IInArchivesClassService {
    @Autowired
    private InArchivesClassMapper inArchivesClassMapper;

    /**
     * 查询档案收集
     *
     * @param xuehao 档案收集主键
     * @return 档案收集
     */
    @Override
    public InArchivesClass selectInArchivesClassByXuehao(String xuehao) {
        return inArchivesClassMapper.selectInArchivesClassByXuehao(xuehao);
    }

    /**
     * 查询档案收集列表
     *
     * @param inArchivesClass 档案收集
     * @return 档案收集
     */
    @Override
    public List<InArchivesClass> selectInArchivesClassList(InArchivesClass inArchivesClass) {
        return inArchivesClassMapper.selectInArchivesClassList(inArchivesClass);
    }

    /**
     * 新增档案收集
     *
     * @param inArchivesClass 档案收集
     * @return 结果
     */
    @Override
    public int insertInArchivesClass(InArchivesClass inArchivesClass) {
        if (StringUtils.isNotNull(inArchivesClassMapper.selectInArchivesClassByXuehao(inArchivesClass.getXuehao()))) {
            throw new ServiceException("学号不允许重复");
        }
        inArchivesClass.setCreateTime(DateUtils.getNowDate());
        return inArchivesClassMapper.insertInArchivesClass(inArchivesClass);
    }

    /**
     * 修改档案收集
     *
     * @param inArchivesClass 档案收集
     * @return 结果
     */
    @Override
    public int updateInArchivesClass(InArchivesClass inArchivesClass) {
        inArchivesClass.setUpdateTime(DateUtils.getNowDate());
        return inArchivesClassMapper.updateInArchivesClass(inArchivesClass);
    }

    /**
     * 批量删除档案收集
     *
     * @param xuehaos 需要删除的档案收集主键
     * @return 结果
     */
    @Override
    public int deleteInArchivesClassByXuehaos(String[] xuehaos) {
        return inArchivesClassMapper.deleteInArchivesClassByXuehaos(xuehaos);
    }

    /**
     * 删除档案收集信息
     *
     * @param xuehao 档案收集主键
     * @return 结果
     */
    @Override
    public int deleteInArchivesClassByXuehao(String xuehao) {
        return inArchivesClassMapper.deleteInArchivesClassByXuehao(xuehao);
    }
}
