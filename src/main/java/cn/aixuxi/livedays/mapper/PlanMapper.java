package cn.aixuxi.livedays.mapper;

import cn.aixuxi.livedays.dto.PlanOutputDTO;
import cn.aixuxi.livedays.entity.Plan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 类描述
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 13:59
 */

public interface PlanMapper extends BaseMapper<Plan> {

    List<PlanOutputDTO> findPlanById(Integer id);

    Plan findPlanByDayId(Integer id);

    List<PlanOutputDTO> findPlansById(Integer id);
}
