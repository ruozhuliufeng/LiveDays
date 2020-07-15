package cn.aixuxi.livedays.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 类描述 问题解决计划表
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 13:56
 */
@Data
@TableName("plan")
public class Plan {
    /**
     * 指定自增策略
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer dayId;
    private Date startTime;//计划开始时间
    private Date endTime;//计划结束时间
    private String problem;//待解决的问题
    private String solvePlan;//解决方案
    private String duration;//持续时长
    private Integer isComplete;//是否完成
    private Integer isEndComplete;//是否最终完成
    private Integer isCarry;//是否实施
}
