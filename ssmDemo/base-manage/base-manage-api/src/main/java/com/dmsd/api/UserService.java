package com.dmsd.api;

import com.dmsd.pojo.TUser;
import com.dmsd.pojo.User;

import java.util.List;

/**
 * Created by Ares on 2017/10/24.
 */
public interface UserService {
    /**
     * 根据id查询用户信息-王雷-2017年10月24日10:36:02
     * @param Id 用户id
     * @return 用户实体信息
     */
    TUser findUserById(String Id);

    List<User> queryUserMap();
}
