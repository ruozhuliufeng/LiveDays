package cn.aixuxi.livedays.service;

import cn.aixuxi.livedays.dto.PlanOutputDTO;
import cn.aixuxi.livedays.entity.Plan;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 14:04
 */
public interface PlanService {
    Plan findPlanByDayId(Integer id);

    void updatePlan(Plan plan);

    List<PlanOutputDTO> findPlansById(Integer id);

    Plan findPlanById(Integer id);

    void deleteById(Integer id);

    void add(Plan plan);
}
