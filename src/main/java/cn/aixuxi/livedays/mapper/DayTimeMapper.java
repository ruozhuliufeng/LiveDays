package cn.aixuxi.livedays.mapper;

import cn.aixuxi.livedays.dto.DayTimeOutputDTO;
import cn.aixuxi.livedays.entity.DayTime;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface DayTimeMapper extends BaseMapper<DayTime> {
    List<DayTimeOutputDTO> findDaysById(Integer id);

    DayTime selectLastById(Integer userRefId);
}
