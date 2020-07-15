package cn.aixuxi.livedays.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 类描述 时间记录表
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 13:54
 */
@Data
@TableName("daytime")
public class DayTime {
    /**
     * 指定自增策略
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Date startTime;//开始时间
    private Date endTime;//结束时间
    private String cause;//拉黑原因
    private String duration;//持续时间
}
