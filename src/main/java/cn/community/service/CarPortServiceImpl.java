package cn.community.service;

import cn.community.service.c_interface.CarPortService;
import cn.community.mapper.CarPortMapper;


import cn.community.mapper.HOwnerMapper;
import cn.community.pojo.CarPort;

import cn.community.pojo.CarPortExample;
import cn.community.pojo.HOwner;
import cn.community.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class CarPortServiceImpl implements CarPortService {
    @Autowired
    CarPortMapper carPortMapper;
    @Autowired
    HOwnerMapper hOwnerMapper;

    public CarPort getCarPortByHid(Integer OwnerId) {
        CarPortExample carPortExample = new CarPortExample();
        carPortExample.createCriteria().andOwnerIdEqualTo(OwnerId);
        List<CarPort> carPorts = carPortMapper.selectByExample(carPortExample);
        if (carPorts.size() > 0) {
            return carPorts.get(0);
        } else {
            return new CarPort();
        }
    }

    /**
     * 查询所有的车位信息
     *
     * @return
     */
    @Override
    public List<CarPort> selectAllCarPort(int start) {
        List<CarPort> carPorts = carPortMapper.selectAllCartPort((start - 1) * 11);
        for (CarPort carPort : carPorts) {
            if (carPort.getOwnerId() != null) {
                HOwner hOwner = hOwnerMapper.selectByPrimaryKey(carPort.getOwnerId());
                carPort.setCarPortOwnerName(hOwner.getOwnerName());
                carPort.setCarNum(hOwner.getCarId());
            }
            if (carPort.getPortStat().equals("used")) {
                carPort.setPortStat("租用");
            } else if (carPort.getPortStat().equals("leisure")) {
                carPort.setPortStat("空闲");
            } else {
                carPort.setPortStat("售出");
            }
        }
        return carPorts;
    }

    /**
     * 统计所有的车位
     *
     * @return
     */
    @Override
    public long countAll() {
        CarPortExample example = new CarPortExample();
        CarPortExample.Criteria criteria = example.createCriteria();
        criteria.andPortIdIsNotNull();
        long count = carPortMapper.countByExample(example);
        return count;
    }

    /**
     * 删除车位
     *
     * @param carPortId
     */
    @Override
    public void deleteCarPort(String carPortId) {
        CarPortExample example = new CarPortExample();
        CarPortExample.Criteria criteria = example.createCriteria();
        criteria.andPortIdEqualTo(carPortId);
        carPortMapper.deleteByExample(example);
    }

    /**
     * 添加停车位
     */
    @Override
    public void addCarPort() {
        CarPort carPort = new CarPort();
        String carPortId = IDUtils.genItemId();
        carPort.setPortId(carPortId);
        carPort.setPortStat("leisure");
        carPortMapper.insert(carPort);
    }

    /**
     * 更新车位信息
     *
     * @param carPort
     * @param dateInterval
     */
    @Override
    public String updateCarPort(CarPort carPort, String dateInterval) {
        HOwner hOwner = hOwnerMapper.selectByPrimaryKey(carPort.getOwnerId());
        if (null != carPort.getOwnerId() && !("".equals(carPort.getOwnerId()))) {
            if (hOwner == null) {
                return "没有业主";
            }
        } else {
            String[] split = dateInterval.split("-");
            carPort.setStartDate(new Date(split[0]));
            carPort.setEndDate(new Date(split[1]));
            CarPortExample example = new CarPortExample();
            CarPortExample.Criteria criteria = example.createCriteria();
            criteria.andPortIdEqualTo(carPort.getPortId());
            carPortMapper.updateByExample(carPort, example);
            return "更新成功";
        }

        return "更新成功";
    }


}
