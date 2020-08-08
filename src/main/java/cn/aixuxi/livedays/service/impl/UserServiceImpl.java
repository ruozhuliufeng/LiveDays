package cn.aixuxi.livedays.service.impl;

import cn.aixuxi.livedays.dto.PlanOutputDTO;
import cn.aixuxi.livedays.dto.UserInputDTO;
import cn.aixuxi.livedays.dto.UserOutputDTO;
import cn.aixuxi.livedays.entity.DayTime;
import cn.aixuxi.livedays.entity.Relationship;
import cn.aixuxi.livedays.entity.User;
import cn.aixuxi.livedays.mapper.DayTimeMapper;
import cn.aixuxi.livedays.mapper.PlanMapper;
import cn.aixuxi.livedays.mapper.RelationshipMapper;
import cn.aixuxi.livedays.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.aixuxi.livedays.service.UserService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述 用户服务类
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 18:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RelationshipMapper relationShipMapper;
    @Autowired
    private PlanMapper planMapper;
    @Autowired
    private DayTimeMapper dayTimeMapper;
    @Override
    public void save(UserInputDTO userInputDTO) {
        User user = new User();
        user.setUsername(userInputDTO.getUsername());
        user.setPassword(userInputDTO.getPassword());
        user.setPhone(userInputDTO.getPhone());
        user.setEmail(userInputDTO.getEmail());
        user.setBinding(userInputDTO.getBinding());
        user.setSex(userInputDTO.getSex());
        user.setIsPublic(0);//默认不公开
        user.setStatus(0);//默认不激活
        user.setDuration("0");
        user.setCode("123456");//邮箱激活用code
        user.setIsBlacklist(0);//默认不在黑名单
        if ("是".equals(userInputDTO.getIsMaster())){
            user.setIsMaster(1);
        }else {
            user.setIsMaster(0);
        }
        //根据绑定码查找用户
        List<Integer> userRefId = userMapper.findIdByBinding(userInputDTO.getBinding());
        userMapper.insert(user);
        User us = login(userInputDTO);
        Integer id = us.getId();
        Relationship relationship = relationShipMapper.findByUserId(id);
        if (userRefId!=null){
            if (relationship==null){
                relationship = new Relationship();
                for (Integer refId:userRefId){
                    if (user.getIsMaster()==1 && !refId.equals(id)){
                        relationship.setId(id);
                        relationship.setUserRefId(refId);
                    }else if (user.getIsMaster()==0 && !refId.equals(id)){
                        relationship.setUserRefId(id);
                        relationship.setId(refId);
                    }
                }
                relationship.setStatus(0);
                relationShipMapper.insert(relationship);
            }else {
                for (Integer refId:userRefId){
                    if (user.getIsMaster()==1 && !refId.equals(id)){
                        relationship.setId(id);
                        relationship.setUserRefId(refId);
                    }else if (user.getIsMaster()==0 && !refId.equals(id)){
                        relationship.setUserRefId(id);
                        relationship.setId(refId);
                    }
                }
                relationship.setStatus(0);
                relationShipMapper.updateById(relationship);
            }

        }
        DayTime dayTime = new DayTime();
        dayTime.setUserId(id);
        dayTime.setStartTime(new Date());
        dayTimeMapper.insert(dayTime);
    }

    /**
     * 功能描述: 用户登陆
     * @param userInputDTO 登陆信息
     * @return : 登陆用户
     * @author : ruozhuliufeng
     * @date : 2020/6/7 22:47
     */
    @Override
    public User login(UserInputDTO userInputDTO) {
        User user = userMapper.login(userInputDTO);
        if (user!=null){
            return user;
        }
        return null;
    }

    /**
     * 功能描述: 注销用户
     * @param user 用户id
     * @return : void
     * @author : ruozhuliufeng
     * @date : 2020/6/7 22:46
     */
    @Override
    public void cancel(User user) {
        userMapper.deleteById(user.getId());
    }

    @Override
    public UserOutputDTO findById(Integer id) {
        List<UserOutputDTO> list = userMapper.findById(id);
        if (list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<PlanOutputDTO> findPlanById(Integer id) {
        return planMapper.findPlanById(id);
    }

    /**
     * 功能描述: 通过ID获取用户
     * @param userRefId 用户ID
     * @return : 用户信息
     * @author : ruozhuliufeng
     * @date : 2020/6/8 16:36
     */
    @Override
    public User findUserById(Integer userRefId) {
        return userMapper.selectById(userRefId);
    }

    /**
     * 功能描述: 修改用户
     * @param refUser 用户ID
     * @return : void
     * @author : ruozhuliufeng
     * @date : 2020/6/8 16:37
     */
    @Override
    public void updateUser(User refUser) {
        userMapper.updateById(refUser);
    }

    @Override
    public User isUniqueUsername(String username) {
        User user =  userMapper.isUniqueUsername(username);
        return user;
    }
}
