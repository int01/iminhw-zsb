package com.minhw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@EnableCaching // 标注启动缓存
//@SpringBootApplication

/**
 * 多库连接池使用下方这个
 *
 * @author mz
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class IminhwApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(IminhwApiApplication.class, args);

        System.out.printf("APP启动成功。");
    }
}
