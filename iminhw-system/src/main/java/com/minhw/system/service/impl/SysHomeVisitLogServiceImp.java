package com.minhw.system.service.impl;

import com.minhw.system.domain.SysHomeVisitLog;
import com.minhw.system.mapper.SysHomeVisitLogMapper;
import com.minhw.system.service.ISysHomeVisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: iminhw-zsb
 * @description:
 * @author: MinHw or mz
 * @create: 2022-07-15 20:07
 **/
@Service
public class SysHomeVisitLogServiceImp implements ISysHomeVisitLogService {

    @Autowired
    private SysHomeVisitLogMapper sysHomeVisitLogMapper;

    @Override
    public List<SysHomeVisitLog> selectHomeVisitLogList(SysHomeVisitLog sysHomeVisitLog) {
        return sysHomeVisitLogMapper.selectHomeVisitLogList(sysHomeVisitLog);
    }

    @Override
    public int deleteHomeVisitLogByIds(Long[] visitIds) {
        return sysHomeVisitLogMapper.deleteHomeVisitLogByIds(visitIds);
    }

    @Override
    public SysHomeVisitLog selectHomeVisitLogById(Long visitId) {
        return sysHomeVisitLogMapper.selectHomeVisitLogById(visitId);
    }

    @Override
    public void cleanHomeVisitLog() {
        sysHomeVisitLogMapper.cleanHomeVisitLog();
    }
}
