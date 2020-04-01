package cn.community.controller;

import cn.community.service.c_interface.ComplaintService;
import cn.community.pojo.Complaint;
import cn.community.utils.IDUtils;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/complaint")
public class ComplaintController {
    @Autowired
    ComplaintService complaintService;


    @RequestMapping("/showAll")
    public String showAll(HttpSession session, Map<String, Object> map) {
        Integer owerId = (Integer) session.getAttribute("userId");
        if (null == owerId) {
            return "redirect:/login";
        }
        List<Complaint> allComplaint = complaintService.getAllComplaint(owerId);
        map.put("allComplaint", allComplaint);
        return "howner/complaint";
    }

    @RequestMapping("/delById")
    public String delComplantById(String id) {
        try {
            complaintService.delComplantById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/login";
        }

        return "redirect:/complaint/showAll";
    }

    @RequestMapping("/updata")
    public String upData(String complaintId, String complaintComment) {
        try {
            complaintService.upDataComplantById(complaintId, complaintComment);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error";
        }

        return "redirect:/complaint/showAll";

    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestBody String complaintComment, HttpSession session) {
        if (null == session) {
            return "redirect:/login";
        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String dateFormat = sdf.format(now);
        Date now = new Date();
//      从session中获取用户
        Integer ownerId = (Integer) session.getAttribute("userId");
        Complaint complaint = new Complaint();
        complaint.setComplaintComment(complaintComment);
        complaint.setComplaintDate(now);
        complaint.setOwnerId(ownerId);
        complaint.setComplaintId(IDUtils.genItemId());
        ObjectMapper mapper = new ObjectMapper();
        String resString = "";
        Map<String, Object> map = new HashMap<>();
        try {
            complaintService.addComplaintComment(complaint);
            resString = mapper.writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", "投诉失败");
            return resString;
        }
        //        complaintService.addComplaintComment
        map.put("result", "投诉成功");
        return resString;
    }


    /**
     * 查询出所有的投诉
     */

    @RequestMapping("/selectAllComplaint")
    public String selectAllComplaint(Map<String, Object> map) {
        List<Complaint> complaints = complaintService.selectAllComplaint();
        map.put("complaints", complaints);
        return "admin/allComplaint";
    }

    /**
     * 删除投诉
     */
    @RequestMapping("/deleteComplaint")
    public String deleteComplaint(String complaintId) {
        System.out.println("hello");
        complaintService.deleteComplaint(complaintId);
        return "redirect:/complaint/selectAllComplaint";
    }

    /**
     * 回复投诉
     */
    @RequestMapping("/reback")
    public String reback(String complaintId, Map<String, Object> map) {
        map.put("complaintId", complaintId);
        return "admin/rebackComplaint";
    }

    @RequestMapping("/rebackComplaint")
    public String rebackComplaint(String feedback, String complaintId) {
        complaintService.rebackComplaint(complaintId, feedback);
        return "redirect:/complaint/selectAllComplaint";
    }
}
