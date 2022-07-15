package com.minhw.system.service;

import com.minhw.system.domain.SysHomeVisitLog;

import java.util.List;

/**
 * @program: iminhw-zsb
 * @description:
 * @author: MinHw
 * @create: 2022-07-15 20:07
 **/
public interface ISysHomeVisitLogService {
    /**
     * 查询系统前台访问日志集合
     *
     * @param sysHomeVisitLog 前台访问日志对象
     * @return 前台访问日志集合
     */
     List<SysHomeVisitLog> selectHomeVisitLogList(SysHomeVisitLog sysHomeVisitLog);

    /**
     * 批量删除系统前台访问日志
     *
     * @param visitIds 需要删除的前台访问日志ID
     * @return 结果
     */
     int deleteHomeVisitLogByIds(Long[] visitIds);

    /**
     * 查询前台访问日志详细
     *
     * @param visitId 前台访问ID
     * @return 前台访问日志对象
     */
    SysHomeVisitLog selectHomeVisitLogById(Long visitId);

    /**
     * 清空前台访问日志
     */
     void cleanHomeVisitLog();
}
