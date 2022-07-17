package com.minhw.stu.service;

import java.util.List;
import com.minhw.stu.domain.ExportNotificationView;

/**
 * 通知书数据Service接口
 * 
 * @author iminhw
 * @date 2022-07-17
 */
public interface IExportNotificationViewService 
{
    /**
     * 查询通知书数据
     * 
     * @param xh 通知书数据主键
     * @return 通知书数据
     */
    public ExportNotificationView selectExportNotificationViewByXh(String xh);

    /**
     * 查询通知书数据列表
     * 
     * @param exportNotificationView 通知书数据
     * @return 通知书数据集合
     */
    public List<ExportNotificationView> selectExportNotificationViewList(ExportNotificationView exportNotificationView);

}
