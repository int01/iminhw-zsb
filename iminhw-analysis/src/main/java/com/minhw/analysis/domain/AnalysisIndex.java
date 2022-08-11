package com.minhw.analysis.domain;

import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

import java.io.Serializable;

/**
 *
 * @author iminhw
 * @date 2022-08-11
 */
public class AnalysisIndex implements Serializable {

    /**
     * 类型名称
     */
    private String name;

    /**
     * 类型值
     */
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
