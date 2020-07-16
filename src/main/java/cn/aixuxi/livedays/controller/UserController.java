package cn.aixuxi.livedays.controller;

import cn.aixuxi.livedays.dto.DayTimeOutputDTO;
import cn.aixuxi.livedays.dto.PlanOutputDTO;
import cn.aixuxi.livedays.dto.UserInputDTO;
import cn.aixuxi.livedays.dto.UserOutputDTO;
import cn.aixuxi.livedays.entity.Relationship;
import cn.aixuxi.livedays.entity.User;
import cn.aixuxi.livedays.service.DayTimeService;
import cn.aixuxi.livedays.service.PlanService;
import cn.aixuxi.livedays.service.RelationShipService;
import cn.aixuxi.livedays.service.UserService;
import cn.aixuxi.livedays.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 类描述
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 13:58
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RelationShipService relationShipService;
    @Autowired
    private DayTimeService dayTimeService;
    @Autowired
    private PlanService planService;
    /**
     * 功能描述: 用户注册
     * @param  userInputDTO 注册信息
     * @return : java.lang.String
     * @author : ruozhuliufeng
     * @date : 2020/6/6 16:30
     */
    @RequestMapping("/save")
    public String save(UserInputDTO userInputDTO){
        userService.save(userInputDTO);
        //跳转到登录页面
        return "redirect:/";
    }

    /**
     * 功能描述: 用户登录
     * @param userInputDTO 页面获取用户登录数据
     * @param httpSession 保存用户登录信息
     * @return : 返回页面名称
     * @author : ruozhuliufeng
     * @date : 2020/6/7 20:08
     */
    @RequestMapping("/login")
    public String login(UserInputDTO userInputDTO, HttpSession httpSession){
        User currentUser = userService.login(userInputDTO);
        httpSession.setAttribute("currentUser",currentUser);
        UserOutputDTO userOutputDTO = userService.findById(currentUser.getId());
//        try {
//            String sustain = DateUtils.dateCompare(userOutputDTO.getStartTime(),new Date());
//            userOutputDTO.setSustain(sustain);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        httpSession.setAttribute("userOutputDTO",userOutputDTO);
        List<PlanOutputDTO> planslist = userService.findPlanById(currentUser.getId());
        httpSession.setAttribute("planslist",planslist);
        return "main";
    }

    /**
     * 功能描述: 跳转到个人设置页面
     * @param httpSession 存储携带数据
     * @return : 个人设置页面名称
     * @author : ruozhuliufeng
     * @date : 2020/6/7 20:09
     */
    @GetMapping("/self")
    public String self(HttpSession httpSession){
        User currentUser = (User) httpSession.getAttribute("currentUser");
        List<DayTimeOutputDTO> daylist = dayTimeService.findDaysById(currentUser.getId());
        httpSession.setAttribute("daylist",daylist);
        List<PlanOutputDTO> planlist = planService.findPlansById(currentUser.getId());
        httpSession.setAttribute("planlist",planlist);
        return "user/self";
    }


    /**
     * 功能描述: 跳转到个人中心页面
     * @param httpSession 存储携带数据
     * @return : 个人中心页面名称
     * @author : ruozhuliufeng
     * @date : 2020/6/7 20:09
     */
    @GetMapping("/center")
    public String center(HttpSession httpSession){
        return "user/center";
    }

    /**
     * 功能描述: 跳转到他人设置页面
     * @param httpSession 存储携带数据
     * @return : 他人设置页面名称
     * @author : ruozhuliufeng
     * @date : 2020/6/7 20:09
     */
    @GetMapping("/other")
    public String other(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("currentUser");
        //通过用户id获取关系
        Relationship relationship = relationShipService.findById(user.getId());
        httpSession.setAttribute("relationship",relationship);
        //通过获取另一伴的id
        Integer id = relationShipService.findRefIdById(user.getId());
        List<PlanOutputDTO> planslist = planService.findPlansById(id);
        httpSession.setAttribute("planslist",planslist);
        List<DayTimeOutputDTO> dayslist = dayTimeService.findDaysById(id);
        httpSession.setAttribute("dayslist",dayslist);
        return "user/other";
    }

    /**
     * 功能描述: 退出登录
     * @param httpSession 清除数据
     * @return : 重定向到首页
     * @author : ruozhuliufeng
     * @date : 2020/6/7 20:13
     */
    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }

    /**
     * 功能描述: 注销账号
     * @param httpSession 获取用户信息
     * @return : 重定向到首页
     * @author : ruozhuliufeng
     * @date : 2020/6/7 20:59
     */
    @GetMapping("/cancel")
    public String cancel(HttpSession httpSession){
        User user = (User) httpSession.getAttribute("currentUser");
        userService.cancel(user);
        return "redirect:/";
    }


    /**
     * 功能描述: 判断用户名是否存在
     * @param username 待判断的用户名
     * @return : 判断是否存在
     * @author : ruozhuliufeng
     * @date : 2020/7/15 22:07
     */
    @GetMapping("/isUniqueUsername")
    @ResponseBody
    public String isUniqueUsername(String username){
        boolean userName = userService.isUniqueUsername(username);
        // 将userName转为字符串
        return String.valueOf(userName);
    }
//    @PostMapping("/update")
//    public String update(UserInputDTO userInputDTO,HttpSession httpSession){
//        String imgUrl = UploadUtils.imgUplad(userInputDTO.getImg());
//        httpSession.setAttribute("imgUrl",imgUrl);
//        return "redirect:/user/center";
//    }
}
