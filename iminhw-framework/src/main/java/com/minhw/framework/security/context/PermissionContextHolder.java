package com.minhw.framework.security.context;

/**
 * @author minhw
 * @date 2022/8/25 12:16
 */
public class PermissionContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setContext(String permission)
    {
        contextHolder.set(permission);
    }

    public static String getContext()
    {
        return contextHolder.get();
    }
}
