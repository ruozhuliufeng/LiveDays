package cn.aixuxi.livedays;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@MapperScan("cn.aixuxi.livedays.mapper")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class LivedaysApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivedaysApplication.class, args);
    }

}
