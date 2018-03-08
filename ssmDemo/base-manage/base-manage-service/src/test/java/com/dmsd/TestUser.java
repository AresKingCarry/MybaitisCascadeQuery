package com.dmsd;

import com.dmsd.pojo.User;
import com.dmsd.testUtil.CommonFacade;
import org.junit.Test;

import java.util.List;

/**
 * Created by Ares on 2018/3/8.
 */
public class TestUser extends CommonFacade {

    @Test
    public void testqueryUserMap(){
        List<User> users = userService.queryUserMap();
        System.out.println(users);
    }
}
