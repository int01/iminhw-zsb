package com.minhw.entity;

import java.io.Serializable;

public class SysUser01 implements Serializable {
    private Integer id;

    private static final long serialVersionUID = 1L;

    public SysUser01(Integer id) {
        this.id = id;
    }

    public SysUser01() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}