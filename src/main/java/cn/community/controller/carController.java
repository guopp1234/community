package cn.community.controller;

import cn.community.service.c_interface.CarPortService;
import cn.community.pojo.CarPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/carport")
public class carController {
    @Autowired
    CarPortService carPortService;

    @RequestMapping("/showCarPort")
    public String showInfoByownerId(HttpSession session, Map<String, Object> map) {

        if (null == session) {
            return "redirect:/login";
        }
        Integer ownerId = (Integer) session.getAttribute("userId");
//        將用户车库的信息查询出来
        CarPort portByHid = carPortService.getCarPortByHid(ownerId);
        map.put("car", portByHid);

        return "howner/carPortInfo";
    }

    /**
     * 删除车位信息
     *
     * @param carPortId
     */

    @RequestMapping("/deleteCarPort")
    public String deleteCarPort(String carPortId) {
        carPortService.deleteCarPort(carPortId);
        return "redirect:/manager/allCarPort?start=1";
    }

    /**
     * 添加车位
     *
     * @return
     */
    @RequestMapping("/addCarPort")
    public String addCarPort() {
        carPortService.addCarPort();
        return "redirect:/manager/allCarPort?start=1";
    }

    /**
     * 编辑车位
     *
     * @return
     */
    @RequestMapping("/updateCarPort")
    public String updateCarPort(String carPortId, Map<String, Object> map) {
        map.put("carPortId", carPortId);
        return "updateCarPort";
    }

    @RequestMapping("/updateCarPortSubmit")
    public String updateCarPortSubmit(CarPort carPort, String dateInterval, Map<String, Object> map) {
        String msg = carPortService.updateCarPort(carPort, dateInterval);
        System.out.println(msg);
        if ("没有业主".equals(msg)) {
            map.put("carPortId", carPort.getPortId());
            return "redirect:/carport/updateCarPort";
        }

        return "redirect:/manager/allCarPort?start=1";
    }
}
