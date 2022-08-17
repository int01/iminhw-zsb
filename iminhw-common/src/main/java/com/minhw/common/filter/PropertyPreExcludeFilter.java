package com.minhw.common.filter;

import com.alibaba.fastjson2.filter.SimplePropertyPreFilter;

/**
 * @program: iminhw-zsb
 * @description: 排除JSON敏感属性
 * @author: MinHw or mz
 * @create: 2022-08-17 14:56
 **/
public class PropertyPreExcludeFilter extends SimplePropertyPreFilter {
    public PropertyPreExcludeFilter() {
    }

    public PropertyPreExcludeFilter addExcludes(String... filters) {
        for (int i = 0; i < filters.length; i++) {
            this.getExcludes().add(filters[i]);
        }
        return this;
    }
}
