package cn.aixuxi.livedays.dto;

import lombok.Data;

import java.util.Date;

/**
 * 类描述 界面输出DTO
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 13:32
 */
@Data
public class UserOutputDTO {
    private Integer id;//用户id
    private Date startTime;
    private Date endTime;
    private String duration;
    private String cause;
    private Integer isPlan;//是否有计划
    private Integer dayId;
    private String sustain;//截至目前持续时长
}
