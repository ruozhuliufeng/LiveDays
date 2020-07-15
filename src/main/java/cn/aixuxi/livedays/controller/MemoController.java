package cn.aixuxi.livedays.controller;

import cn.aixuxi.livedays.dto.MemoInputDTO;
import cn.aixuxi.livedays.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述 备注控制层
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/9 14:06
 */
@Controller
@RequestMapping("/memo")
public class MemoController {
    @Autowired
    private MemoService memoService;
    @GetMapping("/add")
    public String add(MemoInputDTO memoInputDTO){
        memoService.add(memoInputDTO);
        return "redirect:/main";
    }
}
