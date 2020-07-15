package cn.aixuxi.livedays.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 类描述 备忘实体类
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/8 0:19
 */
@Data
@TableName("memo")
public class Memo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Date startTime;
    private Integer userId;
    private String content;
}
