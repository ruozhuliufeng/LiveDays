package cn.aixuxi.livedays.mapper;

import cn.aixuxi.livedays.dto.UserInputDTO;
import cn.aixuxi.livedays.dto.UserOutputDTO;
import cn.aixuxi.livedays.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 类描述
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 13:59
 */
//@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<Integer> findIdByBinding(String binding);

    List<UserOutputDTO> findById(Integer id);
}
