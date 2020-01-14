package com.example.demo_1.controller;

import com.example.demo_1.bean.*;
import com.example.demo_1.dao.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ManagerController {
    @Resource
    e_userDao edao;
    @Resource
    e_dormDao edorm;
    @Resource
    e_chargeDao ecdao;
    @Resource
    e_maintainDao emdao;
    @Resource
    e_announcementDao eadao;
    @Resource
    e_ammeterDao eamdao;

    @RequestMapping("listDorminfo")//寝室信息列表
    public String listDorminfo( Model model) {
         List<e_dorm> list = edorm.findAll();
         List<String> lstr  = new ArrayList<>();
         for(int i = 0;i<list.size();i++){
             String name = "";
             List<String> ls = edao.findNameByDormNum(list.get(i).getE_dorm_num());
             for(int j = 0; j < ls.size();j++){
                name = name + " "+  ls.get(j);
                 System.out.println(ls.get(j));
                System.out.println(name+"========================");
             }
             lstr.add(name);
         }
         model.addAttribute("lstr",lstr);
         model.addAttribute("list",list);
         return "dormInfoList";
    }
    @RequestMapping("listRechargerDetail")//电费充值列表
    public String listRechargerDetail(Model model) {
        List<e_recharge> list =ecdao.findAll();
        model.addAttribute("list",list);
        return "rechargerList";
    }
    @RequestMapping("Recharger")//管理员进入充值界面
    public String Recharger(Integer dorm_num, Double insertMoney,Model model) {
        model.addAttribute("d",dorm_num);
        model.addAttribute("i",insertMoney);
        return "recharger";
    }
    @RequestMapping("rechargerMoney")//管理员执行充值操作
    public String rechargerMoney(Integer dorm_num, Double setMoney,Model model) {
        String state = "已充值";
        ecdao.updateBydorm_num(state,dorm_num);
        eamdao.updatemoney(setMoney,dorm_num);
        return "ManagerPaySuccess";
    }

    @RequestMapping("listmaintain")//管理员执行充值操作
    public String listmaintain(Model model) {
        List<e_maintain>  emlist= emdao.findAll();
        model.addAttribute("emlist",emlist);
        return "listmaintain";
    }

    @RequestMapping("notice")//进入发布公告界面
    public String notice() {
        return "postnotice";
    }
    @RequestMapping("postnotice")//发布公告
    public String postnotice(String title,String content,Model model) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = df.format(new Date());
        e_announcement ea  = new e_announcement();
        ea.setTitle(title);
        ea.setContent(content);
        ea.setPosttime(s);
        eadao.save(ea);
        return allnotice(model);
    }
    @RequestMapping("allnotice.do")//公告列表
    public String allnotice(Model model) {
        List<e_announcement> ea  =  eadao.findAllnotice();
        model.addAttribute("ea1",ea);
        return "allnotice";
    }
    @RequestMapping("dianbiao")//电表管理
    public String dianbiao(Model m) {
        List<e_ammeter> eam1 =  eamdao.findbyStatus("智能电表");
        List<e_ammeter> eam2 =  eamdao.findbyStatus("传统电表");
        m.addAttribute("eam1",eam1);
        m.addAttribute("eam2",eam2);
        return "dianbiao";
    }
    @RequestMapping("yijiantingdian")//智能电表一键停电
    public String yijiantingdian(Model m) {
        eamdao.updatedianbiao("断电中","智能电表");
        return dianbiao(m);
    }
    @RequestMapping("yijianlaidian")//智能电表一键来电
    public String yijianlaidian(Model m) {
        eamdao.updatedianbiao("供电中","智能电表");
        return dianbiao(m);
    }

    @RequestMapping("tingdian")//单独停电
    public String tingdian(String id ,Model m) {
        System.out.println(id+"=========================");
        eamdao.updatedianbiao1("断电中",id);
        return dianbiao(m);
    }
    @RequestMapping("huifu")//单独恢复
    public String huifu(String id ,Model m) {
        eamdao.updatedianbiao1("供电中",id);
        return dianbiao(m);
    }


}
