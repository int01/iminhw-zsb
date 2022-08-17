package com.minhw.analysis.domain;

import java.io.Serializable;

/**
 * @program: iminhw-zsb
 * @description: 查询人数通知接口封装
 * @author: MinHw or mz
 * @create: 2022-08-17 16:30
 **/
public class AnalysisIndex2  implements Serializable {
    private String dq;

    private Integer value;

    private String year;

    public String getDq() {
        return dq;
    }

    public void setDq(String dq) {
        this.dq = dq;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
