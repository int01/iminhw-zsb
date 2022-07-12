package com.minhw.stu.service.impl;

import com.minhw.common.exception.ServiceException;
import com.minhw.common.utils.DateUtils;
import com.minhw.common.utils.StringUtils;
import com.minhw.common.utils.bean.BeanValidators;
import com.minhw.stu.domain.StuOutNotification;
import com.minhw.stu.mapper.StuOutNotificationMapper;
import com.minhw.stu.service.IStuOutNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

/**
 * 通知书邮寄记录Service业务层处理
 *
 * @author iminhw
 * @date 2022-07-12
 */
@Service
public class StuOutNotificationServiceImpl implements IStuOutNotificationService {
    private static final Logger log = LoggerFactory.getLogger(StuOutNotificationServiceImpl.class);

    @Autowired
    private Validator validator;
    @Autowired
    private StuOutNotificationMapper stuOutNotificationMapper;

    /**
     * 查询通知书邮寄记录
     *
     * @param ksh 通知书邮寄记录主键
     * @return 通知书邮寄记录
     */
    @Override
    public StuOutNotification selectStuOutNotificationByKsh(String ksh) {
        return stuOutNotificationMapper.selectStuOutNotificationByKsh(ksh);
    }

    /**
     * 查询通知书邮寄记录列表
     *
     * @param stuOutNotification 通知书邮寄记录
     * @return 通知书邮寄记录
     */
    @Override
    public List<StuOutNotification> selectStuOutNotificationList(StuOutNotification stuOutNotification) {
        return stuOutNotificationMapper.selectStuOutNotificationList(stuOutNotification);
    }

    /**
     * 新增通知书邮寄记录
     *
     * @param stuOutNotification 通知书邮寄记录
     * @return 结果
     */
    @Override
    public int insertStuOutNotification(StuOutNotification stuOutNotification) {
        if (StringUtils.isNotNull(stuOutNotificationMapper.selectStuOutNotificationByKsh(stuOutNotification.getKsh()))) {
            throw new ServiceException("考生号不允许重复");
        }
        stuOutNotification.setCreateTime(DateUtils.getNowDate());
        return stuOutNotificationMapper.insertStuOutNotification(stuOutNotification);
    }

    /**
     * 修改通知书邮寄记录
     *
     * @param stuOutNotification 通知书邮寄记录
     * @return 结果
     */
    @Override
    public int updateStuOutNotification(StuOutNotification stuOutNotification) {
        stuOutNotification.setUpdateTime(DateUtils.getNowDate());
        return stuOutNotificationMapper.updateStuOutNotification(stuOutNotification);
    }

    /**
     * 批量删除通知书邮寄记录
     *
     * @param kshs 需要删除的通知书邮寄记录主键
     * @return 结果
     */
    @Override
    public int deleteStuOutNotificationByKshs(String[] kshs) {
        return stuOutNotificationMapper.deleteStuOutNotificationByKshs(kshs);
    }

    /**
     * 删除通知书邮寄记录信息
     *
     * @param ksh 通知书邮寄记录主键
     * @return 结果
     */
    @Override
    public int deleteStuOutNotificationByKsh(String ksh) {
        return stuOutNotificationMapper.deleteStuOutNotificationByKsh(ksh);
    }

    @Override
    public String importStuOutNotification(List<StuOutNotification> stuOutNotificationList, boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(stuOutNotificationList) || stuOutNotificationList.size() == 0) {
            throw new ServiceException("导入通知书邮寄记录数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (StuOutNotification stuOutNotification : stuOutNotificationList) {
            try {
                if (StringUtils.isNotEmpty(stuOutNotification.getKsh())) {
                    // 验证是否存在
                    StuOutNotification ot = stuOutNotificationMapper.selectStuOutNotificationByKsh(stuOutNotification.getKsh());
                    if (StringUtils.isNull(ot)) {
                        BeanValidators.validateWithException(validator, stuOutNotification);
                        stuOutNotification.setCreateBy(operName);
                        this.insertStuOutNotification(stuOutNotification);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、 " + stuOutNotification + " 导入成功");
                    } else if (isUpdateSupport) {
                        BeanValidators.validateWithException(validator, stuOutNotification);
                        stuOutNotification.setUpdateBy(operName);
                        this.updateStuOutNotification(stuOutNotification);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、 " + stuOutNotification + " 更新成功");
                    } else {
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、 " + stuOutNotification + " 已存在");
                    }
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、 " + stuOutNotification + " 考生号为空");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、 " + stuOutNotification + " 导入失败：";
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
}
