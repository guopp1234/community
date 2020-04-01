package cn.community.controller;

import cn.community.service.c_interface.ManagerService;
import cn.community.service.c_interface.StaffService;
import cn.community.service.c_interface.UserService;
import cn.community.pojo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ManagerService managerService;
    @Autowired
    StaffService staffService;

    @RequestMapping("/login")
    public String login(User user, Map<String, Object> map, HttpSession session) {
        String loginMsg = userService.login(user);
        System.out.println(user.getRole());
        if (loginMsg.equals("账号错误") || loginMsg.equals("密码错误") || loginMsg.equals("账号为数字")) {
            map.put("msg", loginMsg);
            return "login";
        }

        if (user.getRole() == 1) {
            Manager manager = managerService.selectById(Integer.valueOf(user.getUserName()));
            session.setAttribute("user", manager);
        } else if (user.getRole() == 2) {
            session.setAttribute("userId", Integer.valueOf(user.getUserName()));     //将用户的账号存到session中
            //查询出用户的信息
            HOwner hOwner = userService.searchById(Integer.valueOf(user.getUserName()));  //查询用户的信息
            session.setAttribute("user", hOwner);
        } else if (user.getRole() == 3) {
            Staff staff = staffService.selectById(Integer.valueOf(user.getUserName()));
            session.setAttribute("user", staff);
        }


        return loginMsg;
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    public String logout() throws Exception {
        return "login";
    }

    @RequestMapping("/signIn")
    public String signIn(HOwner hOwner, Map<String, Object> map) {
        RegisterResult registerResult = userService.signIn(hOwner);
        String msg = registerResult.getMsg();

        if ("login".equals(msg)) {
            map.put("userId", registerResult.getUserName());
            map.put("warningInfo", "这是您的账号，请牢记！");
            return "login";
        } else {
            map.put("msg", msg);

            return "hower_register";
        }


    }
    /**
     * 查询所有的员工信息
     */
    @RequestMapping("/allStaff")
    public String Staff(Map<String, Object> map) {
        List<Staff> staff = staffService.getALl();
        map.put("staff", staff);
        return "admin/allStaff";
    }
    /**
     * 删除业主
     *
     * @param staffId
     * @return
     */
    @RequestMapping("/deleteStaff")
    public String deleteStaff(String staffId) {
        System.out.println("hello");
        staffService.delById(Integer.valueOf(staffId));
        System.out.println(staffId);
        return "redirect:/user/allStaff";
    }

    /**
     * 更业主信息
     *
     * @param staffId
     * @param map
     * @return
     */
    @RequestMapping("/updateStaff")
    public String updateStaff(String staffId, Map<String, Object> map) {

        map.put("staffId", staffId);
        return "updateStaff";
    }

    @RequestMapping("/updateStaffSubmit")
    public String updateStaffSubmit(Staff staff) {

        System.out.println(staff.getStaffId());
        staffService.upData(staff);
        System.out.println(staff.getStaffId());
        System.out.println(staff.getStaffName());
        System.out.println(staff.getSex());
        return "redirect:/user/allStaff";
    }

    /**
     * 查询所有的业主信息
     */
    @RequestMapping("/allOwner")
    public String selectAllOWner(Map<String, Object> map) {
        List<HOwner> hOwners = userService.selectAllOwner();
        map.put("hOwners", hOwners);
        return "admin/allOwner";
    }


    /**
     * 删除业主
     *
     * @param ownerId
     * @return
     */
    @RequestMapping("/deleteOwner")
    public String deleteOwner(String ownerId) {
        System.out.println("hello");
        userService.deleteOwner(Integer.valueOf(ownerId));
        System.out.println(ownerId);
        return "redirect:/user/allOwner";
    }

    /**
     *
     * @param
     * @return
     */
    @RequestMapping("/insertOwner")
    public String insertOwner() {
        return "admin/OwnerAdd";
    }
    @RequestMapping("/addOwner")
    public String addOwner(HOwner hOwner) {
        System.out.println("hello");
        HOwner owner = new HOwner();
        owner.setOwnerId(hOwner.getOwnerId());
        owner.setOwnerName(hOwner.getOwnerName());
        owner.setIphone(hOwner.getIphone());
        userService.addOwner(hOwner);
        System.out.println(hOwner.getOwnerName());

        return "redirect:/user/allOwner";
    }
    /**
     * 更业主信息
     *
     * @param ownerId
     * @param map
     * @return
     */
    @RequestMapping("/updateOwner")
    public String updateOwner(String ownerId, Map<String, Object> map) {

        map.put("ownerId", ownerId);
        return "updateOwner";
    }

    @RequestMapping("/updateSubmit")
    public String updateOwnerSubmit(HOwner hOwner) {

        System.out.println(hOwner.getOwnerId());
        userService.updateOwner(hOwner);
        System.out.println(hOwner.getOwnerId());
        System.out.println(hOwner.getOwnerName());
        System.out.println(hOwner.getSex());
        return "redirect:/user/allOwner";
    }
}
