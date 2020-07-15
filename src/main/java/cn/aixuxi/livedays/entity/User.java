package cn.aixuxi.livedays.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 类描述  数据库实体类
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 12:47
 */

@Data
@TableName("user")
public class User {
    /**
     * 指定自增策略
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    //用户名
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String email;
    //是否为主用户
    private Integer isMaster;
    // 绑定码
    private String binding;
    //是否公开
    private Integer isPublic;
    // 最高时长
    private String duration;
    // 邮箱验证码
    private String code;
    // 是否激活
    private Integer status;
    // 是否在黑名单
    private Integer isBlacklist;
}
