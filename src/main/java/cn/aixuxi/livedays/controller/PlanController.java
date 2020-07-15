package cn.aixuxi.livedays.controller;

import cn.aixuxi.livedays.dto.PlanInputDTO;
import cn.aixuxi.livedays.entity.DayTime;
import cn.aixuxi.livedays.entity.Plan;
import cn.aixuxi.livedays.entity.User;
import cn.aixuxi.livedays.service.DayTimeService;
import cn.aixuxi.livedays.service.PlanService;
import cn.aixuxi.livedays.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.DenyAll;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

/**
 * 类描述 Plan控制层
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/8 0:03
 */
@Controller
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;
    @Autowired
    private DayTimeService dayTimeService;
    /**
     * 功能描述: 保存计划
     * @param planInputDTO 计划数据
     * @return : 重定向到页面
     * @author : ruozhuliufeng
     * @date : 2020/6/8 0:33
     */
    @PostMapping("/add")
    public String add(PlanInputDTO planInputDTO,HttpSession httpSession){
        User user = (User) httpSession.getAttribute("currentUser");
        DayTime dayTime = dayTimeService.findDayById(planInputDTO.getId());
        Plan plan = new Plan();
        plan.setSolvePlan(planInputDTO.getSolvePlan());
        plan.setIsCarry(0);//默认不执行
        plan.setStartTime(planInputDTO.getStartTime());
        plan.setEndTime(planInputDTO.getEndTime());
        plan.setIsComplete(0);
        plan.setIsEndComplete(0);
        plan.setProblem(dayTime.getCause());
        plan.setUserId(user.getId());
        try {
            plan.setDuration(DateUtils.dateCompare(planInputDTO.getStartTime(),planInputDTO.getEndTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        planService.add(plan);
        return "redirect:/main";
    }

    /**
     * 功能描述: 主用户准许实施该计划
     * @param id 计划id
     * @param httpSession 存取数据
     * @return : 页面重定向
     * @author : ruozhuliufeng
     * @date : 2020/6/8 0:42
     */
    @GetMapping("/allow")
    public String allow(Integer id, HttpSession httpSession){

        return "redirect:/user/other";
    }

    /**
     * 功能描述: 修改计划内容
     * @param id 计划id
     * @param solvePlan 修改的计划内容
     * @param httpSession 存取数据
     * @return : 页面重定向
     * @author : ruozhuliufeng
     * @date : 2020/6/8 23:23
     */
    @GetMapping("/update")
    public String update(Integer id,String solvePlan,HttpSession httpSession){
        Plan plan = planService.findPlanById(id);
        plan.setSolvePlan(solvePlan);
        planService.updatePlan(plan);
        return "redirect:/user/self";
    }

    @GetMapping("/delete")
    public String delete(Integer id,HttpSession httpSession){
        planService.deleteById(id);
        return "redirect:/user/self";
    }
}
