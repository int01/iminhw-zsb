package com.minhw.archives.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minhw.archives.mapper.RemainArchivesMapper;
import com.minhw.archives.domain.RemainArchives;
import com.minhw.archives.service.IRemainArchivesService;

/**
 * 剩余档案Service业务层处理
 *
 * @author iminhw
 * @date 2022-07-09
 */
@Service
public class RemainArchivesServiceImpl implements IRemainArchivesService {
    @Autowired
    private RemainArchivesMapper remainArchivesMapper;

    /**
     * 查询剩余档案
     *
     * @param id 剩余档案主键
     * @return 剩余档案
     */
    @Override
    public RemainArchives selectRemainArchivesById(Long id) {
        return remainArchivesMapper.selectRemainArchivesById(id);
    }

    /**
     * 查询剩余档案列表
     *
     * @param remainArchives 剩余档案
     * @return 剩余档案
     */
    @Override
    public List<RemainArchives> selectRemainArchivesList(RemainArchives remainArchives) {
        return remainArchivesMapper.selectRemainArchivesList(remainArchives);
    }

    /**
     * 新增剩余档案
     *
     * @param remainArchives 剩余档案
     * @return 结果
     */
    @Override
    public int insertRemainArchives(RemainArchives remainArchives) {
            return remainArchivesMapper.insertRemainArchives(remainArchives);
    }

    /**
     * 修改剩余档案
     *
     * @param remainArchives 剩余档案
     * @return 结果
     */
    @Override
    public int updateRemainArchives(RemainArchives remainArchives) {
        return remainArchivesMapper.updateRemainArchives(remainArchives);
    }

    /**
     * 批量删除剩余档案
     *
     * @param ids 需要删除的剩余档案主键
     * @return 结果
     */
    @Override
    public int deleteRemainArchivesByIds(Long[] ids) {
        return remainArchivesMapper.deleteRemainArchivesByIds(ids);
    }

    /**
     * 删除剩余档案信息
     *
     * @param id 剩余档案主键
     * @return 结果
     */
    @Override
    public int deleteRemainArchivesById(Long id) {
        return remainArchivesMapper.deleteRemainArchivesById(id);
    }
}
