package com.minhw.framework.web.service;

import com.minhw.common.constant.CacheConstants;
import com.minhw.common.constant.Constants;
import com.minhw.common.core.domain.entity.SysUser;
import com.minhw.common.core.redis.RedisCache;
import com.minhw.common.exception.user.UserPasswordNotMatchException;
import com.minhw.common.exception.user.UserPasswordRetryLimitExceedException;
import com.minhw.common.utils.MessageUtils;
import com.minhw.common.utils.SecurityUtils;
import com.minhw.common.utils.ServletUtils;
import com.minhw.common.utils.ip.IpUtils;
import com.minhw.framework.manager.AsyncManager;
import com.minhw.framework.manager.factory.AsyncFactory;
import com.minhw.framework.security.context.AuthenticationContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @program: iminhw-zsb
 * @description:
 * @author: MinHw or mz
 * @create: 2022-08-02 00:19
 **/
@Component
public class SysPasswordService {
    @Autowired
    private RedisCache redisCache;

    @Value(value = "${user.password.maxRetryCount}")
    private int maxRetryCount;

    @Value(value = "${user.password.lockTime}")
    private int lockTime;

    /**
     * 登录账户密码错误次数缓存键名
     *
     * @param username 用户名
     * @return 缓存键key
     */
    private String getCacheKey(String username) {
        return CacheConstants.PWD_ERR_CNT_KEY + username + IpUtils.getIpAddr(ServletUtils.getRequest());
    }

    /**
     *
     * @param user
     */
    public void validate(SysUser user) {
        Authentication usernamePasswordAuthenticationToken = AuthenticationContextHolder.getContext();
        String username = usernamePasswordAuthenticationToken.getName();
        String password = usernamePasswordAuthenticationToken.getCredentials().toString();

        if (Integer.valueOf(maxRetryCount).intValue() >0 || Integer.valueOf(lockTime).intValue() > 0) {
            Integer retryCount = redisCache.getCacheObject(getCacheKey(username));

            if (retryCount == null) {
                retryCount = 0;
            }

            if (retryCount >= Integer.valueOf(maxRetryCount).intValue()) {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
                        MessageUtils.message("user.password.retry.limit.exceed", maxRetryCount, lockTime)));
                throw new UserPasswordRetryLimitExceedException(maxRetryCount, lockTime);
            }

            if (!matches(user, password)) {
                retryCount = retryCount + 1;
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
                        MessageUtils.message("user.password.retry.limit.count", retryCount)));
                redisCache.setCacheObject(getCacheKey(username), retryCount, lockTime, TimeUnit.MINUTES);
                throw new UserPasswordNotMatchException();
            } else {
                clearLoginRecordCache(username);
            }
        }
    }

    public boolean matches(SysUser user, String rawPassword) {
        return SecurityUtils.matchesPassword(rawPassword, user.getPassword());
    }

    public void clearLoginRecordCache(String loginName) {
        if (redisCache.hasKey(getCacheKey(loginName))) {
            redisCache.deleteObject(getCacheKey(loginName));
        }
    }
}