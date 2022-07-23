package com.minhw.stu.service.impl;

import com.minhw.common.exception.ServiceException;
import com.minhw.common.utils.DateUtils;
import com.minhw.common.utils.StringUtils;
import com.minhw.common.utils.bean.BeanValidators;
import com.minhw.stu.domain.StuMatriculate;
import com.minhw.stu.mapper.StuMatriculateMapper;
import com.minhw.stu.service.IStuMatriculateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

/**
 * 录取数据Service业务层处理
 *
 * @author iminhw
 * @date 2022-07-11
 */
@Service
public class StuMatriculateServiceImpl implements IStuMatriculateService {
    private static final Logger log = LoggerFactory.getLogger(StuMatriculateServiceImpl.class);
    @Autowired
    private StuMatriculateMapper stuMatriculateMapper;

    @Autowired
    private Validator validator;

    /**
     * 查询录取数据
     *
     * @param ksh 录取数据主键
     * @return 录取数据
     */
    @Override
    public StuMatriculate selectStuMatriculateByKsh(String ksh) {
        return stuMatriculateMapper.selectStuMatriculateByKsh(ksh);
    }

    /**
     * 查询录取数据列表
     *
     * @param stuMatriculate 录取数据
     * @return 录取数据
     */
    @Override
    public List<StuMatriculate> selectStuMatriculateList(StuMatriculate stuMatriculate) {
        return stuMatriculateMapper.selectStuMatriculateList(stuMatriculate);
    }

    /**
     * 新增录取数据
     *
     * @param stuMatriculate 录取数据
     * @return 结果
     */
    @Override
    public int insertStuMatriculate(StuMatriculate stuMatriculate) {
        if (StringUtils.isNotNull(stuMatriculateMapper.selectStuMatriculateByKsh(stuMatriculate.getKsh()))) {
            throw new ServiceException("考生号不允许重复");
        }
        stuMatriculate.setCreateTime(DateUtils.getNowDate());
        return stuMatriculateMapper.insertStuMatriculate(stuMatriculate);
    }

    /**
     * 修改录取数据
     *
     * @param stuMatriculate 录取数据
     * @return 结果
     */
    @Override
    public int updateStuMatriculate(StuMatriculate stuMatriculate) {
        stuMatriculate.setUpdateTime(DateUtils.getNowDate());
        return stuMatriculateMapper.updateStuMatriculate(stuMatriculate);
    }

    /**
     * 批量删除录取数据
     *
     * @param kshs 需要删除的录取数据主键
     * @return 结果
     */
    @Override
    public int deleteStuMatriculateByKshs(String[] kshs) {
        return stuMatriculateMapper.deleteStuMatriculateByKshs(kshs);
    }

    /**
     * 删除录取数据信息
     *
     * @param ksh 录取数据主键
     * @return 结果
     */
    @Override
    public int deleteStuMatriculateByKsh(String ksh) {
        return stuMatriculateMapper.deleteStuMatriculateByKsh(ksh);
    }

    @Override
    public String importStuMatriculate(List<StuMatriculate> stuMatriculateList, boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(stuMatriculateList) || stuMatriculateList.size() == 0) {
            throw new ServiceException("导入录取数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (StuMatriculate matriculate : stuMatriculateList) {
            try {
                if (StringUtils.isNotEmpty(matriculate.getKsh())) {
                    // 验证是否存在
                    StuMatriculate m = stuMatriculateMapper.selectStuMatriculateByKsh(matriculate.getKsh());
                    if (StringUtils.isNull(m)) {
                        BeanValidators.validateWithException(validator, matriculate);
                        matriculate.setCreateBy(operName);
                        this.insertStuMatriculate(matriculate);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、考生号 " + matriculate.getKsh() + " 导入成功");
                    } else if (isUpdateSupport) {
                        BeanValidators.validateWithException(validator, matriculate);
                        matriculate.setUpdateBy(operName);
                        this.updateStuMatriculate(matriculate);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、考生号 " + matriculate.getKsh() + " 更新成功");
                    } else {
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、考生号 " + matriculate.getKsh() + " 已存在");
                    }
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、 " + matriculate + " 考生号为空");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、 " + matriculate + " 导入失败：";
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
