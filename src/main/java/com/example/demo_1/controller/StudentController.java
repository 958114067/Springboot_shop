package com.example.demo_1.controller;

import com.example.demo_1.bean.*;
import com.example.demo_1.dao.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;


@Controller
public class StudentController {
    private String filepath = "E:/uploadfile/";
    @Resource
    e_userDao edao;
    @Resource
    e_dormDao edorm;
    @Resource
    e_chargeDao ecdao;
    @Resource
    e_topicDao etdao;
    @Resource
    e_replyDao erdao;
    @Resource
    e_maintainDao emdao;
    @Resource
    e_announcementDao eadao;
    @Resource
    e_ammeterDao eamdao;

    @PostMapping("login")//登录
    public String login(String name, String pwd, HttpSession session, Model model) {
        e_user eu = edao.findByNameAndPwd(name, pwd);
        if (eu != null) {
            if (eu.getE_identity() == 1) {//学生端
                //System.out.println("hello zhangbo,hello zhangbo,hello zhangbo,hello zhangbo,");
                session.setAttribute("eu", eu);
                List<e_announcement> ea2 = eadao.findAllnotice();
                session.setAttribute("ea2", ea2);
                return "index1";
            } else {//管理员端
                return "index2";
            }
        }
        return "loginmsg";
    }

    @PostMapping("register")//注册
    public String register(String name, String password, Integer dormnum, HttpSession session, Model model) throws Exception {
        Integer identify = 1;
        e_user eu = new e_user();
        eu.setE_name(name);
        eu.setE_dorm_num(dormnum);
        eu.setE_identity(identify);
        eu.setE_password(password);
        eu.setE_image(null);
        eu.setE_phone(null);
        edao.save(eu);
        return "login";
    }

    @RequestMapping("dorm_info")//展示寝室信息
    public String dormInfo(int dorm_num, Model model) {
        List<String> list = edao.findNameByDormNum(dorm_num);
        model.addAttribute("list", list);
        e_ammeter e = eamdao.findbynum(dorm_num);
        Double d = e.getE_ele();
        model.addAttribute("d", d);
        return "dormInfo";
    }

    @RequestMapping("inMoney")//进入充值界面
    public String inMoney(int dorm_num, Model model) {
        Double d = eamdao.findMoneyByDormNum(dorm_num);
        model.addAttribute("d", d);
        return "payTheFess";
    }

    @RequestMapping("chenggong")//充值成功
    public String chenggong(String out_trade_no, String total_amount) {
        Integer no = Integer.valueOf(out_trade_no.substring(out_trade_no.length() - 3));//寝室号
        Double a = Double.valueOf(total_amount);//充值金额
        String type = eamdao.findType(no);
        System.out.println(no + "     " + type);
        System.out.println("我进来了这里。。。。。。。。。。。。。。");
        eamdao.updatemoney(a, no);
        e_recharge ec = new e_recharge();
        ec.setE_dorm_num(no);
        ec.setE_insertmoney(a);
        ec.setE_recharge_detail("已充值");
        ecdao.save(ec);
        return "paySuccess1";
    }

    @RequestMapping("insertMoney")//进行充值操作
    @Transactional//将本方法注入事务
    public String insertMoney(int dorm_num, Double lastmoney, Double setMoney, Model model) {

        String type = eamdao.findType(dorm_num);
        if (type.equals("传统电表")) {
            e_recharge ec = new e_recharge();
            ec.setE_dorm_num(dorm_num);
            ec.setE_insertmoney(setMoney);
            ec.setE_recharge_detail("未处理");
            model.addAttribute("money", setMoney);
            model.addAttribute("num", dorm_num);
            ecdao.save(ec);
            return "paySuccess";
        }
        model.addAttribute("money", setMoney);
        model.addAttribute("num", dorm_num);
        return "index";
    }

    @RequestMapping("topic.do")//进入帖子列表
    public String topic(Model model) {
        List<e_topic> et = etdao.findAllList();
        model.addAttribute("et", et);
        return "topiclist";
    }

    @RequestMapping("mytopic.do")//进入发帖界面
    public String mytopic(Model model) {
        return "posttopic";
    }

    @RequestMapping("posttopic.do")//发帖之后跳回帖子列表界面
    public String posttopic(String title, String content, HttpSession s, Model model) {
        e_user eu = (e_user) s.getAttribute("eu");
        String e_name = eu.getE_name();
        e_topic et = new e_topic();
        title = title.replaceAll("垃圾", "**");
        title = title.replaceAll("傻逼", "**");
        title = title.replaceAll("操", "**");
        title = title.replaceAll("SB", "**");
        title = title.replaceAll("sb", "**");
        content = content.replaceAll("垃圾", "**");
        content = content.replaceAll("傻逼", "**");
        content = content.replaceAll("操", "**");
        content = content.replaceAll("SB", "**");
        content = content.replaceAll("sb", "**");
        et.setTitle(title);
        et.setContent(content);
        et.setE_name(e_name);
        etdao.save(et);
        return topic(model);
    }

    @RequestMapping("topiccontent.do")//进入帖子详情页
    public String topiccontent(Integer topicid, Model model, HttpSession s) {
        e_topic et = etdao.findByTID(topicid);
        model.addAttribute("topicdata", et);
        List<e_reply> er = erdao.findAllByTopicid(topicid);
        model.addAttribute("replydata", er);
        return "replytopic";
    }

    @RequestMapping("myreply.do")//进入回帖界面
    public String myreply(Integer topicid, Model m) {
        m.addAttribute("replytopicid", topicid);
        return "reply";
    }

    @RequestMapping("postreply.do")//回帖完再跳转至帖子详情页
    public String postreply(Integer topicid, String content, Model m, HttpSession s) {
        e_user eu = (e_user) s.getAttribute("eu");
        String e_name = eu.getE_name();
        e_reply er = new e_reply();
        content = content.replaceAll("垃圾", "**");
        content = content.replaceAll("傻逼", "**");
        content = content.replaceAll("操", "**");
        content = content.replaceAll("SB", "**");
        content = content.replaceAll("sb", "**");
        er.setE_name(e_name);
        er.setTopicid(topicid);
        er.setContent(content);
        erdao.save(er);
        return topiccontent(topicid, m, s);
    }

    @RequestMapping("declare.do")//报修清单
    public String declare(int dorm_num) {
        return "declare";
    }

    @RequestMapping("mydeclare.do")//我的报修
    public String mydeclare(Model m, HttpSession s) {
        e_user eu = (e_user) s.getAttribute("eu");
        Integer e_dorm_num = eu.getE_dorm_num();
        List<e_maintain> em = emdao.findByDormNum(e_dorm_num);
        m.addAttribute("em", em);
        return "Mydeclare";
    }

    @RequestMapping("mydeclare1.do")//申请报修
    public String mydeclare1(String type, String remark, Model m, HttpSession s) {
        e_user eu = (e_user) s.getAttribute("eu");
        Integer e_dorm_num = eu.getE_dorm_num();
        e_maintain em = new e_maintain();
        em.setE_dorm_num(e_dorm_num);
        em.setType(type);
        em.setRemark(remark);
        emdao.save(em);
        return mydeclare(m, s);
    }

    @RequestMapping("noticedate.do")//公告详情
    public String noticedate(Integer announcementid, Model m) {
        e_announcement ea = eadao.findbyannid(announcementid);
        m.addAttribute("ea3", ea);
        return "noticedate";
    }

    @RequestMapping("moniyongdian.do")//进入模拟用电
    public String moniyongdian(Integer dorm_num, Model m) {
        e_ammeter eamm = eamdao.findbynum(dorm_num);
        m.addAttribute("eamm", eamm);
        return "moniyongdian";
    }

    @RequestMapping("gomoni30s")//使用模拟用电
    public String gomoni30s(Integer id, Model m) {
        e_ammeter eamm = eamdao.findbynum(id);
        m.addAttribute("eamm", eamm);
        Double ele;
        if (eamm.getE_ele() < -10 || eamm.getStatus().equals("断电中")) {
            return "tingdian";
        }
        ele = eamm.getE_ele();
        ele -= 15;
        eamm.setE_ele(ele);
        eamdao.updateele(ele, id);
        return "moniyongdian30s";
    }

    @ResponseBody
    @RequestMapping("moni30s")//使用模拟用电
    public e_ammeter moni30s(Integer id, Model m) {
        e_ammeter eamm = eamdao.findbynum(id);
        m.addAttribute("eamm", eamm);
        Double ele;
        if (eamm.getE_ele() < -10 || eamm.getStatus().equals("断电中")) {
            return eamm;
        }
        ele = eamm.getE_ele();
        ele -= 15;
        eamm.setE_ele(ele);
        eamdao.updateele(ele, id);
        return eamm;
    }

    public void sayHello() {
        //System.out.println("hello zhangbo,hello zhangbo,hello zhangbo,hello zhangbo,hello zhangbo,hello zhangbo,hello zhangbo,hello zhangbo,hello zhangbo,hello zhangbo,");
    }
}
