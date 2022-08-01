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
            failureMsg.insert(0, "导入成功 " + successNum + "条，" + "导入失败 " + failureNum + " 条数据异常，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();

    }

    @Override
    public List<InArchivesClass> selectInArchivesClassByBj(InArchivesClass inArchivesClass) {
        return inArchivesClassMapper.selectInArchivesClassByBj(inArchivesClass);
    }

    @Override
    public InArchivesClass selectInArchivesClassByKshOrXueHOrSfzh(InArchivesClass inArchivesClass) {
        InArchivesClass inArchivesClassRes = inArchivesClassMapper.selectInArchivesClassByKshOrXueHOrSfzh(inArchivesClass);
        if (StringUtils.isNull(inArchivesClassRes)) {
            throw new ServiceException("在班级数据中查不到此人");
        }
        return this.selectInArchivesClassXhAndUpdateXhBybj(inArchivesClassRes);
    }

    @Override
    public int selectInArchivesClassMaxXhBybj(String bj) {
        Integer res = inArchivesClassMapper.selectInArchivesClassMaxXhBybj(bj);
        if (StringUtils.isNull(res)) {
            return 0;
        }
        return res;
    }

    @Override
    public InArchivesClass selectInArchivesClassXhAndUpdateXhBybj(InArchivesClass inArchivesClass) {
        Integer res = inArchivesClassMapper.selectInArchivesClassMaxXhBybj(inArchivesClass.getBj());
        if (StringUtils.isNull(res)) {
            res = 0;
        }
        Long xh = inArchivesClass.getXh();
        /** 如果序号不存在，则系统自动在此人班级最大序号+1，并赋予此人 */
        if (xh == null || xh < 1) {
            inArchivesClass.setXh(Long.valueOf(res + 1));
//            防止用户停留在页面不操作，导致序号被其他用户暂用，使用及时更新，就不使用mq了
//            同时将邮寄档案的状态也一起更新，但当序号存在时，不会更新档案状态
        }
// 在括号里面 当ems档案调用时，不会更新档案状态
        inArchivesClassMapper.updateInArchivesClass(inArchivesClass);
        return inArchivesClass;
    }
}
