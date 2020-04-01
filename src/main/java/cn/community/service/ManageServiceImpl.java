package cn.community.service;

import cn.community.service.c_interface.ManagerService;
import cn.community.mapper.CarPortMapper;
import cn.community.mapper.HOwnerMapper;
import cn.community.mapper.ManagerMapper;
import cn.community.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageServiceImpl implements ManagerService {
    @Autowired
    ManagerMapper managerMapper;
    @Autowired
    CarPortMapper carPortMapper;
    @Autowired
    HOwnerMapper hOwnerMapper;

    /**
     * 通过管理员id查询所有的信息
     *
     * @param id
     * @return
     */

    @Override
    public Manager selectById(int id) {
        return managerMapper.selectByPrimaryKey(id);
    }


}
