package cn.aixuxi.livedays.service.impl;

import cn.aixuxi.livedays.dto.PlanOutputDTO;
import cn.aixuxi.livedays.entity.Plan;
import cn.aixuxi.livedays.mapper.PlanMapper;
import cn.aixuxi.livedays.service.PlanService;
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
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanMapper planMapper;


    /**
     * 功能描述: 根据问题ID获取计划
     * @param id 问题ID
     * @return : cn.aixuxi.livedays.entity.Plan
     * @author : ruozhuliufeng
     * @date : 2020/6/8 17:47
     */
    @Override
    public Plan findPlanByDayId(Integer id) {
        return planMapper.findPlanByDayId(id);
    }

    @Override
    public void updatePlan(Plan plan) {
        planMapper.updateById(plan);
    }

    /**
     * 功能描述: 获取个人设置页面所有Plan
     * @param id 用户id
     * @return : 页面显示PlanDTO
     * @author : ruozhuliufeng
     * @date : 2020/6/8 17:33
     */
    @Override
    public List<PlanOutputDTO> findPlansById(Integer id) {
        return planMapper.findPlansById(id);
    }

    /**
     * 功能描述: 根据计划id获取计划
     * @param id 计划id
     * @return : 该计划
     * @author : ruozhuliufeng
     * @date : 2020/6/8 17:47
     */
    @Override
    public Plan findPlanById(Integer id) {
        return planMapper.selectById(id);
    }

    @Override
    public void deleteById(Integer id) {
        planMapper.deleteById(id);
    }

    @Override
    public void add(Plan plan) {
        planMapper.insert(plan);
    }
}
