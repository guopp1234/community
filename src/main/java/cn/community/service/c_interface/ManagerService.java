package cn.community.service.c_interface;

import cn.community.pojo.Manager;

public interface ManagerService {
    /**
     * 通过管理员的id查询所有的信息
     *
     * @param id
     * @return
     */
    public Manager selectById(int id);


}
