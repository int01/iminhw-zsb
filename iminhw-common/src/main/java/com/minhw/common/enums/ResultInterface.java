package com.minhw.common.enums;

/**
 * @program: DataReporting
 * @description: ResultInterface 结果枚举接口
 * @author: MinHw or mz
 * @create: 2022-03-23 13:36
 **/
public interface ResultInterface {
    /**
     * 获取状态编码
     * @return 编码
     */
    Integer getStatus();

    /**
     * 获取提示信息
     * @return 提示信息
     */
     String getMessage();
}
