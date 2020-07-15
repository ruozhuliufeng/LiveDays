package cn.aixuxi.livedays.dto;

import lombok.Data;

import java.util.Date;

/**
 * 类描述 界面输出的planDTO
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/7 21:57
 */
@Data
public class PlanOutputDTO {
    /**
     * 功能描述:  首页
     * @author : ruozhuliufeng
     * @date : 2020/6/8 0:14
     */
    private Date startTime;//计划开始时间
    private Date endTime;//计划结束时间
    private String problem;//待解决的问题
    private String solvePlan;//解决方案

    /**
     * 功能描述:  个人设置页显示
     * @author : ruozhuliufeng
     * @date : 2020/6/8 0:14
     */
    private Integer id;
    private String duration;
    private Integer isCarry;
}
