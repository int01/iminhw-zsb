package com.minhw.common.exception.user;

/**
 * @program: iminhw-zsb
 * @description: 用户登陆设备数量限制异常类
 * @author: MinHw or mz
 * @create: 2022-08-02 01:31
 **/
public class UserAccountEquipmentLimitLoginException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserAccountEquipmentLimitLoginException(String code, Object[] args) {
        super(code, args);
    }
}
