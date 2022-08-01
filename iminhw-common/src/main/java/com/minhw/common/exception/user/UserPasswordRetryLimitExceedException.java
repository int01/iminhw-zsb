package com.minhw.common.exception.user;

/**
 * @program: iminhw-zsb
 * @description: 用户错误最大次数异常类
 * @author: MinHw or mz
 * @create: 2022-08-02 00:16
 **/
public class UserPasswordRetryLimitExceedException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserPasswordRetryLimitExceedException(int retryLimitCount, int lockTime) {
        super("user.password.retry.limit.exceed", new Object[]{retryLimitCount, lockTime});
    }
}
