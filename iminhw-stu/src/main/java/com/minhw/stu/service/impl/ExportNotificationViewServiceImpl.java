package com.minhw.stu.service.impl;

import com.minhw.stu.domain.ExportNotificationView;
import com.minhw.stu.mapper.ExportNotificationViewMapper;
import com.minhw.stu.service.IExportNotificationViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通知书数据Service业务层处理
 *
 * @author iminhw
 * @date 2022-07-17
 */
@Service
public class ExportNotificationViewServiceImpl implements IExportNotificationViewService {
    @Autowired
    private ExportNotificationViewMapper exportNotificationViewMapper;

    /**
     * 查询通知书数据
     *
     * @param xh 通知书数据主键
     * @return 通知书数据
     */
    @Override
    public ExportNotificationView selectExportNotificationViewByXh(String xh) {
        return exportNotificationViewMapper.selectExportNotificationViewByXh(xh);
    }

    /**
     * 查询通知书数据列表
     *
     * @param exportNotificationView 通知书数据
     * @return 通知书数据
     */
    @Override
    public List<ExportNotificationView> selectExportNotificationViewList(ExportNotificationView exportNotificationView) {
        return exportNotificationViewMapper.selectExportNotificationViewList(exportNotificationView);
    }


}
