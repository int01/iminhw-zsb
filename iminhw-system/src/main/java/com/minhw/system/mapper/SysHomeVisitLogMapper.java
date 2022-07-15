package com.minhw.system.mapper;

import com.minhw.system.domain.SysHomeVisitLog;

import java.util.List;

/**
 * @program: iminhw-zsb
 * @description:
 * @author: MinHw
 * @create: 2022-07-15 19:51
 **/
public interface SysHomeVisitLogMapper {

    /**
     * 查询系统前台访问日志集合
     *
     * @param sysHomeVisitLog 前台访问日志对象
     * @return 前台访问日志集合
     */
    public List<SysHomeVisitLog> selectHomeVisitLogList(SysHomeVisitLog sysHomeVisitLog);

    /**
     * 批量删除系统前台访问日志
     *
     * @param operIds 需要删除的前台访问日志ID
     * @return 结果
     */
    public int deleteHomeVisitLogByIds(Long[] operIds);

    /**
     * 查询前台访问日志详细
     *
     * @param operId 前台访问ID
     * @return 前台访问日志对象
     */
    public SysHomeVisitLog selectHomeVisitLogById(Long operId);

    /**
     * 清空前台访问日志
     */
    public void cleanHomeVisitLog();
}
