package com.dmsd.controller;

import com.dmsd.api.UserService;
import com.dmsd.pojo.TUser;
import com.dmsd.tool.JacksonJsonUntil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ares on 2017/10/24.
 */
@Controller
public class UserController {

    //注入api
    @Autowired
    private UserService userService;

    @RequestMapping("/user/{id}")
    @ResponseBody
    public String findUserById(@PathVariable String id) throws JsonProcessingException {
        TUser user = userService.findUserById(id);
        String json = JacksonJsonUntil.objectToJson(user);
        return json;
    }

}
