package com.example.ssmdemo23.demos.controrller;


import cn.hutool.core.net.NetUtil;
import com.example.ssmdemo23.demos.entity.work;
import com.example.ssmdemo23.demos.form.workAddForm;
import com.example.ssmdemo23.demos.form.workDeleteForm;
import com.example.ssmdemo23.demos.form.workUpdateForm;
import com.example.ssmdemo23.demos.service.workservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@Controller
@RequestMapping("/work")
@RequiredArgsConstructor
public class workcontroller {

    private final workservice workservice;

    @GetMapping("/list")
    public String listwork(Model model){
        model.addAttribute( "worklist",workservice.getAllwork());
        return "/work/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public Map<String,  Object> listwork(Map<String, Object> query){
        Map<String, Object> result = new HashMap<>();
        result.put("worklist",workservice.getAllwork());
        return result;
    }

    @GetMapping("/add")
    public String addwork(){
        return "/work/workadd";
    }



    @PostMapping("/add")
    @ResponseBody
    public Map<String,  Object> addwork(workAddForm workAddForm) throws UnknownHostException {

        Map<String, Object> result = new HashMap<>();

        String macAddress = NetUtil.getMacAddress(InetAddress.getLocalHost());

        work work = new work();
        work.setName(workAddForm.getName());
        work.setNum(workAddForm.getNum());
        work.setClasses(workAddForm.getClasses());
        work.setMacAdd(macAddress);
        Integer insertNum = workservice.addwork(work);
        result.put("msg","success");
        result.put("insertNum",insertNum);
        return result;
    }

    @GetMapping("/update")
    public String updatework(){
        return "/work/update";
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String,  Object> updatework(workUpdateForm workUpdateForm ) throws UnknownHostException {

        Map<String, Object> result = new HashMap<>();

        work work = new work();
        work.setId(workUpdateForm.getId());
        work.setName(workUpdateForm.getName());
        work.setNum(workUpdateForm.getNum());
        work.setClasses(workUpdateForm.getClasses());
        work.setMacAdd(NetUtil.getMacAddress(InetAddress.getLocalHost()));

        Integer insertNum = workservice.updatework(work);

        result.put("success",true);
        result.put("insertNum",insertNum);
        return result;
    }

    @GetMapping("/delete")
    public String deletework(){
        return "/work/delete";
    }

    @PostMapping("/delete")
    @ResponseBody
    public Map<String,  Object> deletework(workDeleteForm workDeleteForm ){
        Map<String, Object> result = new HashMap<>();
        Integer insertNum = workservice.deletework(workDeleteForm.getId());
        result.put("success",true);
        result.put("insertNum",insertNum);
        return result;
    }
}