package com.minhw.archives.service.impl;

import com.minhw.archives.domain.RemainArchives;
import com.minhw.archives.mapper.RemainArchivesMapper;
import com.minhw.archives.service.IRemainArchivesService;
import com.minhw.common.exception.ServiceException;
import com.minhw.common.utils.DateUtils;
import com.minhw.common.utils.StringUtils;
import com.minhw.common.utils.bean.BeanValidators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

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

    @Autowired
    protected Validator validator;

    private static final Logger log = LoggerFactory.getLogger(InArchivesEmsServiceImpl.class);

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
        remainArchives.setCreateTime(DateUtils.getNowDate());
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
        remainArchives.setUpdateTime(DateUtils.getNowDate());
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

    @Override
    public String importRemainArchives(List<RemainArchives> remainArchivesList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(remainArchivesList) || remainArchivesList.size() == 0) {
            throw new ServiceException("导入剩余档案数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (RemainArchives remain : remainArchivesList) {
            try {
                // 验证是否存在相同数据
                RemainArchives r = remainArchivesMapper.selectRemainArchivesRepeat(remain);
                if (StringUtils.isNull(r)) {
                    BeanValidators.validateWithException(validator, remain);
                    remain.setCreateBy(operName);
                    this.insertRemainArchives(remain);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、数据 " + remain + " 导入成功");
                } else if (isUpdateSupport) {
                    BeanValidators.validateWithException(validator, remain);
                    remain.setUpdateBy(operName);
                    this.updateRemainArchives(remain);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、数据 " + remain + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、数据 " + remain + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、数据 " + remain + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum +
                    " 条数据异常（同学年同名数据请提供唯一标识进行区分，如：身份证号），错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
