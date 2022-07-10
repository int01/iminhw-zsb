package com.minhw.archives.service.impl;

import com.minhw.archives.domain.InArchivesEms;
import com.minhw.archives.mapper.InArchivesEmsMapper;
import com.minhw.archives.service.IInArchivesEmsService;
import com.minhw.common.core.domain.entity.SysUser;
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
 * 邮寄档案Service业务层处理
 *
 * @author iminhw
 * @date 2022-07-09
 */
@Service
public class InArchivesEmsServiceImpl implements IInArchivesEmsService {
    private static final Logger log = LoggerFactory.getLogger(InArchivesEmsServiceImpl.class);
    @Autowired
    private InArchivesEmsMapper inArchivesEmsMapper;

    @Autowired
    protected Validator validator;

    /**
     * 查询邮寄档案
     *
     * @param id 邮寄档案主键
     * @return 邮寄档案
     */
    @Override
    public InArchivesEms selectInArchivesEmsById(Long id) {
        return inArchivesEmsMapper.selectInArchivesEmsById(id);
    }

    /**
     * 查询邮寄档案列表
     *
     * @param inArchivesEms 邮寄档案
     * @return 邮寄档案
     */
    @Override
    public List<InArchivesEms> selectInArchivesEmsList(InArchivesEms inArchivesEms) {
        return inArchivesEmsMapper.selectInArchivesEmsList(inArchivesEms);
    }

    /**
     * 新增邮寄档案
     *
     * @param inArchivesEms 邮寄档案
     * @return 结果
     */
    @Override
    public int insertInArchivesEms(InArchivesEms inArchivesEms) {
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
    public int updateInArchivesEms(InArchivesEms inArchivesEms) {
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
    public int deleteInArchivesEmsByIds(Long[] ids) {
        return inArchivesEmsMapper.deleteInArchivesEmsByIds(ids);
    }

    /**
     * 删除邮寄档案信息
     *
     * @param id 邮寄档案主键
     * @return 结果
     */
    @Override
    public int deleteInArchivesEmsById(Long id) {
        return inArchivesEmsMapper.deleteInArchivesEmsById(id);
    }

    @Override
    public String importArchivesEms(List<InArchivesEms> inArchivesEmsList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(inArchivesEmsList) || inArchivesEmsList.size() == 0) {
            throw new ServiceException("导入快递单号数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (InArchivesEms ems : inArchivesEmsList) {
            try {
                // 验证是否存在这个快递单号
                InArchivesEms e = inArchivesEmsMapper.selectInArchivesEmsBykddh(ems.getKddh());
                if (StringUtils.isNull(e)) {
                    BeanValidators.validateWithException(validator, ems);
                    ems.setCreateBy(operName);
                    this.insertInArchivesEms(ems);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、快递单号 " + ems.getKddh() + " 导入成功");
                } else if (isUpdateSupport) {
                    BeanValidators.validateWithException(validator, ems);
                    ems.setUpdateBy(operName);
                    this.updateInArchivesEms(ems);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、快递单号 " + ems.getKddh() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、快递单号 " + ems.getKddh() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、快递单号 " + ems.getKddh() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据异常，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public InArchivesEms updateInArchivesEmsByKddh(InArchivesEms inArchivesEms) {
        InArchivesEms archivesEms = inArchivesEmsMapper.selectInArchivesEmsBykddh(inArchivesEms.getKddh());
        if (StringUtils.isNotNull(archivesEms)) {
            inArchivesEmsMapper.updateInArchivesEmsByKddh(inArchivesEms);
            return archivesEms;
        }
        return inArchivesEms;
    }
}
