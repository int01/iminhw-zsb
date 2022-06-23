package com.minhw.web.controller.system;

import com.minhw.common.config.IminhwProperties;
import com.minhw.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author minhw
 */
@RestController
public class SysIndexController {
    /**
     * 系统基础配置
     */
    @Autowired
    private IminhwProperties iminhwProperties;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index() {
        return StringUtils.format("成航招办{}api接口，当前版本：v{}，请通过正常地址访问。<br/>开发者：闵宏维<br/>Email：iminhw@qq.com", iminhwProperties.getName(), iminhwProperties.getVersion());
    }
}
