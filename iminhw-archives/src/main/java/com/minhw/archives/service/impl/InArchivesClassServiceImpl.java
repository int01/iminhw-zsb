package com.minhw.archives.service.impl;

import com.minhw.archives.domain.InArchivesClass;
import com.minhw.archives.mapper.InArchivesClassMapper;
import com.minhw.archives.service.IInArchivesClassService;
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
 * 档案收集Service业务层处理
 *
 * @author iminhw
 * @date 2022-07-09
 */
@Service
public class InArchivesClassServiceImpl implements IInArchivesClassService {

    private static final Logger log = LoggerFactory.getLogger(InArchivesClassServiceImpl.class);
    @Autowired
    private InArchivesClassMapper inArchivesClassMapper;

    @Autowired
    private Validator validator;

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

    @Override
    public String importInArchivesClass(List<InArchivesClass> inArchivesClassList, boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(inArchivesClassList) || inArchivesClassList.size() == 0) {
            throw new ServiceException("导入档案收集数据或分班数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (InArchivesClass inArchivesClass : inArchivesClassList) {
            try {
                if (StringUtils.isNotEmpty(inArchivesClass.getXuehao())) {
                    // 验证是否存在
                    InArchivesClass inAClass = inArchivesClassMapper.selectInArchivesClassByXuehao(inArchivesClass.getXuehao());
                    if (StringUtils.isNull(inAClass)) {
                        BeanValidators.validateWithException(validator, inArchivesClass);
                        inArchivesClass.setCreateBy(operName);
                        this.insertInArchivesClass(inArchivesClass);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、学号 " + inArchivesClass.getXuehao() + " 导入成功");
                    } else if (isUpdateSupport) {
                        BeanValidators.validateWithException(validator, inArchivesClass);
                        inArchivesClass.setUpdateBy(operName);
                        this.updateInArchivesClass(inArchivesClass);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、考生号 " + inArchivesClass.getXuehao() + " 更新成功");
                    } else {
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、考生号 " + inArchivesClass.getXuehao() + " 已存在");
                    }
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、 " + inArchivesClass + " 学号为空");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、 " + inArchivesClass + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "导入成功 " + successNum + "条，" +"导入失败 " + failureNum + " 条数据异常，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();

    }
}
