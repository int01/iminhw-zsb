package com.minhw.common.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: iminhw-zsb
 * @description: 自定义文件配置
 * @author: MinHw or mz
 * @create: 2022-06-21 13:39
 **/
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "iminhw")
public class IminhwProperties {

    private boolean captchaOpen;
    private String uploadStaticPath;

}
