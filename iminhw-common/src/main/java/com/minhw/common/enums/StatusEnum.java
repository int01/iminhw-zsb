package com.minhw.common.enums;

import lombok.Getter;

/**
 * 数据状态枚举-用于逻辑删除控制
 * @author mz
 */
@Getter
public enum StatusEnum {

    /**
     * 数据已被删除
     */
    DELETE(StatusConst.DELETE, "删除"),
    /**
     * 被冻结的数据，不可用
     */
    FREEZED(StatusConst.FREEZED, "冻结"),
    /**
     * 正常的数据
     */
    OK(StatusConst.OK, "启用");

    private byte code;

    private String message;

    StatusEnum(byte code, String message) {
        this.code = code;
        this.message = message;
    }
}

