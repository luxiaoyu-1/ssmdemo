package com.example.ssmdemo23.demos.service;

import com.example.ssmdemo23.demos.entity.work;

import java.util.List;

public interface workservice {
    Integer addwork(work work);

    Integer deletework(Integer id);

    Integer updatework(work work);

    List<work> getAllwork();

}