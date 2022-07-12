package com.minhw.stu.service;

import com.minhw.stu.domain.StuOutNotification;

import java.util.List;

/**
 * 通知书邮寄记录Service接口
 *
 * @author iminhw
 * @date 2022-07-12
 */
public interface IStuOutNotificationService {
    /**
     * 查询通知书邮寄记录
     *
     * @param ksh 通知书邮寄记录主键
     * @return 通知书邮寄记录
     */
    public StuOutNotification selectStuOutNotificationByKsh(String ksh);

    /**
     * 查询通知书邮寄记录列表
     *
     * @param stuOutNotification 通知书邮寄记录
     * @return 通知书邮寄记录集合
     */
    public List<StuOutNotification> selectStuOutNotificationList(StuOutNotification stuOutNotification);

    /**
     * 新增通知书邮寄记录
     *
     * @param stuOutNotification 通知书邮寄记录
     * @return 结果
     */
    public int insertStuOutNotification(StuOutNotification stuOutNotification);

    /**
     * 修改通知书邮寄记录
     *
     * @param stuOutNotification 通知书邮寄记录
     * @return 结果
     */
    public int updateStuOutNotification(StuOutNotification stuOutNotification);

    /**
     * 批量删除通知书邮寄记录
     *
     * @param kshs 需要删除的通知书邮寄记录主键集合
     * @return 结果
     */
    public int deleteStuOutNotificationByKshs(String[] kshs);

    /**
     * 删除通知书邮寄记录信息
     *
     * @param ksh 通知书邮寄记录主键
     * @return 结果
     */
    public int deleteStuOutNotificationByKsh(String ksh);

    String importStuOutNotification(List<StuOutNotification> stuOutNotificationList, boolean isUpdateSupport, String operName);

}
