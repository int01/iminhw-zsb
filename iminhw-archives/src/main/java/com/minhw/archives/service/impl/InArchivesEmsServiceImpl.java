package com.minhw.archives.service.impl;

import com.minhw.archives.domain.InArchivesClass;
import com.minhw.archives.domain.InArchivesEms;
import com.minhw.archives.mapper.InArchivesClassMapper;
import com.minhw.archives.mapper.InArchivesEmsMapper;
import com.minhw.archives.service.IInArchivesClassService;
import com.minhw.archives.service.IInArchivesEmsService;
import com.minhw.common.exception.ServiceException;
import com.minhw.common.utils.DateUtils;
import com.minhw.common.utils.StringUtils;
import com.minhw.common.utils.bean.BeanValidators;
import com.minhw.stu.domain.StuMatriculate;
import com.minhw.stu.mapper.StuMatriculateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    protected Validator validator;
    @Autowired
    private InArchivesEmsMapper inArchivesEmsMapper;

    @Autowired
    private InArchivesClassMapper inArchivesClassMapper;

    @Autowired
    private IInArchivesClassService inArchivesClassService;

    @Autowired
    private StuMatriculateMapper stuMatriculateMapper;

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
                InArchivesEms e = inArchivesEmsMapper.selectInArchivesEmsByNowYearKddh(ems.getKddh());
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
                    failureMsg.append("<br/>" + failureNum + "、快递单号 " + ems.getKddh() + " 在本年限内存在");
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
        InArchivesEms archivesEms = inArchivesEmsMapper.selectInArchivesEmsByYearkddh(inArchivesEms);
        if (StringUtils.isNotNull(archivesEms)) {
            inArchivesEmsMapper.updateInArchivesEmsByKddh(inArchivesEms);
            return archivesEms;
        }
        return inArchivesEms;
    }

    @Override
    public Integer selectInArchivesEmsMaxXhByYear(String yearStr) {
        Integer res = inArchivesEmsMapper.selectInArchivesEmsMaxXhByYear(yearStr);
        if (StringUtils.isNull(res)) {
            return 0;
        }
        return res;
    }

    @Override
    public Map<String, Object> updateInArchivesEmsByNowYearKddh(InArchivesEms inArchivesEms) {
        Map<String, Object> resultMap = new HashMap<>();
        Map mapPm = inArchivesEms.getParams();
        String remark = inArchivesEms.getRemark();
        /** 验证此快递单号是不是属于当年的，非当年的不许通过 */
//        if (StringUtils.isNull(inArchivesEmsMapper.selectInArchivesEmsByNowYearKddh(inArchivesEms.getKddh()))) {
//            throw new ServiceException("当前快递单号在当年不存在，请检查导入时间或确认是否录入");
//        }
        /** 将验证快递单号修改为使用快递序号 故上侧注解。验证序号是否存在并且在当年是否多条 */
        List<InArchivesEms> inArchivesEmsList = inArchivesEmsMapper.selectInArchivesEmsByNowYearXhList(inArchivesEms.getXh());
        if (StringUtils.isNull(inArchivesEmsList)) {
            if (inArchivesEmsList.size() > 1) {
                throw new ServiceException("当前快递序号在当年存在多条，请检查录入并修改调整");
            } else {
                throw new ServiceException("当前快递序号在当年不存在，请检查导入时间或确认是否正确录入");
            }
        }
        /** 袋子里面是存在档案时才执行 */
        if ((Boolean) mapPm.get("showSwitch")) {
            /** 必须要录取数据存在该考生 */
            StuMatriculate stuMatriculate = stuMatriculateMapper.selectStuMatriculateByKsh(inArchivesEms.getKsh());
            if (StringUtils.isNull(stuMatriculate)) {
                throw new ServiceException("该考生号在录取数据中不存在");
            }
            if ((Boolean) mapPm.get("getMatUpDateEmsSwitch")) {
                /** 按录取信息补全ems内的基本数据  */
                inArchivesEms.setXm(stuMatriculate.getXm());
                inArchivesEms.setSfzh(stuMatriculate.getSfzh());
            }
            InArchivesClass inArchivesClass = inArchivesClassMapper.selectInArchivesClassByKsh(inArchivesEms.getKsh());
            boolean updateClassSwitch = (Boolean) mapPm.get("updateClassSwitch");
            /** 更新班级档案状态*/
            if (updateClassSwitch) {
                if (StringUtils.isNull(inArchivesClass)) {
                    throw new ServiceException("更新班级档案状态失败，该考生号在档案收集（分班数据）中不存在");
                }
                inArchivesClass.setDazt(1L);
                inArchivesClass.setUpdateBy(inArchivesEms.getUpdateBy());
                inArchivesClass = inArchivesClassService.selectInArchivesClassXhAndUpdateXhBybj(inArchivesClass);
                resultMap.put("updateClass", inArchivesClass);
            } else {
                remark += " 该档案拆袋时班级档案状态未更新，请核对";
                inArchivesEms.setRemark(remark);
            }
            resultMap.put("classEntity", inArchivesClass);
        }
        /** 袋子里面是存在档案时才执行 end */
//        resultMap.put("unpackState", inArchivesEmsMapper.updateInArchivesEmsByNowYearKddh(inArchivesEms));
        resultMap.put("unpackState", inArchivesEmsMapper.updateInArchivesEmsByNowYearXh(inArchivesEms));

        return resultMap;
    }
}
