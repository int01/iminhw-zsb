package com.minhw.archives.mapper;

import com.minhw.archives.domain.InArchivesEms;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 邮寄档案Mapper接口
 *
 * @author iminhw
 * @date 2022-07-09
 */
public interface InArchivesEmsMapper {
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
     * 删除邮寄档案
     *
     * @param id 邮寄档案主键
     * @return 结果
     */
    public int deleteInArchivesEmsById(Long id);

    /**
     * 批量删除邮寄档案
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInArchivesEmsByIds(Long[] ids);

    /**
     * @param kddh
     * @return
     */
    InArchivesEms selectInArchivesEmsBykddh(String kddh);

    InArchivesEms selectInArchivesEmsByYearkddh(InArchivesEms inArchivesEms);
    /**
     * 根据单号更新
     *
     * @param inArchivesEms
     * @return
     */
    int updateInArchivesEmsByKddh(InArchivesEms inArchivesEms);

    Integer selectInArchivesEmsMaxXhByYear(@Param("yearStr") String yearStr);

    /**
     * 得到当年快递单号的记录
     * @return
     */
    InArchivesEms selectInArchivesEmsByNowYearKddh(String kddh);

    /**
     * 更新当年导入的快递单号数据
     *
     * @param inArchivesEms
     * @return
     */
    int updateInArchivesEmsByNowYearKddh(InArchivesEms inArchivesEms);

}
