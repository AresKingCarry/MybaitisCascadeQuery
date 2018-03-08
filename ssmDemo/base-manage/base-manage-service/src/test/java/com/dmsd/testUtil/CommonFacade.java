package com.dmsd.testUtil;

import com.dmsd.api.OrderService;
import com.dmsd.api.UserService;
import org.junit.Before;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommonFacade {
    public BeanFactory factory;
    public OrderService orderService;
    public UserService userService;



    @Before
    public void setUp() {
        factory = new ClassPathXmlApplicationContext("classpath:spring-context.xml");

        orderService = (OrderService) factory.getBean("orderServiceImpl");

        userService = (UserService) factory.getBean("userServiceImpl");

    }
}
