package cn.aixuxi.livedays.service;

import cn.aixuxi.livedays.dto.DayTimeOutputDTO;
import cn.aixuxi.livedays.entity.DayTime;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 14:04
 */

public interface DayTimeService {
    List<DayTimeOutputDTO> findDaysById(Integer id);

    DayTime selectById(Integer userRefId);

    void updateById(DayTime dayTime);

    void insert(DayTime dayTime);

    DayTime findDayById(Integer id);

    DayTime selectLastById(Integer userRefId);
}
