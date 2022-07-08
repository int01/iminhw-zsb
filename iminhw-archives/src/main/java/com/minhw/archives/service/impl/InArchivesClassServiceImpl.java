package com.minhw.archives.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minhw.archives.mapper.InArchivesClassMapper;
import com.minhw.archives.domain.InArchivesClass;
import com.minhw.archives.service.IInArchivesClassService;

/**
 * 档案收集情况Service业务层处理
 *
 * @author iminhw
 * @date 2022-07-09
 */
@Service
public class InArchivesClassServiceImpl implements IInArchivesClassService {
    @Autowired
    private InArchivesClassMapper inArchivesClassMapper;

    /**
     * 查询档案收集情况
     *
     * @param xuehao 档案收集情况主键
     * @return 档案收集情况
     */
    @Override
    public InArchivesClass selectInArchivesClassByXuehao(String xuehao) {
        return inArchivesClassMapper.selectInArchivesClassByXuehao(xuehao);
    }

    /**
     * 查询档案收集情况列表
     *
     * @param inArchivesClass 档案收集情况
     * @return 档案收集情况
     */
    @Override
    public List<InArchivesClass> selectInArchivesClassList(InArchivesClass inArchivesClass) {
        return inArchivesClassMapper.selectInArchivesClassList(inArchivesClass);
    }

    /**
     * 新增档案收集情况
     *
     * @param inArchivesClass 档案收集情况
     * @return 结果
     */
    @Override
    public int insertInArchivesClass(InArchivesClass inArchivesClass) {
            return inArchivesClassMapper.insertInArchivesClass(inArchivesClass);
    }

    /**
     * 修改档案收集情况
     *
     * @param inArchivesClass 档案收集情况
     * @return 结果
     */
    @Override
    public int updateInArchivesClass(InArchivesClass inArchivesClass) {
        return inArchivesClassMapper.updateInArchivesClass(inArchivesClass);
    }

    /**
     * 批量删除档案收集情况
     *
     * @param xuehaos 需要删除的档案收集情况主键
     * @return 结果
     */
    @Override
    public int deleteInArchivesClassByXuehaos(String[] xuehaos) {
        return inArchivesClassMapper.deleteInArchivesClassByXuehaos(xuehaos);
    }

    /**
     * 删除档案收集情况信息
     *
     * @param xuehao 档案收集情况主键
     * @return 结果
     */
    @Override
    public int deleteInArchivesClassByXuehao(String xuehao) {
        return inArchivesClassMapper.deleteInArchivesClassByXuehao(xuehao);
    }
}
