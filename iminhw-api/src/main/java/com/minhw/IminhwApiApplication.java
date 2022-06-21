package com.minhw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@EnableCaching // 标注启动缓存
/**对自动生存得到的mapper 配置这个不用单个添加@Mapper **/
@MapperScan("com.**.mapper")
@SpringBootApplication
/** 多库连接池使用下方这个 **/
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class IminhwApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(IminhwApiApplication.class, args);
    }
}
