package cn.community;

import cn.community.service.c_interface.*;
import cn.community.pojo.*;
import cn.community.utils.IDUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityManageApplicationTests {

    @Autowired
    NewsService newsService;

    @Autowired
    CarPortService carPortService;
    @Autowired
    ArrearageService arrearageService;

    @Autowired
    ComplaintService complaintService;

    @Autowired
    MaintainService maintainService;
    @Autowired
    UserService userService;

    @Test
    public void testDeleteOwner() {
        userService.deleteOwner(5915);
    }

    @Test
    public void contextLoads() {
/*        List<News> allNews = newsService.getAllNews();
        System.out.println("allNews = " + allNews);*/
        News newsById = newsService.getNewsById("002");
        System.out.println("newsById = " + newsById);
    }

    @Test
    public void testCarPortService() {

        CarPort carPortByHid = carPortService.getCarPortByHid(5909);
        System.out.println("carPortByHid = " + carPortByHid);
    }

    @Test
    public void testArrearageService() {

        Arrearage arrearageByHId = arrearageService.getArrearageByHId(5901);
        System.out.println("arrearageByHId = " + arrearageByHId);
    }

    @Test
    public void testComplaintService() {
        Complaint complaintByOwnId = complaintService.getComplaintByOwnId(5901);
        System.out.println("complaintByOwnId = " + complaintByOwnId.getComplaintComment());
    }

    @Test
    public void testMaintainService() {
        Maintain maintainByownId = maintainService.getMaintainByownId(5900);
        System.out.println("maintainByownId = " + maintainByownId);
    }

    @Test

    public void countCarPort() {
        System.out.println(carPortService.countAll());
    }

    public void testComplaint() throws Exception {
        /*complaintService.upDataComplantById("0006", "66666666666");
        System.out.println(" success ");*/
        Date now = new Date();
//      从session中获取用户
        Integer ownerId = 5901;
        String complaintComment = "你好暗室逢灯";
        Complaint complaint = new Complaint();
        complaint.setComplaintComment(complaintComment);
        complaint.setComplaintDate(now);
        complaint.setOwnerId(ownerId);
//        156212399797541 0007
        complaint.setComplaintId(IDUtils.genItemId());
        complaintService.addComplaintComment(complaint);
    }

    @Test
    public void TestDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String format = sdf.format(now);
        System.out.println("format = " + format);

    }

    @Test
    public void testMiantain() throws Exception {
        maintainService.add("没有水 了 ", 5901);
    }

    @Autowired
    StaffService staffService;


    @Test
    public void testStaff() {
        staffService.delById(4);
    }
}
