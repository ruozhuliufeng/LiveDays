package cn.aixuxi.livedays.controller;

import cn.aixuxi.livedays.entity.DayTime;
import cn.aixuxi.livedays.entity.Plan;
import cn.aixuxi.livedays.entity.Relationship;
import cn.aixuxi.livedays.entity.User;
import cn.aixuxi.livedays.mapper.DayTimeMapper;
import cn.aixuxi.livedays.service.DayTimeService;
import cn.aixuxi.livedays.service.PlanService;
import cn.aixuxi.livedays.service.RelationShipService;
import cn.aixuxi.livedays.service.UserService;
import cn.aixuxi.livedays.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;

/**
 * 类描述 DayTime控制层
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/7 21:59
 */
@Controller
@RequestMapping("/daytime")
public class DayTimeController {

    @Autowired
    private RelationShipService relationShipService;
    @Autowired
    private DayTimeService dayTimeService;
    @Autowired
    private PlanService planService;
    @Autowired
    private UserService userService;
    /**
     * 功能描述: 将用户拉入黑名单
     * @param id 操作者ID
     * @param httpSession 存取数据
     * @return : 重定向页面
     * @author : ruozhuliufeng
     * @date : 2020/6/7 22:15
     */
    @GetMapping("/into")
    public String into(Integer id, HttpSession httpSession){
        //获取当前时间
        Date d1 = new Date();
        //获取另一伴的id
        Integer userRefId = relationShipService.findRefIdById(id);
        //对另一位用户进行操作
        User refUser = userService.findUserById(userRefId);
        refUser.setIsBlacklist(1);
        userService.updateUser(refUser);
        DayTime dayTime = dayTimeService.selectLastById(userRefId);
        //作为结束时间
        dayTime.setEndTime(d1);
        //开始时间
        Date d2 = dayTime.getStartTime();
        //持续时长
        try {
            dayTime.setDuration(DateUtils.dateCompare(d2,d1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dayTimeService.updateById(dayTime);
        Relationship relationship = relationShipService.findByUserId(id);
        //状态改为黑名单状态
        relationship.setStatus(1);
        relationShipService.updateById(relationship);
        httpSession.setAttribute("relationship",relationship);
        return "redirect:/user/other";
    }

    /**
     * 功能描述: 将用户拉出黑名单
     * @param id 操作者id
     * @param httpSession 存取数据
     * @return : 页面重定向
     * @author : ruozhuliufeng
     * @date : 2020/6/7 22:25
     */
    @GetMapping("/out")
    public String out(Integer id,HttpSession httpSession){
        //获取当前时间
        Date date = new Date();
        Integer userRefId = relationShipService.findRefIdById(id);
        //对另一位用户进行操作
        User refUser = userService.findUserById(userRefId);
        refUser.setIsBlacklist(0);
        userService.updateUser(refUser);
        DayTime dayTime = new DayTime();
        dayTime.setStartTime(date);
        dayTime.setUserId(userRefId);
        //保存进数据库
        dayTimeService.insert(dayTime);
        Relationship relationship = relationShipService.findByUserId(id);
        //状态改为解除黑名单状态
        relationship.setStatus(0);
        relationShipService.updateById(relationship);
        httpSession.setAttribute("relationship",relationship);
        return "redirect:/user/other";
    }

    /**
     * 功能描述: 子用户达成计划目标
     * @param id 当前计划id
     * @param httpSession 存取数据
     * @return : 页面重定向
     * @author : ruozhuliufeng
     * @date : 2020/6/8 0:38
     */
    @GetMapping("/complete")
    public String complete(Integer id,HttpSession httpSession){
        Plan plan = planService.findPlanByDayId(id);
        plan.setIsComplete(1);
        planService.updatePlan(plan);
        return "redirect:/user/self";
    }

    /**
     * 功能描述: 主用户认可目标达成
     * @param id 当前计划id
     * @param httpSession 存取数据
     * @return : 页面重定向
     * @author : ruozhuliufeng
     * @date : 2020/6/8 0:39
     */
    @GetMapping("/endcomplete")
    public String endcomplete(Integer id,HttpSession httpSession){
        Plan plan = planService.findPlanById(id);
        plan.setIsEndComplete(1);
        planService.updatePlan(plan);
        return "redirect:/user/other";
    }

    /**
     * 功能描述: 准许用户实施该条计划
     * @param id 计划id
     * @param httpSession 存取数据
     * @return : 重定向页面
     * @author : ruozhuliufeng
     * @date : 2020/6/8 17:45
     */
    @GetMapping("/carry")
    public String carry(Integer id,HttpSession httpSession){
        Plan plan = planService.findPlanById(id);
        plan.setIsCarry(1);
        planService.updatePlan(plan);
        return "redirect:/user/other";
    }

    @GetMapping("/cause")
    public String cause(Integer id,String cause,HttpSession httpSession){
        DayTime dayTime = dayTimeService.findDayById(id);
        dayTime.setCause(cause);
        dayTimeService.updateById(dayTime);
        return "redirect:/";
    }
}
