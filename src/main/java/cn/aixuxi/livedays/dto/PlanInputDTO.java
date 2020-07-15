package cn.aixuxi.livedays.dto;

import lombok.Data;

import java.util.Date;

/**
 * 类描述 页面输入的计划
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/7 21:57
 */
@Data
public class PlanInputDTO {
    private Integer id;//注意：这里是day的id
    private Date startTime;
    private Date endTime;
    private String solvePlan;
}
