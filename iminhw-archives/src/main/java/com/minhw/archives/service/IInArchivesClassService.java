package com.minhw.archives.service;

import com.minhw.archives.domain.InArchivesClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 档案收集Service接口
 *
 * @author iminhw
 * @date 2022-07-09
 */
public interface IInArchivesClassService {
    /**
     * 查询档案收集
     *
     * @param xuehao 档案收集主键
     * @return 档案收集
     */
    public InArchivesClass selectInArchivesClassByXuehao(String xuehao);

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
     * 批量删除档案收集
     *
     * @param xuehaos 需要删除的档案收集主键集合
     * @return 结果
     */
    public int deleteInArchivesClassByXuehaos(String[] xuehaos);

    /**
     * 删除档案收集信息
     *
     * @param xuehao 档案收集主键
     * @return 结果
     */
    public int deleteInArchivesClassByXuehao(String xuehao);

    String importInArchivesClass(List<InArchivesClass> inArchivesClassList, boolean isUpdateSupport, String operName);

    List<InArchivesClass> selectInArchivesClassByBj(InArchivesClass inArchivesClass);

    InArchivesClass selectInArchivesClassByKshOrXueHOrSfzh(InArchivesClass inArchivesClass);

    int selectInArchivesClassMaxXhBybj(String bj);

    InArchivesClass selectInArchivesClassXhAndUpdateXhBybj(InArchivesClass inArchivesClass);
}
