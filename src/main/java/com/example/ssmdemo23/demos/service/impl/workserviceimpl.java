package com.example.ssmdemo23.demos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ssmdemo23.demos.entity.work;
import com.example.ssmdemo23.demos.mapper.workmapper;
import com.example.ssmdemo23.demos.service.workservice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class workserviceimpl implements workservice {

    private final workmapper workmapper;
    @Override
    public Integer addwork(work work) {
        work.setCreateTime(new Date());
        work.setUpdateTime(new Date());
        return workmapper.insert(work);
    }

    @Override
    public Integer deletework(Integer id) {
        return workmapper.deleteById(id);
    }

    @Override
    public Integer updatework(work work) {
        work.setUpdateTime(new Date());
        return workmapper.updateById(work);
    }

    @Override
    public List<work> getAllwork() {
        return workmapper.selectList(new QueryWrapper<work>().eq("1",1 ));
    }





}