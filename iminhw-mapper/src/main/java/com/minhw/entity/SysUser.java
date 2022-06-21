package com.minhw.entity;

import java.io.Serializable;

public class SysUser implements Serializable {
    private Integer id;

    private static final long serialVersionUID = 1L;

    public SysUser(Integer id) {
        this.id = id;
    }

    public SysUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}