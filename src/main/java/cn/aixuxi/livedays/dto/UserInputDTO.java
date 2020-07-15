package cn.aixuxi.livedays.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 类描述 界面输入用户DTO
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 13:32
 */
@Data
public class UserInputDTO {
    private String username;
    private String password;
    private String email;
    private String sex;
    private String phone;
    private String isMaster;
    private String binding;
//    private MultipartFile img;
}
