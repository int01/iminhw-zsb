package com.minhw.mapper;

import com.minhw.entity.SysUser01;
import com.minhw.entity.SysUser01Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUser01Mapper {
    long countByExample(SysUser01Example example);

    int deleteByExample(SysUser01Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser01 record);

    int insertSelective(SysUser01 record);

    List<SysUser01> selectByExample(SysUser01Example example);

    int updateByExampleSelective(@Param("record") SysUser01 record, @Param("example") SysUser01Example example);

    int updateByExample(@Param("record") SysUser01 record, @Param("example") SysUser01Example example);
}