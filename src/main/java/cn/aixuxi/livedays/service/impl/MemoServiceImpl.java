package cn.aixuxi.livedays.service.impl;

import cn.aixuxi.livedays.dto.MemoInputDTO;
import cn.aixuxi.livedays.entity.Memo;
import cn.aixuxi.livedays.mapper.MemoMapper;
import cn.aixuxi.livedays.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 类描述 备注服务实现类
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/9 14:07
 */
@Service
public class MemoServiceImpl implements MemoService {

    @Autowired
    private MemoMapper memoMapper;
    @Override
    public void add(MemoInputDTO memoInputDTO) {
        Memo memo = new Memo();
        memo.setUserId(memoInputDTO.getId());
        memo.setContent(memoInputDTO.getContent());
        memo.setStartTime(new Date());
        memoMapper.insert(memo);
    }
}
