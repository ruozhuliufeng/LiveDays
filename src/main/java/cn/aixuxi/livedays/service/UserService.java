package cn.aixuxi.livedays.service;

import cn.aixuxi.livedays.dto.PlanOutputDTO;
import cn.aixuxi.livedays.dto.UserInputDTO;
import cn.aixuxi.livedays.dto.UserOutputDTO;
import cn.aixuxi.livedays.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 14:03
 */
public interface UserService {


    void save(UserInputDTO userInputDTO);

    User login(UserInputDTO userInputDTO);

    void cancel(User user);

    UserOutputDTO findById(Integer id);

    List<PlanOutputDTO> findPlanById(Integer id);

    User findUserById(Integer userRefId);

    void updateUser(User refUser);
}
