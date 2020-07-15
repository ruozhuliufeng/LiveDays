package cn.aixuxi.livedays.service.impl;

import cn.aixuxi.livedays.dto.DayTimeOutputDTO;
import cn.aixuxi.livedays.entity.DayTime;
import cn.aixuxi.livedays.mapper.DayTimeMapper;
import cn.aixuxi.livedays.service.DayTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 18:08
 */
@Service
public class DayTimeServiceImpl implements DayTimeService {
    @Autowired
    private DayTimeMapper dayTimeMapper;
    @Override
    public List<DayTimeOutputDTO> findDaysById(Integer id) {
        return dayTimeMapper.findDaysById(id);
    }

    /**
     * 功能描述: 通过用户ID获取Day
     * @param userRefId 用户ID
     * @return : cn.aixuxi.livedays.entity.DayTime
     * @author : ruozhuliufeng
     * @date : 2020/6/8 23:16
     */
    @Override
    public DayTime selectById(Integer userRefId) {
        return dayTimeMapper.selectById(userRefId);
    }

    @Override
    public void updateById(DayTime dayTime) {
        dayTimeMapper.updateById(dayTime);
    }

    @Override
    public void insert(DayTime dayTime) {
        dayTimeMapper.insert(dayTime);
    }

    /**
     * 功能描述: 通过dayID获取daytime
     * @param id day的id
     * @return : DayTime数据
     * @author : ruozhuliufeng
     * @date : 2020/6/8 23:15
     */
    @Override
    public DayTime findDayById(Integer id) {
        return dayTimeMapper.selectById(id);
    }

    @Override
    public DayTime selectLastById(Integer userRefId) {
        return dayTimeMapper.selectLastById(userRefId);
    }
}
