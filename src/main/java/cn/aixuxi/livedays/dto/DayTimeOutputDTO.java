package cn.aixuxi.livedays.dto;

import lombok.Data;

import java.util.Date;

/**
 * 类描述 界面输出问题DTO
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/7 21:57
 */
@Data
public class DayTimeOutputDTO {
    private Integer id;
    private Date startTime;
    private Date endTime;
    private String cause;
    private String duration;
    private Integer isComplete;
    private Integer isEndComplete;
}
