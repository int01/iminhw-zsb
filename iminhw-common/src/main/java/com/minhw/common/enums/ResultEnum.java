package com.minhw.common.enums;

import lombok.Getter;

/**
 * 后台返回结果集枚举
 * @author minhw
 */
@Getter
public enum ResultEnum implements ResultInterface {

    /**
     * 通用状态
     */
    SUCCESS(200, "成功"),
    ERROR(400, "错误"),

    /**
     * 账户问题
     */
    USER_EXIST(401, "用户名已经存在"),
    USER_PWD_NULL(402, "密码不能为空"),
    USER_INEQUALITY(403, "两次密码不一致"),
    USER_OLD_PWD_ERROR(404, "原密码不正确"),
    USER_NAME_PWD_NULL(405, "用户名和密码不能为空"),
    USER_CAPTCHA_ERROR(406, "验证码错误"),

    USER_LOGIN_SUCCESS(200,"登陆成功"),
    USER_LOGIN_UP_NULL(500,"账户已被冻结或不存在"),
    USER_LOGIN_ERROR(400,"账号或密码错误"),

    /**
     * 注册
     */
    USER_REGISTER_SUCESS(200, "注册成功"),
    USER_REGISTER_ERROR(501, "注册异常，请联系管理员"),

    /**
     * 角色问题
     */
    ROLE_EXIST(401, "角色标识已经存在，不允许重复！"),

    /**
     * 部门问题
     */
    DEPT_EXIST_USER(401, "部门存在用户，无法删除"),

    /**
     * 字典问题
     */
    DICT_EXIST(401, "该字典标识已经存在，不允许重复！"),

    /**
     * 非法操作
     */
    STATUS_ERROR(401, "非法操作：状态有误"),

    /**
     * 权限问题
     */
    NO_PERMISSIONS(401, "权限不足！"),
    NO_ADMIN_AUTH(500, "不允许操作超级管理员"),
    NO_ADMIN_STATUS(501, "不能修改超级管理员状态"),
    NO_ADMINROLE_AUTH(500, "不允许操作管理员角色"),
    NO_ADMINROLE_STATUS(501, "不能修改管理员角色状态"),

    /**
     * 文件问题
     */
    FILE_UPLOAD_ERROR(501,"上传失败"),
    NO_FILE_NULL(401, "文件不能为空"),
    NO_FILE_TYPE(402, "不支持该文件类型"),


    ;

    private Integer status;

    private String message;

    ResultEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
