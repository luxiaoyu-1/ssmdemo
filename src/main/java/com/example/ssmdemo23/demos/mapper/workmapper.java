package com.example.ssmdemo23.demos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ssmdemo23.demos.entity.work;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface workmapper extends BaseMapper<work> {
    List<work> getWorksByWorkNameLike(String workName);
}